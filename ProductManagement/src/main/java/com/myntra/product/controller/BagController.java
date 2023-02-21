package com.myntra.product.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.product.common.APIResponse;
import com.myntra.product.dto.AlterBagDto;
import com.myntra.product.dto.EditBagDto;
import com.myntra.product.dto.ListRemoveBagDto;
import com.myntra.product.service.BagService;

@CrossOrigin
@RestController
@RequestMapping("/bag")
public class BagController {

	private BagService bagService;
	
	public BagController(BagService bagService) {
		super();
		this.bagService = bagService;
	}
	
	@PostMapping("/add/{userId}")
	public APIResponse addToBag(@PathVariable Long userId,@RequestBody AlterBagDto bag) {
		return bagService.addToBag(userId,bag);
	}
	
	@PostMapping("/move/{userId}")
	public APIResponse moveToBag(@PathVariable Long userId,@RequestBody AlterBagDto bag) {
		return bagService.moveToBag(userId,bag);
	}
	
	@GetMapping("/{userId}")
	public APIResponse getBag(@PathVariable Long userId) {
		return bagService.getBag(userId);
	}
	
	@PostMapping("/{userId}")
	public APIResponse removeFromBag(@PathVariable Long userId,@RequestBody ListRemoveBagDto bag) {
		return bagService.removeFromBag(userId,bag);
	}
	
	@PutMapping("/{userId}")
	public APIResponse editBag(@PathVariable Long userId,@RequestBody EditBagDto bag) {
		return bagService.editBag(userId,bag);
	}
}
