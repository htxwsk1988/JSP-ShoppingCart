package com.cc.cad.model;

import java.util.Date;

//EJB representing each record in shop.Order table.
public class OrderBean {
	
	private long orderId; 
	private long userId; 
	private Date orderDate;
	private String payMethod;
	private byte isPaid;
	private double totalPrice;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public byte getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(byte isPaid) {
		this.isPaid = isPaid;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
