<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="to.AlunoTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aluno Cadastrado</title>
</head>
<body>
	<%AlunoTO to = (AlunoTO)request.getAttribute("aluno"); %>
	Nome: 	  <%=to.getSnome()	  %> <br>
	Endereço: <%=to.getsEnd()   %> <br>
	E-Mail:   <%=to.getsMail()  %> <br>
	RG: 	  <%=to.getsRg()  %> <br>
	CPF: 	  <%=to.getsCpf() 	  %> <br>
	Login: 	  <%=to.getsUsuario()  %> <br>
</body>
</html>