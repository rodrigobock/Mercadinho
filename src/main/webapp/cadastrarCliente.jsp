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
                <a href="login">Voltar</a>
                <h1 class="title">Cadastro de clientes</h1>
                <form action="ClienteControl" method="post" class="login-form">
                    <input type="text" name="nome" required oninvalid="this.setCustomValidity('Insira um nome!')"
                           oninput="this.setCustomValidity('')" placeholder="Nome"> <br>
                    <input type="text" name="telefone" required oninvalid="this.setCustomValidity('Insira um telefone!')"
                           oninput="this.setCustomValidity('')" placeholder="Telefone"> <br>
                    <input type="text" name="cpf" required oninvalid="this.setCustomValidity('Insira um CPF!')"
                           oninput="this.setCustomValidity('')" placeholder="CPF"> <br>
                    <input type="submit" value="Cadastrar">            
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>