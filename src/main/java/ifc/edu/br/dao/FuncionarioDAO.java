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
    public boolean CriarUsuario(String nome, String telefone, String cpf, String cargo, String login, String senha) throws Exception {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Funcionario func = new Funcionario();
            func.setNome(nome);
            func.setTelefone(telefone);
            func.setCpf(cpf);
            func.setCargo(cargo);
            func.setLogin(login);
            func.setSenha(senha);
            func.setTipoCadastro("FUNCIONARIO");
            em.persist(func);

            tx.commit();

            return true;
        } catch (Exception e) {
            e.getMessage();
        }
        return false;
    }

    // BUSCAR TODOS
    public List todosFuncionarios() {
        List funcionarios = em.createQuery("from Pessoa where tipoCadastro = 'FUNCIONARIO'").getResultList();
        return funcionarios;
    }
}
