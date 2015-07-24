package usuario;

import java.util.*;

import exceptions.*;
import jogo.*;


public abstract class Usuario {
	
	private String nome;
	private String login;
	private double quantDinheiro;
	private int x2p = 0;
	
	protected List<Jogo> jogosComprados;

	public Usuario(String nome, String login) throws StringInvalidaException{
		if(nome == null || login == null || nome.equals("") || login.equals("")){
			throw new StringInvalidaException("Nome do usuario ou login invalido.");
		}
		this.nome = nome;
		this.login = login;
		this.quantDinheiro = 0;
		this.jogosComprados = new ArrayList<Jogo>();
	} // fecha o cosntrutor
	
	public abstract void compraJogo(Jogo jogo);
	
	
	public void adicionaDinheiro(Double dinheiro){
		quantDinheiro += dinheiro;
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
	
	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p += x2p;
	}
	
	public int adicionaX2PporJogo(){
		int x2p = 0;
		for (int i = 0; i < jogosComprados.size(); i++) {
			if(jogosComprados.get(i) instanceof Rpg){
				x2p += jogosComprados.get(i).getQuantVezesJogou() * 10;
				setX2p(jogosComprados.get(i).getQuantVezesJogou() * 10);
			}
			if(jogosComprados.get(i) instanceof Luta){
				x2p += jogosComprados.get(i).getScore() / 1000;
				setX2p(jogosComprados.get(i).getScore() / 1000);
			}
			if(jogosComprados.get(i) instanceof Plataforma){
				x2p += jogosComprados.get(i).getQuantVezesZerou() * 20;
				setX2p(jogosComprados.get(i).getQuantVezesZerou() * 20);
			}
			
		}
		return x2p;
		
	}
	
	public int calculaX2PTotal(){
		int totalX2P = 0;
		totalX2P = (getX2p() + adicionaX2PporJogo());
		
		return totalX2P;
	}

	@Override
	public String toString() {
		String imprimir = "=== Central P2CG ===\n\n"
				+ getLogin() +"\n" + getNome() + " Jogador - " + getClass() + " " + this.calculaX2PTotal() +  "\nLista de Jogos: \n";
		double precoTotal = 0;
		double precoComDesconto = 0;
		for (int i = 0; i < jogosComprados.size(); i++) {
			precoTotal += jogosComprados.get(i).getPreco();
			if (this instanceof Noob){
				precoComDesconto += (jogosComprados.get(i).getPreco() - (jogosComprados.get(i).getPreco() * 0.1));
			}
			if (this instanceof Veterano){
				precoComDesconto += (jogosComprados.get(i).getPreco() - (jogosComprados.get(i).getPreco() * 0.2));
			}
			imprimir += "+" + jogosComprados.get(i).getNome() + "- " + jogosComprados.get(i).getClass() + "\n"
					+ "==> Jogou " + jogosComprados.get(i).getQuantVezesJogou() +  " vez(es)\n"
					+ "==> Zerou " + jogosComprados.get(i).getQuantVezesZerou() +  " vez(es)\n"
					+ "==> Maior Score " + jogosComprados.get(i).getScore() +  " vez(es)\n\n";
		}
		
		imprimir += "Total de preço dos Jogos: R$" + precoTotal;
		
		imprimir += "\nTotal arrecadado com vendas de jogos: R$" + precoComDesconto;
		
		
		return imprimir;
	}

} // fecha a classe usuario
