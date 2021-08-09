<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Dormitory</title>
    <link rel="stylesheet" href="/css/topten.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body class="container">
        <header>
            <h1><c:out value="${dorm.name}"/> Dormitory</h1>
        </header>
        <form id="formulario" action="" method="post">
            <label for="formulario"> Student: </label>
            <select form="formulario" name="formulario" id="formularios">
                <c:forEach items="${nombres}" var="nombre">
                    <option value="${nombre.id}"><c:out value="${nombre.firstName}"/> <c:out value="${nombre.lastName}"/></option>
                </c:forEach>
                <input type="submit" value="Add"/>
            </select>
        </form>
        <div class="alert alert-dark" role="alert">
            <table class="table">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${dorms.nombre}" var="nombre">
                    <tr>
                        <td><c:out value="${nombre.firstName}"/> <c:out value="${nombre.lastName}"/></td>
                        <td>
                            <form class="box" action="" method="post">
                                <input  type="hidden" name="_method" value="Remove">
                                <input class="cuadrito" type="submit" value="Remove">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    <footer>
        <a href="/dorms/new">Crea otro dormitorio</a>

    </footer>
</div>
</body>
</html>
