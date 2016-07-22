<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, to.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Alunos cadastrados</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">

	<table class="table table-bordered">
	<thead><tr><th>CPF</th><th>Nome</th><th>Endereço</th>
	<th>Telefone</th><th>E-mail</th><th>RG</th><th>Usuário</th></tr></thead>
	
	<tbody>
	<%@ page ArrayList<AlunoTO> lista = (ArrayList<AlunoTO>)request.getAttribute("alunoFull");
		for(AlunoTO to:lista){
	%>
		<tr>
		<td><%=to.getsCpf()%></td>
		<td><%=to.getSnome()%></td>
		<td><%=to.getsEnd()%></td>
		<td><%=to.getsTel()%></td>
		<td><%=to.getsMail()%></td>
		<td><%=to.getsRg()%></td>
		<td><%=to.getsUsuario()%></td>
		</tr>
	
	<% 		
		}
	%>
	</tbody>
	</table>

</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

</body>
</html>