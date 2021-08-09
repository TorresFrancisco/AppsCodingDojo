<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Details</title>
    <link rel="stylesheet" href="/css/show.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<header>
    <a href="/dashboard">Dashboard</a>
</header>
<div id="cuadro">
    <div class="alert alert-success" role="alert">
        <p>Title: <c:out value="${lookify.title}"/></p>
        <p>Artist: <c:out value="${lookify.artist}"/></p>
        <p>Rating ( 1 - 10 ) <c:out value="${lookify.rating}"/></p>
        <form action="/lookifys/${lookify.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input class="cuadrito" type="submit" value="Delete">
        </form>
    </div>
</div>
</body>
</html>
