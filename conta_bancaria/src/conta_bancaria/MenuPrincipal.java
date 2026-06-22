package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class MenuPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcao; 
		
		Scanner leia = new Scanner(System.in);
		
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
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				case 8:
					
					break;
				case 9:
					System.out.println("Você saiu do programa! \n\nVolte sempre." );
					break;
					default:
						System.out.println("Opção Iválida!");
		}
			
		} while (opcao !=9);
	
		
		
		
		
		
		
		
		leia.close();

	}

}
