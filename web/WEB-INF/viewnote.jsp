
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <form method="post">
            <h1>Simple Note Keeper</h1>
            <h2>View Note</h2>
            <b>Title: </b>${title} 
            <br>
            <br>
            <b>Contents: </b>
            <p>${content}</p>
            <a href="note?edit">Edit</a>
        </form>
    </body>
</html>
