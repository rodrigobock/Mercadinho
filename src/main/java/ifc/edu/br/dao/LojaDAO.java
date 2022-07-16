/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.dao;

import ifc.edu.br.models.Loja;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class LojaDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public LojaDAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }

    // INSERIR LOJA
    public void CriarLoja(Loja l) {
        EntityTransaction tx = em.getTransaction();

        if (!tx.isActive()) {
            tx.begin();
        }
        em.persist(l);
        tx.commit();
    }

    // BUSCAR TODOS
    public List consultarLojas() {
        List lojas = em.createQuery("from Loja", Loja.class).getResultList();
        return lojas;
    }

    public Loja consultarLoja(Long id) {
        Query q = em.createQuery("from Loja where id = :id");
        q.setParameter("id", id);
        Loja loja = (Loja) q.getSingleResult();
        return loja;
    }

}
