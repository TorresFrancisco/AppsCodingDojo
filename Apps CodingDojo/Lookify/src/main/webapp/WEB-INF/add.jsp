<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Song</title>
    <link rel="stylesheet" href="/css/add.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>
<header>
    <a href="/dashboard">Dashboard</a>
</header>
<div id="cuadro">
    <div class="alert alert-success" role="alert">
        <form:form action="/songs/new" method="post" modelAttribute="lookify">
            <p>
                <form:label path="title"> Title </form:label>
                <form:errors path="title"/>
                <form:input path="title"/>
            </p>
            <p>
                <form:label path="artist"> Artist </form:label>
                <form:errors path="artist"/>
                <form:input path="artist"/>
            </p>
            <p>
                <form:label path="rating"> Rating ( 1 - 10 )</form:label>
                <form:errors path="rating"/>
                <form:input type="number" min="1" max="10" path="rating"/>
            </p>
            <input type="submit" value="Add Song"/>
        </form:form>
    </div>
</div>
</body>
</html>
