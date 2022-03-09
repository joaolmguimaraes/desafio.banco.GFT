package contas;

import javax.swing.*;
import java.util.*;

public class Mesa {
    public static void main(String[] args) {

        List<Conta> corrente = new ArrayList<>();
        List<Conta> poupanca = new ArrayList<>();

        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));

            switch (op) {
                case 1:
                    corrente.add(criarCorrente());
                    break;
                case 2:
                    poupanca.add(criarPoupanca());
                    break;
                case 3:
                    depositar(corrente, poupanca);
                    break;
                case 4:
                    imprimirExtrato(corrente, poupanca);
                    break;
                case 5:
                  listarContas(corrente, poupanca);
                    break;
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while(op != 6);
    }
    private static Object menu() {
       return ("""
               ***Mesa do Gerente***
               1) Criar conta corrente
               2) Criar poupança
               3) Depositar
               4) Imprimir Saldo
               5) Listar contas
               6) Sair""");

    }
    private static Conta criarCorrente() {
        return new Conta();
    }
    private static Conta criarPoupanca() {
        return new Conta();
    }
    private static void depositar(List<Conta> correntes, List<Conta> poupancas) {
        int numeroDaConta = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
        boolean depositoFeito = false;
        for (int i = 0; i < correntes.size(); i++) {
            if (correntes.get(i).numeroConta == numeroDaConta) {
                double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito: "));
                correntes.get(i).depositar(deposito);
                depositoFeito = true;
                break;
            }
        }
        if (!depositoFeito) {
            for (int i = 0; i < poupancas.size(); i++) {
                if (poupancas.get(i).numeroConta == numeroDaConta) {
                    double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor de depósito: "));
                    poupancas.get(i).depositar(deposito);
                    depositoFeito = true;
                    break;
                }
            }
        }
        if(!depositoFeito) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }
    private static void imprimirExtrato(List<Conta> correntes, List<Conta> poupancas) {
        int numeroDaConta = Integer.parseInt(JOptionPane.showInputDialog("Informe o número da conta: "));
        boolean extratoImpresso = false;
        for (int i = 0; i < correntes.size() ; i++) {

            if (correntes.get(i).numeroConta == numeroDaConta) {
                correntes.get(i).imprimirExtrato();
                extratoImpresso = true;
                break;
            }
        }
        if (!extratoImpresso) {
            for (int i = 0; i < poupancas.size() ; i++) {

                if (poupancas.get(i).numeroConta == numeroDaConta) {
                    poupancas.get(i).imprimirExtrato();
                    extratoImpresso = true;
                    break;
                }
            }
        }
        if (!extratoImpresso) {
            JOptionPane.showMessageDialog(null, "Conta não encontrada.");
        }
    }
    private static void listarContas(List<Conta> correntes, List<Conta> poupancas) {
        String contas = "Contas correntes: ";
        for (int i = 0; i < correntes.size(); i++) {
            int numeroConta = correntes.get(i).numeroConta;
            contas = contas + numeroConta + " ";

        }
        contas = contas + "\nContas poupanças: ";
        for (int i = 0; i < poupancas.size(); i++) {
            int numeroConta = poupancas.get(i).numeroConta;
            contas = contas + numeroConta + " ";
        }
        JOptionPane.showMessageDialog(null, contas);
    }
}

