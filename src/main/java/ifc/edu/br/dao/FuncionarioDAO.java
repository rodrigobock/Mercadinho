/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.dao;

import ifc.edu.br.models.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public FuncionarioDAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }

    // INSERIR FUNCIONARIO    
    public boolean CriarUsuario(Funcionario f) throws Exception {

        EntityTransaction tx = em.getTransaction();
        if (!tx.isActive()) {
            tx.begin();
        }
        try {
            tx.begin();
            em.persist(f);
            tx.commit();

            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    public boolean ValidaLogin(String login) throws SQLException {

        EntityTransaction tx = em.getTransaction();
        if (!tx.isActive()) {
            tx.begin();
        }
        try {

            Query q = em.createQuery("from Pessoa where login = :login and tipoCadastro = 'FUNCIONARIO'");
            q.setParameter("login", login);

            Funcionario funcionario = (Funcionario) q.getSingleResult();

            final Long result = funcionario.getId();

            return result != null && result > 0;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    // BUSCAR TODOS
    public List<Funcionario> todosFuncionarios() throws SQLException{

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

            Query query = em.createQuery("from Pessoa where tipoCadastro = 'FUNCIONARIO'");
            List<Funcionario> funcs = query.getResultList();
            for (Funcionario f : funcs) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(f.getId());
                funcionario.setNome(f.getNome());
                funcionario.setTelefone(f.getTelefone());
                funcionario.setCpf(f.getCpf());
                funcionario.setCargo(f.getCargo());
                funcionario.setLogin(f.getLogin());

                funcionarios.add(funcionario);
            }

        return funcionarios;
    }

    public Funcionario buscaFuncionario(Integer id) {
        Query q = em.createQuery("from Pessoa where id = :id and tipoCadastro = 'FUNCIONARIO'");
        q.setParameter("id", id);
        Funcionario funcionario = (Funcionario) q.getSingleResult();
        return funcionario;
    }

    public void deleteUser(int userId) {
        Query q = em.createNativeQuery("delete from Pessoa where id = :id");
        q.setParameter("id", userId);
        q.executeUpdate();
    }

    public void updateUser(Funcionario func) {
        Query q = em.createQuery("UPDATE from Pessoa where "
                + "nome = :nome,"
                + "telefone = :telefone,"
                + "cpf = :cpf,"
                + "cargo = :cargo,"
                + "login = :login,"
                + "senha = :senha"
                + "where id = :id");
        q.setParameter("nome", func.getNome());
        q.setParameter("telefone", func.getTelefone());
        q.setParameter("cpf", func.getCpf());
        q.setParameter("cargo", func.getCargo());
        q.setParameter("login", func.getLogin());
        q.setParameter("senha", func.getSenha());
        q.setParameter("id", func.getId());

        q.executeUpdate();
    }
}
