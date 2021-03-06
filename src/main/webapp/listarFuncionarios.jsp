<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
         import="java.util.*"
         import="ifc.edu.br.models.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/tables.css">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="paginaInicial.jsp">Voltar</a>
        <h1>Funcionários</h1>
        <table class="content-table">
            <thead>
                <tr>
                    <th style="display: none">Id</th>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>CPF</th>
                    <th>Login</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td style="display:none"><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.nome}" /></td>
                        <td><c:out value="${user.telefone}" /></td>
                        <td><c:out value="${user.cpf}" /></td>
                        <td><c:out value="${user.login}" /></td>
                        <td><a href="FuncionarioController?action=edit&userId=<c:out value="${user.id}"/>">Update</a></td>
                        <td><a href="FuncionarioController?action=delete&userId=<c:out value="${user.id}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="FuncionarioController?action=insert">Add User</a></p>
    </body>
    <jsp:include page="footer.jsp"/>
</html>
