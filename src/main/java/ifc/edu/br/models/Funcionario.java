/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario_seq")
    @SequenceGenerator(name = "funcionario_seq", initialValue = 1)
    private Long id;
    private String cargo;
    private String login;
    private String senhha;
    
    public Funcionario() {
    }
    
    public Funcionario(String cargo, String login, String senhha, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.cargo = cargo;
        this.login = login;
        this.senhha = senhha;
    }
    
    public Funcionario(String cargo, String login, String senhha) {
        this.cargo = cargo;
        this.login = login;
        this.senhha = senhha;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenhha() {
        return senhha;
    }

    public void setSenhha(String senhha) {
        this.senhha = senhha;
    }

}
