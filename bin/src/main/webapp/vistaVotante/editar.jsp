<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../css/styleCandidato.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Actualizar Votante</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: red" id="containerTitulos">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"><h1>Actualizar
						Votante</h1> Votante Management App </a>
			</div>
		</nav>
	</header>

	<hr>
	<div id="botones" class="container text-left">
		<div id="containerMenus">
			<a href="<%=request.getContextPath()%>/VotanteController?action=index" class="btn btn-success containerMenu">Ir al
				menú</a> 			
			<a href="<%=request.getContextPath()%>/vistaVotante/registrar.jsp"
						class="btn btn-success containerMenu">Registrar nuevo Votante</a>
			<a href="<%=request.getContextPath()%>/vistaVotante/mostrar.jsp"
				class="btn btn-success containerMenu">Listar Votantes</a>
		</div>
	</div>

	<div class="container">
		<div class="card">
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/VotanteController?action=editar" method="post">
					<div class="form-group">
						<label for="validation01">Id</label> <input type="number"
							class="form-control" value='<c:out value="${candidato.id}"></c:out>'
							placeholder="Id" name="id" >
					</div>
					<div class="form-group">
						<label for="validation01">Documento</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.documento}"></c:out>'
							placeholder="Documento" name="documento">
					</div>
					<div class="form-group">
						<label for="validation01">Nombre</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.nombre}"></c:out>'
							placeholder="Nombre" name="nombre">
					</div>
					
					<div class="form-group">
						<label for="validation01">Apellido</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.apellido}"></c:out>'
							placeholder="Apellido" name="apellido">
					</div>
					<div class="form-group">
						<label for="validation01">Elección</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.eleccion}"></c:out>'
							placeholder="Eleccion" name="eleccion">
					</div>
					<div class="form-group">
						<label for="validation01">Número</label> <input type="text"
							class="form-control" value='<c:out value="${candidato.numero}"></c:out>'
							placeholder="N�mero" name="numero">
					</div>			
						<input type="submit" class="btn btn-success btnFinal" value="Guardar"
							name="guardar">
					
				</form>
			</div>
		</div>
	</div>

	
    <style>


</style>
</body>
</html>