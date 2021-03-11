package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;


/*id: number;
productName: string;
price: Number;
productDesc: string;*/

@Entity
@Table(name = "products_tbl")
public class Product {

    @Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
	private Integer productId; 
    
    @Column(length = 20)
    @JsonProperty("productName")
	private String name;
    
    
	private double price;
	
	@Column(length = 50)
	private String productDesc;
	
	private LocalDate expDate;
	
	public Product() {
	System.out.println("in contrs of" + getClass().getName());
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String name, double price, LocalDate expDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.expDate = expDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", productDesc="
				+ productDesc + ", expDate=" + expDate + "]";
	}
	
	
	
}
