package banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Conta contaPoupanca = new Conta();
        Conta contaCorrente = new Conta();
        Scanner sc = new Scanner(System.in);
        
        int op = 1;
            while (op != 0){
                System.out.println("1 - Criar conta.");
                if (cliente.getNome() != null){
                    System.out.println("2 - Cria conta corrente.");
                    System.out.println("3 - Cria conta poupança.");
                    System.out.println("4 -  Imprimir.");
                }
                if (contaCorrente.getCliente() != null){
                    System.out.println("5 - Depositar na conta corrente.");
                }
                if (contaPoupanca.getCliente() != null){
                    System.out.println("6 - Depositar na conta poupança.");
                }
                if (contaCorrente.getCliente()!= null && contaPoupanca.getCliente()!= null){
                    System.out.println("7 - Comprar criptomoeda.");
                }
                System.out.println("8 - sair.");
                int escolha = sc.nextInt();
                sc.nextLine();
                switch (escolha){
                    case 1:
                        // Criando a conta
                        System.out.println("Informe seu nome: ");
                        cliente.setNome(sc.nextLine());
                        break;
                    case 2:
                        // Criando a conta corrente
                         System.out.println("Conta corrente criada com sucesso");
                         contaCorrente = new Conta(cliente);
                        break;
                    case 3:
                        // Criando a conta poupança
                        System.out.println("Conta poupança criada com sucesso");
                        contaPoupanca = new Conta(cliente);
                        break;
                    case 4:
                        // Imprimindo infos comum
                        System.out.println("Qual conta deseja utilizar?");
                        System.out.println("1 - Conta corrente");
                        System.out.println("2 - Conta poupança");
                        int escolhaContaParaCripto = sc.nextInt();
                        sc.nextLine();
                        switch (escolhaContaParaCripto){
                            case 1:
                                System.out.println("Info comum da conta corrente!");
                                contaCorrente.imprimirInfosComuns();
                                break;
                            case 2:
                                System.out.println("Info comum da conta poupança!");
                                contaPoupanca.imprimirInfosComuns();
                                break;
                            default:
                                System.out.println("Escolha uma opção valida!");
                        }
                        break;
                    case 5:
                        // Depositando na conta corrente
                        System.out.println("Informe o valor a ser depositado na conta corrente!: ");
                        contaCorrente.depositar(sc.nextDouble());
                        break;
                    case 6:
                        // Depositando na conta poupança
                        System.out.println("Informe o valor a ser depositado na conta poupança!: ");
                        contaPoupanca.depositar(sc.nextDouble());
                        break;
                    case 7:
                        System.out.println("Qual conta deseja utilizar?");
                        System.out.println("1 - Conta corrente");
                        System.out.println("2 - Conta poupança");
                        int escolhaConta = sc.nextInt();
                        sc.nextLine();
                        switch (escolhaConta){
                            case 1:
                                System.out.println("Selecione a moeda: [ KTC , YTR, TTQ, BYM] Conta corrente");
                                contaCorrente.comprarCriptoMoeda(sc.nextLine(),contaCorrente);
                                System.out.println("Moeda comprada com sucesso!");
                                continue;
                            case 2:
                                System.out.println("Selecione a moeda: [ KTC , YTR, TTQ, BYM] Conta poupança");
                                contaCorrente.comprarCriptoMoeda(sc.nextLine(),contaCorrente);
                                System.out.println("Moeda comprada com sucesso!");
                                continue;
                            default:
                                System.out.println("Escolha uma opção valida!");
                        }
                    case 8:
                        op = 0;
                }
            }
    }
}
