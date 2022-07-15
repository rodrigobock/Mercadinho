package ifc.edu.br.control;

import ifc.edu.br.dao.LoginDAO;
import ifc.edu.br.models.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import ifc.edu.br.utils.PasswordHash;
import jakarta.servlet.RequestDispatcher;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    
    private PasswordHash hash;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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

        String login = request.getParameter("login");
        String senha = hash.hashPassword(request.getParameter("senha"));

        LoginDAO ldao = new LoginDAO();

        try {
            PrintWriter writer = response.getWriter();
            Funcionario funcionario = ldao.validaLogin(login, senha);
            if (funcionario == null) {
                request.setAttribute("loginErro", "Usuário ou senha incorretos!");
                RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                view.forward(request, response);
            } else {
                response.sendRedirect("paginaInicial.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
