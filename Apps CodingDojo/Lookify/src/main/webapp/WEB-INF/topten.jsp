<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" href="/css/topten.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
    <header>
        <h1>Top Ten Songs:</h1>
        <a href="/dashboard">Dashboard</a>
    </header>
    <div>
        <div class="alert alert-dark" role="alert">
            <table class="table">
                <c:forEach var="lookify" items="${topten}">
                <tr>
                    <td><c:out value="${lookify.rating}"/></td>
                    <td><a href="/songs/${lookify.id}"><c:out value="${lookify.title}"/></a></td>
                    <td><c:out value="${lookify.artist}"/></td>
                </tr>
                </c:forEach>
            </table>
    </div>
    </div>
</body>
</html>
