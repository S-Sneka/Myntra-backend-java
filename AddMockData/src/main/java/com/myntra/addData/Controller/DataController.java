package com.myntra.addData.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.addData.Entity.Category;
import com.myntra.addData.Entity.ChildCategory;
import com.myntra.addData.Entity.Coupon;
import com.myntra.addData.Entity.HomeCategories;
import com.myntra.addData.Entity.HomePage;
import com.myntra.addData.Entity.Product;
import com.myntra.addData.Entity.ProductImage;
import com.myntra.addData.Entity.ProductSpecification;
import com.myntra.addData.Entity.Size;
import com.myntra.addData.Entity.SubCategory;
import com.myntra.addData.Entity.CategoryProductMapping;
import com.myntra.addData.Service.DataService;

@CrossOrigin
@RestController
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private DataService dataService;

	@PostMapping("/addCategory")
	public Category addCat(@RequestBody Category category) {
		return dataService.saveCat(category);
	}
	
	@PostMapping("/addSubCategory")
	public SubCategory addSub(@RequestBody SubCategory subCategory) {
		return dataService.saveSubCat(subCategory);
	}
	
	@PostMapping("/addChildCategory")
	public ChildCategory add(@RequestBody ChildCategory childCategory) {
		return dataService.saveChildCat(childCategory);
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return dataService.saveProduct(product);
	}
	
	@PostMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return dataService.updateProduct(product);
	}
	
	@PostMapping("/addSize")
	public Size add(@RequestBody Size size) {
		return dataService.saveSize(size);
	}
	
	@PostMapping("/addImage")
	public ProductImage add(@RequestBody ProductImage image) {
		return dataService.saveImage(image);
	}
	
	@PostMapping("/addspecification")
	public ProductSpecification add(@RequestBody ProductSpecification sp) {
		return dataService.saveSpecification(sp);
	}
	
	@PostMapping("/addHomeCatImage")
	public HomeCategories addCatImage(@RequestBody HomeCategories image) {
		return dataService.saveHomeCatImage(image);
	}
	
	@PostMapping("/productmapping")
	public CategoryProductMapping CategoryProductMapping(@RequestBody CategoryProductMapping map) {
		return dataService.saveMapping(map);
	}
	
	@PostMapping("/homeCategory")
	public HomePage addHomeCategory(@RequestBody HomePage homeCategory) {
		return dataService.saveHome(homeCategory);
	}
	
	@PostMapping("/coupon")
	public Coupon saveCoupon(@RequestBody Coupon coupon) {
		return dataService.saveCoupon(coupon);
	}
}