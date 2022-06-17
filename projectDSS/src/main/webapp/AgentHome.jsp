<%@page import="tn.iit.dao.DocumentDao"%>
<%@page import="tn.iit.model.User"%>
<%@page import="tn.iit.dao.UserDao"%>
<%@page import="tn.iit.dao.DemandeDao"%>
<%@page import="tn.iit.model.DemandeTirage"%>
<%@page import="tn.iit.model.Matiere"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>


<body>
	<center>
		<h1>Agent</h1>

	</center>
	<div align="center">
		<%
		List<DemandeTirage> e = (List<DemandeTirage>) session.getAttribute("DemandeTirage");
		List<String> enseignant = (List<String>) session.getAttribute("ens");

		%>
			<%!UserDao UserDao = new UserDao();%>
			<%!DocumentDao DocumentDao = new DocumentDao();%>
				
		<div class="container mt-12">

			<div class="row">

				<div class="col-12 mx-auto"></div>
			</div>
			<div class="row">
				<div class="col-12 mx-auto">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">Enseignant</th>
								<th scope="col">Document</th>
								
								<th scope="col">nombre de copies</th>
								<th scope="col">Date</th>

								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>
							<%
							for (DemandeTirage dt : e) {
							%>

							<tr><th>
								<%for(int i=0;i<UserDao.getAllUser().size();i++){
								if(UserDao.getAllUser().get(i).getId()==dt.getId_Enseignant()){
								%>
								
								<%=(UserDao.getAllUser().get(i).getFirstName()+" "+UserDao.getAllUser().get(i).getLastName()) %>
								<%break;}} %>					
						</th>
								<th>
								<%for(int i=0;i<DocumentDao.getAllDocument().size();i++){
								if(DocumentDao.getAllDocument().get(i).getId()==dt.getIdDocument()){
								%>
								
								<%=(DocumentDao.getAllDocument().get(i).getNomDocument())%>
								<%break;}} %>					
						</th>
								
								<th><%=dt.getNombreCopie()%></th>
								<th><%=dt.getDate()%></th>


								<th><a class="btn btn-warning btn-sm"
									href="DemandeTirageController?id=<%=dt.getId()%>">Imprimer</a></th>

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