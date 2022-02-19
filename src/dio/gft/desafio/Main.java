package dio.gft.desafio;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Double> map = new HashMap<>();
        HashMap<Integer, Double> mapCP = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int op = 0;
        Conta cc;
        Conta cp;
        int conta = 0;
        double saldo = 0;
        double valorDeposito;



        menu();

        do {
            op = scan.nextInt();
            switch (op) {
                case 1:
                    cc = criarContaCorrente();
                    map.put(cc.numeroConta, cc.saldo);
                    System.out.println("Conta Corrente criada com sucesso.");
                    break;
                case 2:
                    cp = criarContaPoupanca();
                    mapCP.put(cp.numeroConta, cp.saldo);
                    System.out.println("Conta Poupança criada com sucesso.");
                    break;
                case 3:
                    System.out.println("Digite a conta a receber o depósito: ");
                    conta = scan.nextInt();

                    if (map.containsKey(conta) || mapCP.containsKey(conta)) {
                        System.out.println("Insira valor de depósito: ");
                        valorDeposito = scan.nextDouble();
                        if (map.containsKey(conta)) {
                            saldo = map.get(conta);
                            saldo += valorDeposito;
                            map.replace(conta, saldo);
                        } else {
                            saldo = mapCP.get((conta));
                            saldo += valorDeposito;
                            mapCP.replace(conta, saldo);
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("Digite a conta para imprimir o extrato: ");
                    conta = scan.nextInt();

                    if (map.containsKey(conta) || mapCP.containsKey(conta)) {
                        if (map.containsKey(conta)) {
                            System.out.println("Saldo = " + map.get(conta));
                        } else {
                            System.out.println("Saldo = " + mapCP.get(conta));
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }


                    break;
                default:
                    System.out.println("Operação inválida.");
            }
            menu();
        } while (op != 5);
        System.out.println(map.entrySet());
        System.out.println(mapCP.entrySet());
    }


    private static void menu() {
        System.out.println("1) Criar conta corrente\n" +
                "2) Criar poupança\n" +
                "3) Depositar\n" +
                "4) Imprimir Saldo\n" +
                "5) Sair");
    }

    private static Conta criarContaCorrente() {

        Conta cc = new ContaCorrente();

        return cc;
    }

    private static Conta criarContaPoupanca() {

        Conta cp = new ContaPoupanca();

        return cp;
    }

}



//package dio.gft.desafio;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Conta cc = new ContaCorrente();
//        Conta cp = new ContaPoupanca();
//        cc.depositar(100);
//        cc.imprimirExtrato();
//        cp.imprimirExtrato();
//    }
//}
