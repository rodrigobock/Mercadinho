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
import java.util.List;

public class FuncionarioDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public FuncionarioDAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }    
    // INSERIR FUNCIONARIO    
    public boolean CriarUsuario(String cargo, String login, String senha) throws Exception {

        EntityTransaction tx = em.getTransaction();
        tx.begin();              

        try {
            Funcionario func = new Funcionario();
            func.setCargo(cargo);
            func.setLogin(login);
            func.setSenha(senha);
            em.persist(func);
        
            tx.commit();

            return true;
        } catch (Exception e) {
            e.getMessage();            
        }
        return false;
    }

    // BUSCAR TODOS
    public List<Funcionario> TodosFuncionarios() {
        // conexão
        EntityTransaction tx = em.getTransaction();
        tx.begin(); 

        try {
            Query q = em.createQuery("from funcionario");
            List<Funcionario> funcionarios = q.getResultList();

            return funcionarios;

        } catch (Exception e) {
            e.getMessage();            
        }
        return null;
    }
}
