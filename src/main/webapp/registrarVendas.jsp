<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
         import="java.util.*"
         import="ifc.edu.br.models.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar venda</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>        
        <div class="login-page">
            <div class="form">
                <a href="login">Voltar</a>
                <h1 class="title">Cadastro de venda</h1>
                <form method="POST" action='RegVendas' name="frmAddVenda">
                    Funcionário <br/>
                    <input type="text" disabled="true" name="nome" required oninvalid="this.setCustomValidity('Insira um nome!')"
                           oninput="this.setCustomValidity('')" placeholder="Nome" 
                           value="<c:out value="${funcionario.nome}"/>" /> <br /> 
                    Loja: <br/>
                    <input type="text" disabled="true" name="loja" required oninvalid="this.setCustomValidity('Insira um telefone!')"
                           oninput="this.setCustomValidity('')" placeholder="Loja" 
                           value="<c:out value="${loja.nome}"/>" /> <br /> 

                    Cliente: <br/> 
                    <select name="cliente">
                        <%
                            ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getAttribute("cliente");
                            for (Cliente cliente : clientes) {
                        %>
                        <option value="<%=cliente.getId()%>"><%=cliente.getNome()%></option>
                        <%
                            }
                        %>
                    </select> <br>

                    Produtos: <br/> 
                    <select name="pdt">
                        <%
                            ArrayList<Produto> produtos = (ArrayList<Produto>) request.getAttribute("produtos");
                            for (Produto produto : produtos) {
                        %>
                        <option value="<%=produto.getId()%>"><%=produto.getNome()%></option>
                        <%
                            }
                        %>
                    </select> <br>


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
