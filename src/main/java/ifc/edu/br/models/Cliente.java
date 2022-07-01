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
@Table(name = "cliente")
public class Cliente extends Pessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", initialValue = 1)
    private Long idCliente;
    private NotaFiscal venda;
    private Integer qtdeCompras;

    public Cliente() {
    }

    public Cliente(NotaFiscal venda, Integer qtdeCompras) {
        this.venda = venda;
        this.qtdeCompras = qtdeCompras;
    }
    
    public Cliente(Long id, NotaFiscal venda, Integer qtdeCompras, String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
        this.venda = venda;
        this.qtdeCompras = qtdeCompras;
    }

    public NotaFiscal getVenda() {
        return venda;
    }

    public void setVenda(NotaFiscal venda) {
        this.venda = venda;
    }

    public Integer getQtdeCompras() {
        return qtdeCompras;
    }

    public void setQtdeCompras(Integer qtdeCompras) {
        this.qtdeCompras = qtdeCompras;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

}
