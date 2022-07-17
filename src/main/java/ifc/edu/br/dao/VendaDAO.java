/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.dao;

import ifc.edu.br.models.NotaFiscal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class VendaDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public VendaDAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }

    // INSERIR NOTA FISCAL
    public void CriarNotaFiscal(NotaFiscal nf) {
        EntityTransaction tx = em.getTransaction();

        if (!tx.isActive()) {
            tx.begin();
        }
        em.persist(nf);
        tx.commit();
    }

    // BUSCAR TODOS
    public List consultarNotaFiscals() {
        List nfs = em.createQuery("from NotaFiscal", NotaFiscal.class).getResultList();
        return nfs;
    }

    public NotaFiscal consultarNotaFiscal(Long nf_id) {
        Query q = em.createQuery("from NotaFiscal where id = :id");
        q.setParameter("id", nf_id);
        NotaFiscal notaFiscal = (NotaFiscal) q.getSingleResult();
        return notaFiscal;
    }

}
