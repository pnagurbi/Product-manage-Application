package com.sathya;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/Addproductservlet")
@MultipartConfig
public class Addproductservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		//read the form data
    				String proId= request.getParameter("proId");
    				String proName= request.getParameter("proName");
    				Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
    				String proBrand= request.getParameter("proBrand");
    				String proMadeIn= request.getParameter("proMadeIn");
    				Date proMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
    				Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
    				
    				Part part=request.getPart("proImage");
    				InputStream InputStream =part.getInputStream();
    				
    				byte[] proImage=IOUtils.toByteArray(InputStream);
    				
    				//using the data create product object
    				
    				
    				Product product=new Product();
    				product.setProId(proId);
    				product.setProName(proName);
    				product.setProPrice(proPrice);
    				product.setProBrand(proBrand);
    				product.setProMadeIn(proMadeIn);
    				product.setProMfgDate(proMfgDate);
    				product.setProExpDate(proExpDate);
    				product.setProImage(proImage);
    				
    				//sending the product object to DAO layer
    				ProductDao productDao=new ProductDao();
    				int result=productDao.save(product);
    				if(result == 1)
    				{
    					//To send the data to JSP file add the data into request object
    					request.setAttribute("saveResult", result);
    					
    					RequestDispatcher dispatcher = request.getRequestDispatcher("ProductList.jsp");
    					dispatcher.forward(request, response);
    				}
    				else
    				{
    					response.setContentType("text/html");
    					PrintWriter writer = response.getWriter();
    					writer.println("Data insertion fail check once...."+result);
    					RequestDispatcher dispatcher = request.getRequestDispatcher("add-product.html");
    					dispatcher.include(request, response);
    				}
    				
    			}

    		}

    