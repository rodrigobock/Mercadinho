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
                    <input name="senha" type="password" placeholder="password"/>
                    <button type="submit"> Login </button>
                    
                    <p class="message">Not registered? <a href="funcionario">Create an account</a></p>
                </form>
            </div>
        </div>

    </body>
</html>
