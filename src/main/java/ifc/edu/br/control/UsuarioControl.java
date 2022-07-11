package ifc.edu.br.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ifc.edu.br.models.Pessoa;
import ifc.edu.br.dao.daoPessoa;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UsuarioControl", urlPatterns = {"/cadastraUsuario"})
public class UsuarioControl extends HttpServlet {

    daoPessoa pdao = new daoPessoa();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //GET:
        //No param: Retrieve All
        //Param r: Retrieve single
        //Param d: Remove
        //Param f: Add
        String op = request.getParameter("op");

        switch (op){
            case "r":
                String pRemove = request.getParameter("q");

                Pessoa p = pdao.findPessoa(pRemove);

                request.setAttribute("pRemove", p);
                getServletContext().getRequestDispatcher("/exibir.jsp").forward(request, response);
            default :
                ArrayList<Pessoa> pessoas = pdao.returnPessoas();
                request.setAttribute("registros", pessoas);
                getServletContext().getRequestDispatcher("/listar.jsp").forward(request, response);

        }

        if (op == null) {
            // obtém dados
        } else if (op.equals("r")) { // exibe alguém específico
            // obtém o parâmetro de quem vai ser recuperado
            String quem = request.getParameter("q");
            // localiza o registro
            Pessoa p = pdao.findPessoa(quem);
            // insere o registro como atributo na requisição
            request.setAttribute("alguem", p);
            // encaminha a resposta para a página exibir
            getServletContext().getRequestDispatcher("/exibir.jsp")
                    .forward(request, response);
        } else if (op.equals("d")) {
            String quem = request.getParameter("q");
            if (pdao.removePessoa(quem)) {
                request.setAttribute("msg", "Pessoa removida com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu algum erro ao excluir a pessoa");
            }
            getServletContext().getRequestDispatcher("/mensagem.jsp")
                    .forward(request, response);
        } else if (op.equals("f")) {
            getServletContext().getRequestDispatcher("/form.jsp")
                    .forward(request, response);
        } else if (op.equals("a")) { // a = atualização/GET = parte 1:
            // abrir o formulário de edição
            // obtém o parâmetro de quem vai ser alterado
            String quem = request.getParameter("q");
            // localiza o registro
            Pessoa p = pdao.findPessoa(quem);
            // insere o registro como atributo na requisição
            request.setAttribute("alguem", p);
            // encaminha para a página de alteração
            getServletContext().getRequestDispatcher("/form_editar.jsp")
                    .forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // configuração para corrigir questões de acento
        request.setCharacterEncoding("utf8");

        String op = request.getParameter("op");

        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        if (op == null) { // incluir pessoa é a opção padrão

            Pessoa nova = new Pessoa(nome, cpf, telefone);
            if (pdao.addPessoa(nova)) {
                request.setAttribute("msg", "Pessoa incluída com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu um erro ao incluir a pessoa :-(");
            }
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);

        } else if (op.equals("put")) { // atualização de dados da pessoa

            Pessoa atualizada = new Pessoa(nome, cpf, telefone);
            if (pdao.updatePessoa(atualizada)) {
                request.setAttribute("msg", "Pessoa atualizada com sucesso");
            } else {
                request.setAttribute("msg", "Ocorreu um erro ao atualizar a pessoa :-(");
            }
            getServletContext().getRequestDispatcher("/mensagem.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
