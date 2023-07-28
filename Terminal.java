import java.util.Scanner;
import java.util.ArrayList;

public class Terminal {

	static ArrayList<Conta> contas;
	public static void main(String[] args) {
		contas = new ArrayList<Conta>();
		mostrarOperacoes();
	}

	public static void mostrarOperacoes() {
		System.out.println("\n");
		System.out.println("=====| Selecione a operacao desejada: |====");
		System.out.println("===========================================");
		System.out.println("=====|   1 - Criar Conta              |====");
		System.out.println("=====|   2 - Depositar                |====");
		System.out.println("=====|   3 - Sacar                    |====");
		System.out.println("=====|   4 - Transferir               |====");
		System.out.println("=====|   5 - Exibir Saldo             |====");
		System.out.println("=====|   6 - Listar Contas            |====");
		System.out.println("=====|   7 - Sair                     |====");
		System.out.println("===========================================");
		
		Scanner entrada = new Scanner(System.in);
		int operacao = entrada.nextInt();
		switch(operacao) {
			case 1:
				System.out.println("\nInforme os dados solicitados abaixo.");
				System.out.println("\nNome: ");
				String nome = entrada.next();
				System.out.println("\nCPF: ");
				String cpf = entrada.next();
				System.out.println("\nEmail: ");
				String email = entrada.next();
				Cliente cliente = new Cliente(nome, cpf, email);
				System.out.println("\nDigite 1 para Conta Corrente ou 2 para Conta poupanca: ");
				int escolha = entrada.nextInt();
				if (escolha == 1) {
					Conta conta = new ContaCorrente(cliente);
					conta.criarContaCorrente(escolha);
					contas.add(conta);
					System.out.println("\nConta Corrente criada com sucesso!\n");
				}
				else if (escolha == 2) {
					Conta conta = new ContaPoupanca(cliente);
					conta.criarContaPoupanca(escolha);
					contas.add(conta);
					System.out.println("\nConta Poupanca criada com sucesso!\n");
				}
				else
					System.out.println("Tipo de Conta não encontrado");
				
				break;
			case 2:
				System.out.println("Informe o numero da conta para o depósito: ");
				int numeroContaDeposito = entrada.nextInt();
				Conta contaDeposito = Conta.encontrarConta(numeroContaDeposito);
				if (contaDeposito == null) {
					System.out.println("Conta não encontrada");
					break;
				}
				System.out.println("Informe o valor do depósito: ");
				double valorDeposito = entrada.nextDouble();
				if (contaDeposito != null) {
					contaDeposito.depositar(valorDeposito);
				}	
				break;
			case 3:
				System.out.println("Informe o numero da conta para o saque: ");
				int numeroContaSaque = entrada.nextInt();
				Conta contaSaque = Conta.encontrarConta(numeroContaSaque);
				if (contaSaque == null) {
					System.out.println("Conta não encontrada");
					break;
				}
				System.out.println("Informe o valor do saque: ");
				double valorSaque = entrada.nextDouble();
				if (contaSaque != null) {
					contaSaque.sacar(valorSaque);
				}
				break;
			case 4:
				System.out.println("Informe o numero da conta origem: ");
				int numeroContaOrigem = entrada.nextInt();
				Conta contaOrigem = Conta.encontrarConta(numeroContaOrigem);
				if (contaOrigem == null ) {
					System.out.println("Conta não encontrada");
					break;
				}
				
				System.out.println("Informe o numero da conta destino: ");
				int numeroContaDestino = entrada.nextInt();
				Conta contaDestino = Conta.encontrarConta(numeroContaDestino);
				
				if (contaDestino == null) {
					System.out.println("Conta não encontrada");
					break;
				}
					
				System.out.println("Informe o valor da transferência: ");
				double valorTransferencia = entrada.nextDouble();
					
				if (contaOrigem != null && contaDestino != null) {
					contaOrigem.transferir(valorTransferencia, contaDestino);
				}
				break;
			case 5:
				if (contas.size() <= 0) {
					System.out.println("Cadastro de contas vazio");
					break;
				}
				System.out.println("Informe o numero da conta: ");
				int numeroContaExibir = entrada.nextInt();
				Conta contaExibir = Conta.encontrarConta(numeroContaExibir);
				if (contaExibir == null) {
					System.out.println("Conta não encontrada");
					break;
				}
				contaExibir.imprimirSaldo(numeroContaExibir);
				break;
			case 6:
				if (contas.size() > 0) {
					for (Conta conta : contas) {
						System.out.println(conta);
					}
				}
				else
					System.out.println("Cadastro de contas vazio");
				break;
			case 7:
				System.out.println("=== Obrigado por fazer parte do Banco DIO! ===");
				System.out.println("\n");
				System.out.println("===             Volte Sempre               ===");
				System.exit(0);
			default:
				System.out.println("\nOperacao invalida\n");
				mostrarOperacoes();
		}
		mostrarOperacoes();
	}
}
