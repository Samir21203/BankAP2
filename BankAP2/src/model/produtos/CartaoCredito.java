/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.produtos;

//import model.produtos.ProdutoBancario;
import model.Cliente;
/**
 *
 * @author Victor
 */
public class CartaoCredito implements ProdutoBancario {
    private final int codigo;
    private final String validade;
    private double limite;
    private double fatura;
    private final Cliente cliente;
    private static int geraCodigo = 1;
    
    public CartaoCredito (String validade, double limite, Cliente cliente){
        this.cliente = cliente;
        this.limite = limite;
        this.validade = validade;
        this.codigo = geraCodigo;
        this.fatura = 0;
        geraCodigo += 1;
    }
    
    public boolean realizarCompra(double valor){
        boolean compra = false;
        if(valor <= limite){
        limite -= valor;
        fatura += valor;
        compra = true;
        }
        return compra;
    }
    
    public void pagarFatura(double valor){
        fatura -= valor;
    }
    
    //getters
    public int getCodigo(){
        return codigo;
    }
    public String getValidade(){
        return validade;
    }
    public double getLimite(){
        return limite;
    }
    public double getFatura(){
        return fatura;
    }
    public Cliente getCliente(){
        return cliente;
    }
    
    //setters
    public void setLimite(double limite){
        this.limite = limite;
    }
}
