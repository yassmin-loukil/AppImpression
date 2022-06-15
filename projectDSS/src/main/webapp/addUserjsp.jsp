<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>



<jsp:include page="header.jsp"></jsp:include>


<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<div class="row">
			<div class="col-6 mx-auto">
				<form action="UserController" method="POST">
					<fieldset>
						
						<div class="form-group">
							<label for="exampleInputEmail1">Nom</label> <input type="text"
								name="nom" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="firstName"
								placeholder="Enter name" required>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Prenom</label> <input type="text"
								name="prenom" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name=lastName
								placeholder="Enter last name" required>
						</div>
							<div class="form-group">
							<label for="exampleInputEmail1">Nom d'utilisateur</label> <input type="text"
								name="username" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" name="userName"
								placeholder="Enter last name" required>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Password</label> <input
								type="password" name="pass" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								name="daten"  required>
						</div>


						<div class="form-group">
							<label for="exampleSelect1">Role</label> <select
								class="form-control" id="exampleSelect1" name="role">
								<option value="Admin">Admin</option>
								<option value="Enseignant">Enseignant</option>
								<option value="Agent">Agent</option>
							</select>
						</div>

								
						<div class="form-group">
							<label for="exampleSelect1">Role</label> <select
								class="form-control" id="exampleSelect1" name="etat">
								<option value="actif">Actif</option>
								<option value="inactif">Inactif</option>
							</select>
						</div>		
										<button type="submit" class="btn btn-primary" name="addUser"
							value="ajouter">Ajouter</button>
					</fieldset>
				</form>
</div>
</div>
</div>


</body>
</html>