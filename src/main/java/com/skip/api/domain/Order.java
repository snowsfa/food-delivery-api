package com.skip.api.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skip.api.enums.OrderStatusEnum;

@Entity
public class Order {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    
    private LocalDateTime date;
    
    @OneToOne
    private Customer customer;
    
    @Size(min=1, max=200)
    private String deliveryAddress;
    
    @Size(min=1, max=50)
    private String contact;
    
    @OneToOne
    private Store store;
    
    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<OrderItem> orderItems;
    
    private BigDecimal total;
    
    private OrderStatusEnum Status;
    
    private LocalDateTime lastUpdate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	@JsonIgnore
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public BigDecimal getTotal() {
		return total;
	}

	@JsonIgnore
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public OrderStatusEnum getStatus() {
		return Status;
	}

	@JsonIgnore
	public void setStatus(OrderStatusEnum status) {
		Status = status;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	@JsonIgnore
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
        
}
