<%--
    Document   : form
    Created on : Mar 17, 2022, 3:09:25 PM
    Author     : friend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cad Func</title>
    </head>
    <body>
        <h1>Cadastro de funcionário</h1>
        <form action="funcionario" method="post">
            Cargo: <input type="text" name="cargo" value=""> <br>
            Login: <input type="text" name="login" value=""> <br>
            Senha: <input type="text" name="senha" value=""> <br>
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>