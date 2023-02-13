<%-- 
    Document   : home
    Created on : 13-Feb-2023, 12:59:28 AM
    Author     : ragha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <h1>Home Page</h1>
        Hello ${username}
        <form action="home" method="post">
            <input type="submit" name="submit" value="Log Out">
            <input type="hidden" name="action" value="logout">
        </form>
    </body>
</html>