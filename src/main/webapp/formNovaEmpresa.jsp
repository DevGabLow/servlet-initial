<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova Empresa</title>
</head>
<body>

<form action="${linkServletNovaEmpresa }" method="post">
	Nome: <input name="nome" type="text" /><br/>
	Data: <input name="data" type="text">
	<button type="submit">Cadastrar</button>
</form>
</body>
</html>