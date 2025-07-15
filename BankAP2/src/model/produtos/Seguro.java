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
public class Seguro implements ProdutoBancario {
    private String tipo; // Vida, Automóvel, etc.
    private double valorMensal;
    private Cliente cliente;

    public Seguro(Cliente cliente, String tipo, double valorMensal){
        this.cliente = cliente;
        this.tipo = tipo;
        this.valorMensal = valorMensal;
    }
    
    public String getDescricao() {
        return "Seguro " + tipo + " por " + valorMensal + " ao mês.";
    }

    //getters
    public String getTipo(){
        return tipo;
    }
    public double getValorMensal(){
        return valorMensal;
    }
    public Cliente getCliente(){
        return cliente;
    }
    
    //setters
    public void setValorMensal(double valorMensal){
        this.valorMensal = valorMensal;
    }
}

