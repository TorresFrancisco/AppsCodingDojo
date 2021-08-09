<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title><c:out value="${pack.name}"/></title>
    <link rel="stylesheet" href="/css/editPackage.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
    <header>
        <a href="/logout">Logout</a>
        <a href="/packages">Previous Page</a>
    </header>
    <div class="alert alert-success cuadro" role="alert">
        <h2>Package:<c:out value="${pack.name}"/></h2>
        <p><form:errors path="pack.*"/></p>
        <form:form action="/packages/${pack.id}/edit" method="post" modelAttribute="pack">
            <input type="hidden" name="_method" value="put">
            <form:input type="hidden" path="name" value="${pack.name}"/>
            <p>
                <form:label path="cost"> Cost: </form:label>
                <form:input path="cost" />
            </p>
            <input class="btn btn-warning botoncito" type="submit" value="Edit"/>
        </form:form>
        <c:if test="${pack.userSuscribed.size() == 0}">
            <a href="/packages/${pack.id}/delete">Delete</a>
        </c:if>
    </div>
</body>
</html>