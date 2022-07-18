<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
         import="ifc.edu.br.models.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/tables.css">
    </head>
    <body>
        <a href="paginaInicial.jsp">Voltar</a>
        <h1>Produtos</h1>
        <table class="content-table" >
            <thead>
                <tr>
                    <th style="display: none">Id</th>
                    <th>Nome</th>
                    <th>Valor</th>
                    <th>Peso</th>
                    <th>UnMedida</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${produtos}" var="prod">
                    <tr>
                        <td style="display:none"><c:out value="${prod.id}" /></td>
                        <td><c:out value="${prod.nome}" /></td>
                        <td>R$<c:out value="${prod.valor}" /></td>
                        <td><c:out value="${prod.peso}" /></td>
                        <td><c:out value="${prod.unidadeMedida.tipo}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="ProdutoController?pg=<c:out value="${prev}"/>">${ant}</a>
        <a href="ProdutoController?pg=<c:out value="${next}"/>">${prox}</a>        
    </body>
    <jsp:include page="footer.jsp"/>
</html>
