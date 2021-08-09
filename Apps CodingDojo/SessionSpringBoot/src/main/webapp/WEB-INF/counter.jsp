<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/counter.css">
    <title>Welcome, again</title>
</head>
<body>
    	<h1>You have visited <a href="/">http://bebecita.cl/</a><h1> 
    	<h1><c:out value="${count}"/></h1>
    	<h1><a href="/">Test another visit</a>?<h1>
</body>
</html>