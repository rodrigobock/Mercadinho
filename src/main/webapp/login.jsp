<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form action="login" method="post" class="login-form">
                    <input type="text" name="login" placeholder="username"/>
                    <input type="password" name="senha" placeholder="password"/>
                    <input type="submit" value="Login">
                    
                    <p class="message">Funcionario novo? <a href="funcionario">Create an account</a></p>
                    <br>
                    <p class="message">Cliente novo? <a href="ClienteControl">Create an account</a></p>
                </form>
            </div>
        </div>
    </body>
    <footer>
        Rodrigo Bock e Nicolas Escobar. TADS 2022™
    </footer>    
</html>
