/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.edu.br.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {

    private Integer qtdeCompras;

    public Cliente() {
    }

    public Cliente(Integer qtdeCompras) {
        this.qtdeCompras = qtdeCompras;
    }


    public Integer getQtdeCompras() {
        return qtdeCompras;
    }

    public void setQtdeCompras(Integer qtdeCompras) {
        this.qtdeCompras = qtdeCompras;
    }

}
