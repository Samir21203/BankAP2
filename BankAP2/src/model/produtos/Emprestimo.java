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
public class Emprestimo implements ProdutoBancario {
    private double valor;
    private double juros;
    private int parcelas;
    private Cliente cliente;
    
    public Emprestimo(double valor, double juros, int parcelas, Cliente cliente){
        this.valor = valor;
        this.juros = juros;
        this.parcelas = parcelas;
        this.cliente = cliente;
    }

    public double calcularValorFinal() {
        return valor * Math.pow(1 + juros, parcelas);
    }

    public String getDescricao() {
        return "Empréstimo de " + valor + " em " + parcelas + " parcelas";
    }

    //getters
    public double getValor(){
        return valor;
    }
    public double getJuros(){
        return juros;
    }
    public int getParcelas(){
        return parcelas;
    }
    public Cliente getCliente(){
        return cliente;
    }
    
    //setters
    public void setJuros(double juros){
        this.juros = juros;
    }
    public void setParcelas(int parcelas){
        this.parcelas = parcelas;
    }
}
