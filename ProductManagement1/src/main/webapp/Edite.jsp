<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Base64"%>
  <html>
	 <head>
		<title>Add product </title>
		
		    <link rel="stylesheet"
		       href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	     
	</head>
	  <body>
		     <div class="container mt-5 text-center">
				  <h2 class="text-center font-italic mb-1">Edit Product Data..</h2>
				  <form method="post"  action="./Updateproductservlet"
				enctype="multipart/form-data" onsubmit="return validateForm()">
				
				  <div class="form-group">
					   <label class="font-italic font-weight-bold"
					   for="proId">Product ID:</label>
					   <input type="text" class="form-control-sm"
					   id="proId" name="proId" value ="${existingproduct.proId}" required>
				  </div>
				   <div class="form-group">
					  <label class="font-italic font-weight-bold"
					  for="proName">Product Name:</label>
					  <input type="text" class="form-control-sm"
					  id="proName" name="proName" value ="${existingproduct.proName}"required>
				  </div>
				        <div class="form-group">
					      <label class="font-italic font-weight-bold"
					      for="proPrice">Product Price:</label>
					      <input type="number" class="form-control-sm"
					      id="proPrice" name="proPrice" value ="${existingproduct.proPrice}"required>
				  </div>
				  
				   <div class="form-group">
					  <label class="font-italic font-weight-bold"
					  for="proBrand">Product Brand:</label>
					  <input type="text" class="form-control-sm"
					  id="proBrand" name="proBrand" value ="${existingproduct.proBrand}"required>
				  </div>
				   <div class="form-group">
					  <label class="font-italic font-weight-bold"
					  for="proMadeIn">Product MadeIn:</label>
					  <input type="text" class="form-control-sm"
					  id="proMadeIn" name="proMadeIn" value ="${existingproduct.proMadeIn}"required>
				  </div>
				  <div class="form-group">
					  <label class="font-italic font-weight-bold"
					  for="proMfgDate">Manufacturing Date:</label>
					  <input type="date" class="form-control-sm"
					  id="proMfgDate" name="proMfgDate" value ="${existingproduct.proMfgDate}"required>
				  </div>
                    <div class="form-group">
					  <label class="font-italic font-weight-bold"
					  for="proExpDate">Expiry Date:</label>
					  <input type="date" class="form-control-sm"
					  id="proExpDate" name="proExpDate" value ="${existingproduct.proExpDate}"required>
				  </div>
				  
				  <div class="form-group">
				     <label class="font-italic font-weight-bold"
					  for="proImage">Product Image:</label>
					  <img id ="currentImage"
					  src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingproduct.proImage)}" alt=" Current ProductImage" style="max-width:100px; max-height:100px;">
					  <input type = "hidden" id="existingImage" name="existingImage" value= "${Base64.getEncoder().encodeToString (existingproduct.proImage)}">
				 </div>
				  
				   <div class="form-group">
				<label class="font-italic font-weight-bold" for="newproImage">New product image</label>
				<input type="file" class="font-control-file-sm" id ="newproImage" name="newproImage" accept="Image/*">
					  
				  </div>
				  
				  <div>
					  <input type="submit" class="btn btn-success" value="Update ProductList"/>
					  
				  </div>
				</form>
			</div>
	  </body>
</html>
