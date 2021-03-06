package ifc.edu.br.control;

import ifc.edu.br.dao.LoginDAO;
import ifc.edu.br.models.Funcionario;
import ifc.edu.br.utils.CriarTabelas;
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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private String returnCookieLogin(HttpServletRequest request) {
        Cookie listaCookies[] = request.getCookies();
        if (listaCookies != null) {
            for (Cookie c : listaCookies) {
                if (c.getName().equals("CookieLogin-1-login")) {
                    return c.getValue();
                }
            }
        }
        return null;
    }

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

        // configuração para corrigir questões de acento
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(true);

        String loginCookie = returnCookieLogin(request);
        if (loginCookie != null) {
            session.setAttribute("login", loginCookie);
            response.sendRedirect("paginaInicial.jsp");
        } else {
            session.removeAttribute("login");

            Cookie ckLogin = new Cookie("CookieLogin-1-login", "");
            ckLogin.setMaxAge(0);
            response.addCookie(ckLogin);

            RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
            view.forward(request, response);

        }
        //processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        

        // configuração para corrigir questões de acento
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("login");
        String senhaHash = PasswordHash.hashPassword(request.getParameter("senha"));

        LoginDAO ldao = new LoginDAO();

        if (login.equals(CriarTabelas.getLogin())) {
            response.sendRedirect("paginaInicial.jsp");
        } else {
            
            HttpSession session = request.getSession(true);
            
            try {
                Funcionario funcionario = ldao.validaLogin(login, senhaHash);

                if (funcionario == null) {
                    request.setAttribute("loginErro", "Usuário ou senha incorretos!");
                    RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
                    view.forward(request, response);
                } else {

                    session.setAttribute("login", login);

                    Cookie cookieLogin = new Cookie("CookieLogin-1-login", login);
                    cookieLogin.setMaxAge(24 * 60 * 60 * 30);
                    response.addCookie(cookieLogin);

                    response.sendRedirect("paginaInicial.jsp");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
