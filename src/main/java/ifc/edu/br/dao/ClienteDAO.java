/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.dao;

import ifc.edu.br.models.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class ClienteDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ClienteDAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }

    // INSERIR CLIENTE    
    public boolean CriarUsuario(String nome, String telefone, String cpf) throws Exception {

        EntityTransaction tx = em.getTransaction();
        if (!tx.isActive()) {
            tx.begin();
        }
        try {
            Cliente cliente = new Cliente();
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setCpf(cpf);
            cliente.setTipoCadastro("CLIENTE");
            em.persist(cliente);

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
            Query q = em.createNativeQuery("SELECT * FROM pessoa WHERE login = :login and tipoCadastro = 'CLIENTE'");
            q.setParameter("login", login);

            final Long result = (Long) q.getSingleResult();

            return result != null && result > 0;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    // BUSCAR TODOS
    public List<Cliente> TodosClientes() {

        try {
            Query q = em.createQuery("from Pessoa where tipoCadastro = 'CLIENTE'");
            List<Cliente> clientes = q.getResultList();

            if (clientes.isEmpty() || clientes.size() == 0) {
                return null;
            } else {
                return clientes;
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public Cliente consultarCliente(Long id) {
        Query q = em.createQuery("from Pessoa where id = :id");
        q.setParameter("id", id);
        Cliente cliente = (Cliente) q.getSingleResult();
        return cliente;
    }

    public void adicionaCompra(Long id) {
        EntityTransaction tx = em.getTransaction();
        if (!tx.isActive()) {
            tx.begin();
        }
        try {
            Cliente c = consultarCliente(id);
            Integer comprasAtuais = 0;
            if (c.getQtdeCompras() == null) {
                comprasAtuais = 0;
            } else {
                comprasAtuais = c.getQtdeCompras();
            }
            comprasAtuais++;
            Query q = em.createNativeQuery("update Pessoa set qtdeCompras = :qtdeCompras where id = :id");
            q.setParameter("qtdeCompras", comprasAtuais);
            q.setParameter("id", id);
            q.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
    }

}
