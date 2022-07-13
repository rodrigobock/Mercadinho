/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.dao;

import ifc.edu.br.models.Funcionario;
import ifc.edu.br.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.sql.SQLException;

public class LoginDAO {

    public Funcionario validaLogin(String login, String senha) throws SQLException {

        EntityManager manager = JpaUtil.getEntityManager();

        try {
            Query q = manager.createNativeQuery("SELECT * FROM Funcionario WHERE login = :login and senha = :senha", Funcionario.class);
            q.setParameter("login", login);
            q.setParameter("senha", senha);
            Funcionario funcionario = (Funcionario) q.getSingleResult();

            /*
            Fechando a conexão pois se feito return sem dar CLOSE fica em aberto
            e depois demora para abrir uma nova
            */
            manager.close();
            JpaUtil.close();
            return funcionario;

        } catch (Exception e) {
            e.getMessage();
        }

        manager.close();
        JpaUtil.close();

        return null;

    }

}
