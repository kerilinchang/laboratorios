package jogo;

import jogo.Luta;
import jogo.Plataforma;
import jogo.Rpg;

public class FactoryJogo {
	
	public Rpg criaJogoRPG(String nome, double preco, String tipoDeJogo){
			return new Rpg(nome, preco);
	}
	
	public Luta criaJogoLuta(String nome, double preco, String tipoDeJogo){
		return new Luta(nome, preco);
	}

	public Plataforma criaPlataforma(String nome, double preco, String tipoDeJogo){
		return new Plataforma(nome, preco);
	}
	
}
