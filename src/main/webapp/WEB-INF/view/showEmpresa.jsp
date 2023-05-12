<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/main" var="linkServletUpdateEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>

<form action="${linkServletUpdateEmpresa}" method="post">
		<input type="hidden" name="id" value="${ empresa.id }"/> 
		<input type="hidden" name="action" value="create" />
	Nome: <input name="nome" type="text"  value="${ empresa.nome }"/><br/>
	Data: <input name="data" type="text" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/YYYY" />">
	<button type="submit">Atualizar</button>
</form>
</body>
</html>