package com.myntra.product.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.myntra.product.common.APIResponse;
import com.myntra.product.dao.BagDao;
import com.myntra.product.dto.AlterBagDto;
import com.myntra.product.dto.BagViewDto;
import com.myntra.product.dto.EditBagDto;
import com.myntra.product.dto.ListRemoveBagDto;
import com.myntra.product.entity.BagProducts;
import com.myntra.product.entity.Coupon;
import com.myntra.product.entity.CouponMapping;
import com.myntra.product.entity.Product;
import com.myntra.product.entity.Size;
import com.myntra.product.entity.WishListProducts;
import com.myntra.product.repository.BagRepository;
import com.myntra.product.repository.CouponMappingRepository;
import com.myntra.product.repository.CouponRepository;
import com.myntra.product.repository.ImageRepository;
import com.myntra.product.repository.ProductRepository;
import com.myntra.product.repository.SizeRepository;
import com.myntra.product.repository.WishListRepository;

@Service
public class BagService {
	
	private ProductRepository productRepo;
	private SizeRepository sizeRepo;
	private ImageRepository imageRepo;
	private APIResponse apiResponse;
	private Product prod;
	private WishListRepository wishListRepo;
	private BagRepository bagRepo;
	private BagProducts bag;
	private BagViewDto bagView;
	private CouponRepository couponRepo;
	private CouponMappingRepository couponMappingRepo;
	private CouponMapping couponMap;
	private RestTemplateService restTemplate;

	public BagService(ProductRepository productRepo, SizeRepository sizeRepo, ImageRepository imageRepo,
			APIResponse apiResponse, Product prod, WishListRepository wishListRepo, BagRepository bagRepo,
			BagProducts bag, BagViewDto bagView, CouponRepository couponRepo, CouponMappingRepository couponMappingRepo,
			CouponMapping couponMap,RestTemplateService restTemplate) {
		super();
		this.productRepo = productRepo;
		this.sizeRepo = sizeRepo;
		this.imageRepo = imageRepo;
		this.apiResponse = apiResponse;
		this.prod = prod;
		this.wishListRepo = wishListRepo;
		this.bagRepo = bagRepo;
		this.bag = bag;
		this.bagView = bagView;
		this.couponRepo = couponRepo;
		this.couponMappingRepo = couponMappingRepo;
		this.couponMap = couponMap;
		this.restTemplate= restTemplate;
	}

