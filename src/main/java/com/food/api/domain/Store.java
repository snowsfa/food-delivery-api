package com.food.api.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    
    @Size(min=1, max=100)
    private String name;
    
    @ManyToMany
    @JoinTable(name="store_cuisine", joinColumns=
    {@JoinColumn(name="store_id")}, inverseJoinColumns=
      {@JoinColumn(name="cuisine_id")})
    private List<Cuisine> cuisines;
    
    @OneToMany(mappedBy="store", cascade=CascadeType.ALL)
    private List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cuisine> getCuisines() {
		return cuisines;
	}

	public void setCuisines(List<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}    
    
}
