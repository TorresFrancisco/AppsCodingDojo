<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/pag.css">
    <title>The Bushido Code</title>
    </head>
    <body>
        <div class="info">
            <h1><u>Submitted Info</u></h1>
            <br>
            <h2>Name: <c:out value="${name}"/></h2>
            <h2>Location: <c:out value="${location}"/></h2>
            <h2>Language: <c:out value="${language}"/></h2>
            <h2>Comment: <c:out value="${comment}"/></h2>
        </div>
    </body>
    </html>
