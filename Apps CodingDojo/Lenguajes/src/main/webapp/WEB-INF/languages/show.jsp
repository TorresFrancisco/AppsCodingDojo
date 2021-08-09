<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Mostrar Lenguaje</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/show.css">
</head>
<body>
<header>
    <a href="/languages">Dashboard</a>
</header>

<div id="cuadro">
<div class="alert alert-success" role="alert">
        <h1><c:out value="${language.name}"/></h1>
        <p><c:out value="${language.creator}"/></p>
        <p><c:out value="${language.version}"/></p>
        <a href="/languages/${language.id}/edit">Edit</a>
        <form action="/languages/${language.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input class="cuadrito" type="submit" value="Delete">
        </form>
</div>
</div>
</body>
</html>
