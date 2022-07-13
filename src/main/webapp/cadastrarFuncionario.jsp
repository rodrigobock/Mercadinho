<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cad Func</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>        
        <div class="login-page">
            <div class="form">
                <h1 class="title">Cadastro de funcionário</h1>
                <form action="funcionario" method="post" class="login-form">
                    <input type="text" name="cargo" placeholder="Cargo"> <br>
                    <input type="text" name="login" placeholder="Login"> <br>
                    <input type="password" name="senha" placeholder="Senha"> <br>
                    <input type="submit" value="Cadastrar">            
                </form>
            </div>
        </div>
    </body>
    <footer>
        Rodrigo Bock e Nicolas Escobar. TADS 2022™
    </footer>
</html>