	public APIResponse addToBag(Long userId,AlterBagDto bagDto) {
		List<BagProducts> existProds = bagRepo.findByProductUsernSize(bagDto.getProductId(),userId,bagDto.getSize());
		if(existProds.size()==0) {
			bag.setId(null);
			bag.setUserId(userId);
			bag.setProductId(bagDto.getProductId());
			bag.setSize(bagDto.getSize());
			bag.setSelected(true);
			bag.setQuantity((long)1);
			Long addressId = (long)restTemplate.getDefaultAddressId(userId);
			System.out.println(addressId);
			bag.setAddressId(addressId);
			bagRepo.save(bag);
		}
		else {
			BagProducts p = existProds.get(0);
			p.setQuantity((p.getQuantity()+1));
			bagRepo.save(p);
		}
		List<CouponMapping> couponMapping = couponMappingRepo.findByUserId(userId);
		prod = productRepo.findById(bagDto.getProductId()).orElse(null);
		long mrp = getMrp(prod.getId(),bagDto.getSize());
		if(couponMapping.size()==0) {
			couponMap.setTotalMRP(mrp);
			long discount = (long)(mrp * ((float)prod.getDiscount()/100));
			couponMap.setDiscountOnMRP(discount);
			couponMap.setCouponId(couponRepo.findValidCoupon(couponMap.getTotalMRP()));
			couponMap.setUserId(userId);
			couponMappingRepo.save(couponMap);
		}
		else {
			couponMap = couponMapping.get(0);
			couponMap.setTotalMRP((couponMap.getTotalMRP() + mrp));
			long discount = couponMap.getDiscountOnMRP() + (long)(mrp * ((float)prod.getDiscount()/100));
			couponMap.setDiscountOnMRP(discount);
			couponMap.setCouponId(couponRepo.findValidCoupon(couponMap.getTotalMRP()));
			couponMappingRepo.save(couponMap);
		}
		apiResponse.setData(null);
		apiResponse.setMessage("Added to Bag");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse moveToBag(Long userId,AlterBagDto bagDto) {
		addToBag(userId,bagDto);
		List<WishListProducts> wish = wishListRepo.findByProductUserId(bagDto.getProductId(),bag.getUserId());
		wishListRepo.delete(wish.get(0));
		apiResponse.setData(null);
		apiResponse.setMessage("Moved to Bag");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse getBag(Long userId) {
		List<BagProducts> bagProducts = bagRepo.findByUserId(userId);
		if(bagProducts.size()==0) {
			apiResponse.setData(null);
		}
		else {
			List<BagDao> bagDisplayList = new LinkedList<>();
			long countOfItems = 0;
			long selectedItems = 0;
			for(BagProducts bp:bagProducts) {
				BagDao bagDao = new BagDao();
				Product p = productRepo.findById(bp.getProductId()).orElse(null);
				bagDao.setBrand(p.getBrand());
				bagDao.setDiscount(p.getDiscount());
				bagDao.setImage(imageRepo.findByProductId(p.getId()).get(0).getUrl());
				bagDao.setMrp(getMrp(p.getId(),bp.getSize()));
				bagDao.setProductId(bp.getProductId());
				bagDao.setProductName(p.getName());
				bagDao.setQuantity(bp.getQuantity());
				bagDao.setSelectedSize(bp.getSize());
				bagDao.setSeller(p.getSeller());
				bagDao.setSize(sizeRepo.findByProductId(p.getId()).get(0));
				Long availablity = getAvailablity(p.getId(),bp.getSize());
				if(availablity==0) {
					bagDao.setProductAvailablity("OUT OF STOCK");
				}
				else if(availablity<bp.getQuantity()) {
					bagDao.setProductAvailablity("Only "+availablity+" products available");
				}
				else {
					bagDao.setProductAvailablity(null);
				}
				bagDao.setSelected(bp.getSelected());
				bagDisplayList.add(bagDao);
				if(bp.getSelected())
					selectedItems++;
				countOfItems++;
			}
			CouponMapping couponMapping = couponMappingRepo.findByUserId(userId).get(0);
			Coupon coupon = couponRepo.findById(couponMapping.getCouponId()).orElse(null);
//			bagView.setDefaultAddress(getAddress(userId));
			bagView.setCoupon(coupon);
			bagView.setConvenienceFee((long)99);
			bagView.setItems(bagDisplayList);
			bagView.setItemsCount(countOfItems);
			bagView.setSelectedItemsCount(selectedItems);
			bagView.setTotalMrp(couponMapping.getTotalMRP());
			bagView.setDiscountOnMrp(couponMapping.getDiscountOnMRP());
			bagView.setCouponDiscount(couponMapping.getTotalMRP()* (coupon.getDiscountPercentage() / 100));
			Long total = bagView.getTotalMrp()- bagView.getDiscountOnMrp() - bagView.getCouponDiscount();
			if(total==0)
				bagView.setTotalAmount((long)0);
			else
				bagView.setTotalAmount(total+bagView.getConvenienceFee());
			apiResponse.setData(bagView);
		}
		apiResponse.setMessage("Bag");
		apiResponse.setStatus(true);
		return apiResponse;
	}

	public APIResponse removeFromBag(Long userId,ListRemoveBagDto bagList) {
		List<AlterBagDto> bagListItems = bagList.getList();
		long mrp = (long)0;
		long discount = (long)0;
		for(AlterBagDto b:bagListItems) {
			BagProducts bagProds = bagRepo.findByProductUsernSize(b.getProductId(),userId,b.getSize()).get(0);
			bagRepo.delete(bagProds);
			prod = productRepo.findById(b.getProductId()).orElse(null);
			mrp += (getMrp(prod.getId(),b.getSize()) * bagProds.getQuantity());
			discount += ((long)(mrp * ((float)prod.getDiscount()/100))*bagProds.getQuantity());
		}
		couponMap = couponMappingRepo.findByUserId(userId).get(0);
		couponMap.setTotalMRP(couponMap.getTotalMRP() - mrp);
		couponMap.setDiscountOnMRP(couponMap.getDiscountOnMRP() - discount);
		if(couponMap.getTotalMRP()==0) 
			couponMap.setCouponId(null);
		else
			couponMap.setCouponId(couponRepo.findValidCoupon(couponMap.getTotalMRP()));
		couponMappingRepo.save(couponMap);
		apiResponse.setData(null);
		apiResponse.setMessage("Removed items from bag");
		apiResponse.setStatus(true);
		return apiResponse;
	}


	public APIResponse editBag(Long userId,EditBagDto bagDto) {
		List<BagProducts> existProds = bagRepo.findByProductUsernSize(bagDto.getProductId(),userId,bagDto.getSize());
		BagProducts bagProd = existProds.get(0);
		couponMap = couponMappingRepo.findByUserId(userId).get(0);
		prod = productRepo.findById(bagDto.getProductId()).orElse(null);
		if(bagDto.getQuantity()!=null) {
			long prodMrp = getMrp(bagDto.getProductId(),bagDto.getSize()) ;
			long prodDiscount = (long)(prodMrp*(float)prod.getDiscount()/100);
			long mrp = ((bagDto.getQuantity() - bagProd.getQuantity()) * prodMrp);
			long discount = ((bagDto.getQuantity() - bagProd.getQuantity()) * prodDiscount);
			mrp += couponMap.getTotalMRP();
			discount += couponMap.getDiscountOnMRP();
			couponMap.setTotalMRP(mrp);
			couponMap.setDiscountOnMRP(discount);
			if(couponMap.getTotalMRP()==0) 
				couponMap.setCouponId(null);
			else
				couponMap.setCouponId(couponRepo.findValidCoupon(couponMap.getTotalMRP()));
			bagProd.setQuantity(bagDto.getQuantity());
		}
		if(bagDto.getSelected()!=null) {
			bagProd.setSelected(bagDto.getSelected());
			long mrp = getMrp(prod.getId(),bagProd.getSize()) * bagProd.getQuantity();
			if(bagDto.getSelected()) {
				couponMap.setTotalMRP(couponMap.getTotalMRP() + mrp);
				couponMap.setDiscountOnMRP(couponMap.getDiscountOnMRP() + (long)(mrp * ((float)prod.getDiscount()/100)));
				if(couponMap.getTotalMRP()==0) 
					couponMap.setCouponId(null);
				else
					couponMap.setCouponId(couponRepo.findValidCoupon(couponMap.getTotalMRP()));
			}
			else {
				couponMap.setTotalMRP(couponMap.getTotalMRP() - mrp);
				couponMap.setDiscountOnMRP(couponMap.getDiscountOnMRP() - (long)(mrp * ((float)prod.getDiscount()/100)));
				couponMap.setCouponId(couponRepo.findValidCoupon(couponMap.getTotalMRP()));
			}
		}
		if(bagDto.getNewSize()!=null) {
			List<BagProducts> prods = bagRepo.findByProductUsernSize(bagDto.getProductId(),userId,bagDto.getNewSize());
			long oldMrp = getMrp(bagDto.getProductId(),bagDto.getSize()) * bagProd.getQuantity();
			long newMrp = getMrp(bagDto.getProductId(),bagDto.getNewSize()) * bagProd.getQuantity();
			long oldDiscount = (long)(oldMrp * ((float)prod.getDiscount()/100));
			long newDiscount = (long)(newMrp * ((float)prod.getDiscount()/100));
			couponMap.setTotalMRP(couponMap.getTotalMRP() - oldMrp + newMrp);
			couponMap.setDiscountOnMRP(couponMap.getDiscountOnMRP() - oldDiscount + newDiscount);
			couponMap.setCouponId(couponRepo.findValidCoupon(couponMap.getTotalMRP()));
			if(prods.size()==0) {
				bagProd.setSize(bagDto.getNewSize());
			}
			else {
				BagProducts p = prods.get(0);
				bagProd.setQuantity((p.getQuantity()+bagProd.getQuantity()));
				bagRepo.delete(bagProd);
				bagProd.setId(p.getId());
				bagProd.setSelected(p.getSelected());
				bagProd.setSize(p.getSize());
			}
		}
		couponMappingRepo.save(couponMap);
		bagRepo.save(bagProd);			
		apiResponse.setData(null);
		apiResponse.setMessage("Edited item from bag");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public long getMrp(long prodId, String size) {
		long mrp = (long)0;
		Size sz = sizeRepo.findByProductId(prodId).get(0);
		if(size.equals("XS"))
			mrp = sz.getXSamount();
		else if(size.equals("S"))
			mrp = sz.getSamount();
		else if(size.equals("M"))
			mrp = sz.getMamount();
		else if(size.equals("L"))
			mrp = sz.getLamount();
		else if(size.equals("XL"))
			mrp = sz.getXLamount();
		else if(size.equals("XXL"))
			mrp = sz.getXXLamount();
		return mrp;
	}
	
	public long getAvailablity(long prodId, String size) {
		long mrp = (long)0;
		Size sz = sizeRepo.findByProductId(prodId).get(0);
		if(size.equals("XS"))
			mrp = sz.getXSavailable();
		else if(size.equals("S"))
			mrp = sz.getSavailable();
		else if(size.equals("M"))
			mrp = sz.getMavailable();
		else if(size.equals("L"))
			mrp = sz.getLavailable();
		else if(size.equals("XL"))
			mrp = sz.getXLavailable();
		else if(size.equals("XXL"))
			mrp = sz.getXXLavailable();
		return mrp;
	}

}
