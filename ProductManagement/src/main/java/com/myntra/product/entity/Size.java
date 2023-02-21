package com.myntra.product.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="Size")
public class Size {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long productId;
	@Column
	private Long XSavailable;
	@Column
	private Long Savailable;
	@Column
	private Long Mavailable;
	@Column
	private Long Lavailable;
	@Column
	private Long XLavailable;
	@Column
	private Long XXLavailable;
	@Column
	private Long XSamount;
	@Column
	private Long Samount;
	@Column
	private Long Mamount;
	@Column
	private Long Lamount;
	@Column
	private Long XLamount;
	@Column
	private Long XXLamount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getXSavailable() {
		return XSavailable;
	}
	public void setXSavailable(Long xSavailable) {
		XSavailable = xSavailable;
	}
	public Long getSavailable() {
		return Savailable;
	}
	public void setSavailable(Long savailable) {
		Savailable = savailable;
	}
	public Long getMavailable() {
		return Mavailable;
	}
	public void setMavailable(Long mavailable) {
		Mavailable = mavailable;
	}
	public Long getLavailable() {
		return Lavailable;
	}
	public void setLavailable(Long lavailable) {
		Lavailable = lavailable;
	}
	public Long getXLavailable() {
		return XLavailable;
	}
	public void setXLavailable(Long xLavailable) {
		XLavailable = xLavailable;
	}
	public Long getXXLavailable() {
		return XXLavailable;
	}
	public void setXXLavailable(Long xXLavailable) {
		XXLavailable = xXLavailable;
	}
	public Long getXSamount() {
		return XSamount;
	}
	public void setXSamount(Long xSamount) {
		XSamount = xSamount;
	}
	public Long getSamount() {
		return Samount;
	}
	public void setSamount(Long samount) {
		Samount = samount;
	}
	public Long getMamount() {
		return Mamount;
	}
	public void setMamount(Long mamount) {
		Mamount = mamount;
	}
	public Long getLamount() {
		return Lamount;
	}
	public void setLamount(Long lamount) {
		Lamount = lamount;
	}
	public Long getXLamount() {
		return XLamount;
	}
	public void setXLamount(Long xLamount) {
		XLamount = xLamount;
	}
	public Long getXXLamount() {
		return XXLamount;
	}
	public void setXXLamount(Long xXLamount) {
		XXLamount = xXLamount;
	}
	
}
