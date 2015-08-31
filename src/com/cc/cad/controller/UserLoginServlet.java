package com.cc.cad.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.cad.model.*;
/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
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
		
		String u = request.getParameter("txtUserName"); 
		String p = request.getParameter("txtPassword"); 
		
		UserBeanDAO udao = new UserBeanDAO(); 
		
		if(udao.isUserValid(u, p)){
			// Valid user.
			
			// Add user info into session for checking login status.
			UserBean ub = udao.getUserBean(u); 
			
			request.getSession().setAttribute("userInfo", ub);
			
			// Retrieve shopping cart info. 
			ShoppingCartDAO sdao = (ShoppingCartDAO)request.getSession().getAttribute("myCart");
			
			ArrayList<MovieBean> al = sdao.showMyCart(); 
			
			request.setAttribute("myCartInfo", al);
			
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			
		}else{
			// Invalid user, redirect to login page.
			request.getRequestDispatcher("userLogin.jsp").forward(request, response);
		}
		
		
		
	
	}

}
