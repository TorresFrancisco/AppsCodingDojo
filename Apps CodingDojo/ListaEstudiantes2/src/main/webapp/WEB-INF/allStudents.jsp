<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/topten.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <header>
        <h1>All Students</h1>
    </header>
<table class="table table-danger">
    <thead>
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${nombre}" var="nombre">
        <tr>
            <td><c:out value="${nombre.firstName}"/> <c:out value="${nombre.lastName}"/></td>
            <td><c:out value="${nombre.age}"/></td>
            <td><c:out value="${nombre.contacto.address}"/></td>
            <td><c:out value="${nombre.contacto.city}"/></td>
            <td><c:out value="${nombre.contacto.state}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <footer>
        <a href="/students/new">Crea otro estudiante</a>
    </footer>
</div>
</body>
</html>
