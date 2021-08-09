<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="/css/dashboard.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
<header>
    <h1> Admin Dashboard </h1>
    <a href="/logout">logout</a>
</header>
<h1> Customers </h1>
<div class="tabla">
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th> Name </th>
            <th> Next Due Date </th>
            <th> Amount Due </th>
            <th> Package Type </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="admin">
            <c:if test="${admin.rol !=  1}">
                <tr>
                    <td><c:out value="${admin.firstname}"/> <c:out value="${admin.lastname}"/></td>
                    <td><c:out value="${admin.dueDate}"/></td>
                    <td><c:out value="${admin.pack.cost}"/></td>
                    <td><c:out value="${admin.pack.name}"/></td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
<h1> Packages </h1>
<div class="tabla2">
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th> Package Name </th>
            <th> Package Cost </th>
            <th> Available </th>
            <th> Users </th>
            <th> Action </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${packageList}" var="packs">
            <tr>
                <td><c:out value="${packs.name}"/></td>
                <td><c:out value="${packs.cost}"/></td>
                <td>
                    <c:if test="${packs.available == true}">available</c:if>
                    <c:if test="${packs.available == false}">unavailable</c:if>
                </td>
                <td><c:out value="${packs.userSuscribed.size()}"/></td>
                <td>
                    <c:if test="${packs.userSuscribed.size() > 0 && packs.available == false}">desactivate</c:if>
                    <c:if test="${packs.userSuscribed.size() == 0 && packs.available == false}">
                        <a href="/packages/${packs.id}/available">activate</a>
                    </c:if>
                    <c:if test="${packs.userSuscribed.size() == 0 && packs.available == true}">
                        <a href="/packages/${packs.id}/available">desactivate</a>
                    </c:if>
                    <a href="/packages/${packs.id}/edit">edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
    <div class="alert alert-success cuadro" role="alert">
        <h2>Create Package</h2>
        <p><form:errors path="package.*"/></p>
        <form:form action="" method="post" modelAttribute="package">
            <p>
                <form:label path="name"> Package Name: </form:label>
                <form:input path="name"/>
            </p>
            <p>
                <form:label path="cost"> Cost: </form:label>
                <form:input path="cost"/>
            </p>
            <input class="btn btn-warning botoncito" type="submit" value="Create new Package"/>
        </form:form>
    </div>
</body>
</html>