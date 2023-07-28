
public abstract class Conta implements IConta{
	
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected String tipoConta;
	protected double saldo;
	protected Cliente cliente;
		
	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if (valor > 0 && saldo >= valor) {
			setSaldo(getSaldo()- valor);
			System.out.println("Retire as cédulas.\n");
		}
		else {
			System.out.println("Favor tentar novamente. Verifique o valor.\n");
		}
	}
	@Override
	public void depositar(double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.printf("Depósito de %.2f realizado.\n", valor);
		}
		else {
			System.out.println("Favor tentar novamente. Verifique o valor\n");
		}
	}
	@Override
	public void transferir(double valor, Conta contaDestino) {
		if (valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo()- valor);
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);
			System.out.printf("Transferencia de R$%.2f realizada com sucesso", valor);
		}
		else {
			System.out.println("Não foi possível realizar a transferência.\n");
		}
	}
	@Override
	public void imprimirSaldo(int numeroConta) {
		for (Conta c : Terminal.contas) {
			if (c.getNumero() == numeroConta) {
				System.out.println("\n##### Exibir saldo da Conta #####\n" + 
				   		   		   "\nTitular: "+ this.cliente.getNome() +				 
				   		   		   "\nAgencia: " + this.agencia +
				   		   		   "\nTipo de Conta: " + this.tipoConta +
				   		   		   "\nNumero: "+ this.numero +
				   		   		   "\nSaldo: " + this.saldo + "\n");
			}
		}
	}
	@Override
	public void criarContaCorrente(int escolha) {
		setTipoConta("Corrente");
	}
	@Override
	public void criarContaPoupanca(int escolha) {
		setTipoConta("Poupanca");
	}
	public static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (Terminal.contas.size() > 0) {
			for (Conta c : Terminal.contas) {
				if (c.getNumero() == numeroConta) {
					conta = c;
				}
			}
		}
		else {
			System.out.println("Não existem contas cadastradas");
		}
		return conta;
	}

	public int getAgencia() {
		return agencia;
	}
	public int getNumero() {
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String toString () {
		return "\nTitular: "+ this.cliente.getNome() + 
			   "\nCPF: "+ this.cliente.getCpf() +
			   "\ne-mail: " + this.cliente.getEmail() +
			   "\nAgencia: " + this.agencia +
			   "\nTipo de Conta: " + this.tipoConta +
			   "\nNumero: "+ this.numero;
	}

}
