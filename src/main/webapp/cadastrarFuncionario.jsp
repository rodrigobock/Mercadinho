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
                <% out.println("<a href=\"" + request.getParameter("back") 
                        + "\">Voltar</a>");%>
                <h1 class="title">Cadastro de funcionário</h1>
                <form action="ListarController" method="post" class="login-form">
                    <input type="text" name="nome" placeholder="Nome"> <br>
                    <input type="text" name="telefone" placeholder="Telefone"> <br>
                    <input type="text" name="cpf" placeholder="CPF"> <br>
                    <input type="text" name="cargo" placeholder="Cargo"> <br>
                    <input type="text" name="login" placeholder="Login"> <br>
                    <input type="password" name="senha" placeholder="Senha"><br>                         
                    <span style="color: red">${cadastroErro}</span>
                    <span style="color: greenyellow">${cadastroOk}</span>
                    <span style="color: greenyellow">${atualizacaoOk}</span>
                    <input type="submit" value="Cadastrar">            
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>