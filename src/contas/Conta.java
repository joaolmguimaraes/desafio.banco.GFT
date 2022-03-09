package contas;

import javax.swing.*;

public class Conta implements IConta {

    private static final String AGENCIA_PADRAO = "0001";
    private static int SEQUENCIAL = 0;
    protected String agencia;
    protected int numeroConta;
    protected double saldo;

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = ++SEQUENCIAL;
    }

    @Override
    public void sacar(double valor) {

    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {

    }

    @Override
    public void imprimirExtrato() {
        String detalhes = "Saldo em conta: " + this.saldo;
        JOptionPane.showMessageDialog(null, detalhes);
    }
}
