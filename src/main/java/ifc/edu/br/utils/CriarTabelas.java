package ifc.edu.br.utils;

import ifc.edu.br.dao.ClienteDAO;
import ifc.edu.br.dao.FuncionarioDAO;
import ifc.edu.br.dao.LojaDAO;
import ifc.edu.br.dao.ProdutoDAO;
import ifc.edu.br.models.Cliente;
import ifc.edu.br.models.Funcionario;
import ifc.edu.br.models.Loja;
import ifc.edu.br.models.Produto;
import ifc.edu.br.models.UnidadeMedida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CriarTabelas {
    
    private static final String login = "admin";

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        if (!tx.isActive()) {
            tx.begin();
        }

        //Criar unidades de medida predeterminadas
        UnidadeMedida kg = new UnidadeMedida();
        UnidadeMedida L = new UnidadeMedida();
        UnidadeMedida cx = new UnidadeMedida();
        UnidadeMedida un = new UnidadeMedida();
        //Tipo Quilograma        
        kg.setTipo("Kg");
        em.persist(kg);
        //Tipo Litro        
        L.setTipo("L");
        em.persist(L);
        //Tipo Caixa
        cx.setTipo("Cx");
        em.persist(cx);
        //Tipo Unidade
        un.setTipo("Un");
        em.persist(un);

        Loja l = new Loja();
        LojaDAO ldao = new LojaDAO();

        Produto p = new Produto();
        ProdutoDAO pdao = new ProdutoDAO();

        Funcionario f = new Funcionario();
        FuncionarioDAO fdao = new FuncionarioDAO();

        Cliente c = new Cliente();
        ClienteDAO cdao = new ClienteDAO();

        l.setNome("Administradora");
        l.setCep("0000000");
        l.setCnpj("1234567890");
        ldao.CriarLoja(l);

        f.setNome("Admin");
        f.setCpf("000000000000");
        f.setTelefone("70707070");
        f.setCargo(login.toUpperCase());
        f.setLogin(login);
        f.setSenha(PasswordHash.hashPassword(login));
        f.setLoja(l);
        fdao.CriarUsuario(f);

        cdao.CriarUsuario("Cliente", "000000000000", "70707070");
        
        tx.commit();

    }

}
