<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Editar Lenguaje</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/edit.css">
</head>
<body>
<header>
    <a href="/languages">Dashboard</a>
    <form class="box" action="/languages/${language.id}" method="post">
        <input  type="hidden" name="_method" value="delete">
        <input class="cuadrito" type="submit" value="delete">
    </form>
</header>

<div id="cuadro">
<div class="alert alert-primary" role="alert">
    <h1>Edit language</h1>
    <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:input path="creator"/>
        </p>
        <p>
            <form:label path="version">Version</form:label>
            <form:errors path="version"/>
            <form:input path="version"/>
        </p>
        <input type="submit" value="Submit"/>
        </form:form>
</div>
</div>
</body>
</html>