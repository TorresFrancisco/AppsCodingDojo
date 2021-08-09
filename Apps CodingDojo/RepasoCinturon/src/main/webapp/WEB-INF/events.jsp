<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Events</title>
    <link rel="stylesheet" href="/css/events.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
    <header>
        <h1>Welcome, <c:out value="${user.firstname}"/> <c:out value="${user.lastname}"/></h1>
        <button class="btn btn-warning"><a href="/logout">logout</a></button>
    </header>
    <h2>Here are some of the events in your state:</h2>
    <div class="tabla">
        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th> Name </th>
                <th> Date </th>
                <th> Location </th>
                <th> Host </th>
                <th> Action / Status </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${stateContaining}" var="event">
                <tr>
                    <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
                    <td><fmt:formatDate pattern="MMMM dd, yyyy" value="${event.date}" /></td>
                    <td><c:out value="${event.location}"/></td>
                    <td><c:out value="${event.host.firstname}"/></td>
                    <td>
                        <c:if test="${event.host.id == user.id}"><a href="/events/${event.id}/edit">Edit</a></c:if>
                        <c:if test="${event.host.id == user.id}">
                            <form class="xd" action="/events/delete/${event.id}" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <input class="botoncito" type="submit" value="delete"></form></c:if>
                        <c:if test="${event.host.id != user.id && !event.usuariosAsisten.contains(user)}"><a href="/events/join/${event.id}">Join</a></c:if>
                        <c:if test="${event.host.id != user.id && event.usuariosAsisten.contains(user)}"><a href="/events/cancel/${event.id}">Cancel</a></c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <h2>Here are some of the events in other states:</h2>
    <div class="tabla2">
        <table class="table table-dark table-striped">
            <thead>
            <tr>
                <th> Name </th>
                <th> Date </th>
                <th> Location </th>
                <th> State </th>
                <th> Host </th>
                <th> Action </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${stateNotContaining}" var="event">
                <tr>
                    <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
                    <td><fmt:formatDate pattern="MMMM dd, yyyy" value="${event.date}" /></td>
                    <td><c:out value="${event.location}"/></td>
                    <td><c:out value="${event.state}"/></td>
                    <td><c:out value="${event.host.firstname}"/></td>
                    <td>
                        <c:if test="${event.host.id == user.id}"><a href="/events/${event.id}/edit">Edit</a></c:if>
                        <c:if test="${event.host.id == user.id}">
                            <form class="xd" action="/events/delete/${event.id}" method="post">
                                <input type="hidden" name="_method" value="delete">
                                <input class="botoncito" type="submit" value="delete"></form></c:if>
                        <c:if test="${event.host.id != user.id && !event.usuariosAsisten.contains(user)}"><a href="/events/join/${event.id}">Join</a></c:if>
                        <c:if test="${event.host.id != user.id && event.usuariosAsisten.contains(user)}"><a href="/events/cancel/${event.id}">Cancel</a></c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="cuadro">
        <div class="alert alert-success" role="alert">
            <h2>Create an Event</h2>
            <p><form:errors path="evento.*"/></p>
            <form:form action="" method="post" modelAttribute="evento">
            <p>
                <form:label path="name"> Name: </form:label>
                <form:input path="name"/>
            </p>
            <p>
                <form:label type="date" path="date"> Date: </form:label>
                <form:input type="date" path="date"/>
            </p>
            <p>
                <form:label path="location"> Location: </form:label>
                <form:input  path="location"/>
            </p>
            <p>
                <form:label path="state"> State: </form:label>
                <form:input  path="state"/>
            </p>
            <input class="btn btn-warning botoncito" type="submit" value="Create"/>
            </form:form>
        </div>
    </div>
</body>
</html>
