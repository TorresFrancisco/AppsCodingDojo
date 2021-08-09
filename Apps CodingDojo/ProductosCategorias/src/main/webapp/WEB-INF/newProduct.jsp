<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Product</title>
    <link rel="stylesheet" href="/css/home.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<header>
    <a href="/categories/new">Crea una categoria</a>
</header>
    <div id="informacion">
        <h1>New Product</h1>
        <form:form action="/products/new" method="post" modelAttribute="product">
            <p>
                <form:label path="name"> Name: </form:label>
                <br>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <p>
                <form:label path="description"> Description: </form:label>
                <br>
                <form:errors path="description"/>
                <form:textarea path="description"/>
            </p>
            <p>
                <form:label path="price"> Price: </form:label>
                <br>
                <form:errors path="price"/>
                <form:input path="price"/>
            </p>
            <input type="submit" value="Create"/>
        </form:form>
    </div>
</body>
</html>
