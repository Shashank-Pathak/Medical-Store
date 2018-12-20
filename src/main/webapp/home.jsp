<!DOCTYPE html>
<html>
<head>
<title>Medical Store</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script>

var ids = [ "addMedicine", "medicinesList", "viewMedicineById","deleteMedicineById" ];
	<%String id = (String) request.getParameter("id");%>	
	
	function myLoader()
	{
	 var myId = <%=id%>;
	 console.log(myId);
	 if(myId){
		 document.getElementById(myId).style.display = 'inline'; 
	 }else{
		document.getElementById("addMedicine").style.display = 'inline'; 
	 }
	}
	
</script>
</head>
<body onload=myLoader()>
	<div class="main">
		<div class="row header">
			<div class="col-md-11">
				<p>Medical Store</p>
			</div>
			<div class="col-md-1">
				<a class="logout-btn" href="index.jsp">Logout</a>
			</div>
		</div>
		<div class="main-content">
			<div class="navbar navbar-inverse">
				<ul class="nav navbar-nav">
					<li><a href="home.jsp?id='addMedicine'">Add</a></li>
					<li><a href="home.jsp?id='medicinesList'">View All</a></li>
					<li><a href="home.jsp?id='viewMedicineById'">Find Medicine</a></li>
					<li><a href="home.jsp?id='deleteMedicineById'">Delete</a></li>
				</ul>
			</div>
			<div class="main-content-body">
				<div class="tab-content">
					<div class="app-container">
						<div class="col-md-4" id="addMedicine" style="display: none;">
							<form action="AddMedicineServlet" method="post">
								<label for="medId">Id</label> <input type="number" min=1
									name="medId" placeholder="Id" class="form-control" required>
								<label for="medName">Medicine Name</label> <input type="text"
									name="medName" placeholder="Name" class="form-control"
									required> <label for="medComposition">Composition</label> <input
									type="text"  name="medComposition" placeholder="Composition"
									class="form-control" required> <label for="medExpDate">Expiry
									Date</label> <input type="date" name="medExpDate"
									placeholder="dd-mm-yyyy" class="form-control" required>
								<label for="medPrice">Price</label> <input type="number"
									name="medPrice" placeholder="Price" class="form-control"
									required>
								<button class="btn btn-success" name="addMedicineButton" id="addMedicineButtonId" style="margin-top: 20px"
									type="submit">Save</button>
							</form>
						</div>
						<div class="col-md-4" id="medicinesList" style="display: none;">
							<form action="ListAllMedicineServlet" method="get">
								<button class="btn btn-success" style="margin-top: 20px"
									type="submit" name = "getMedicinesButton" >Get Medicines</button>
							</form>
						</div>

						<div class="col-md-4" id="viewMedicineById" style="display: none;">
							<form action="GetMedicineServlet" method="post">
								<input type="number" name="getMedId"
									placeholder="Enter Medicine Id" class="form-control" required>
								<button class="btn btn-info" name = "getMedicineButton"style="margin-top: 10px">Find</button>
							</form>
						</div>
						<div class="col-md-4" id="deleteMedicineById" style="display: none;">
							<form action="DeleteMedicineServlet" method="post">
								<input type="number" name="deleteMedId"
									placeholder="Enter Medicine Id" class="form-control" required>
								<button class="btn btn-danger" name = "deleteMedicineButton"style="margin-top: 10px">Delete</button>
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
</body>
</html>


