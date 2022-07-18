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
                <h1 class="title">Login</h1>
                <form action="login" method="post" class="login-form">
                    <input type="hidden" name="back" value="login" />
                    <input type="text" name="login" placeholder="username"/>
                    <input type="password" name="senha" placeholder="password"/>
                    <span style="color: red">${loginErro}</span>
                    <input type="submit" value="Login">

                    <p class="message">Cliente novo? <a href="ClienteControl">Create an account</a></p>
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
