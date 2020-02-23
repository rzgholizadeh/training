<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Company Home Page - test</title>
</head>


<body>
	<h2>Company Home Page -test</h2>
	<hr>
	<p>Welcome to the luv2code Company Home Page!</p>
	<hr>
	<!-- displaying user id -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>

	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to /leaders... only for managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				meeting</a> (only for manager role)
		</p>

	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to /systems... only for admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT systems
				meeting</a> (only for Admin role)
		</p>

	</security:authorize>
	<hr>
	<!-- logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>



</html>