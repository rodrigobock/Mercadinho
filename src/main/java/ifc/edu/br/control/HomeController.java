package ifc.edu.br.control;

import ifc.edu.br.dao.FuncionarioDAO;
import ifc.edu.br.dao.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet{
        
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
        if (loginCookie != null){
            session.setAttribute("login", loginCookie);
            response.sendRedirect("paginaInicial.jsp");
        }else{
            session.removeAttribute("login");

            Cookie ckLogin = new Cookie("CookieLogin-1-login", "");
            ckLogin.setMaxAge(0);
            response.addCookie(ckLogin);
            
            RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
            view.forward(request, response);
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        FuncionarioDAO fdao = new FuncionarioDAO();
        
        ProdutoDAO pdao = new ProdutoDAO();
        
        RequestDispatcher view = null;

        // configuração para corrigir questões de acento
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String btn = request.getParameter("btn").split("&")[0];
                        
        switch (btn) {
            case "cadFunc":
                response.sendRedirect(request.getContextPath() 
                        + "/FuncionarioController?action=cadastrarFuncionario");
                break;
            case "cadProd":
                request.setAttribute("ums", pdao.todosUM());
                view = request.getRequestDispatcher("/cadProdutos.jsp");
                view.forward(request, response);
                break;
            case "cadLoja":
                view = request.getRequestDispatcher("/cadastrarLoja.jsp");
                view.forward(request, response);                
                break;
            case "registraVenda":         
                String func = request.getParameter("btn").split("&")[1];
                response.sendRedirect(request.getContextPath() 
                        + "/RegVendas?action=inserirVenda&userLogin=" + func);                                
                break;
            case "listaFunc":
                try {
                    request.setAttribute("users", fdao.todosFuncionarios());
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
                view = request.getRequestDispatcher("/listarFuncionarios.jsp");
                view.forward(request, response);
                break;
            case "listaProd":
                response.sendRedirect(request.getContextPath() 
                        + "/ProdutoController");
                break;
            case "Logout":
                session.removeAttribute("login");
            
                Cookie ckLogin = new Cookie("CookieLogin-1-login", "");
                ckLogin.setMaxAge(0);
                response.addCookie(ckLogin);

                response.sendRedirect("login.jsp");
                
                break;
            default:
                response.sendRedirect("login.jsp");                
        }       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
}
