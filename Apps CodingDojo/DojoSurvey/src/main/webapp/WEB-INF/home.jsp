<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/home.css">
    <title>Secret Code</title>
</head>
<body>
<div class="dato">
    <form action="/result" method = "POST">
        <label for="name">Your Name:</label>
        <input type="text" id="Name" name="name">
        <br><br>
            <label for="location">Dojo Location:</label>
                <select name="location" id="location">
                    <option value="San Jose">San Jose</option>
                    <option value="Santiago">Santiago</option>
                    <option value="Silicon Valley">Silicon Valley</option>
                    <option value="Dubai">Dubai</option>
                </select>
        <br><br>
            <label for="location">Favorite Language:</label>
                <select name="language" id="language">
                    <option value="Python">Python</option>
                    <option value="Java">Java</option>
                    <option value="C">C</option>
                    <option value="JavaScript">JavaScript</option>
                </select>
        <br><br>
            <label for="comment">Comment (optional):</label>
                <br><br>
                <textarea id="comment" name="comment" rows="4" cols="50">

                </textarea>
        <br><br>
        <input class="submit" type="submit" value="Submit">
    </form>
</div>
</body>
</html>