package jogo;

import java.util.*;

public class Jogo {
	
	private String nome;
	private double preco;
	protected int score;
	private int quantVezesJogou = 0;
	private int quantVezesZerou = 0;
	private List<Jogabilidade> listaDejogos;
	
	public Jogo(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
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
