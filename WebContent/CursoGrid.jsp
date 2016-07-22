<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <!DOCTYPE html>
        <html lang="pt-br">
<html>
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cursos cadastrados</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">

	<table class="table table-bordered">
	<thead><tr><th>Codigo</th><th>Descricao</th><th>Data Inicio</th>
	<th>Data Fim</th><th>Horario</th><th>Num. Vagas</th><th>Area</th><th>Valor(R$)</th></tr></thead>
	
	<tbody>
	 <c:forEach var="curso" items="${cursoFull }">
		<tr>
			<td>${curso.codigo()%></td>
			<td>${curso.descricao()%></td>
			<td>${curso.dataInicio()%></td>
			<td>${curso.dataFim()%></td>
			<td>${curso.horario()%></td>
			<td>${curso.numVagas()%></td>
			<td>${curso.area()%></td>
			<td>${curso.valor()%></td>
		</tr>
	</c:forEach>
	
	
	</tbody>
	</table>

</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>