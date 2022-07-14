<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="ifc.edu.br.models.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css.css">
        <title>JSP Page</title>
    </head>
    <body>
    <%
        ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) request.getAttribute("funcionarios");
    %>
        <table>
            <thead>
                <tr>
                    <th colspan="1">id</th>
                    <th colspan="1">nome</th>
                    <th colspan="1">telefone</th>
                    <th colspan="1">CPF</th>
                    <th colspan="1">Login</th>
                </tr>
            </thead>
            <tbody>
    <%
        for (Funcionario funcionario : funcionarios) {
    %>
            <tr>
            <td><%=funcionario.getId()%></td>
            <td><%=funcionario.getNome()%></td>
            <td><%=funcionario.getTelefone()%></td>
            <td><%=funcionario.getCpf()%></td>
            <td><%=funcionario.getLogin()%></td>
            </tr>
    <%
        }
    %>       
            </tbody>
        </table>
    <a href="paginaInicial.jsp">Retornar ao início</a>
    </body>
</html>
