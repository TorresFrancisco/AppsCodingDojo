<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New License</title>
</head>
<body>
    <h1>New License</h1>
        <form:form action="/licenses/new" method="post" modelAttribute="license">
            <form:label path="person"> Person: </form:label>
                <form:select path="person">
                    <c:forEach items="${persons}" var="persona">
                        <form:option value="${persona.id}"><c:out value="${persona.firstName}"/> <c:out value="${persona.lastName}"/></form:option>
                    </c:forEach>
                </form:select>
            <p>
                <form:label path="state"> State: </form:label>
                <form:errors path="state"/>
                <form:input path="state"/>
            </p>
            <p>
                <form:label type="Date" path="expirationDate"> Expiration Date: </form:label>
                <form:errors type="Date" path="expirationDate"/>
                <form:input type="Date" path="expirationDate"/>
            </p>
                <input type="submit" value="Create"/>
                </form:form>
</body>
</html>
