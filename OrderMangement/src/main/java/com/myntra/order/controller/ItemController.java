package com.myntra.order.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.order.common.APIResponse;
import com.myntra.order.service.ItemService;

@CrossOrigin
@RestController
@RequestMapping("/item")
public class ItemController {
	
	private ItemService itemService;

	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@GetMapping("track/{itemId}")
	public APIResponse getCurrentOrders(@PathVariable Long itemId) {
		return itemService.trackItem(itemId);
	}
}
