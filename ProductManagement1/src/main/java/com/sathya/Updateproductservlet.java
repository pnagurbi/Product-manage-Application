package com.sathya;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;


@WebServlet("/Updateproductservlet")
public class Updateproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proId = request.getParameter("proId");
		String UpdateproductName = request.getParameter("proName");
		
		double UpdateproductPrice = Double.parseDouble(request.getParameter("proPrice"));
	    String UpdateproductBrand = request.getParameter("proBrand");
	    
	    String UpdateproductMadeIn = request.getParameter("proMadeIn");
	    Date UpdateproductMfgDate = Date.valueOf(request.getParameter("proMfgDate"));
	    Date UpdateproductExpDate = Date.valueOf(request.getParameter("proExp"));
	    
	    Product product = new Product();
	    product.setProId(proId );
		product.setProName(UpdateproductName);
		product.setProPrice(UpdateproductPrice);
		product.setProBrand(UpdateproductBrand);
		product.setProMadeIn(UpdateproductMadeIn);
		product.setProMfgDate(UpdateproductMfgDate);
		product.setProExpDate(UpdateproductExpDate);
		
		Part filepart = request.getPart("newImage");//"newproImage" is the name of your file input field
		if(filepart !=null && filepart.getSize()>0) {
			InputStream inputStream = filepart.getInputStream();
			byte[] newImagedata = IOUtils.toByteArray(inputStream);
			product.setProImage(newImagedata);
		}
		else
		{
			 Part file=request.getPart("existingImage");
			InputStream inputStream =file.getInputStream();
			byte[] existingImage = IOUtils.toByteArray(inputStream);
			product.setProImage(existingImage);
		}
		ProductDao dao = new ProductDao();
		int result =dao.UpdateById(product);
		if(result==1)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("ProductList.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("Data Update fail check once...."+result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("add-product.html");
			dispatcher.include(request, response);
		}

		}
		
	}


