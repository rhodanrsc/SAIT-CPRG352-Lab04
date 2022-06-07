
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Edit Note</h1>
        <form method="post" action="note">
            <label>Title:</label>
            <input type="text" name="editTitle">
            <br>
            <label>Contents:</label>
            <textarea cols="" rows="6" name="editContent"></textarea>
            <br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
