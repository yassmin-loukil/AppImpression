<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="tn.iit.model.User"%>
<%@page import="java.util.List"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>


<body>
	<center>
		<h1>Enseignant</h1>
		
	</center>
	<div align="center">
		<%
		List<User> e = (List<User>) session.getAttribute("user");
		%>
		<div class="container mt-12">

			<div class="row">

				<div class="col-12 mx-auto">

					<nav class="navbar navbar-expand-lg navbar-light ">
						<a href="addUserjsp.jsp">Ajouter un nouveau utlisateur</a> 
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarColor03"
							aria-controls="navbarColor03" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>

					</nav>
				</div>
			</div>
			<div class="row">
				<div class="col-12 mx-auto">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Nom</th>
								<th scope="col">Prénom</th>
								<th scope="col">Nom d'utilisateur</th>
								<th scope="col">Role</th>
								<th scope="col">Etat</th>

								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (User eq : e) {
							%>

							<tr>
								<th><%=eq.getFirstName()%></th>
								<th><%=eq.getLastName()%></th>
								<th><%=eq.getUsername()%></th>
								<th><%=eq.getRole()%></th>
								<th><%=eq.getEtat()%></th>


								<th><a class="btn btn-warning btn-sm"
									href="updateUser.jsp?id=<%=eq.getId()%>">editer</a></th>

							</tr>

							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>

		</div>








	</div>
</body>
</html>