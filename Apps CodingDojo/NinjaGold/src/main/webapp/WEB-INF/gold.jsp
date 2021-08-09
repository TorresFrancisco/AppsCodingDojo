<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/gold.css">
    <title>Ninja Gold Game</title>
</head>
<body>
    <h1 class="oro">Your gold: <c:out value="${gold}"/></h1>
<div id="container">
    <form class="subcontent" action="gold" method="POST">
        <h1>Farm</h1>
        <h2>(earns 10-20 gold)</h2>
        <br>
        <button name="place"  value = "farm"> Find Gold!</button>
    </form>

    <form class="subcontent" action="gold" method="POST">
        <h1>Cave</h1>
        <h2>(earns 5-10 gold)</h2>
        <br>
        <button name="place"  value = "cave"> Find Gold!</button>
    </form>

    <form class="subcontent" action="gold" method="POST">
        <h1>House</h1>
        <h2>(earns 2-5 gold)</h2>
        <br>
        <button name="place"  value = "house"> Find Gold!</button>
    </form>

    <form class="subcontent" action="gold" method="POST">
        <h1>Casino</h1>
        <h2>(earns/takes 0-50 gold)</h2>
        <br>
        <button name="place"  value = "casino"> Find Gold!</button>
    </form>

    <form class="subcontent" action="gold" method="POST">
        <h1>Spa</h1>
        <h2>(takes 5 - 20 gold)</h2>
        <br>
        <button name="place"  value = "spa">Relax my friend!</button>
    </form>

    <h1 class="activities">Activities:</h1>
        <textarea rows="10" cols="200">
            <c:forEach items="${actions}" var="action">
                <c:out value="${action}"/>
            </c:forEach>

        </textarea>
        <br><br>
    <a class="reset" href="reset">RESET</a>
</div>
</body>
</html>