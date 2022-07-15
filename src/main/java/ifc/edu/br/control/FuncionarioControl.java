/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ifc.edu.br.control;

import ifc.edu.br.dao.FuncionarioDAO;
import ifc.edu.br.models.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FuncionarioControl", urlPatterns = {"/FuncionarioControl"})
public class FuncionarioControl extends HttpServlet {

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

        // configuração para corrigir questões de acento
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String cpf = request.getParameter("cpf");
        String cargo = request.getParameter("cargo");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        Funcionario func = new Funcionario();
        
        func.setNome(request.getParameter("nome"));
        func.setTelefone(request.getParameter("telefone"));
        func.setCpf(request.getParameter("cpf"));
        func.setCargo(request.getParameter("cargo"));
        func.setLogin(request.getParameter("login"));
        func.setSenha(request.getParameter("senha"));
        
        try {
            if (fdao.ValidaLogin(func.getLogin())) {
                request.setAttribute("cadastroErro", "Funcionário já existe no sistema!");
                getServletContext().getRequestDispatcher("/cadastrarFuncionario.jsp").include(request, response);
            }else if (fdao.CriarUsuario(func)) {
                request.setAttribute("cadastroOk", "Funcionário cadastrado com sucesso");
                getServletContext().getRequestDispatcher("/cadastrarFuncionario.jsp").include(request, response);
            }else{
                request.setAttribute("msg", "Erro ao cadastrar!");
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
