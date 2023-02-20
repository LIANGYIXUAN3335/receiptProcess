package com.yixuan.receiptProcess.receiptProcess.Receipt;


public class Item {
	private String shortDescription;
	
	private Double price;
	
//	@ManyToOne
//	@JsonIgnore
//	private Receipt receipt;
	
	public Item(String shortDescription, Double price) {
		super();
		this.shortDescription = shortDescription;
		this.price = price;
	}
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



}
