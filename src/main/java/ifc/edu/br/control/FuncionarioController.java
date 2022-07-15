/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ifc.edu.br.control;

import ifc.edu.br.dao.FuncionarioDAO;
import ifc.edu.br.models.Funcionario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FuncionarioController", urlPatterns = {"/FuncionarioController"})
public class FuncionarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/cadastrarFuncionario.jsp";
    private static String LIST_USER = "/listarFuncionarios.jsp";
    private static String InitialPage = "/paginaInical.jsp";
    private FuncionarioDAO fdao;

    public FuncionarioController() {
        super();
        fdao = new FuncionarioDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String forward = "";
            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("delete")) {
                int userId = Integer.parseInt(request.getParameter("userId"));
                fdao.deleteUser(userId);
                forward = LIST_USER;
                request.setAttribute("users", fdao.todosFuncionarios());
            } else if (action.equalsIgnoreCase("edit")) {
                forward = INSERT_OR_EDIT;
                String id = request.getParameter("id");
                Funcionario funcionario = fdao.buscaFuncionario(Integer.parseInt(id));
                request.setAttribute("funcionario", funcionario);
            } else if (action.equalsIgnoreCase("listarFuncionarios")) {
                forward = LIST_USER;
                request.setAttribute("users", fdao.todosFuncionarios());
            } else{
                forward = INSERT_OR_EDIT;
            }

            RequestDispatcher view = request.getRequestDispatcher(forward);
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Funcionario func = new Funcionario();

        func.setNome(request.getParameter("nome"));
        func.setTelefone(request.getParameter("telefone"));
        func.setCpf(request.getParameter("cpf"));
        func.setCargo(request.getParameter("cargo"));
        func.setLogin(request.getParameter("login"));
        func.setSenha(request.getParameter("senha"));

        String id = request.getParameter("id");

        try {
            if (fdao.ValidaLogin(func.getLogin())) {
                request.setAttribute("cadastroErro", "Funcionário já existe no sistema!");
                getServletContext().getRequestDispatcher("/cadastrarFuncionario.jsp").include(request, response);
            } else if (id == null || id.isEmpty()) {
                fdao.CriarUsuario(func);

                RequestDispatcher view = request.getRequestDispatcher("login");
                request.setAttribute("cadastroOk", "Funcionário cadastrado com sucesso");
                request.setAttribute("users", fdao.todosFuncionarios());
                view.forward(request, response);
                // getServletContext().getRequestDispatcher("/cadastrarFuncionario.jsp").include(request, response);
            } else if (id != null || !id.isEmpty()) {
                func.setId(Long.parseLong(request.getParameter("id")));
                fdao.updateUser(func);

                RequestDispatcher view = request.getRequestDispatcher(InitialPage);
                request.setAttribute("atualizacaoOk", "Funcionário atualizado com sucesso");
                request.setAttribute("users", fdao.todosFuncionarios());
                view.forward(request, response);

            } else {
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
    }// </editor-fold>

}
