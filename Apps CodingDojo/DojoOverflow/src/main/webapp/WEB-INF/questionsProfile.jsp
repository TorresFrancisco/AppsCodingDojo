<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Question profile </title>
    <link rel="stylesheet" href="/css/questionProfile.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
    <header>
        <h1><c:out value="${questions.pregunta}"/></h1>
    </header>
    <div class="tags">
        <h2 id="tags">Tags:</h2>
        <c:forEach items="${tags}" var="tag">
            <button class="btn btn-secondary"><c:out value="${tag.subject}"/></button>
        </c:forEach>
    </div>
    <div class="tabla">
        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th>Answers</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${questions.answers}" var="respuestas">
            <tr>
                <td><c:out value="${respuestas.respuesta}"/></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="tabla2">
        <h2>Add your answer:</h2>
        <form:form action="" method="post" modelAttribute="answer">
            <p>
                <form:label path="respuesta"> Answer: </form:label>
                <form:errors path="respuesta"/>
                <form:textarea cols="40" rows="3" path="respuesta"/>
            </p>
            <input id="botonAzul" class="btn btn-primary" type="submit" value="Answer it!">
        </form:form>
    </div>
    <footer>
        <button class="btn btn-warning"><a href="/questions">Dashboard</a></button>
        <button class="btn btn-warning"><a href="/questions/new">New Question</a></button>
    </footer>
</body>
</html>
