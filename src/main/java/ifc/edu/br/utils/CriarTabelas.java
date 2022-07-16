package ifc.edu.br.utils;

import ifc.edu.br.models.UnidadeMedida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CriarTabelas {

    public static void main(String[] args) {
        
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
        tx.commit();
        
    }

}
