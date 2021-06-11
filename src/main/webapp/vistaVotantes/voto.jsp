<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="co.edu.ufps.entities.*"%>
<%@page import="co.edu.ufps.dao.*"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../style.css">
<link rel="stylesheet" type="text/css" href="../css/styleVotante.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Confirmar Votante</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #38C953">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"><h1>Actualizar
						Votos</h1> Votos Management App </a>
			</div>
		</nav>
	</header>

	<hr>
	<div id="botones" class="container text-left">
		
		<a href="<%=request.getContextPath()%>/VotanteServlet?action=index" class="btn btn-success">Ir al
			menú</a> 			
		<a href="<%=request.getContextPath()%>/vistaVotantes/registro.jsp"
					class="btn btn-success">Registrar nuevo Votante</a>
		<a href="<%=request.getContextPath()%>/vistaVotantes/mostrar.jsp"
			class="btn btn-success">Listar Votantes</a>
	</div>

	<div class="container">
		<div class="card">
			<div class="card-body">
				<form action="${pageContext.request.contextPath}/Voto?action=mostrar" method="post">
					
					<div class="form-group"><input type="hidden"
							class="form-control" value='<c:out value="${votante.id}"></c:out>'
							placeholder="Id" name="id">
					</div>
					<div class="form-group">
						<label for="validation01">Nombre</label> <input type="text"
							class="form-control" value='<c:out value="${votante.nombre}"></c:out>'
							placeholder="Nombre" name="nombre" disabled>
					</div>
					
					<div class="form-group">
						<label for="validation01">Email</label> <input type="email"
							class="form-control" value='<c:out value="${votante.email}"></c:out>'
							 placeholder="Email" name="email" disabled>
					</div>
					<div class="form-group">
						<select name="tipodocumento">
      				 	<option>Tipo de documento</option> 
       					 <% for(Tipodocumento t: new TipodocumentoDAO().list()){%>
          			 	<option value="<%=t.getId()%>"><%=t.getId()%> - <%=t.getDescripcion()%> </option>
       						 <% }%>
					</select>
					
					</div>
					<div class="form-group">
						<label for="validation01">Documento</label> <input type="text"
							class="form-control" 
							 placeholder="Documento" name="documento">
					</div>
									
						<input type="submit" class="btn btn-success" value="Confirmar Votación"
							name="guardar">
				</form>
			</div>
		</div>
	</div>

	<footer>
        <div class="row">
            <div class="col-md-3">
                <ul id="ul-con" type="none">
                    <b>Contacto</b>
                    <li>Email: juansebastiansp@ufps.edu.co</li>
                    <li>Cel: +57 3219810616</li>
                </ul>
            </div>
        </div>
        <hr>
        <p>2021 © All Rights Reserved. Desarrollado por JUAN SEBASTIAN SANCHEZ PRADA </p>
    </footer>