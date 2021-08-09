<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Questions Dashboard</title>
    <link rel="stylesheet" href="/css/dashboard.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
    <header>
        <h1>Questions Dashboard</h1>
    </header>
        <table class="table table-danger">
            <thead>
            <tr>
                <th>Question</th>
                <th>Tags</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${questions}" var="quest">
                <tr>
                    <td><a href="/questions/${quest.id}"><c:out value="${quest.pregunta}"/></a></td>
                    <td>
                        <c:forEach items="${quest.tags}" var="tag">
                        <c:out value="${tag.subject}"/>
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <footer>
            <a href="/questions/new">New Question</a>
        </footer>
</body>
</html>

