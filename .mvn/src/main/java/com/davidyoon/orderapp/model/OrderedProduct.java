package com.davidyoon.orderapp.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "orderedProductId")
public class OrderedProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderedProductId;
	
	@OneToOne
	@JoinColumn(name="productId")
	private Product product;
	
	private Integer quantity;
	
	private LocalDateTime createdDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderListId")
	private OrderList orderList;
	
	public OrderedProduct() {
		
	}

	public OrderedProduct(long orderedProductId, Product product, Integer quantity, LocalDateTime createdDate,
			OrderList orderList) {
		super();
		this.orderedProductId = orderedProductId;
		this.product = product;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.orderList = orderList;
	}

	/**
	 * @return the orderedProductId
	 */
	public long getOrderedProductId() {
		return orderedProductId;
	}

	/**
	 * @param orderedProductId the orderedProductId to set
	 */
	public void setOrderedProductId(long orderedProductId) {
		this.orderedProductId = orderedProductId;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the createdDate
	 */
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the order
	 */
	public OrderList getOrderList() {
		return orderList;
	}

	/**
	 * @param orderList the order to set
	 */
	public void setOrderList(OrderList orderList) {
		this.orderList = orderList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderedProduct [orderedProductId=" + orderedProductId + ", product=" + product + ", quantity="
				+ quantity + ", createdDate=" + createdDate + ", order=" + orderList + "]";
	}
	
}
