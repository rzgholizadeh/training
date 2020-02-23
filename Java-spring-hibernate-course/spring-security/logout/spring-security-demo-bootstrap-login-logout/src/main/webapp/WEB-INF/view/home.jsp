<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Company Home Page - test</title>
</head>


<body>
	<h2>Company Home Page -test</h2>
	<hr>
	<p>Welcome to the luv2code Company Home Page!</p>
	<!-- logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>



</html>