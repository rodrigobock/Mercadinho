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
                <form method="POST" action='RegVendas'>
                    Funcionário <br/>
                    <input type="text" name="nomeFuncionario" value="<c:out value="${funcionario.nome}"/>" /> <br /> 
                    Loja: <br/>
                    <input type="text" disabled="true" name="loja" value="<c:out value="${loja.nome}"/>" /> <br /> 

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
                    <select name="produto">
                        <%
                            ArrayList<Produto> produtos = (ArrayList<Produto>) request.getAttribute("produtos");
                            for (Produto produto : produtos) {
                        %>
                        <option value="<%=produto.getId()%>"><%=produto.getNome()%></option>
                        <%
                            }
                        %>
                    </select> <br>

                    <input type="submit" value="Cadastrar">            
                </form>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
