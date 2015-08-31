package com.cc.cad.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ShoppingCartDAO {
	
	private Connection conn=null; 
	private ResultSet rs=null; 
	private PreparedStatement ps=null; 
	
	private double totalPrice = 0.0;
	
	// HashMap<movieId, movieNumber>
	HashMap<String, String> map = new HashMap<String, String>(); 
	
	// Add item. 
	public void addItem(String itemId, String itemNum){
		map.put(itemId, itemNum); 
	}
	
	// Remove item. 
	public void delItem(String itemId){
		map.remove(itemId); 
	}
	
	// Remove all item. 
	public void delAllItem(){
		map.clear(); 
	}
	
	// Edit number. 
	public void editItemNum(String itemId, String itemNum){
		map.put(itemId, itemNum); 
	}
	
	// Return total price. 
	public double getTotalPrice(){
		return totalPrice; 
	}
	
	
	// Show shopping cart.
	public ArrayList<MovieBean> showMyCart(){
		
		ArrayList<MovieBean> al = new ArrayList<MovieBean>(); 
		
		try{
			
			String sql = "SELECT * FROM shop.Movies where id IN "; 
			
			Iterator it = map.keySet().iterator(); 
			
			String subSQL = "("; 
			
			while(it.hasNext()){
				
				String id = (String)it.next();  
				
				if(it.hasNext()){
					subSQL = subSQL + id + ','; 
				}else{
					subSQL = subSQL + id + ')'; 
				}
				
			}
			
			sql = sql + subSQL; 
			
			conn = new ConnDB().getConn(); 
			
			ps = conn.prepareStatement(sql); 
			
			rs = ps.executeQuery(); 
			
			this.totalPrice = 0.0;
			
			while(rs.next()){
				MovieBean bean = new MovieBean(); 
				
				int id = rs.getInt(1);
				bean.setId(id);
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				double price = rs.getDouble(4);
				bean.setPrice(price);
				bean.setInventoryNum(rs.getInt(5));
				bean.setPublisher(rs.getString(6));
				bean.setImage(rs.getString(7));
				bean.setType(rs.getString(8));
				
				al.add(bean); 
				
				this.totalPrice += price * Integer.parseInt(this.getMovieNumById(id+""));
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.close(); 
		}
		
		return al; 
		
	}
	
	
	public String getMovieNumById(String id){
		return (String)map.get(id);
	}
	
	// Close ODBC resources. 
	public void close(){
		 try{
			 if(rs!=null){
				 rs.close();
				 rs=null; 
			 }
			 
			 if(ps!=null){
				 ps.close();
				 ps=null; 
			 }
			 
			 if(conn!=null){
				 conn.close();
			 }
			 
		 }catch(Exception ex){
			 ex.printStackTrace();
		 } 
	 }
}
