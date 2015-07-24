package jogo;

import exceptions.InteiroInvalidoException;
import exceptions.StringInvalidaException;
import jogo.Luta;
import jogo.Plataforma;
import jogo.Rpg;

public class FactoryJogo {
	
	public Rpg criaJogoRPG(String nome, double preco, String tipoDeJogo) throws StringInvalidaException, InteiroInvalidoException{
			return new Rpg(nome, preco);
	}
	
	public Luta criaJogoLuta(String nome, double preco, String tipoDeJogo) throws StringInvalidaException, InteiroInvalidoException{
		return new Luta(nome, preco);
	}

	public Plataforma criaPlataforma(String nome, double preco, String tipoDeJogo) throws StringInvalidaException, InteiroInvalidoException{
		return new Plataforma(nome, preco);
	}
	
}
