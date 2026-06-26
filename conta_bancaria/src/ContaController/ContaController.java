package ContaController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ContaRepository.ContaRepository;
import conta_bancaria.model.Conta;

public class ContaController implements ContaRepository {

	private List<Conta> listarContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void listarTodas() {

		for (var conta : listarContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listarContas.add(conta);
		System.out.printf("A conta número %d foi criada com sucesso!%n", conta.getNumero());
	}

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			conta.get().visualizar();

		else
			System.out.printf("\nA conta número %d não fo1 encontrada! ", numero);
			

	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta.isPresent()) {
			listarContas.set(listarContas.indexOf(buscaConta.get()), conta);
				System.out.printf("\nA conta número %d foi atualizada com sucessoÏ! ", conta.getNumero());

		} else
			System.out.printf("\nA conta número %d não fo1 encontrada! ", conta.getNumero());

	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (listarContas.remove(conta.get()))
				System.out.printf("\nA conta número %d foi deletada com sucesso! ", numero);

		} else
			System.out.printf("\nA conta número %d não fo1 encontrada! ", numero);

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (conta.get().sacar(valor))
				System.out.printf("\nO saque no valor de: R$%.2f, na conta: %d foi efetuado com sucesso! ", valor, numero);

		 else
			System.out.printf("\nO saque no valor de: R$%.2f, na conta: %d não foi efetuado devido ao saldo insuficiente! ", valor, numero);
			
		} else
			System.out.printf("\nA conta número %d não fo1 encontrada! ", numero);

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			 conta.get().depositar(valor);
				System.out.printf("\nO deposito no valor de: R$%.2f, na conta: %d foi efetuado com sucesso! ", valor, numero);

		} else 
			System.out.printf("\nA conta número %d não fo1 encontrada! ", numero);

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if (contaOrigem.get().sacar(valor)) {
				contaDestino.get().depositar(valor);
				System.out.printf("\nA transferência no valor de R$ %.2f, da conta número %d "
						+ " para a conta %d foi efetuado com sucesso!"
						, valor, numeroOrigem, numeroDestino);
			} else
				System.out.printf("\nA transferência no valor de R$ %.2f, da conta número %d "
						+ "para a conta %d não foi efetuado devido ao saldo insuficiente na conta de origem!"
						, valor, numeroOrigem, numeroDestino);
		} else
			System.out.printf("\nA conta número %d e/ou a conta número %d não foram encontradas!"
					, numeroOrigem, numeroDestino);
	}
	
	@Override
	public void listarPorTitular(String titular) {
		// TODO Auto-generated method stub
		
		List<Conta> listaTitulares = listarContas.stream()
				.filter(conta -> conta.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		if (listaTitulares.isEmpty()) {
			System.out.printf("\nNenhum titular com o nome: %s foi encontrado.", titular);
			
			listaTitulares.forEach(conta -> conta.visualizar());
		}
		else 
			listaTitulares.forEach(conta -> conta.visualizar());
	}
	
	// Método Auxiliar

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : listarContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);

		}
		return Optional.empty();
	}


}
