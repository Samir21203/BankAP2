/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.contas;

/**
 *
 * @author Victor
 */
public class ContaPoupanca extends Conta {
    
    private double taxaRendimento;
    private int diaRendimento; // dia simulado
    private int mesesSemRendimento; // contador de ciclos simulando meses

    public ContaPoupanca(String cliente, double taxaRendimento, int diaRendimento) {
        super(cliente);
        this.taxaRendimento = taxaRendimento;
        this.diaRendimento = diaRendimento;
        this.mesesSemRendimento = 1; // começa com um mês disponível
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public int getDiaRendimento() {
        return diaRendimento;
    }

    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }

    public void simularPassagemDeMes() {
        mesesSemRendimento++;
    }

    public void aplicarRendimento() {
        if (mesesSemRendimento >= 1) {
            double rendimento = getSaldo() * taxaRendimento;
            depositar(rendimento);
            historico.add("\nRendimento aplicado: R$ " + rendimento);
            System.out.println("Rendimento aplicado com sucesso.");
            mesesSemRendimento = 0; // zera o contador após aplicar
        } else {
            System.out.println("Rendimento já aplicado neste mês simulado.");
        }
    }

    @Override
    public String getTipo() {
        return "Conta Poupança";
    }
    
}
