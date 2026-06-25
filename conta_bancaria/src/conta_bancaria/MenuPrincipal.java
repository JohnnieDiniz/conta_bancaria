package conta_bancaria;

import java.util.Optional;
import java.util.Scanner;

import ContaController.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class MenuPrincipal {

	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {

		criarContasTestes();

		int opcao;

		do {
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("---------------------------------------------------------------");
			System.out.println("------------------------- BANCO DINIZ -------------------------");
			System.out.println("---------------------------------------------------------------");
			System.out.println("               1 - Criar Conta.                                ");
			System.out.println("               2 - Listar todas as contas.                     ");
			System.out.println("               3 - Buscar Contas por Números.                  ");
			System.out.println("               4 - Atualizar dados da conta.                   ");
			System.out.println("               5 - Apagar conta.                               ");
			System.out.println("               6 - Sacar.                                      ");
			System.out.println("               7 - Depositar.                                  ");
			System.out.println("               8 - Transferir valores entre conta.             ");
			System.out.println("               9 - Sair da operação.                           ");
			System.out.println("_______________________________________________________________");
			System.out.println(" Ente com a opção desejada:                                    ");
			System.out.println("                                                               " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			switch (opcao) {
			case 1:

				leia.nextLine();
				System.out.print(" ---- Criar conta ----");
				cadastrarContas();
				keyPress();
				break;
			case 2:

				leia.nextLine();
				System.out.print(" ---- Listar todas as contas ----");
				listarContas();
				keyPress();
				break;
			case 3:

				leia.nextLine();
				System.out.print(" ---- Buscar Contas por Números ----");
				procurarContaPorNumero();
				keyPress();
				break;
			case 4:

				leia.nextLine();
				System.out.print(" ---- Atulizar dados da Conta ----");
				atualizarConta();
				keyPress();
				break;
			case 5:

				leia.nextLine();
				System.out.print(" ---- Apagar conta ----");
				deletarConta();
				keyPress();
				break;
			case 6:

				leia.nextLine();
				System.out.print(" ---- Sacar ----");
				keyPress();
				break;
			case 7:

				leia.nextLine();
				System.out.print(" ---- Depositar ----");
				keyPress();
				break;
			case 8:

				leia.nextLine();
				System.out.print(" ---- Transferência ----");
				keyPress();
				break;
			case 9:

				leia.nextLine();
				System.out.print(" ");
				System.out.println("\nVocê saiu do programa! \n\nVolte sempre.");
				;
				break;
			default:
				System.out.println("Opção Iválida!");
			}

		} while (opcao != 9);
	}

	public static void sobre() {
		System.out.println("\n-------------------------------------------------------");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("João Vitor Diniz Alves");
		System.out.println("github.com/JohnnieDiniz");
		System.out.println("---------------------------------------------------------");
	}


	public static void criarContasTestes() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(
				new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
	}

	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}

	public static void listarContas() {
		contaController.listarTodas();
	}

	public static void cadastrarContas() {
		System.out.println("\nDigite o número da agencia: ");
		int agencia = leia.nextInt();

		System.out.println("\nDigite o nome do títular da conta: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.println("\nDigite o tipo da conta (1 - CC | 2 - CP): ");
		int tipo = leia.nextInt();

		System.out.println("\nDigite o saldo da conta: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.println("Digite o limite da conta: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			contaController
					.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.println("Digite o dia do aniversário da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválida" + Cores.TEXT_RESET);
		}
	}

	public static void procurarContaPorNumero() {
		System.out.println("\nDigite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		contaController.procurarPorNumero(numero);

	}

	public static void deletarConta() {
		System.out.println("\nDigite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Optional<Conta> conta = contaController.buscarNaCollection(numero);

		if (conta.isPresent()) {
			System.out.printf("Tem certeza que você deseja deletar a conta: %d ?", numero);
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S"))
				contaController.deletar(numero);
			else
				System.out.println("\nOperação Cancelada!");
		} else {
			System.out.println("\nA conta não foi encontrada!");
		}

	}

	public static void atualizarConta() {

		System.out.println("\nDigite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Optional<Conta> conta = contaController.buscarNaCollection(numero);

		if (conta.isPresent()) {

			// obtem os dados atuais da conta

			int agencia = conta.get().getAgencia();
			String titular = conta.get().getTitular();
			int tipo = conta.get().getTipo();
			float saldo = conta.get().getSaldo();

			// atualiza a a agencia ou mantem o valor atual

			System.out.printf(
					"Agência atual: %d"
							+ "%nDigite o número da nova agência: \n(Pressione ENTER para manter o valor atual) ",
					agencia);
			String entrada = leia.nextLine();

			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);

			System.out.println(agencia);

			// atualiza o titular ou mantem o valor atual

			System.out.printf(
					"Agência atual: %s"
							+ "%nDigite o nome do novo titular: \n(Pressione ENTER para manter o valor atual) ",
					titular);
			entrada = leia.nextLine();

			titular = entrada.isEmpty() ? titular : entrada;

			System.out.println(titular);

			// atualizar o saldo ou valor

			System.out.printf(
					"Agência atual: %.2f"
							+ "%nDigite o número da nova agência: \n(Pressione ENTER para manter o valor atual) ",
					saldo);
			entrada = leia.nextLine();

			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",", "."));

			System.out.println(saldo);

			// atualizar o tipo da conta ou manter o mesmo valor

			switch (tipo) {

			case 1 -> {
				ContaCorrente contaCorrente = (ContaCorrente) conta.get();
				float limite = contaCorrente.getLimite();

				System.out.printf(
						"Agência atual: %.2f"
								+ "%nDigite o número da nova agência: \n(Pressione ENTER para manter o valor atual) ",
						limite);
				entrada = leia.nextLine();

				limite = entrada.isEmpty() ? saldo : Float.parseFloat(entrada.replace(",", "."));

				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
			}
			case 2 -> {
				ContaPoupanca contaPoupanca = (ContaPoupanca) conta.get();
				int aniversario = contaPoupanca.getAniversario();

				// Atualiza o aniversario ou mantém o valor atual
				System.out.printf("Dia do aniversário atual: %.d" + "%nDigite o novo dia do aniversário da conta "
						+ "(Pressione ENTER para manter o valor atual)", aniversario);
				entrada = leia.nextLine();

				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);

				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));

			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo da conta é inválido");
			}

		} else {
			System.out.printf("\nA conta numero: %d mão foi encontrada", numero);
		}

	}

}
