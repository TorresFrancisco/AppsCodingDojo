<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New Question</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
    <header>
        <h1>What is your question?</h1>
    </header>
    <div id="cuadro">
        <div class="alert alert-success" role="alert">
            <form:form action="/questions/new" method="post" modelAttribute="questions">
                <p>
                    <form:label path="pregunta"> Question: </form:label>
                    <form:errors path="pregunta"/>
                    <form:textarea cols="160" rows="5" path="pregunta"/>
                </p>
                <p>
                    <label for="tgs">Tags:</label>
                    <input id="tgs" type="text" name="tgs">
                </p>
                <input class="btn btn-info" type="submit" value="Submit">
            </form:form>
        </div>
    </div>
</body>
</html>

