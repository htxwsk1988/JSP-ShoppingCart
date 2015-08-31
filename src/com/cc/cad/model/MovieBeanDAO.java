package com.cc.cad.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovieBeanDAO {
	
	private Connection conn=null; 
	private ResultSet rs=null; 
	private PreparedStatement ps=null; 
	
	// Return page count. 
	public int getPageCount(int pageSize){
		
		int pageCount = 0; 
		int rowCount = 0; 
		try{
			
			conn = new ConnDB().getConn(); 
			
			ps= conn.prepareStatement("SELECT COUNT(*) FROM shop.Movies");
			
			rs = ps.executeQuery(); 
			
			if(rs.next()){
				rowCount = rs.getInt(1);
			}
			
			if(rowCount%pageSize==0){
				pageCount = rowCount/pageSize; 
			}else{
				pageCount = rowCount/pageSize+1; 
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close(); 
		}
		
		return pageCount; 
		
	}
	
	
	// Return movies by paging.
	public ArrayList getMovieByPage(int pageSize, int pageNow){
		
		ArrayList al = new ArrayList(); 
		
		try{
			
			conn = new ConnDB().getConn(); 
			
			ps = conn.prepareStatement("SELECT TOP " + pageSize 
					+ " * FROM shop.Movies WHERE Id NOT IN (SELECT TOP " 
					+ pageSize*(pageNow-1) + " Id FROM shop.Movies)"); 
			
			rs =ps.executeQuery(); 
			
			MovieBean bean = null; 
			
			while(rs.next()){
				
				bean = new MovieBean(); 
				
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setPrice(rs.getDouble(4));
				bean.setInventoryNum(rs.getInt(5));
				bean.setPublisher(rs.getString(6));
				bean.setImage(rs.getString(7));
				bean.setType(rs.getString(8));
				
				al.add(bean); 
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return al; 
	}
	
	
	// Return movies by Id. 
	public MovieBean getMovieById(String id){
		
		MovieBean bean = new MovieBean(); 
		
		try{
			conn=new ConnDB().getConn(); 
			
			ps = conn.prepareStatement("SELECT * FROM shop.Movies WHERE Id = ?");
			ps.setString(1, id);
			
			rs = ps.executeQuery(); 
			
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setDescription(rs.getString(3));
				bean.setPrice(rs.getDouble(4));
				bean.setInventoryNum(rs.getInt(5));
				bean.setPublisher(rs.getString(6));
				bean.setImage(rs.getString(7));
				bean.setType(rs.getString(8));
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			this.close();
		}
		
		return bean; 
		
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


