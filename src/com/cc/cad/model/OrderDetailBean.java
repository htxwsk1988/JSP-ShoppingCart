package com.cc.cad.model;

//EJB representing each record in shop.OrderDetail table.
public class OrderDetailBean {
	
	private long orderId;
	private long movieId;
	private int num;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}
