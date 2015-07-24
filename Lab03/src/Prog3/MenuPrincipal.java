package Prog3;

/* 114111365 - Kerilin Laine Andrade Chang: LAB 3 - Turma 3 */

import java.util.Scanner;

public class MenuPrincipal {

	private static Scanner entrada = new Scanner(System.in);
	private static String escolha;

	public static void main(String[] args) {
		menu();

		EconomizaP2 supermercado = new EconomizaP2();
		
		
		int opcao = entrada.nextInt();
		if (opcao == 1){
			System.out.println("==== Cadastro de Produtos ====\n");
		}

		while (opcao != 4) {

			switch (opcao) {
			case 1:
				supermercado.addProduto();
				System.out.println("Deseja cadastrar outro produto? ");
				escolha = entrada.next();
				
				if (escolha.equals("Sim")) {  
					continue;		           
				} 
				else {
					break;      
				}
				
			case 2:
				System.out.println("==== Venda de Produtos ====\n");
				supermercado.venderProduto();
				escolha = entrada.next();
				if (escolha.equals("Sim")){ 
					continue;  
				}else{
					break; 
				}
				
			case 3:
				supermercado.imprimeBalanco();
			}
			menu();
			opcao = entrada.nextInt();
			
		}

	}

	public static void menu() {

		System.out.println("= = = = Bem-vindo(a) ao EconomizaP2 = = = =\n"
				+ "Digita a opcao desejada:\n" + "1 - Cadastrar um Produto\n"
				+ "2 - Vender um Produto\n" + "3 - Imprimir Balanco\n"
				+ "4 - Sair\n\n" + "Opcao: ");
	}

}
