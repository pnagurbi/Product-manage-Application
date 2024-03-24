function validateForm()
{  // read the from data
	var proId = document.getElementById("proId").value;
	var proName = document.getElementById("proName").value;
	var proPrice = document.getElementById("proPrice").value;
	var proBrand = document.getElementById("proBrand").value;
	var proMadeIn = document.getElementById("proMadeIn").value;
	
	if(proId.trim() === "" || proName.trim() === "" || proPrice.trim() === ""|| proBrand.trim()=== "" || proMadeIn.trim()=== "" )
	{
		alert("All fields must be filled out")
		return false;
	}
	if(parseFloat(proPrice)<0)
	{
		alert("product price must be a non-negative value")
		return false;
	}
	if(proName.Length > 50 || proBrand.Length > 50)
	{
		alert("Product name and brand name must be less then 50 characters")
		return false;
	}
	//get the mfg & exg dates
	var proMfgdate = document.getElementById("proMfgDate").value;
	var proExpdate = document.getElementById("proExpDate").value;
	
	// convert into date format
	var manufacturingDateObj = new Date(proMfgdate);
	var ExpiryDateObj = new Date(proExpdate);
   if(manufacturingDateObj > ExpiryDateObj)
   {
	   alert("mfd date cannot be greater than expiry")
	   return false;
   }
   return true;
	
}