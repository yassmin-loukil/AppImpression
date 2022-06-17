<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>S'authentifer</h1>
		<form action="<%=request.getContextPath()%>/login" method="post">

			<div class="form-group">
				<label for="uname">Nom d'utilisateur :</label> <input type="text"
					class="form-control" id="username" placeholder="nom d'utilisateur"
					name="username" required>
			</div>

			<div class="form-group">
				<label for="uname">Mot de passe:</label> <input type="password"
					class="form-control" id="password" placeholder="mot de passe"
					name="password" required>
			</div>


			<button type="submit" class="btn btn-primary">Se connecter</button>
		</form>
	</div>
</body>
</html>