package ContaRepository;

import conta_bancaria.model.Conta;

public interface ContaRepository {
	
	//CRUD 
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void procurarPorNumero(int numero);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	
	// Métodos bancários
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDeposito, float valor);

}
