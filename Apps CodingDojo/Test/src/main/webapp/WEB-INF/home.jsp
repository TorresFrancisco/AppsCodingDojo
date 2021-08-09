<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
        <div class="container">
            <h1><c:out value="${error}"/></h1>
            <form method="POST" action="/code">
                <h2>What is the code?</h2>
                <label><input type="password" name="password"></label>
                <br>
                <button>Try code</button>
            </form>
        </div>
</body>
</html>