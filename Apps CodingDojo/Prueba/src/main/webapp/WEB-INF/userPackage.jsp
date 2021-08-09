<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Edit Task</title>
    <link rel="stylesheet" href="/css/uP.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
<header>
    <h1>Welcome, <c:out value="${user.firstname}"/> <c:out value="${user.lastname}"/>! </h1>
    <a href="/logout">Logout</a>
</header>
<div>
    <h2> Your Current Package: <c:out value="${user.pack.name}"/></h2>
    <h2> Package Cost: <c:out value="${user.pack.cost}"/></h2>
</div>

<div class="alert alert-success cuadro" role="alert">
<c:forEach items="${packages}" var="packs">
    <c:out value="${packs.available}"/>
</c:forEach>
<form:form action="/users/${user.id}" method="post" modelAttribute="user">
    <form:select path="pack">
        <c:forEach items="${packages}" var="packs">
            <c:if test="${packs.available ==  true && packs.name != user.pack.name }">
                <form:option value="${packs.id}"><c:out value="${packs.name}"/></form:option>
            </c:if>
        </c:forEach>
    </form:select>
    <input class="btn btn-warning botoncito" type="submit" value="Switch"/>
    </form:form>
</div>

<%--    <form:select path="user">--%>
<%--    <option value="${user.id}" selected ><c:out value="${user.firstname}"></c:out> <c:out value="${user.lastname}"></c:out></option>--%>