package com.cc.cad.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserBeanDAO {
	
	private Connection conn=null; 
	private ResultSet rs=null; 
	private PreparedStatement ps=null; 
	
	// Check whether is a valid user.
	public boolean isUserValid(String u, String p){
		
		boolean b = false; 
		
		try{
			
			conn = new ConnDB().getConn(); 
			
			ps = conn.prepareStatement("SELECT TOP 1 PASSWD FROM shop.Users WHERE USERNAME = ?"); 
			
			ps.setString(1, u);
			
			rs = ps.executeQuery(); 
			
			if(rs.next()){
				String dbPasswd = rs.getString(1); 
				
				if(dbPasswd.equals(p)){
					b = true; 
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.close();
		}
		
		return b; 
	}
	
	
	// Return UserBean by username.
	public UserBean getUserBean(String u){
		
		UserBean ub = new UserBean(); 
		
		try{
			
			conn = new ConnDB().getConn(); 
			
			ps = conn.prepareStatement("SELECT TOP 1 * FROM shop.USERS WHERE USERNAME=?"); 
			
			ps.setString(1, u);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				ub.setUSERID(rs.getLong(1));
				ub.setUSERNAME(rs.getString(2));
				ub.setFULLNAME(rs.getString(3));
				ub.setPASSWD(rs.getString(4));
				ub.setEMAIL(rs.getString(5));
				ub.setPHONE(rs.getString(6));
				ub.setADDRESS(rs.getString(7));
				ub.setPOSTCODE(rs.getString(8));
				ub.setLEVEL(rs.getInt(9));
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.close();
		}
		
		return ub; 
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
