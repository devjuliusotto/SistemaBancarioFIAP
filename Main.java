package projeto.cap.oito.fiap;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        Conta conta = new Conta(1, GerateNumCC(), 1000.00, TipoConta.CORRENTE, new Cliente(opcao, null, null, null, null, null));
        Conta contaDestino = new Conta(2, GerateNumCC(), 500.00, TipoConta.CORRENTE, new Cliente(opcao, null, null, null, null, null));

        do {
            System.out.println("\n*Sistema Bancário*");
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Exibir Informações da Conta");
            System.out.println("4. Transferir");
            System.out.println("5. Cadastrar Cliente");
            System.out.println("6. Sair");
            System.out.print("Digite a opção desejada: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 2:
                    System.out.print("Informe o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 3:
                    conta.imprimirDetalhes();
                    break;
                case 4:
                    System.out.print("Informe o valor para transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    // Aqui, assumimos que a contaDestino já está definida. Na prática, você pode pedir ao usuário para especificar a conta de destino.
                    conta.transferir(contaDestino, valorTransferencia);
                    break;
                case 5:
                	scanner.nextLine();
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite o endereço do cliente: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o RG do cliente: ");
                    String rg = scanner.nextLine();
                    Cliente cliente = new Cliente(opcao, nome, telefone, endereco, cpf, rg);
                    cliente.ShowClient();
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);

        scanner.close();
    }
    
    public static String GerateNumCC() {
        Random random = new Random();
        int day = random.nextInt(31) + 1;
        int month = random.nextInt(12) + 1;
        int hour = random.nextInt(24); 
        int numberCheck = day * month * hour;
        int digit = ValidadeCheck(numberCheck);
        String CC = String.format("%05d-%d", numberCheck, digit);
        return CC;
    }
    


private static int ValidadeCheck(int numeroConta) {
    int soma = 0;
    int fator = 2;
    while (numeroConta > 0) {
        int digito = numeroConta % 10;
        soma += digito * fator;
        fator++;
        numeroConta /= 10;
    }
    int digitoVerificacao = 11 - (soma % 11);
    if (digitoVerificacao >= 10) {
        digitoVerificacao = 0;
    }
    return digitoVerificacao;
}
}
