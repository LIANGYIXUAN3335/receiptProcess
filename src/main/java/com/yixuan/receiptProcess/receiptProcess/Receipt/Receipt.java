package com.yixuan.receiptProcess.receiptProcess.Receipt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Receipt {

    private UUID id ;
	private String retailer;
	private LocalDate purchaseDate;
	private LocalTime purchaseTime;
	private List<Item> items;
	private double total;
	
	@Override
	public String toString() {
		return "Receipt [id=" + id + ", retailer=" + retailer + ", purchaseDate=" + purchaseDate + ", purchaseTime="
				+ purchaseTime + ", items=" + items + ",total=" +total + "]";
	}

	public Receipt(UUID id,  String retailer,
			 LocalDate purchaseDate, LocalTime purchaseTime,
			List<Item> items,double total) {
		super();
		this.id = id;
		this.retailer = retailer;
		this.purchaseDate = purchaseDate;
		this.purchaseTime = purchaseTime;
		this.items = items;
		this.total = total;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getRetailer() {
		return retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public LocalTime getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(LocalTime purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	


}
