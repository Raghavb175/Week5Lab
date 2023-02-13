<%-- 
    Document   : login
    Created on : 13-Feb-2023, 1:18:35 AM
    Author     : ragha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            Username: <input type="text" name="username" value=${username}><br>
            Password: <input type="text" name="password" value=${password}><br>
            <input type="submit" name="submit" value="Log In">
        </form>
        ${invalid}
    </body>
</html>