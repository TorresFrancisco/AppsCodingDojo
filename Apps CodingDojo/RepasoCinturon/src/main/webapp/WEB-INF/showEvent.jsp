<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title><c:out value="${event.name}"/></title>
    <link rel="stylesheet" href="/css/showEvent.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
        <header><h1><c:out value="${event.name}"/></h1></header>
        <div class="information">

            <h3>Host: <c:out value="${event.host.firstname}"/> <c:out value="${event.host.lastname}"/></h3>
            <h3>Date: <fmt:formatDate pattern="MMMM dd, yyyy" value="${event.date}" /></h3>
            <h3>Location: <c:out value="${event.location}"/>, <c:out value="${event.state}"/></h3>
            <h3>People who are attending this event: <c:out value="${event.usuariosAsisten.size()}"/> </h3>
            <table class="table table-success table-striped">
                <thead>
                <tr>
                    <th> Name </th>
                    <th> Location </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${event.usuariosAsisten}" var="user">
                    <tr>
                        <td><c:out value="${user.firstname}"/> <c:out value="${user.lastname}"/></td>
                        <td><c:out value="${user.location}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="boxes">
            <h2>Message Wall</h2>
            <textarea rows="10" cols="50"><c:out value="${datosString}"/></textarea>
            <form:form action="" method="post" modelAttribute="messagedescription">
                <br><br>
                <p>
                    <form:label path="description"> Add comment: </form:label>
                    <form:input  path="description"/>
                </p>
                <input class="btn btn-info" type="submit" value="Submit">
            </form:form>
        </div>
        <footer>
            <button class="btn btn-warning"><a href="/events">Vuelva a lo eventos amigo mío</a></button>
        </footer>
</body>
</html>
