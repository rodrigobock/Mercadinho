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
        tx.begin();

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

    // BUSCAR TODOS
    public List<Cliente> TodosClientes() {
        // conexão
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Query q = em.createQuery("from pessoa where tipoCadastro = 'CLIENTE'");
            List<Cliente> clientes = q.getResultList();

            return clientes;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
