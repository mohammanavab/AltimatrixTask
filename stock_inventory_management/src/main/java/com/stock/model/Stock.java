package com.stock.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "stock")
public class Stock {
	@Id
	@GeneratedValue
	private Integer stockId;
	private Integer productId;
	private String stockName;
	private Date purchaseDate;
	private Date SellingDate;
	private double purchaSeprice;
	private double sellingPrice;
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getSellingDate() {
		return SellingDate;
	}
	public void setSellingDate(Date sellingDate) {
		SellingDate = sellingDate;
	}
	public double getPurchaSeprice() {
		return purchaSeprice;
	}
	public void setPurchaSeprice(double purchaSeprice) {
		this.purchaSeprice = purchaSeprice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}



}
