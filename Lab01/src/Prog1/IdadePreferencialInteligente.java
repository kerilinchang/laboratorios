package Prog1;

import java.util.Scanner;

public class IdadePreferencialInteligente {
	
	private static Scanner entrada = new Scanner(System.in);
	private static int idade;
	
	public static void main(String[] args){
		
		System.out.println("digite o ano do seu nascimento");
		int ano_nas = entrada.nextInt();
		
		System.out.println("digite o ano atual");
		int ano_atual = entrada.nextInt();
		
		int idade = ano_atual - ano_nas;
		System.out.println("a sua idade � " + idade + " anos");
		
		minhaIdade();
				
	}
	
	public static void minhaIdade(){
		if (idade < 16){
			System.out.println("vc n�o precisa votar");	
		}
		
		else if (idade >= 16 && idade < 18){
			System.out.println("vc pode votar, por�m n�o � obrigado");
		}
		
		else if (idade >= 18 && idade < 70){
			System.out.println("voce � obrigado a vorat");
		}
		
		else{
			System.out.println("a partir da sua idade n�o � mais obrigado a votar");
		}
		
	}

}
