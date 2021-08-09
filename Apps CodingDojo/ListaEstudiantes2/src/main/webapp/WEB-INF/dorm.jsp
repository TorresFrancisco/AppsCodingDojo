<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Dormitories</title>
</head>
<body>
    <h1>Dormitories</h1>
    <form:form action="/dorms/new" method="post" modelAttribute="dorm">
        <p>
            <form:label path="name"> Name: </form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <input type="submit" value="Create"/>
    </form:form>
</body>
</html>
