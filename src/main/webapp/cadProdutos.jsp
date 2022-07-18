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
            Nome do produto: <input type="text" name="descricao" value=""> <br>
            Cod. barras: <input type="text" name="gtin" value=""> <br>
            Valor <input type="text" name="valor" value=""> <br>
            Peso: <input type="text" name="peso" value=""> <br>
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
