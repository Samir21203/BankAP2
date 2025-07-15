/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.produtos;

import model.Cliente;

/**
 *
 * @author Victor
 */
public class Investimento implements ProdutoBancario {
    private double valorInicial;
    private double rendimentoAnual;
    private int anos;
    private Cliente cliente;
    
    public Investimento(Cliente cliente, double valorInicial, double rendimentoAnual, int anos){
        this.cliente = cliente;
        this.valorInicial = valorInicial;
        this.rendimentoAnual = rendimentoAnual;
        this.anos = anos;
    }

    public double calcularValorFinal() {
        return valorInicial * Math.pow(1 + rendimentoAnual, anos);
    }

    public String getDescricao() {
        return "Investimento de R$ " + valorInicial + " por " + anos + " anos.";
    }

    //getters
    public double getValorInicial(){
        return valorInicial;
    }
    public double getRendimentoAnual(){
        return rendimentoAnual;
    }
    public int getAnos(){
        return anos;
    }
    public Cliente getCliente(){
        return cliente;
    }
}
