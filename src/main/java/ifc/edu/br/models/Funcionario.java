/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{
    
    private Long id;
    private String cargo;
    private String login;
    private String senhha;
    
    @OneToOne(mappedBy="funcionario", cascade = CascadeType.ALL)
    private Set<Pessoa> pessoas = new HashSet<>();

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

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
}
