<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
        <link rel="stylesheet" href="css/style.css">
        <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <div class="sidebar">
            <div class="logo"> Bem-vindo ${login}!
                <i class='bx bx-coffee' ></i>
            </div>
            <form method="post" action="HomeController">
                <ul>
                    <li>
                        <a href="#">
                            <button name="btn" value="Home">
                                <i class='bx bx-home-alt-2' ></i>
                                <span class="linkname">Home</span>
                            </button>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <button name="btn" value="User">
                                <i class='bx bxs-face' ></i>
                                <span class="linkname">User</span>
                            </button>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <button name="btn" value="User">
                                <i class='bx bx-cart' ></i>
                                <span class="linkname">Sell</span>
                            </button>
                        </a>
                    </li>                
                    <li>
                        <a href="#">
                            <button name="btn" value="List">
                                <i class='bx bx-list-ol' ></i>
                                <span class="linkname">List</span>
                            </button>
                        </a>
                    </li>
                    <li>
                        <a href="#">                        
                            <button name="btn" value="Logout">
                                <i class='bx bx-log-out' ></i>
                                <span class="linkname">Log out</span>
                            </button>                        
                        </a>
                </ul>
            </form>
        </div>
        <form action="CadProdutos" method="get">
            <br> <button type="submit" name="CadProdutos">Cadastrar Produtos</button>
            <br> <button type="submit" name="RegVendas">Registrar Venda</button>
        </form>
        <form action="FuncionarioController" method="get">
            <button>
                <a href="FuncionarioController?action=listarFuncionarios">Listar Usuários</a>
            </button>
        </form>
        <form action="LojaController" method="GET" >
            <input type="submit" value="Cadastro de Loja">
        </form>
    </body>
    <footer>
        Rodrigo Bock e Nicolas Escobar. TADS 2022™
    </footer>
</html>
