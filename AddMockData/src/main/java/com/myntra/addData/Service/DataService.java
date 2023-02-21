package com.myntra.addData.Service;

import org.springframework.stereotype.Service;

import com.myntra.addData.Entity.Category;
import com.myntra.addData.Entity.CategoryProductMapping;
import com.myntra.addData.Entity.ChildCategory;
import com.myntra.addData.Entity.Coupon;
import com.myntra.addData.Entity.HomeCategories;
import com.myntra.addData.Entity.HomePage;
import com.myntra.addData.Entity.Product;
import com.myntra.addData.Entity.ProductImage;
import com.myntra.addData.Entity.ProductSpecification;
import com.myntra.addData.Entity.Size;
import com.myntra.addData.Entity.SubCategory;
import com.myntra.addData.Repository.CatProdRepository;
import com.myntra.addData.Repository.CategoryRepository;
import com.myntra.addData.Repository.ChildCatRepository;
import com.myntra.addData.Repository.CouponRepository;
import com.myntra.addData.Repository.HomeCategoriesRepository;
import com.myntra.addData.Repository.HomeRepository;
import com.myntra.addData.Repository.ImageRepository;
import com.myntra.addData.Repository.ProductRepository;
import com.myntra.addData.Repository.SizeRepository;
import com.myntra.addData.Repository.SpecificationRepository;
import com.myntra.addData.Repository.SubCatRepository;

@Service
public class DataService {

	private CategoryRepository catRepo;
	private ProductRepository productRepo;
	private SizeRepository sizeRepo;
	private ImageRepository imageRepo;
	private ChildCatRepository childRepo;
	private SubCatRepository subCatRepo;
	private CatProdRepository catProdRepository;
	private HomeCategoriesRepository homeCatRepository;
	private HomeRepository homeRepo;
	private SpecificationRepository specificationRepo;
	private CouponRepository couponRepo;

	public DataService(CategoryRepository catRepo, ProductRepository productRepo, SizeRepository sizeRepo,CouponRepository couponRepo,
			ImageRepository imageRepo, ChildCatRepository childRepo, SubCatRepository subCatRepo,CatProdRepository catProdRepository,
			HomeCategoriesRepository homeCatRepository,HomeRepository homeRepo,SpecificationRepository specificationRepo) {
		super();
		this.catRepo = catRepo;
		this.productRepo = productRepo;
		this.sizeRepo = sizeRepo;
		this.imageRepo = imageRepo;
		this.childRepo = childRepo;
		this.subCatRepo = subCatRepo;
		this.catProdRepository = catProdRepository;
		this.homeCatRepository = homeCatRepository;
		this.homeRepo = homeRepo;
		this.specificationRepo = specificationRepo;
		this.couponRepo = couponRepo;
	}

	public Category saveCat(Category category) {
		return catRepo.save(category);
	}

	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}

	public SubCategory saveSubCat(SubCategory subCategory) {
		return subCatRepo.save(subCategory);
	}

	public ChildCategory saveChildCat(ChildCategory childCategory) {
		return childRepo.save(childCategory);
	}

	public Size saveSize(Size size) {
		return sizeRepo.save(size);
	}

	public ProductImage saveImage(ProductImage image) {
		return imageRepo.save(image);
	}

	public CategoryProductMapping saveMapping(CategoryProductMapping map) {
		return catProdRepository.save(map);
	}

	public HomeCategories saveHomeCatImage(HomeCategories image) {
		return homeCatRepository.save(image);
	}

	public HomePage saveHome(HomePage homeCategory) {
		return homeRepo.save(homeCategory);
	}

	public ProductSpecification saveSpecification(ProductSpecification sp) {
		return specificationRepo.save(sp);
	}

	public Product updateProduct(Product p) {
		Product productDao = productRepo.findById(p.getId()).orElse(null);
//		productDao.setBrand(p.getBrand());
//		productDao.setDiscount(p.getDiscount());
//		productDao.setMrp(p.getMrp());
//		productDao.setName(p.getName());
//		productDao.setRatings(p.getRatings());
//		productDao.setStar(p.getStar());
		productDao.setEmiOption(p.getEmiOption());
		productDao.setOffer(p.getOffer());
		productDao.setPincode(p.getPincode());
		productDao.setProductDetails(p.getProductDetails());
		productDao.setSeller(p.getSeller());
		productDao.setSizeFit(p.getSizeFit());
//		productDao.setColor(p.getColor());
//		productDao.setDescription(p.getDescription());
//		productDao.setDiscount(p.getDiscount());
//		productDao.setDescription(p.getDescription());
		return productRepo.save(productDao);
	}
	
	public Coupon saveCoupon(Coupon c) {
		return couponRepo.save(c);	
	}
	
}
