<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Votantes</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #38C953" id="containerTitulos">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"><h1>Administrar
			Votantes</h1> Votantes Management App </a>
			</div>
		</nav>
	</header>

	<div class="container">
		<hr>
		<div id="botones" class="container text-left containerMenus">
			<a href="<%=request.getContextPath()%>/vistaVotante/registrar.jsp"
					class="btn btn-success containerMenu">Añadir nuevo Votante</a> 
			<a href="<%=request.getContextPath()%>/VotanteController?action=mostrar" class="btn btn-success containerMenu">Mostrar listado de Votantes</a>
		</div>
	</div>

</body>
</html>