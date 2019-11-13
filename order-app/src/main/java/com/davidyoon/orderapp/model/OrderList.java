package com.davidyoon.orderapp.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
				  generator = ObjectIdGenerators.PropertyGenerator.class, 
				  property = "orderListId")
public class OrderList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderListId;
	
	/*********************************
	 *  Customer Information
	 *********************************/
	private String lastName;
	
	private String firstName;
	
	private String companyName;
	
	private String email;
	
	private String contactNumber;
	
	/*********************************
	 *  Order Information
	 *********************************/
	private LocalDateTime creationDate;
	
	private LocalDateTime dueDate;
	
	@OneToMany(
		mappedBy="orderList",
		fetch= FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
	private List<OrderedProduct> orderedProducts;
	
	public OrderList() {
		
	}
	
	public OrderList(String lastName, String firstName, String companyName, String email,
			String contactNumber, LocalDateTime creationDate, LocalDateTime dueDate, List<OrderedProduct> orderedProducts) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.companyName = companyName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.creationDate = creationDate;
		this.dueDate = dueDate;
		this.orderedProducts = orderedProducts;
	}

	/**
	 * @return the orderId
	 */
	public long getOrderListId() {
		return orderListId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderListId(long orderListId) {
		this.orderListId = orderListId;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/**
	 * @return the creationDate
	 */
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the dueDate
	 */
	public LocalDateTime getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the orderedProducts
	 */
	public List<OrderedProduct> getOrderedProducts() {
		return orderedProducts;
	}

	/**
	 * @param orderedProducts the orderedProducts to set
	 */
	public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	
	public void addOrderedProduct(OrderedProduct orderedProduct) {
		this.orderedProducts.add(orderedProduct);
	}
	
	public void removeOrderedProduct(OrderedProduct orderedProduct) {
		this.orderedProducts.remove(orderedProduct);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [orderId=" + orderListId + ", lastName=" + lastName + ", firstName=" + firstName + ", companyName="
				+ companyName + ", email=" + email + ", contactNumber=" + contactNumber + ", creationDate="
				+ creationDate + ", dueDate=" + dueDate + "]";
	}
	
	

     
    // standard constructors / setters / getters / toString
}
