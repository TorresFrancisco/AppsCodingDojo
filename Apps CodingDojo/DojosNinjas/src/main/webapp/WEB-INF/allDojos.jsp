<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <header>
            <h1><c:out value="${dojo.name}"/> Ninjas</h1>
        </header>
        <table class="table table-danger">
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Age</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dojo.ninjas}" var="ninja">
            <tr>
                <td><c:out value="${ninja.firstName}"/></td>
                <td><c:out value="${ninja.lastName}"/></td>
                <td><c:out value="${ninja.age}"/></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <footer>
            <a href="/dojos/new">Crea otro Dojo</a>
            <a href="/ninjas/new">Crea otro Ninja</a>
        </footer>
    </div>
</body>
</html>
