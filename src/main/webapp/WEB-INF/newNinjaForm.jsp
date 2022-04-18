<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja Form</title>
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
			<div class="dojo">
				<form:label path="dojo"> Dojo: </form:label>
				<form:select path="dojo">
					<c:forEach var="dojo" items="${dojos }">
						<form:option value="${dojo.id }">${dojo.name }</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="firstName">
				<form:label path="firstName"> First Name: </form:label>
				<form:input path="firstName"/>
				<form:errors path="firstName"/> 
			</div>
			<div class="lastName">
				<form:label path="lastName"> Last Name: </form:label>
				<form:input path="lastName"/>
				<form:errors path="lastName"/> 
			</div>
			<div class="age">
				<form:label path="age"> Age: </form:label>
				<form:input path="age" type="number"/>
				<form:errors path="age"/> 
			</div>
			<button>Create</button>
		</form:form>
	</div>
</body>
</html>