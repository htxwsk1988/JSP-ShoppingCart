package com.cc.cad.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.cad.model.MovieBean;
import com.cc.cad.model.ShoppingCartDAO;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command=request.getParameter("command"); 
		
		// Retrieve shopping cart from session. 
		// This guarantees each user have only one shopping cart per session.
		ShoppingCartDAO sdao= (ShoppingCartDAO)request.getSession().getAttribute("myCart"); 
		
		
		if(sdao==null){
			sdao = new ShoppingCartDAO(); 
			
			request.getSession().setAttribute("myCart", sdao);
		}
		
		if(command.equals("add")){
			
			// Add item into shopping cart.
			String id = request.getParameter("id"); 
			sdao.addItem(id, "1");
				
		}else if(command.equals("delete")){
			
			// Remove item by id from shopping cart.
			String id = request.getParameter("id"); 
			sdao.delItem(id);
				
		}else if(command.equals("removeAll")){
			
			// Remove all items in shopping cart.
			sdao.delAllItem();
			
		}else if(command.equals("showMyCart")){
			
			// Do nothing but display shopping cart only.
			
		}else if(command.equals("updateNum")){
			
			String[] itemIds = request.getParameterValues("movieId");
			String[] itemNums = request.getParameterValues("txtNum");
			
			for(int i=0; i<itemIds.length; i++){
				// System.out.println("id="+itemIds[i]+"  num="+itemNums[i]);
				sdao.editItemNum(itemIds[i], itemNums[i]);
			}
			
			
		}
		
		// Add shopping cart into arrayList as return.
		ArrayList<MovieBean> al = sdao.showMyCart();
		
		request.setAttribute("myCartInfo", al);
		
		request.getRequestDispatcher("myCart.jsp").forward(request, response);
		

	}

}
