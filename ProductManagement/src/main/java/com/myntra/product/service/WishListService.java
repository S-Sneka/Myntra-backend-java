package com.myntra.product.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.myntra.product.common.APIResponse;
import com.myntra.product.dao.WishListDao;
import com.myntra.product.dto.AlterBagDto;
import com.myntra.product.dto.AlterWishDto;
import com.myntra.product.dto.ListAlterWishDto;
import com.myntra.product.dto.ListRemoveBagDto;
import com.myntra.product.dto.WishViewDto;
import com.myntra.product.entity.Product;
import com.myntra.product.entity.WishListProducts;
import com.myntra.product.repository.ImageRepository;
import com.myntra.product.repository.ProductRepository;
import com.myntra.product.repository.SizeRepository;
import com.myntra.product.repository.WishListRepository;

@Service
public class WishListService {
	private ProductRepository productRepo;
	private SizeRepository sizeRepo;
	private ImageRepository imageRepo;
	private APIResponse apiResponse;
	private WishListRepository wishListRepo;
	private BagService bagService;
	private WishListProducts wishList;
	private WishViewDto wishView;
	private ListRemoveBagDto removefromBag;

	
	public WishListService(ProductRepository productRepo, SizeRepository sizeRepo, ImageRepository imageRepo,
			APIResponse apiResponse, WishListRepository wishListRepo, BagService bagService, WishListProducts wishList,
			WishViewDto wishView,ListRemoveBagDto removeList) {
		super();
		this.productRepo = productRepo;
		this.sizeRepo = sizeRepo;
		this.imageRepo = imageRepo;
		this.apiResponse = apiResponse;
		this.wishListRepo = wishListRepo;
		this.bagService = bagService;
		this.wishList = wishList;
		this.wishView = wishView;
		this.removefromBag = removeList;
	}

	public APIResponse addToWish(Long userId,AlterWishDto wishDto) {
		wishList.setUserId(userId);
		wishList.setProductId(wishDto.getProductId());
		wishList.setId(null);
		wishListRepo.save(wishList);
		apiResponse.setData(null);
		apiResponse.setMessage("Added to wishlist");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse moveToWish(Long userId,AlterBagDto wishDto) {
		List<WishListProducts> wish = wishListRepo.findByProductUserId(wishDto.getProductId(),userId);
		if(wish.size()==0) {
			wishList.setUserId(userId);
			wishList.setProductId(wishDto.getProductId());
			wishList.setId(null);
			wishListRepo.save(wishList);
		}
		List<AlterBagDto> bag = new LinkedList<>();
		bag.add(wishDto);
		removefromBag.setList(bag);
		bagService.removeFromBag(userId, removefromBag);
		apiResponse.setData(null);
		apiResponse.setMessage("Moved to wishlist");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse getWishList(Long userId) {			
		List<WishListDao> wishDisplayList = new LinkedList<>();
		List<WishListProducts> wishListProducts = wishListRepo.findByUserId(userId);
		long count = 0;
		for(WishListProducts wp:wishListProducts) {
			WishListDao wl = new WishListDao();
			Product p = productRepo.findById(wp.getProductId()).orElse(null);
			wl.setBrand(p.getBrand());
			wl.setDiscount(p.getDiscount());
			wl.setImage(imageRepo.findByProductId(p.getId()).get(0).getUrl());
			wl.setMrp(p.getMrp());
			wl.setProductId(p.getId());
			wl.setProductName(p.getName());
			wl.setRatings(p.getRatings());
			wl.setStar(p.getStar());
			wl.setSeller(p.getSeller());
			wl.setSize(sizeRepo.findByProductId(p.getId()).get(0));
			wishDisplayList.add(wl);
			count++;
		}
		wishView.setCountOfItems(count);
		wishView.setItems(wishDisplayList);
		apiResponse.setData(wishView);
		apiResponse.setMessage("Wish List");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse removeFromWishList(Long userId,ListAlterWishDto wish) {
		for(Long product:wish.getProductIds()) {
			List<WishListProducts> wishList = wishListRepo.findByProductUserId(product,userId);
			wishListRepo.delete(wishList.get(0));			
		}
		apiResponse.setData(null);
		apiResponse.setMessage("Removed items from wish list");
		apiResponse.setStatus(true);
		return apiResponse;
	}
}
