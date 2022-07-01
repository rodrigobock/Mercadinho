/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", initialValue = 1)
    private Long id;
    private Venda venda;
    private Integer qtdeCompras;
    
    @OneToOne(mappedBy="cliente", cascade = CascadeType.ALL)
    private Set<Pessoa> pessoas = new HashSet<>();

    public Cliente() {
    }

    public Cliente(Long id, Venda venda, Integer qtdeCompras, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.venda = venda;
        this.qtdeCompras = qtdeCompras;
    }

    public Cliente(Long id, Venda venda, Integer qtdeCompras) {
        this.id = id;
        this.venda = venda;
        this.qtdeCompras = qtdeCompras;
    }

    public Set<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(Set<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getQtdeCompras() {
        return qtdeCompras;
    }

    public void setQtdeCompras(Integer qtdeCompras) {
        this.qtdeCompras = qtdeCompras;
    }

}
