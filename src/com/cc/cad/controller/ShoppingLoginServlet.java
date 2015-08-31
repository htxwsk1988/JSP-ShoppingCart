package com.cc.cad.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.cad.model.UserBean;

/**
 * Servlet implementation class ShoppingLoginServlet
 */
@WebServlet("/ShoppingLoginServlet")
public class ShoppingLoginServlet extends HttpServlet {
	
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
		
		UserBean ub = (UserBean)request.getSession().getAttribute("userInfo");
		
		if(ub==null){
			request.getRequestDispatcher("userLogin.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("confirmation").forward(request, response);
		}
	}

}
