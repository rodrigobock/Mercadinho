/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ifc.edu.br.control;

import ifc.edu.br.dao.FuncionarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Funcionario", urlPatterns = {"/funcionario"})
public class UserControl extends HttpServlet {

    FuncionarioDAO fdao = new FuncionarioDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            getServletContext().getRequestDispatcher("/cadastrarFuncionario.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf8");

        String cargo = request.getParameter("cargo");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        /*
        Adicionado TRY para verificar existência do usuário no sistema e evitar
        duplicidade de registros na tabela
        */
        try {
            /*
            Utilizado IF para não precisar declarar um Objeto sendo que é apenas
            uma verificação e o objeto não realiza atividade alguma após validação
            */
            if (fdao.CriarUsuario(cargo, login, senha) == true) {
                request.setAttribute("msg", "Funcionário incluído com sucesso");
                getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("msg", "Funcionário já existe no sistema");
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
        }
                
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
