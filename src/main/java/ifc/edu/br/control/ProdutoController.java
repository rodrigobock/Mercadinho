/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.control;

import ifc.edu.br.dao.ProdutoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProdutoController", urlPatterns = {"/ProdutoController"})
public class ProdutoController extends HttpServlet{
    
    ProdutoDAO pdao = new ProdutoDAO();
    public final int registros = 10;
    
    public int  inicio,
                fim,
                index;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String pag = request.getParameter("pg");
                        
        if (pag != null){
            index = Integer.parseInt(pag);
            fim = index * registros;            
        }        
        switch (fim) {
            case 0:
                inicio = 0;
                fim = registros;
                index = 1;
                break;
            case 10:
                inicio = 0;
                index = 1;
                break;
            default:
                inicio = fim - registros;
                request.setAttribute("ant", "< anterior");
                index = fim / registros;
        }        
        
        if (pdao.consultarProdutos().size() > fim)
            request.setAttribute("prox", "seguinte >");
        
        String ant = Integer.toString(index - 1);
        String prox = Integer.toString(index + 1);
            
        request.setAttribute("prev", ant);
        request.setAttribute("next", prox);
        request.setAttribute("produtos", pdao.filtraProduto(inicio, fim));
        getServletContext().getRequestDispatcher("/listarProdutos.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    
}
