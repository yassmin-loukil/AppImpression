<%@page import="java.util.List"%>
<%@page import="tn.iit.model.User"%>
<%@page import="tn.iit.dao.UserDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<%!UserDao userDao = new UserDao();%>
	<%
		User p = (User) userDao.getUser(Integer.parseInt(request.getParameter("id")));
	%>

	<div class="container">
		<div class="row">
			<div class="col-6 mx-auto mt-6 pt-6">
				<form action="UserController" method="POST">
					<fieldset>
						<legend>
							Modifier Cordonnée :
							<%=p.getLastName()+" "+p.getFirstName()%></legend>
							<div class="form-group">
							<input hidden="true" readonly="readonly" type="text"
								class="form-control" name="id"
								value="<%=p.getId()%>" id="exampleInputEmail1"
								placeholder="employe's last name">
						</div>
						
								<div class="form-group">
							<label for="exampleInputEmail1">Nom</label> <input type="text"
								class="form-control" name="nom" value="<%=p.getFirstName()%>"
								id="exampleInputEmail1" placeholder="employe's first name">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Prenom</label> <input type="text"
								class="form-control" name="prenom"
								value="<%=p.getLastName()%>" id="exampleInputEmail1"
								placeholder="employe's last name">
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail1">Nom d'utilisateur</label> <input type="text"
								class="form-control" name="username"
								value="<%=p.getUsername()%>" id="exampleInputEmail1"
								placeholder="employe's last name">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" name="pass"
								id="exampleInputPassword1" placeholder="Password">
						</div>
								<div class="form-group">
							<label for="exampleInputEmail1">Role</label> <input readonly="readonly"
								class="form-control" name="role" type="text"
								value="<%=p.getRole()%>" id="exampleInputEmail1"
								placeholder="employe's last name">
						    	<div class="form-group">
							<label for="exampleSelect1">Etat</label> <select
								class="form-control" id="exampleSelect1" name="etat" value="<%=p.getEtat()%>">
								<option value="actif">Actif</option>
								<option value="inactif">Inactif</option>
							</select>
						</div>	
					</fieldset>
					<button type="submit" class="btn btn-primary" name="updateUser"
						value="editer">Submit</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>


</body>
</html>