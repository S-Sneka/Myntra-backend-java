package com.myntra.authentication.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="url")
public class UrlConfiguration {
	private String order;
	private String home;
	private String product;
	private String bag;
	private String wishlist;
	private String coupon;
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getBag() {
		return bag;
	}
	public void setBag(String bag) {
		this.bag = bag;
	}
	public String getWishlist() {
		return wishlist;
	}
	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}
}
