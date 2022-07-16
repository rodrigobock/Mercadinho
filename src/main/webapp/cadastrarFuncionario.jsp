<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
         import="java.util.*"
         import="ifc.edu.br.models.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionarios</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>        
        <div class="login-page">
            <div class="form">
                <a href="login">Voltar</a>
                <h1 class="title">Cadastro de funcionário</h1>
                <form method="POST" action='FuncionarioController' name="frmAddUser">
                    <input type="hidden" name="id" value="<c:out value="${funcionario.id}"/>" /> <br />
                    <input type="text" name="nome" required oninvalid="this.setCustomValidity('Insira um nome!')"
                           oninput="this.setCustomValidity('')" placeholder="Nome" 
                           value="<c:out value="${funcionario.nome}"/>" /> <br /> 
                    <input type="text" name="telefone" required oninvalid="this.setCustomValidity('Insira um telefone!')"
                           oninput="this.setCustomValidity('')" placeholder="Telefone" 
                           value="<c:out value="${funcionario.telefone}"/>" /> <br /> 
                    <input type="text" name="cpf" required oninvalid="this.setCustomValidity('Insira um CPF!')"
                           oninput="this.setCustomValidity('')" placeholder="CPF" 
                           value="<c:out value="${funcionario.cpf}"/>" /> <br /> 
                    <input type="text" name="cargo" required oninvalid="this.setCustomValidity('Insira um Cargo!')"
                           oninput="this.setCustomValidity('')" placeholder="Cargo" 
                           value="<c:out value="${funcionario.cargo}"/>" /> <br /> 
                    <input type="text" name="login" required oninvalid="this.setCustomValidity('Insira um Login!')"
                           oninput="this.setCustomValidity('')" placeholder="Login" 
                           value="<c:out value="${funcionario.login}"/>" /> <br /> 
                    <input type="password" name="senha" required oninvalid="this.setCustomValidity('Insira uma Senha!')"
                           oninput="this.setCustomValidity('')" placeholder="Senha" 
                           value="<c:out value="${funcionario.senha}"/>" /> <br />                        
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
