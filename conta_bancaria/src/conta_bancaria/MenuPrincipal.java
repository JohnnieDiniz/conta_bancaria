package conta_bancaria;

import java.util.Scanner;

import ContaController.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class MenuPrincipal {
	
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {
		
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
					break;
				case 2:
					leia.nextLine();
					System.out.print(" ---- Listar todas as contas ----");
					
					break;
				case 3:
					leia.nextLine();
					System.out.print(" ---- Buscar Contas por Números ----");
					break;
				case 4:
					leia.nextLine();
					System.out.print(" ---- Atulizar dados da Conta ----");
					break;
				case 5:
					leia.nextLine();
					System.out.print(" ---- Apagar conta ----");
					break;
				case 6:
					leia.nextLine();
					System.out.print(" ---- Sacar ----");
					break;
				case 7:
					leia.nextLine();
					System.out.print(" ---- Depositar ----");
					break;
				case 8:
					leia.nextLine();
					System.out.print(" ---- Transferência ----");
					break;
				case 9:
					leia.nextLine();
					System.out.print(" ---- Sair da operação ----");
					System.out.println("Você saiu do programa! \n\nVolte sempre." );
					break;
					default:
						System.out.println("Opção Iválida!");
		}
		
		} 
		while (opcao !=9);
	}
	
		public static void criarContasTestes() {
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
			contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
		}
		public static void listarContas() {
			contaController.listarTodas();
		}
		{
		
		leia.close();

		
	}

}

