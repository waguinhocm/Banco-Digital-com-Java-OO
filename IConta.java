
public interface IConta {
	
	void sacar(double valor);
	void depositar(double valor);
	void transferir(double valor, Conta contaDestino);
	void imprimirSaldo(int numeroConta);
	void criarContaPoupanca(int escolha);
	void criarContaCorrente(int escolha);
	
}