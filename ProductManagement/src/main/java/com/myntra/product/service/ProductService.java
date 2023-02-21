package com.myntra.product.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.myntra.product.common.APIResponse;
import com.myntra.product.dao.ProductDao;
import com.myntra.product.dto.OrderedProductDetails;
import com.myntra.product.dto.ProductsDto;
import com.myntra.product.dto.ProductsDtoM;
import com.myntra.product.dto.SingleProductDto;
import com.myntra.product.entity.CategoryProductMapping;
import com.myntra.product.entity.Product;
import com.myntra.product.entity.ProductImage;
import com.myntra.product.entity.WishListProducts;
import com.myntra.product.repository.CatProdRepository;
import com.myntra.product.repository.ImageRepository;
import com.myntra.product.repository.ProductRepository;
import com.myntra.product.repository.SizeRepository;
import com.myntra.product.repository.SpecificationRepository;
import com.myntra.product.repository.WishListRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepo;
	private SizeRepository sizeRepo;
	private ImageRepository imageRepo;
	private CatProdRepository catProdRepo;
	private APIResponse apiResponse;
	private SingleProductDto singleProduct;
	private Product prod;
	private SpecificationRepository specificationRepo;
	private WishListRepository wishListRepo;
	private OrderedProductDetails orderedProduct;

	public ProductService(ProductRepository productRepo, SizeRepository sizeRepo, ImageRepository imageRepo,
			CatProdRepository catProdRepo, APIResponse apiResponse, SingleProductDto singleProduct, Product prod,
			SpecificationRepository specificationRepo, WishListRepository wishListRepo,
			OrderedProductDetails orderedProduct) {
		super();
		this.productRepo = productRepo;
		this.sizeRepo = sizeRepo;
		this.imageRepo = imageRepo;
		this.catProdRepo = catProdRepo;
		this.apiResponse = apiResponse;
		this.singleProduct = singleProduct;
		this.prod = prod;
		this.specificationRepo = specificationRepo;
		this.wishListRepo = wishListRepo;
		this.orderedProduct = orderedProduct;
	}

	public APIResponse sendProducts(Long userId,Long id) {
		List<CategoryProductMapping> catProds = catProdRepo.findByCategoryId(id);
		if(catProds.size()==0) {
			catProds = catProdRepo.findAll();
		}
		List<Product> prods = new LinkedList<>();
		for(CategoryProductMapping catProd:catProds) {
			prod = productRepo.findById(catProd.getProductId()).orElse(null);
			prods.add(prod);
		}
		List<ProductsDto> products = new LinkedList<>();
		List<Long> wishListed = new LinkedList<>();
		if(userId!=0)
			wishListed = wishListRepo.findWishListedProducts(userId);
		for(Product p:prods) {
			List<ProductImage> images = imageRepo.findByProductId(p.getId());
			List<String> imageUrls = new LinkedList<>();
			for(ProductImage im:images) {
				imageUrls.add(im.getUrl());
			}
			ProductsDto product = new ProductsDto();
			product.setImages(imageUrls);
			product.setProduct(setProductDao(p,wishListed.contains(p.getId())));
			products.add(product);
		}
		products.addAll(products);
		products.addAll(products);
		apiResponse.setData(products);
		apiResponse.setMessage("Products");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse sendProductsM(Long userId,Long id) {
		List<CategoryProductMapping> catProds = catProdRepo.findByCategoryId(id);
		if(catProds.size()==0) {
			catProds = catProdRepo.findAll();
		}
		List<Product> prods = new LinkedList<>();
		for(CategoryProductMapping catProd:catProds) {
			prod = productRepo.findById(catProd.getProductId()).orElse(null);
			prods.add(prod);
		}
		List<ProductsDtoM> productsM = new LinkedList<>();
		List<Long> wishListed = new LinkedList<>();
		if(userId!=0)
			wishListed = wishListRepo.findWishListedProducts(userId);
		for(Product p:prods) {
			ProductsDtoM productM = new ProductsDtoM();
			productM.setImageUrl(imageRepo.findByProductId(p.getId()).get(0).getUrl()); 
			productM.setProduct(setProductDao(p,wishListed.contains(p.getId())));
			productsM.add(productM);
		}
		productsM.addAll(productsM);
		productsM.addAll(productsM);
		apiResponse.setData(productsM);
		apiResponse.setMessage("Products");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public ProductDao setProductDao(Product p,boolean isWishListed) {
		ProductDao productDao = new ProductDao();
		productDao.setBrand(p.getBrand());
		productDao.setDiscount(p.getDiscount());
		productDao.setId(p.getId());
		productDao.setMrp(p.getMrp());
		productDao.setName(p.getName());
		productDao.setRatings(p.getRatings());
		productDao.setStar(p.getStar());
		productDao.setWishListed(isWishListed);
		return productDao;
	}
	
	public APIResponse sendProduct(Long userId,Long id) {
		List<WishListProducts> wishListed = new LinkedList<>();
		if(userId!=0)
			wishListed = wishListRepo.findByProductUserId(id, userId);
		Product p = productRepo.findById(id).orElse(null);
		singleProduct.setProduct(p);
		List<ProductImage> images = imageRepo.findByProductId(p.getId());
		List<String> imageUrls = new LinkedList<>();
		for(ProductImage im:images) {
			imageUrls.add(im.getUrl());
		}
		if(wishListed.size()!=0)
			singleProduct.setIsWishListed(true);
		singleProduct.setImages(imageUrls); 
		singleProduct.setSize(sizeRepo.findByProductId(p.getId()).get(0));
		singleProduct.setSpecification(specificationRepo.findByProductId(p.getId()).get(0));
		apiResponse.setData(singleProduct);
		apiResponse.setMessage("Product");
		apiResponse.setStatus(true);
		return apiResponse;
	}

	public APIResponse sendProductDetails(Long productId) {
		Product product = productRepo.findById(productId).orElse(null);
		orderedProduct.setBrand(product.getBrand());
		orderedProduct.setName(product.getName());
		orderedProduct.setImage(imageRepo.findByProductId(productId).get(0).getUrl());
		apiResponse.setData(orderedProduct);
		return apiResponse;
	}

}
