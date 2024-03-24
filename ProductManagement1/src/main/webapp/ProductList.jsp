<%@ page import="com.sathya.ProductDao" %>
<%@ page import="java.util.Base64"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title> Product List</title>
       <link rel="stylesheet"
		 href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
    <div>
    	<h1 class="text-center font-italic mb-1 text-success">List Of Products Available</h1>
    </div>
    
    <div>
    	<a class="btn btn-success" href=add-product.html>save product</a>
    </div>
    
    <div>
    	<input type="text" placeholder="search">
    </div>
    
    <div>
    	<c:if test="${saveResult==1}">
    		<h1 class="text-success text-center">Data inserted successfully...</h1>
    	</c:if>
    </div>
         <div>
           <c:if test="${deleteResuit==1}">
           <h1 class="text-danger text-center">Data delete successfully...</h1>
           </c:if>
             </div>
              <div>     
           <c:if test="${deleteResuit==0}">
           <h1 class="text-danger text-center">Data delete failed...</h1>
           </c:if>
             </div>   
           
             
         <table class="table table-bordered table-striped">
              <thead class="thead-dark">
              <tr>
                  <th>Product Id</th>
                  <th> product Name</th>
                  <th> product Cost</th>
                  <th> Brand</th>
                  <th>Made In</th>
                  <th> Manufacture Date</th>
                  <th> ExpDate</th>
                   <th> Image</th>
                    <th>Action</th>
                  </tr>
                  </thead>
               <tbody>
                      <c:forEach var ="product" items="<%=new ProductDao().findAll()%>">

                    <tr>
                <td>${product.proId}</td>
				<td>${product.proName}</td>
				<td>${product.proPrice}</td>
				<td>${product.proBrand}</td>
				<td>${product.proMadeIn}</td>
				<td>${product.proMfgDate}</td>
				<td>${product.proExpDate}</td>
                  <td><img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" alt="ProductImage" style="max-width:100px; max-height:100px;"> 
              <td> 
               <a class="btn btn-danger"
              href="./Deleteproductservlet?proId=${product.proId}"> Delete </a>
         
               </td>
    
        	   </tr>
                      
                      </c:forEach>
               </tbody>
         </table>  
    </body>
</html>