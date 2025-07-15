/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.contas;

import java.io.Serializable;
import model.Cliente;
import util.TipoConta;


public class ContaCorrente extends Conta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final double TAXA_SAQUE = 0.002;
    
    private double limiteChequeEspecial;
    private double taxaManutencaoMensal;

    public ContaCorrente(Cliente cliente, double limiteChequeEspecial, double taxaManutencaoMensal) {
        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaManutencaoMensal = taxaManutencaoMensal;
    }

    // --- Getters e Setters ---
    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getTaxaManutencaoMensal() {
        return taxaManutencaoMensal;
    }

    public void setTaxaManutencaoMensal(double taxaManutencaoMensal) {
        this.taxaManutencaoMensal = taxaManutencaoMensal;
    }
    
    public void aplicarTaxaManutencao() {
        setSaldo(getSaldo() - this.taxaManutencaoMensal);
        historico.add(String.format("Taxa de Manutenção: - R$ %.2f", this.taxaManutencaoMensal));
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0) {
            double taxa = valor * TAXA_SAQUE;
            double total = valor + taxa;

            if (total <= (getSaldo() + limiteChequeEspecial)) {
                //System.out.println("Saque realizado com sucesso!");
                setSaldo(getSaldo() - total);
                historico.add("\nSacou R$ " + valor + " (com uso de cheque especial, se necessário)");
                return true;
            }
        }
        //System.out.println("Valor inválido. O saque não foi realizado!");
        return false;
    }

    @Override
    public TipoConta getTipo() {
        return TipoConta.CONTA_CORRENTE;
    }
    
}
