<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="ifc.edu.br.models.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>        
        <div class="form">
        <a href="login">Voltar</a>
        <h1>Cadastro de Produtos</h1>
        <form action="CadProdutos" method="post" class="login-form">
            <input type="text" name="descricao" required oninvalid="this.setCustomValidity('Insira um Produto!')"
                oninput="this.setCustomValidity('')" placeholder="Produto"> <br>
            <input type="text" name="gtin" required oninvalid="this.setCustomValidity('Insira um Código!')"
                oninput="this.setCustomValidity('')" placeholder="Cod. Barras"> <br>
            <input type="text" name="valor" required oninvalid="this.setCustomValidity('Insira um Valor!')"
                   oninput="this.setCustomValidity('')" placeholder="Valor"> <br>
            <input type="text" name="peso" required oninvalid="this.setCustomValidity('Insira um nome!')"
                   oninput="this.setCustomValidity('')" placeholder="Peso"> <br>
            Unidade de medida: 
            <select name="ums">
                <%
                    ArrayList<UnidadeMedida> unidadeMedidas = (ArrayList<UnidadeMedida>) request.getAttribute("ums");
                    for (UnidadeMedida unidadeMedida : unidadeMedidas) {
                %>
                <option value="<%=unidadeMedida.getId()%>"><%=unidadeMedida.getTipo()%></option>
                <%
                    }
                %>
            </select> <br>
            <input type="hidden" name="parent" value="produto">
            <span style="color: greenyellow">${cadastroOk}</span> <br>
            <input type="submit" value="Cadastrar">
        </form>
        </div>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
