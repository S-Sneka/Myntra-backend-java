package com.myntra.order.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.myntra.order.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="item")
public class Item extends Auditable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	@Column
	private Long productId;
	@Column
	private String size;
	@Column
	private String quantity;
	@Column
	private Status status;
	@Column
	private Date dispatchedAt;
	@Column
	private Date shippedAt;
	@Column
	private Date deliveredAt;
	@Column
	private Long orderId;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getDispatchedAt() {
		return dispatchedAt;
	}
	public void setDispatchedAt(Date dispatchedAt) {
		this.dispatchedAt = dispatchedAt;
	}
	public Date getShippedAt() {
		return shippedAt;
	}
	public void setShippedAt(Date shippedAt) {
		this.shippedAt = shippedAt;
	}
	public Date getDeliveredAt() {
		return deliveredAt;
	}
	public void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
}
