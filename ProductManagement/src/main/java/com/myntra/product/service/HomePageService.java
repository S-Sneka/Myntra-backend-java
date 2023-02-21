package com.myntra.product.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.myntra.product.common.APIResponse;
import com.myntra.product.dao.ChildCategoryDao;
import com.myntra.product.dto.ShopByCategories;
import com.myntra.product.entity.Category;
import com.myntra.product.entity.ChildCategory;
import com.myntra.product.entity.HomeCategories;
import com.myntra.product.entity.HomePage;
import com.myntra.product.entity.SubCategory;
import com.myntra.product.repository.CategoryRepository;
import com.myntra.product.repository.ChildCatRepository;
import com.myntra.product.repository.HomeCategoriesRepository;
import com.myntra.product.repository.HomeRepository;
import com.myntra.product.repository.SubCatRepository;

@Service
public class HomePageService {
	private CategoryRepository catRepo;
	private ChildCatRepository childRepo;
	private SubCatRepository subCatRepo;
	private APIResponse apiResponse;
	private HomeRepository homeRepo;
	private HomeCategoriesRepository homeCatRepo;

	public HomePageService(CategoryRepository catRepo, ChildCatRepository childRepo, SubCatRepository subCatRepo,
			APIResponse apiResponse, HomeRepository homeRepo, HomeCategoriesRepository homeCatRepo) {
		super();
		this.catRepo = catRepo;
		this.childRepo = childRepo;
		this.subCatRepo = subCatRepo;
		this.apiResponse = apiResponse;
		this.homeRepo = homeRepo;
		this.homeCatRepo = homeCatRepo;
	}


	public APIResponse sendCategories() {
		List<Category> categories = catRepo.findAll();
		Map<String,List<Map<String,List<ChildCategoryDao>>>> subCategories = new LinkedHashMap<>();
		for(Category c:categories) {
			subCategories.put(c.getCategoryName(),getSubCategories(c.getCategoryId()));
		}
		apiResponse.setData(subCategories);
		apiResponse.setMessage("Categories");
		apiResponse.setStatus(true);
		return apiResponse;
	}


	public List<Map<String,List<ChildCategoryDao>>> getSubCategories(Long id) {
		List<SubCategory> subCat = subCatRepo.findByCategoryId(id);
		Map<String,List<ChildCategoryDao>> col1 = new HashMap<>();
		Map<String,List<ChildCategoryDao>> col2 = new HashMap<>();
		Map<String,List<ChildCategoryDao>> col3 = new HashMap<>();
		Map<String,List<ChildCategoryDao>> col4 = new HashMap<>();
		Map<String,List<ChildCategoryDao>> col5 = new HashMap<>();
		for(SubCategory sub:subCat) {
			List<ChildCategory> c = childRepo.findBySubCategoryId(sub.getSubCategoryId());
			List<ChildCategoryDao> childDao = new LinkedList<>();
			for(ChildCategory dao:c) {
				childDao.add(new ChildCategoryDao(dao.getChildCategoryId(),dao.getChildCategoryName()));
			}
			int colNo = sub.getColumnNo();
			if(colNo==1)
				col1.put(sub.getSubCategoryName(), childDao);
			else if(colNo==2)
				 col2.put(sub.getSubCategoryName(), childDao);
			else if(colNo==3)
				 col3.put(sub.getSubCategoryName(), childDao);
			else if(colNo==4)
				 col4.put(sub.getSubCategoryName(), childDao);
			else
				col5.put(sub.getSubCategoryName(), childDao);
		}
		List<Map<String,List<ChildCategoryDao>>> childCategories = new LinkedList<>();
		childCategories.add(col1);
		childCategories.add(col2);
		childCategories.add(col3);
		childCategories.add(col4);
		childCategories.add(col5);
		return childCategories;
	}

	public APIResponse sendCategoriesM() {
		apiResponse.setData(catRepo.findAll());
		apiResponse.setMessage("Categories");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse shopByCategoriesM() {
		List<Category> categories = catRepo.findAll();
		List<ShopByCategories> shopByList = new LinkedList<>();
		for(Category c:categories) {
			ShopByCategories shopBy = new ShopByCategories();
			shopBy.setCategoryName(c.getCategoryName());
			shopBy.setImage(c.getImage());
			List<SubCategory> subCat = subCatRepo.findByCategoryId(c.getCategoryId());
			Map<String,List<ChildCategoryDao>> subCategories = new LinkedHashMap<>();
			for(SubCategory sub:subCat) {
				List<ChildCategory> child = childRepo.findBySubCategoryId(sub.getSubCategoryId());
				List<ChildCategoryDao> childDao = new LinkedList<>();
				for(ChildCategory dao:child) {
					childDao.add(new ChildCategoryDao(dao.getChildCategoryId(),dao.getChildCategoryName()));
				}
				subCategories.put(sub.getSubCategoryName(), childDao);
			}
			shopBy.setSubCategory(subCategories);
			shopByList.add(shopBy);
		}
		apiResponse.setData(shopByList);
		apiResponse.setMessage("Shop By Categories");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse sendHomePage() {
		List<HomePage> home = homeRepo.findAll();
		Map<String,List<HomeCategories>> homePageCategories = new HashMap<>();
		for(HomePage h:home) {
			String catName = h.getCategory();
			List<HomeCategories> list = homeCatRepo.findByHomeCategoryId(h.getId());
			homePageCategories.put(catName, list);
		}
		apiResponse.setData(homePageCategories);
		apiResponse.setMessage("Home Page");
		apiResponse.setStatus(true);
		return apiResponse;
	}
}
