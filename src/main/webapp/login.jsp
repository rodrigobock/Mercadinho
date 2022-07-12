<%-- 
    Document   : login
    Created on : 11 de jul de 2022, 21:03:53
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            Login: <input type="text" name="login" value="">Login: </input> 
            <br>
            Senha: <input type="text" name="senha" value="">Senha: </input>
            <br>
            <input type="submit" value="Login">
        </form>
        <a href="cadastraUsuario.jsp">Não possui cadastro</a>
    </body>
</html>
