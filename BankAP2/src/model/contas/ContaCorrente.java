/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.contas;

/**
 *
 * @author Victor
 */
public class ContaCorrente extends Conta {
    
    private double limiteChequeEspecial;
    private double taxaManutencaoMensal;

    public ContaCorrente(String cliente, double limiteChequeEspecial, double taxaManutencaoMensal) {
        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaManutencaoMensal = taxaManutencaoMensal;
    }

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

    @Override
    public boolean sacar(double valor) {
        if (valor > 0) {
            double taxa = valor * 0.002;
            double total = valor + taxa;

            if (total > (getSaldo() + limiteChequeEspecial)) {
                System.out.println("Limite insuficiente. O saque não foi realizado!");
                return false;
            }

                        
            System.out.println("Saque realizado com sucesso!");
            historico.add("\nSacou R$ " + valor + " (com uso de cheque especial, se necessário)");
            return true;
        }
        System.out.println("Valor inválido. O saque não foi realizado!");
        return false;
    }

    @Override
    public String getTipo() {
        return "Conta Corrente";
    }
    
}
