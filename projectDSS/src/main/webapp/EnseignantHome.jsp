<%@page import="tn.iit.model.Matiere"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>


<body>
	<center>
		<h1>Enseignant</h1>

	</center>
	<div align="center">
		<%
		List<Matiere> e = (List<Matiere>) session.getAttribute("matiere");
		%>
		<div class="container mt-12">

			<div class="row">

				<div class="col-12 mx-auto">

					
				</div>
			</div>
			<div class="row">
				<div class="col-12 mx-auto">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Nom matière</th>


								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (Matiere mat : e) {
							%>

							<tr>
								<th><%=mat.getNomMatiere()%></th>



								<th><a class="btn btn-warning btn-sm"
									href="TelechargerMatier.jsp?id=<%=mat.getIdEnseignant()%>">Télècharger</a></th>
									<th><a   class="btn btn-warning btn-sm"
									href="DemandeTirage.jsp?id=<%=mat.getId()%>">Envoyer une demande de tirage</a></th>

									

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