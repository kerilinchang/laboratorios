package Prog2;

import java.util.Scanner;

public class CompraLojaoP2 {

	private static int contador_produtos;
	private static double conta;
	private static int porcentagem;
	private static String produtos[];
	private static int quantidade[];
	private static float preco = (float) 1.99 ;
	private static Scanner entrada = new Scanner(System.in);
	
	public static void main (String[] args){
		
		MenuPrincipal.menu();
		int opcao_menu = entrada.nextInt();
		
		while (opcao_menu != 3){
			
			switch(opcao_menu){
				case 1:					
					System.out.println("-- Cadastro de Produtos --");
					System.out.println("Digite a quantidade de produtos diferentes que será comprada: ");
					int objetos_diferentes1 = entrada.nextInt();
					
					produtos = new String[objetos_diferentes1];
					quantidade = new int[objetos_diferentes1];

					cadastraProduto(objetos_diferentes1);
					imprimeFatura();
					break;
					
				case 2:
					System.out.println("Digite o novo preco Base: \n");
					preco = entrada.nextFloat();
					break;
				case 3:
					break;
			}
			
			MenuPrincipal.menu();
			opcao_menu = entrada.nextInt();
		}
		
	} // termina o main
	
	
	
	public static void cadastraProduto(int objetos_diferentes1){
	
		int contador = 1;
		for(int i = 0; i < objetos_diferentes1; i++  ){
			System.out.println("Nome do Produto " + contador + ":");
			String nome_produto = entrada.next();
			produtos[i] = nome_produto;
			
			System.out.println("Quantidade de " + nome_produto + ":");
			int quant_produto = entrada.nextInt();
			quantidade[i] = quant_produto;
			contador_produtos += quant_produto;
			contador++;	
		}
		
		
	}
	

	public static void imprimeFatura(){
		
		System.out.println("-- Cadastro Concluído --");
		System.out.println("A sua compra foi:");
		
	
		for(int i = 0; i < produtos.length; i++){
			porcentagem = (100 * quantidade[i]) / contador_produtos;
			System.out.println(quantidade[i] + " " + produtos[i] + " " + "(" + porcentagem + "%" + ")");
		}
		
		conta = contador_produtos * preco; 
		System.out.println("Total de produtos: " + contador_produtos);
		System.out.println("Total gasto: R$ " + conta);
		
		System.out.println("-- Fim da execução Passo --");
		
	}
	
}	

