<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
        <h1> Producto:  <c:out value="${product.name}"/></h1>
        <div class="alert alert-primary" role="alert">
            <ul class="list-group">
                <c:forEach items="${product.categories}" var="atributos">
                    <li class="list-group-item"><c:out value="${atributos.name}"/></li>
                </c:forEach>
            </ul>
        </div>
        <div>
            <form:form action="" method="post" modelAttribute="categoryProduct">
                <form:label path="category"> Add Category: </form:label>
                <form:select cssClass="form-select" path="category">
                    <c:forEach items="${category}" var="category">
                        <form:option value="${category.id}"><c:out value="${category.name}"/></form:option>
                    </c:forEach>
                </form:select>
                <br>
                <input type="submit" value="Add"/>
            </form:form>
        </div>
        <footer>
            <a href="/products/new">Crea otro producto</a>
            <a href="/categories/new">Crea otra categoria</a>
        </footer>
</body>
</html>
