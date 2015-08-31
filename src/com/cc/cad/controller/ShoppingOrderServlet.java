package com.cc.cad.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cc.cad.model.*;
/**
 * Servlet implementation class ShoppingOrderServlet
 */
@WebServlet("/ShoppingOrderServlet")
public class ShoppingOrderServlet extends HttpServlet {
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
		
		OrderBeanDAO odao = new OrderBeanDAO(); 
		
		ShoppingCartDAO sdao = (ShoppingCartDAO)request.getSession().getAttribute("myCart");
		
		long userId = ((UserBean)request.getSession().getAttribute("userInfo")).getUSERID(); 
		
		OrderCompleteInfoBean bean = (OrderCompleteInfoBean)odao.addOrder(sdao, userId+"");
		
		if(bean!=null){
			
			request.setAttribute("CompleteOrderInfo", bean);
			
			// Redirect back to complete page.
			request.getRequestDispatcher("completeOrder.jsp").forward(request, response);
		}else{
			// Redirect back to confirmation page.
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		
	}

}
