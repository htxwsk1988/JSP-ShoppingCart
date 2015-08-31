package com.cc.cad.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderBeanDAO {
	
	private Connection conn=null; 
	private ResultSet rs=null; 
	private PreparedStatement ps=null; 
	
	// Add order records into database.
	public OrderCompleteInfoBean addOrder(ShoppingCartDAO sdao, String userId){
		
		OrderCompleteInfoBean bean = new OrderCompleteInfoBean();
		
		boolean b = true; 
		
		try{
			
			// Add records into shop.Orders
			conn = new ConnDB().getConn(); 
			
			ps = conn.prepareStatement("INSERT INTO shop.Orders (userId, isPaid, totalPrice) VALUES (?, ?, ?)"); 
			
			ps.setString(1, userId);
			ps.setByte(2, (byte)0);
			ps.setDouble(3, sdao.getTotalPrice());
			
			int added = ps.executeUpdate(); 
			
			if(added==1){
				
				ps = conn.prepareStatement("SELECT max(orderId) FROM shop.Orders");
				
				rs = ps.executeQuery(); 
				
				int orderId = 0;
				
				if(rs.next()){
					orderId = rs.getInt(1);
				}
				
				// Add records into shop.OrderDetial.
				ArrayList<MovieBean> al = sdao.showMyCart(); 
				
				Statement sm = conn.createStatement(); 
				
				for(int i=0; i<al.size(); i++){
					
					MovieBean mb = (MovieBean)al.get(i);
					
					sm.addBatch("INSERT INTO shop.OrderDetail VALUES ('"+orderId+"', '"+mb.getId()+"', '"+sdao.getMovieNumById(mb.getId()+"")+"')");
				}
				
				sm.executeBatch();
				
				String sql = "SELECT orderId, FULLNAME, ADDRESS, POSTCODE, PHONE, totalPrice, USERNAME, EMAIL FROM shop.USERS INNER JOIN shop.Orders " + 
								"ON shop.USERS.userId = shop.Orders.userId WHERE orderId = ? AND shop.USERS.USERID = (SELECT UserId from shop.Orders WHERE orderId = ?)";
				
				
				ps = conn.prepareStatement(sql); 
				
				ps.setLong(1, orderId);
				ps.setLong(2, orderId);
				
				rs = ps.executeQuery(); 
				
				if(rs.next()){
					
					bean.setOrderId(rs.getLong(1));
					bean.setFULLNAME(rs.getString(2));
					bean.setADDRESS(rs.getString(3));
					bean.setPOSTCODE(rs.getString(4));
					bean.setPHONE(rs.getString(5));
					bean.setTotalPrice(rs.getDouble(6));
					bean.setUSERNAME(rs.getString(7));
					bean.setEMAIL(rs.getString(8));
				}
				
			}
			
		}catch(Exception ex){
			b = false; 
			ex.printStackTrace();
		}finally{
			this.close();
		}
		
		if(b){
			return bean; 
		}else{
			return null; 
		}
		
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
