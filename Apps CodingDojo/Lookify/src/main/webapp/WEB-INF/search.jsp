<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" href="/css/search.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
    <body class="container">
    <header>
        <h1>Songs by artist: <c:out value="${busqueda}"/></h1>
        <form class="search" action="/search">
            <input type="text" id="busqueda" name="busqueda">
            <input type="submit" value="New Search">
        </form>
        <a href="/dashboard">Dashboard</a>
    </header>
    <div class="alert alert-dark" role="alert">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Rating</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
        <c:forEach  var="lookify" items="${artist}">
            <tr>
                <td><a href="/songs/${lookify.id}"><c:out value="${lookify.title}"/></a></td>
                <td><c:out value="${lookify.rating}"/></td>
                <td>
                    <form class="box" action="/songs/${lookify.id}" method="post">
                        <input  type="hidden" name="_method" value="delete">
                        <input class="cuadrito" type="submit" value="delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </table>
    </div>
    </body>
</html>
