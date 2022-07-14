/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ifc.edu.br.control;

import ifc.edu.br.dao.ProdutoDAO;
import ifc.edu.br.models.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CadProdutos", urlPatterns = {"/CadProdutos"})
public class CadProdutosController extends HttpServlet {

    ProdutoDAO pdao = new ProdutoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        if (request.getParameter("CadProdutos") != null) {
            request.setAttribute("ums", pdao.todosUM());
            getServletContext().getRequestDispatcher("/cadProdutos.jsp").forward(request, response);
        } else if (request.getParameter("RegVendas") != null) {
            request.setAttribute("produtos", pdao.consultarPodutos());
            getServletContext().getRequestDispatcher("/registrarVendas.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        if ("produto".equals(request.getParameter("parent"))) {
            Produto p = new Produto();
            p.setNome(request.getParameter("descricao"));
            p.setCodBarra(request.getParameter("email"));
            p.setValor(validaDouble(request.getParameter("valor")));
            p.setPeso(validaFloat(request.getParameter("peso")));
            p.setUnidadeMedida(pdao.consultarUM(validaLong(request.getParameter("ums"))));
            pdao.CriarProduto(p);
        }
        request.setAttribute("msg", "Cadastro de produtos realizado com sucesso!");
        getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
    }

    private Double validaDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (Exception e) {
            return 0.0;
        }
    }

    private Float validaFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (Exception e) {
            return 0F;
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
