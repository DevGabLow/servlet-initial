<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	Usu�rio: ${ user.login }
	<c:import url="logout-partial.jsp"/>
	<c:if test="${not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso. <br/>
	</c:if>
	List de empresas
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li>
				${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/YYYY HH:mm" /> 
				<a href="main?action=findOne&id=${ empresa.id }">editar</a>
				<a href="main?action=delete&id=${ empresa.id }"> remover</a>
			 </li>
		</c:forEach>
	</ul>
	<a href="main?action=viewCreate" >Criar</a>
</body>
</html>