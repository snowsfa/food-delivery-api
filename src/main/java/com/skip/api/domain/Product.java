package com.skip.api.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    
    @OneToOne
    @JsonIgnore
    private Store store;
    
    @Transient
    private long storeId;
    
    @Size(min=1, max=50)
    private String name;
    
    @Size(min=1, max=200)
    private String description;
    
    @NotNull
    private BigDecimal price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getStoreId() {
		return store.getId();
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}        
    
}
