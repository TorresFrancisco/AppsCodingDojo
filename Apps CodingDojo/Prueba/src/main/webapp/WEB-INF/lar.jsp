<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="/css/lar.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
<header>
    <h1>Welcome</h1>
</header>
<div class="alert alert-warning contenedor" role="alert">
    <h1>Register</h1>
    <p><form:errors path="user.*"/></p>
    <form:form method="POST" action="/" modelAttribute="user">
        <p>
            <form:label path="firstname">First Name:</form:label>
            <form:input type="firstname" path="firstname"/>
        </p>
        <p>
            <form:label path="lastname">Last Name:</form:label>
            <form:input type="lastname" path="lastname"/>
        </p>
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">PW Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input class="btn btn-danger botoncito" type="submit" value="Register"/>
    </form:form>
</div>
<div class="alert alert-warning contenedor" role="alert">
    <h1>Login</h1>
    <p><c:out value="${error}"/></p>
    <form method="post" action="/login">
        <p>
            <label for="email"> Email: </label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password"> Password: </label>
            <input type="password" id="password" name="password"/>
        </p>
        <input class="btn btn-danger botoncito" type="submit" value="Login"/>
    </form>
</div>
</body>
</html>
