/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ifc.edu.br.control;

import ifc.edu.br.dao.ClienteDAO;
import ifc.edu.br.dao.FuncionarioDAO;
import ifc.edu.br.dao.LojaDAO;
import ifc.edu.br.dao.ProdutoDAO;
import ifc.edu.br.dao.VendaDAO;
import ifc.edu.br.models.Cliente;
import ifc.edu.br.models.Funcionario;
import ifc.edu.br.models.Loja;
import ifc.edu.br.models.NotaFiscal;
import ifc.edu.br.models.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegVendas", urlPatterns = {"/RegVendas"})
public class RegVendasController extends HttpServlet {

    FuncionarioDAO fdao = new FuncionarioDAO();
    LojaDAO ldao = new LojaDAO();
    ProdutoDAO pdao = new ProdutoDAO();
    ClienteDAO cdao = new ClienteDAO();
    VendaDAO vdao = new VendaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String forward = "";
            String login = request.getParameter("userLogin");
            String action = request.getParameter("action");

            Funcionario funcionario = fdao.buscaFuncionarioByLogin(login);
            Loja loja = ldao.consultarLoja(funcionario.getLoja().getId());
            List<Cliente> clientes = cdao.TodosClientes();
            List<Produto> produtos = pdao.consultarProdutos();

            if (action.equalsIgnoreCase("inserirVenda")) {
                forward = "/registrarVendas.jsp";
                request.setAttribute("funcionario", funcionario);
                request.setAttribute("loja", loja);
                request.setAttribute("cliente", clientes);
                request.setAttribute("produtos", produtos);
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
        processRequest(request, response);
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        NotaFiscal nf = new NotaFiscal();
        Produto p = pdao.consultarProduto(validaLong(request.getParameter("produto")));
        Funcionario f = fdao.buscaFuncionarioByLogin(request.getParameter("nomeFuncionario"));
        Cliente cliente = cdao.consultarCliente(validaLong(request.getParameter("cliente")));

        nf.setCliente(cliente);
        nf.setFuncionario(f);
        nf.setProduto(p);
        nf.setValorTotal(p.getValor());

        vdao.CriarNotaFiscal(nf);
        cdao.adicionaCompra(cliente.getId());

        request.setAttribute("msg", "Cadastro de NF realizado com sucesso!");
        getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);

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
