<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Category</title>
    <link rel="stylesheet" href="/css/home.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<header>
    <a href="/products/new">Crea un nuevo producto</a>
</header>
        <div id="informacion">
        <h1>New Category</h1>
        <form:form action="/categories/new" method="post" modelAttribute="category">
            <p>
                <form:label path="name"> Name: </form:label>
                <br>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <input type="submit" value="Create"/>
        </form:form>
        </div>
</body>
</html>
