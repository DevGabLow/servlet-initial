<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/main" var="linkServletLogin" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="${linkServletLogin }" method="post">

		Login: <input name="login" type="text" /><br /> Senha: <input
			name="password" type="password">
		<input type="hidden" name="action" value="login"/>
		<button type="submit">acessar</button>
	</form>
</body>
</html>