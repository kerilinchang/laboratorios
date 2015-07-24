package usuario;

import java.util.*;

import jogo.Jogo;


public abstract class Usuario {
	
	private String nome;
	private String login;
	private double quantDinheiro;
	
	protected List<Jogo> jogosComprados;

	public Usuario(String nome, String login) {
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new ArrayList<Jogo>();
	} // fecha o cosntrutor
	
	public abstract void compraJogo(Jogo jogo);
	
	public void adicionaDinheiro(Double dinheiro){
		quantDinheiro += dinheiro;
	}
	
	public void addJogo(Jogo jogo) {
		boolean jogoPesquisado = procuraJogo(jogo);
		if (jogoPesquisado == false) {
			getJogosComprados().add(jogo);
		}

	}

	public boolean procuraJogo(Jogo jogo) {
		boolean encontrou = false;
		for (int i = 0; i < getJogosComprados().size(); i++) {
			if (getJogosComprados().get(i).getNome().equals(jogo.getNome())) {
				encontrou = true;
			}
		}
		return encontrou;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public double getQuantDinheiro() {
		return quantDinheiro;
	}

	public void setQuantDinheiro(double quantDinheiro) {
		this.quantDinheiro = quantDinheiro;
	}

	public ArrayList<Jogo> getJogosComprados() {
		return (ArrayList<Jogo>) jogosComprados;
	}

	public void setJogosComprados(ArrayList<Jogo> jogosComprados) {
		this.jogosComprados = jogosComprados;
	}
	
	@Override
	public String toString() {
		String imprimir = "=== Central P2CG ===\n\n"
				+ getLogin() +"\n" + getNome() + " Jogador - " + getClass() + "\nLista de Jogos: \n";
		double precoTotal = 0;
		for (int i = 0; i < jogosComprados.size(); i++) {
			precoTotal += jogosComprados.get(i).getPreco();
			imprimir += "+" + jogosComprados.get(i).getNome() + "- " + jogosComprados.get(i).getClass() + "\n"
					+ "==> Jogou " + jogosComprados.get(i).getQuantVezesJogou() +  " vez(es)\n"
					+ "==> Zerou " + jogosComprados.get(i).getQuantVezesZerou() +  " vez(es)\n"
					+ "==> Maior Score " + jogosComprados.get(i).getScore() +  " vez(es)\n\n";
		}
		
		imprimir += "Total de preço dos Jogos: R$" + precoTotal;
		
		imprimir += "\nTotal arrecadado com vendas de jogos: R$" + precoTotal;
		
		
		return imprimir;
	}

} // fecha a classe usuario
