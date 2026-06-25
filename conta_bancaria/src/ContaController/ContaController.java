package ContaController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
				System.out.printf("\nA conta número %d foi deletada com sucessoÏ! ", numero);

		} else
			System.out.printf("\nA conta número %d não fo1 encontrada! ", numero);

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDeposito, float valor) {
		// TODO Auto-generated method stub

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
