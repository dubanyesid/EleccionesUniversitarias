<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Elecciones Java Web JSP y Servlet</title>
</head>
<body>

<style>
	#mensaje{
	color:red;
	}
</style>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #38C953">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"><h1>Administrar
						Votantes</h1> Elecciones Management App </a>
			</div>
		</nav>
	</header>

	<div class="container">
		<hr>
		<div id="botones" class="container text-left">
			<a href="indexCandidatos.jsp"
					class="btn btn-success">Ir a Candidatos</a> 
			<a href="indexVotantes.jsp" class="btn btn-success">Ir a votantes</a>
		</div>
	</div>
<% 
String mensaje=String.valueOf(request.getAttribute("mensaje"));
            if(request.getAttribute("mensaje")!=null) 
            { 
            	if(mensaje.charAt(0)=='Y'){
            	%>          
                <hr>
                <input id="mensaje" type="text" style="width:20%; margin-left:50px" name="txtResultado" value="<%=request.getAttribute("mensaje")%>" disabled/>
        <%
           		 }else{
            	%>
            	<hr>
            	<input id="mensaje" type="text" style="width:20%; color:green; margin-left:50px" name="txtResultado" value="<%=request.getAttribute("mensaje")%>" disabled/> 	
           <%  }
            }
%>
                
</body>
</html>
