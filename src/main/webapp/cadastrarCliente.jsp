<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>        
        <div class="login-page">
            <div class="form">
                <h1 class="title">Cadastro de clientes</h1>
                <form action="ClienteControl" method="post" class="login-form">
                    <input type="text" name="nome" placeholder="nome"> <br>
                    <input type="text" name="telefone" placeholder="telefone"> <br>
                    <input type="text" name="cpf" placeholder="cpf"> <br>
                    <input type="submit" value="Cadastrar">            
                </form>
            </div>
        </div>
    </body>
    <footer>
        Rodrigo Bock e Nicolas Escobar. TADS 2022™
    </footer>
</html>