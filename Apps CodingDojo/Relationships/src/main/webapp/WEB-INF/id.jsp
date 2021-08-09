<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Profile Page</title>
    <link rel="stylesheet" href="/css/id.css">
</head>
<body>
    <div class="container">
        <h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
        <p>License Number: <c:out value="${person.license.number}"/></p>
        <p>State: <c:out value="${person.license.state}"/></p>
        <p>Expiration Date: <c:out value="${person.license.expirationDate}"/></p>

    </div>
</body>
</html>
