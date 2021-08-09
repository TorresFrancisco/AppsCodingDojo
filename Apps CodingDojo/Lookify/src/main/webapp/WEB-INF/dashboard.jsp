<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Lookify!</title>
        <link rel="stylesheet" href="/css/dashboard.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    </head>
    <body class="container">
    <header>
        <a href="/songs/new">Add New</a>
        <a href="/search/topTen">Top Songs</a>
        <form class="search" action="/search">
            <input type="text" id="busqueda" name="busqueda">
            <input type="submit" value="Search Artist">
        </form>
    </header>
    <table class="table table-danger">
        <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lookifys}" var="lookify">
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
        </tbody>
    </table>
    </body>
    </body>
</html>
