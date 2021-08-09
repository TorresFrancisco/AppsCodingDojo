<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Languages</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/index.css">
</head>
<body class="container">
    <table class="table table-danger">
        <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${languages}" var="language">
            <tr>
                <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
                <td><c:out value="${language.creator}"/></td>
                <td><c:out value="${language.version}"/></td>
                <td>
                    <form class="box" action="/languages/${language.id}" method="post">
                        <input  type="hidden" name="_method" value="delete">
                        <input class="cuadrito" type="submit" value="delete">
                    </form>
                    <form class="box" action="/languages/${language.id}/edit" method="put">
                        <input  type="hidden" name="_method" value="edit">
                        <input class="cuadrito" type="submit" value="edit">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form:form action="/languages" method="post" modelAttribute="language">
        <p>
            <form:label path="name"> Name </form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator"> Creator </form:label>
            <form:errors path="creator"/>
            <form:input path="creator"/>
        </p>
        <p>
            <form:label path="version"> Version </form:label>
            <form:errors path="version"/>
            <form:input path="version"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
