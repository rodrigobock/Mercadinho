<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <form action="CadProdutos" method="get">
            <br> <button type="submit" name="CadProdutos">Cadastrar Produtos</button>
            <br> <button type="submit" name="RegVendas">Registrar Venda</button>
        </form>
        <form action="ListarController" method="get">
           <button>
               <a href="ListarController?action=listarFuncionarios">Listar Usuários</a>
           </button>
        </form>
    </body>
    <footer>
        Rodrigo Bock e Nicolas Escobar. TADS 2022™
    </footer>
</html>
