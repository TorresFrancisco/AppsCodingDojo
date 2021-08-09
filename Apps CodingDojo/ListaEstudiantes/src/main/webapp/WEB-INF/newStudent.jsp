<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New Student</title>
</head>
<body>
<h1>New Student</h1>
<form:form action="/students/new" method="post" modelAttribute="nombre">
    <p>
        <form:label path="firstName"> First Name: </form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName"> Last Name: </form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age"> Age: </form:label>
        <form:errors path="age"/>
        <form:input type="number" min="1" max="99" path="age"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>
