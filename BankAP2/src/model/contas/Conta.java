/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.contas;

/**
 *
 * @author Victor
 */
import java.util.ArrayList;
public abstract class Conta {
    
    private int numeroConta;
    private String cliente;
    private double saldo;
    protected ArrayList <String> historico; //utilizei protected para que as classes filhas possam utilizar o historico.add
    private static int identificador;
    
        
    public Conta(String cliente){
        numeroConta = ++identificador;
        this.cliente=cliente;
        saldo = 0.0;
        historico = new ArrayList();
    }
        
       
    public int getNumeroConta() {
        return numeroConta;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public boolean depositar(double valor) {
        if(valor > 0) {
            saldo+= valor;
            System.out.println("Depósito realizado com sucesso!");
            historico.add("\nDepositou R$ "+valor);
            return true;
        }
        System.out.println("Valor inválido. O depósito não foi realizado!");
        return false;
        
    }
    //metodo sacar com taxa de 0,2%
    public boolean sacar(double valor) {
        if(valor > 0) {
            double taxa = valor * 0.002;
            double total = valor + taxa;
                        
            if(total > saldo) {
                System.out.println("Saldo insuficiente. O saque não foi realizado!");
                return false;
            }
            saldo -= total;
            System.out.println("Saque realizado com sucesso!");
            historico.add("\nSacou R$ "+valor);
            return true;
        }
        System.out.println("Valor inválido. O saque não foi realizado!");
        return false;
    }
    public double consultarSaldo() {
        return getSaldo();
    }
    
        
    public String recuperarDadosConta() {
        return "-----------------------" + 
               "\nNúmero da conta: " + getNumeroConta() +
               "\nSaldo: " + getSaldo() + 
               "\nTipo: " + this.getTipo() + 
               "\n-----------------------\n"; 
    }
    
    public String mostrarHistorico(){
        String s = "";
        for(int i=0; i < historico.size(); i++)
            s = s + historico.get(i) + "\n";
        return s;
    }
    
    //método polimórfico
    public void percorreContas() {
    }
    
    //getTipo
    public abstract String getTipo();
    
}
