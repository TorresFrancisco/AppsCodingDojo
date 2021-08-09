<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Contact</title>
</head>
<body>

<h1>Contact Info</h1>
    <form:form action="/contact/new" method="post" modelAttribute="contacto">
        <form:label path="nombre"> Student: </form:label>
        <form:select path="nombre">
            <c:forEach items="${nombres}" var="nombre">
                <form:option value="${nombre.id}"><c:out value="${nombre.firstName}"/> <c:out value="${nombre.lastName}"/></form:option>
            </c:forEach>
        </form:select>
        <p>
            <form:label path="address"> Address: </form:label>
            <form:errors path="address"/>
            <form:input path="address"/>
        </p>
        <p>
            <form:label path="city"> City: </form:label>
            <form:errors path="city"/>
            <form:input path="city"/>
        </p>
        <p>
            <form:label path="state"> State: </form:label>
            <form:errors path="state"/>
            <form:input path="state"/>
        </p>
        <input type="submit" value="Create"/>
    </form:form>
</body>
</html>
