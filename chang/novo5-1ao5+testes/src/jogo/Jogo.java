package jogo;

import java.util.*;

import exceptions.*;

public class Jogo {
	
	private String nome;
	private double preco;
	protected int score;
	private int quantVezesJogou;
	private int quantVezesZerou;
	private List<Jogabilidade> listaDejogos;
	
	public Jogo(String nome, double preco) throws StringInvalidaException, InteiroInvalidoException{
		if(nome == null || nome.equals("")){
			throw new StringInvalidaException("Nome do Jogo invalido.");
		}
		if(preco < 0.0){
			throw new InteiroInvalidoException("Preco nao pode ser negativo.");
		}
		this.nome = nome;
		this.preco = preco;
		this.score = 0;
		this.quantVezesJogou = 0;
		this.quantVezesZerou = 0;
		this.listaDejogos = new ArrayList<Jogabilidade>();
	} 
	
	
	public void joga(int scoreDoUsuario, boolean zerouJogo){
		if(scoreDoUsuario >  score){
			score = scoreDoUsuario;
		}
		if(zerouJogo == true){
			quantVezesZerou++;
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public  int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getQuantVezesJogou() {
		return quantVezesJogou;
	}


	public void setQuantVezesJogou(int quantVezesJogou) {
		this.quantVezesJogou = quantVezesJogou;
	}


	public int getQuantVezesZerou() {
		return quantVezesZerou;
	}


	public void setQuantVezesZerou(int quantVezesZerou) {
		this.quantVezesZerou = quantVezesZerou;
	}


	public List<Jogabilidade> getListaDejogos() {
		return listaDejogos;
	}


	public void setListaDejogos(List<Jogabilidade> listaDejogos) {
		this.listaDejogos = listaDejogos;
	}
	
	

}
