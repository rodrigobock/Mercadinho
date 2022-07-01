/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "item")
public class Item implements Serializable{
    
    private Integer qtdeProdutos;
    
    @Id
    @ManyToOne
    private Produto produto;
    
    @Id
    @ManyToOne
    private NotaFiscal notaFiscal;

    public Item() {
    }

    public Item(Integer qtdeProdutos, Produto produto, NotaFiscal notaFiscal) {
        this.qtdeProdutos = qtdeProdutos;
        this.produto = produto;
        this.notaFiscal = notaFiscal;
    }

    public Integer getQtdeProdutos() {
        return qtdeProdutos;
    }

    public void setQtdeProdutos(Integer qtdeProdutos) {
        this.qtdeProdutos = qtdeProdutos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

}
