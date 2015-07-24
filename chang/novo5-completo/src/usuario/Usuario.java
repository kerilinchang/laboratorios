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
	
	public abstract Jogo compraJogo(Jogo jogo) throws InteiroInvalidoException;

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
	
	public Jogo procuraJogo(String nomeDoJogo){
		
		for (int i = 0; i < getJogosComprados().size(); i++) {
			if(getJogosComprados().get(i).getNome().equals(nomeDoJogo)){
				return getJogosComprados().get(i);
			}
		}
		return null;
	}
	
	public int adicionaX2PporJogo(){
		int x2p = 0;
		for (int i = 0; i < jogosComprados.size(); i++) {
			if(jogosComprados.get(i) instanceof RPG){
				x2p += jogosComprados.get(i).getQuantVezesJogou() * 10;
			}
			if(jogosComprados.get(i) instanceof Luta){
				x2p += jogosComprados.get(i).getScore() / 1000;
			}
			if(jogosComprados.get(i) instanceof Plataforma){
				x2p += jogosComprados.get(i).getQuantVezesZerou() * 20;
			}
		
		}
		setX2p(x2p);
		return x2p;
		
	}
	
	public int calculaX2PTotal(){
		int totalX2P = 0;
		totalX2P = (getX2p() + adicionaX2PporJogo());
		
		return totalX2P;
	}

	@Override
	public String toString() {
		String imprimir = getLogin() + "\n" + getNome();
		
		return imprimir;
	}

	public abstract void recompensar(String nomeDoJogo, int ScoreObtido, boolean zerouJogo);
	
	public abstract void punir(String nomeDoJogo, int ScoreObtido, boolean zerouJogo);

} // fecha a classe usuario
