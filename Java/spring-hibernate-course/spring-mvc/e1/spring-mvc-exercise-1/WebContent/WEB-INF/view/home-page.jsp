<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<title>Enter your information</title>

</head>

<body>

	<form:form action="processForm" modelAttribute="student">

First name: <form:input path="firstName" />
		<br>
		<br>

Last name: <form:input path="lastName" />
		<br>
		<br>

Nationality:
	<form:select path="country">
			<form:options items="${student.countryNames}" />
		</form:select>

		<br>
		<br>
		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		<br>
		<br>

		Favorite OS:
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		Windows <form:checkbox path="operatingSystems" value="Windows" />
		<br>
		<br>
		<input type="submit" value="Submit">
	</form:form>

</body>



</html>

