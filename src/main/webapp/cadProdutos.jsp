<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de produtos</title>
    </head>
    <body>
        <h1>Cadastro de Produtos</h1>
        <form action="cadProdutos" method="post">
            Nome do produto: <input type="text" name="descricao" value=""> <br>
            Cod. barras: <input type="text" name="gtin" value=""> <br>
            Valor <input type="text" name="valor" value=""> <br>
            Peso: <input type="text" name="peso" value=""> <br>
            Unidade de medida: 
            <select name="produtoUM">
                <%
                    ArrayList<UnidadeMedida> ums = (ArrayList<UnidadeMedida>) request.getAttribute("ums");
                    for (UnidadeMedida unidadeMedida : ums) {
                %>
                <option value="<%=unidadeMedida.getId()%>"><%=unidadeMedida.getTipo()%></option>
                <%
                    }
                %>
            </select> <br>
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>