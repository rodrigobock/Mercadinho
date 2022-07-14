/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.dao;

import ifc.edu.br.models.Produto;
import ifc.edu.br.models.UnidadeMedida;
import ifc.edu.br.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    
    EntityManagerFactory emf;
    EntityManager em;

    public ProdutoDAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }
    

    // INSERIR PRODUTO
    public void CriarProduto(Produto p) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(p);
        tx.commit();
    }

    // BUSCAR TODOS
    public List<Produto> TodosProdutos() {
        // conexão
        EntityManager manager = JpaUtil.getEntityManager();
        try {
            Query q = manager.createQuery("from produto");
            List<Produto> produtos = q.getResultList();

            manager.close();
            JpaUtil.close();
            return produtos;

        } catch (Exception e) {
            e.getMessage();
        }

        manager.close();
        JpaUtil.close();

        return null;

    }

    public UnidadeMedida consultarUM(Long id) {
        Query q = em.createQuery("from UnidadeMedida where id = :id", UnidadeMedida.class);
        q.setParameter("id", id);
        return (UnidadeMedida) q.getSingleResult();
    }

    public List todosUM() {
        List unidadeMedidas = em.createQuery("from UnidadeMedida", UnidadeMedida.class).getResultList();
        return unidadeMedidas;
    }

}
