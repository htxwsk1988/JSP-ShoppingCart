package com.cc.cad.model;

import java.util.Date;

public class OrderCompleteInfoBean {
	
	private long USERID;
	private String USERNAME;
	private String FULLNAME;
	private String PASSWD;
	private String EMAIL;
	private String PHONE;
	private String ADDRESS;
	private String POSTCODE;
	private int LEVEL;
	private long orderId; 
	private long userId; 
	private Date orderDate;
	private String payMethod;
	private byte isPaid;
	private double totalPrice;
	
	public long getUSERID() {
		return USERID;
	}
	public void setUSERID(long uSERID) {
		USERID = uSERID;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getFULLNAME() {
		return FULLNAME;
	}
	public void setFULLNAME(String fULLNAME) {
		FULLNAME = fULLNAME;
	}
	public String getPASSWD() {
		return PASSWD;
	}
	public void setPASSWD(String pASSWD) {
		PASSWD = pASSWD;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getPOSTCODE() {
		return POSTCODE;
	}
	public void setPOSTCODE(String pOSTCODE) {
		POSTCODE = pOSTCODE;
	}
	public int getLEVEL() {
		return LEVEL;
	}
	public void setLEVEL(int lEVEL) {
		LEVEL = lEVEL;
	}
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
