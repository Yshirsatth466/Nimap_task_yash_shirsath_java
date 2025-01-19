package com.base.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long Cid;
	    
	    private String Cname;
	    
	    
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<Product> products;

	    
	    
	    public Long getCid() {
			return Cid;
		}
		public void setCid(Long cid) {
			Cid = cid;
		}
		public String getCname() {
			return Cname;
		}
		public void setCname(String cname) {
			Cname = cname;
		}
		public List<Product> getProducts() {
			return products;
		}
		public void setProducts(List<Product> products) {
			this.products = products;
		}
		}
