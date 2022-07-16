/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ifc.edu.br.control;

import ifc.edu.br.dao.FuncionarioDAO;
import ifc.edu.br.dao.LojaDAO;
import ifc.edu.br.models.Funcionario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import ifc.edu.br.utils.PasswordHash;

@WebServlet(name = "FuncionarioController", urlPatterns = {"/FuncionarioController"})
public class FuncionarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/cadastrarFuncionario.jsp";
    private static String LIST_USER = "/listarFuncionarios.jsp";
    private static String InitialPage = "/paginaInical.jsp";
    private FuncionarioDAO fdao;
    private LojaDAO ldao;
    private PasswordHash hash;

    public FuncionarioController() {
        super();
        fdao = new FuncionarioDAO();
        ldao = new LojaDAO();
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
                String id = request.getParameter("userId");
                Funcionario funcionario = fdao.buscaFuncionario(Long.parseLong(id));
                request.setAttribute("funcionario", funcionario);
            } else if (action.equalsIgnoreCase("listarFuncionarios")) {
                forward = LIST_USER;
                request.setAttribute("users", fdao.todosFuncionarios());
            } else {
                forward = INSERT_OR_EDIT;
                request.setAttribute("lojas", ldao.consultarLojas());
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
        response.setContentType("text/html;charset=UTF-8");

        Funcionario func = new Funcionario();

        func.setNome(request.getParameter("nome"));
        func.setTelefone(request.getParameter("telefone"));
        func.setCpf(request.getParameter("cpf"));
        func.setCargo(request.getParameter("cargo"));
        func.setLogin(request.getParameter("login"));
        func.setSenha(hash.hashPassword(request.getParameter("senha")));
        func.setLoja(ldao.consultarLoja(validaLong(request.getParameter("loja"))));

        String id = request.getParameter("id");

        try {
            if (id == null || id.isEmpty()) {

                if (fdao.ValidaLogin(func.getLogin())) {
                    request.setAttribute("cadastroErro", "Funcionário já existe no sistema!");
                    RequestDispatcher view = request.getRequestDispatcher("/cadastrarFuncionario.jsp?action=cadastrarFuncionario");
                    view.forward(request, response);
                } else {
                    fdao.CriarUsuario(func);

                    RequestDispatcher view = request.getRequestDispatcher("/cadastrarFuncionario.jsp?action=cadastrarFuncionario");
                    request.setAttribute("cadastroOk", "Funcionário cadastrado com sucesso");
                    view.forward(request, response);
                }

            } else if (id != null || !id.isEmpty()) {
                func.setId(Long.parseLong(request.getParameter("id")));
                fdao.updateUser(func);

                RequestDispatcher view = request.getRequestDispatcher("login");
                request.setAttribute("atualizacaoOk", "Funcionário atualizado com sucesso");
                view.forward(request, response);

            } else {
                request.setAttribute("msg", "Erro ao cadastrar!");
                getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("msg", "Ocorreu algum erro no cadastro");
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
        }

    }

    private Long validaLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (Exception e) {
            return 0L;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
