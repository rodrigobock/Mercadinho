/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.dao;

import ifc.edu.br.models.Funcionario;
import ifc.edu.br.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.sql.SQLException;

public class LoginDAO {
    
    EntityManagerFactory emf;
    EntityManager em;

    public LoginDAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }
    public Funcionario validaLogin(String login, String senha) throws SQLException {

        try {
            Query q = em.createNativeQuery("SELECT * FROM Funcionario WHERE login = :login and senha = :senha", Funcionario.class);
            q.setParameter("login", login);
            q.setParameter("senha", senha);
            Funcionario funcionario = (Funcionario) q.getSingleResult();
            
            return funcionario;

        } catch (Exception e) {
            e.getMessage();            
        }
        return null;
    }

}
