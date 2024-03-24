package com.sathya;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("./Deleteproductservlet")
public class Deleteproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proId=request.getParameter("proId");
		
		ProductDao ProductDao  = new ProductDao ();
		int result= ProductDao.deleteById(proId);
		{
			if(result==1)
			{
				request.setAttribute("deletereult", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ProductList.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("deletereult",result );
			RequestDispatcher dispatcher = request.getRequestDispatcher("ProductList.jsp");
			dispatcher.forward(request, response);
		}
	}
	}
	}