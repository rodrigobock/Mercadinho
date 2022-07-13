/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.dao;

import ifc.edu.br.models.Funcionario;
import ifc.edu.br.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioDAO {

    // INSERIR FUNCIONARIO
    /*
    Adicionado THROWS para tratar o erro quando tentar incluir um registro
    já existente
    */
    public boolean CriarUsuario(String cargo, String login, String senha) throws Exception {

        /*
        Validação de usuário existente na tabela antes de continuar para 
        inclusão do novo registro
        */
        LoginDAO ldao = new LoginDAO();
        
        try {
            Funcionario funcionario = ldao.validaLogin(login, senha);
            
            if (funcionario != null) {
                throw new Exception("Usuário já existe!");
            }
        } catch (SQLException e) {
            e.getMessage();           
        }
        
        EntityManager manager = JpaUtil.getEntityManager();

        EntityTransaction entityTransaction = manager.getTransaction();
        entityTransaction.begin();

        try {
            Funcionario func = new Funcionario();
            func.setCargo(cargo);
            func.setLogin(login);
            func.setSenha(senha);
            manager.persist(func);

            entityTransaction.commit();

            System.out.println("Dados Inseridos");
            
            /*
            Fechando a conexão pois se feito return sem dar CLOSE fica em aberto
            e depois demora para abrir uma nova
            */
            manager.close();
            JpaUtil.close();

            return true;

        } catch (Exception e) {
            e.getMessage();
        }

        manager.close();
        JpaUtil.close();

        return false;
    }

    
    // BUSCAR TODOS
    public List<Funcionario> TodosFuncionarios() {
        // conexão
        EntityManager manager = JpaUtil.getEntityManager();
      
        try {
            Query q = manager.createQuery("from funcionario");
            List<Funcionario> funcionarios = q.getResultList();
            
            manager.close();
            JpaUtil.close();
            
            return funcionarios;
            
        } catch (Exception e) {
            e.getMessage();
        }

        manager.close();
        JpaUtil.close();
        
        return null;
        
    }
}
