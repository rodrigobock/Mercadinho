/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Funcionario extends Pessoa{
    
    private String cargo;
    private String login;
    private String senha;
    
    @ManyToOne
    private Loja loja;    
 
    public Funcionario() {
    }

    public Funcionario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Funcionario(String cargo, String login, String senha, String nome, String cpf, String telefone, String tipoCadastro) {
        super(nome, cpf, telefone, tipoCadastro);
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }
    
    public Funcionario(String cargo, String login, String senha) {
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

}
