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
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", initialValue = 1)
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String tipoCadastro;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String telefone, String tipoCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.tipoCadastro = tipoCadastro;
    }

    public Pessoa(String nome, String cpf, String telefone, Cliente cliente, Funcionario funcionario) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoCadastro() {
        return tipoCadastro;
    }

    public void setTipoCadastro(String tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }

}
