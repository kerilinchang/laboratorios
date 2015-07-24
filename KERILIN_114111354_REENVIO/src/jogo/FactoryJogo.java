/* 114111365 - Kerilin Laine Andrade Chang: LAB 5 - Turma 3 */


package jogo;

import exceptions.InteiroInvalidoException;
import exceptions.StringInvalidaException;
import jogo.Luta;
import jogo.Plataforma;
import jogo.RPG;

public class FactoryJogo {
	
	public RPG criaJogoRPG(String nome, double preco, String tipoDeJogo) throws StringInvalidaException, InteiroInvalidoException{
			return new RPG(nome, preco);
	}
	
	public Luta criaJogoLuta(String nome, double preco, String tipoDeJogo) throws StringInvalidaException, InteiroInvalidoException{
		return new Luta(nome, preco);
	}

	public Plataforma criaPlataforma(String nome, double preco, String tipoDeJogo) throws StringInvalidaException, InteiroInvalidoException{
		return new Plataforma(nome, preco);
	}
	
}
