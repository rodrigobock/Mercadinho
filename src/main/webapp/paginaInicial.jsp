<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
         import="java.util.*"
         import="ifc.edu.br.models.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
                        <button name="btn" value="cadFunc">
                            <i class='bx bxs-face' ></i>
                            <span class="linkname">Cadastrar Funcionário</span>
                        </button>                        
                    </li>
                    <li>                        
                        <button name="btn" value="cadProd">
                            <i class='bx bx-package'></i>
                            <span class="linkname">Cadastrar Produtos</span>
                        </button>                        
                    </li>
                    <li>                        
                        <button name="btn" value="cadLoja">
                            <i class='bx bxs-store'></i>
                            <span class="linkname">Cadastrar Loja</span>
                        </button>                        
                    </li>
                    <li>
                        <button name="btn" value="registraVenda&<c:out value="${login}"/>">
                            <i class='bx bx-cart' ></i>
                            <span class="linkname">Registrar Venda</span>
                        </button>
                    </li>                
                    <li>                        
                        <button name="btn" value="listaFunc">
                            <i class='bx bxs-group'></i>
                            <span class="linkname">Listar Funcionarios</span>
                        </button>
                    </li>
                    <li>                        
                        <button name="btn" value="listaProd">
                            <i class='bx bxs-barcode bx-tada' ></i>
                            <span class="linkname">Listar Produtos</span>
                        </button>
                    </li>
                    <li>                        
                        <button name="btn" value="Logout">
                            <i class='bx bx-log-out' ></i>
                            <span class="linkname">Log out</span>
                        </button>                        
                    </li>
                </ul>
            </form>
        </div>                            
</body>
<footer>
    Rodrigo Bock e Nicolas Escobar. TADS 2022™
</footer>
</html>
