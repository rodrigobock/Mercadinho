<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Loja</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>        
        <div class="login-page">
            <div class="form">
                <a href="paginaInicial.jsp">Voltar</a>
                <h1 class="title">Cadastro de lojas</h1>
                <form action="LojaController" method="post" class="login-form">
                    <input type="text" name="nome" required oninvalid="this.setCustomValidity('Insira um nome!')"
                           oninput="this.setCustomValidity('')" placeholder="Nome"> <br>
                    <input type="text" name="cep" required oninvalid="this.setCustomValidity('Insira um CEP!')"
                           oninput="this.setCustomValidity('')" placeholder="CEP"> <br>
                    <input type="text" name="cnpj" required oninvalid="this.setCustomValidity('Insira um CNPJ!')"
                           oninput="this.setCustomValidity('')" placeholder="CNPJ"> <br>
                    <span style="color: red">${cadastroErro}</span>
                    <span style="color: greenyellow">${cadastroOk}</span> <br>
                    <input type="submit" value="Cadastrar">
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>