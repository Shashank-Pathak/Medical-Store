<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Map"%>
<%@ page import="devops.ilp1.model.Medicine"%>
<!DOCTYPE html>
<html>
<head>
<title>PlayerDetails</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Tangerine">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script>
	
	</script>
</head>
<body>
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
				<% List<Medicine> list = (List) request.getAttribute("medicineList"); %>
				<%	
Medicine med = null;
Iterator it = list.iterator();

while (it.hasNext()) 
{
	med = (Medicine)it.next();
	String id = Integer.toString(med.getId());
	String name = med.getName();
	String composition = med.getComposition();
	String expDate = med.getExpDate();
	Double price = med.getPrice();

%>

				<div id="medicineInfo">
					<p>
						Id :
						<%=id%></p>
					<p>
						Name :
						<%=name%></p>
					<p>
						Composition :
						<%=composition%></p>
					<p>
						Expiry Date :
						<%= expDate %></p>
					<p>
						Price :
						<%= price %></p>
					<br>

				</div>
				<%			it.remove();
	}
%>
			</div>
		</div>
	</div>
</body>
</html>