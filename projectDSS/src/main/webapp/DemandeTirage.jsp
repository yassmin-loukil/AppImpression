<%@page import="tn.iit.model.Matiere"%>
<%@page import="tn.iit.dao.MatiereDao"%>
<%@page import="tn.iit.model.User"%>
<%@page import="tn.iit.dao.UserDao"%>
<%@page import="tn.iit.dao.DocumentDao"%>
<%@page import="tn.iit.model.Document"%>

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
				<form action="DemandeTirageController" method="post">


					<%
					List<Document> e = (List<Document>) session.getAttribute("document");
					%>
					<%!MatiereDao MatiereDao = new MatiereDao();%>
					<%
					Matiere m = (Matiere) MatiereDao.getMatiere(Integer.parseInt(request.getParameter("id")));
					int idEnsei = m.getIdEnseignant();%>
						<%!UserDao UserDao = new UserDao();%>
						<% String nomEnsei = UserDao.getNomByID(idEnsei);%>
					<fieldset>

						<div class="form-group">
							<div class="form-group">
								 <input
									readonly="readonly" type="text" class="form-control" name="idMatiere"
									value="<%=m.getId()%>" id="exampleInputEmail1"
									placeholder="employe's last name" hidden="true">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Matière</label> <input
									readonly="readonly" type="text" class="form-control" 
									value="<%=m.getNomMatiere()%>" id="exampleInputEmail1"
									placeholder="employe's last name">
							</div>

							<div>
								<label for="exampleInputEmail1">Document</label> <select
									class="form-control" id="exampleSelect1" name="idDoc">

									<%
									for (Document doc : e) {
									%>

									<option value="<%=doc.getId()%>"><%=doc.getNomDocument()%></option>
									<%
									}
									%>
								</select>

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Nombre de copies</label> <input
									type="number" name="nombreCopie" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="nombre de copie" required>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Date</label> <input
									name="date" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  type="date"  >
							</div>


							<button type="submit" class="btn btn-primary"
								name="EnvoyerDemande">Envoyer la demande</button>
					</fieldset>
				</form>
			</div>
		</div>
	</div>


</body>
</html>