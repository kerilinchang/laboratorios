package loja;

import java.util.*;

import jogo.FactoryJogo;
import jogo.Jogo;
import jogo.Luta;
import jogo.Rpg;
import usuario.*;

public class Loja {

	private FactoryUsuario tipoUsuario;
	private FactoryJogo tipoJogo;
	private List<Usuario> listaDeUsuarios;
	private List<Jogo> listaDeJogos;
	
	public static void main(String[] args) {
		Loja loja = new Loja();
		
		Usuario use1 = new Noob("Erik", "erickalcanttara");
		Usuario use2 = new Veterano("Chang", "chingling");
		
		Rpg jogo1 = new Rpg("Dota", 22);
		Luta jogo2 = new Luta("Mortal Kombat", 15);
		jogo1.setQuantVezesJogou(3);
		jogo1.setQuantVezesZerou(90);
		
		use1.adicionaDinheiro(500.0);
		use2.adicionaDinheiro(30.0);
		
		use1.addJogo(jogo1);
		use1.addJogo(jogo2);
		
		use2.addJogo(jogo1);
		use2.addJogo(jogo2);
		
		loja.listaDeUsuarios.add(use1);
		
		for (int i = 0; i < loja.listaDeUsuarios.size(); i++) {
			System.out.println(loja.listaDeUsuarios.get(i).toString());
		}
	}

	public Loja() {
		listaDeUsuarios = new ArrayList<Usuario>();
		listaDeJogos = new ArrayList<Jogo>();
	}

	public void criaUsuario(String nome, String login, String tipoDeUsuario) {

		switch (tipoDeUsuario) {
		case "Noob":
			tipoUsuario.criaUsuarioNoob(nome, login);
			break;
		case "Veterano":
			tipoUsuario.criaUsuarioVeterano(nome, login);
			break;
		}// Switch
	}

	public void criaJogo(String nome, Double preco, String tipoDeJogo) {

		switch (tipoDeJogo) {
		case "RPG":
			tipoJogo.criaJogoRPG(nome, preco, tipoDeJogo);
			break;
		case "Luta":
			tipoJogo.criaJogoLuta(nome, preco, tipoDeJogo);
			break;
		case "Plataforma":
			tipoJogo.criaPlataforma(nome, preco, tipoDeJogo);
			break;
		}// Switch
	}

	public void adicionaJogoAoUsuario(Jogo jogo, String loginUsuario) {

		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (loginUsuario.equals(listaDeUsuarios.get(i).getLogin())) {
				listaDeUsuarios.get(i).compraJogo(jogo);
			}
		}

	}

	public void adicionaDinheiro(String login, Double dinheiro) {
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (listaDeUsuarios.get(i).getLogin().equals(login)) {
				adicionaDinheiro(login, dinheiro);
			}
		}
	}
	
	@Override
	public String toString() {
		String imprimir = "";
		
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			imprimir +=  listaDeUsuarios.get(i).toString();
		}
		
		return imprimir;
	}

}
