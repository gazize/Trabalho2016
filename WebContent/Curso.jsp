<%@ page language="java" contentType="text/html;  charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="to.CursoTO" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset=UTF-8">
<title>Curso Cadastrado</title>
</head>
<body>
	<%CursoTO to = (CursoTO)request.getAttribute("curso"); %>
	Codigo: 	 <%=to.getsCodigo()		 %> <br>
	Descricao:	 <%=to.getsDescricao() 	 %> <br>
	Data Inicio: <%=to.getsDataInicio()  %> <br>
	Data Fim: 	 <%=to.getsDataInicio()  %> <br>
	Horario: 	 <%=to.getsHorario() 	 %> <br>
	Data Inicio: <%=to.getsDataInicio()  %> <br>
	Num. Vagas:  <%=to.getiNumVagas() 	 %> <br>
	Area: 		 <%=to.getsArea() 		 %> <br>
	Valor: 		 <%=to.getdValor() 		 %> <br>
	Num. Vagas:  <%=to.getiNumVagas() 	 %> <br>
	
	
</body>
</html>