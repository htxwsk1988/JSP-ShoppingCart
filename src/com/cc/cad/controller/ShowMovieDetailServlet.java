package com.cc.cad.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.cad.model.MovieBean;
import com.cc.cad.model.MovieBeanDAO;

/**
 * Servlet implementation class ShowMovieDetailServlet
 */
@WebServlet("/ShowMovieDetailServlet")
public class ShowMovieDetailServlet extends HttpServlet {
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
		
		String command = request.getParameter("command"); 
		
		if(command.equals("display")){
			String id = request.getParameter("id");  

			MovieBeanDAO dao = new MovieBeanDAO(); 
			
			MovieBean bean = dao.getMovieById(id); 

			
			request.setAttribute("movieInfo", bean);
			
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}else if(command.equals("paging")){
			
			String pageNow = request.getParameter("pageNow"); 
			
			request.getRequestDispatcher("index.jsp?pageNow="+pageNow).forward(request, response);
		}
		
		

		
	}

}
