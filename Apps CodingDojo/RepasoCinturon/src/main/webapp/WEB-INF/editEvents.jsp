<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Event</title>
    <link rel="stylesheet" href="/css/eventsEdit.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
<div id="cuadro">
    <header><c:out value="${event.name}"/></header>
    <div class="alert alert-success" role="alert">
        <h2>Edit Event</h2>
        <p><form:errors path="evento.*"/></p>
        <form:form action="" method="post" modelAttribute="evento">
            <input type="hidden" name="_method" value="put">
            <p>
                <form:label path="name"> Name: </form:label>
                <form:input path="name" />
            </p>
        <p>
            <form:label type="date" path="date"> Date: </form:label>
            <form:input type="date" path="date"/>
        </p>
            <p>
                <form:label path="location"> Location: </form:label>
                <form:input  path="location"/>
            </p>
            <p>
                <form:label path="state"> State: </form:label>
                <form:input  path="state"/>
            </p>
            <input class="btn btn-warning botoncito" type="submit" value="Edit"/>
        </form:form>
    </div>
</div>
</body>
</html>
