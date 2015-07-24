package loja;

import java.util.*;

import exceptions.*;
import jogo.*;
import usuario.*;

public class Loja {

	private FactoryUsuario tipoUsuario;
	private FactoryJogo tipoJogo;
	private List<Usuario> listaDeUsuarios;
	private List<Jogo> listaDeJogos;

	public Loja() {
		this.listaDeUsuarios = new ArrayList<Usuario>();
		this.listaDeJogos = new ArrayList<Jogo>();
		this.tipoUsuario = new FactoryUsuario();
		this.tipoJogo = new FactoryJogo();
	}

	public static void main(String[] args) throws StringInvalidaException,
			InteiroInvalidoException {
		Loja loja = new Loja();

		Usuario use = loja.criaUsuario("Erick", "erick.alcanttara", "Noob");
		
		System.out.println(use.getClass().getSimpleName());

		loja.adicionaDinheiro(use.getLogin(), 500.0);

		Jogo jogo = loja.criaJogo("Dota", 250.0, "RPG");
		Jogo jogo3 = loja.criaJogo("Magicka", 25.0, "Plataforma");

		loja.adicionaJogoAoUsuario(jogo, use.getLogin());
		//loja.adicionaJogoAoUsuario(jogo3, use.getLogin());
		jogo.joga(15000, true);
		
		loja.upgrade(use.getLogin());
		
		System.out.println(loja.toString());
	}

	public Usuario criaUsuario(String nome, String login, String tipoDeUsuario)
			throws StringInvalidaException {

		Usuario usuario = null;
		switch (tipoDeUsuario) {
		case "Noob":
			usuario = tipoUsuario.criaUsuarioNoob(nome, login);
			listaDeUsuarios.add(usuario);
			return usuario;
		case "Veterano":
			usuario = tipoUsuario.criaUsuarioVeterano(nome, login);
			listaDeUsuarios.add(usuario);
			return usuario;
		}// Switch

		return usuario;
	}

	public Jogo criaJogo(String nome, Double preco, String tipoDeJogo)
			throws StringInvalidaException, InteiroInvalidoException {

		Jogo jogo = null;
		switch (tipoDeJogo) {
		case "RPG":
			jogo = tipoJogo.criaJogoRPG(nome, preco, tipoDeJogo);
			listaDeJogos.add(jogo);
			return jogo;
		case "Luta":
			jogo = tipoJogo.criaJogoLuta(nome, preco, tipoDeJogo);
			listaDeJogos.add(jogo);
			return jogo;
		case "Plataforma":
			jogo = tipoJogo.criaPlataforma(nome, preco, tipoDeJogo);
			listaDeJogos.add(jogo);
			return jogo;
		}// Switch
		return jogo;
	}

	public void adicionaJogoAoUsuario(Jogo jogo, String loginUsuario)
			throws InteiroInvalidoException {

		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (loginUsuario.equals(listaDeUsuarios.get(i).getLogin())) {
				listaDeUsuarios.get(i).compraJogo(jogo);
			}
		}

	}

	public void adicionaDinheiro(String login, Double dinheiro) {
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (listaDeUsuarios.get(i).getLogin().equals(login)) {
				listaDeUsuarios.get(i).setQuantDinheiro(
						listaDeUsuarios.get(i).getQuantDinheiro() + dinheiro);
			}
		}
	}

	public Usuario upgrade(String loginDoUsuario) throws StringInvalidaException {

		Usuario usuario = procuraUsuario(loginDoUsuario);

		if (usuario instanceof Veterano && usuario.getX2p() >= 1000) {
			throw new StringInvalidaException("O usuario ja eh Veterano.");
		}
		if (usuario instanceof Veterano && usuario.getX2p() < 1000) {
			throw new StringInvalidaException(
					"O usuario ja eh Veterano, porem nao possuiu x2p suficientes.");
		}
		if (usuario instanceof Noob && usuario.getX2p() < 1000) {
			throw new StringInvalidaException(
					"O usuario nao possuiu x2p suficientes.");
		}
		if (usuario instanceof Noob && usuario.getX2p() >= 1000) {
			Veterano veterano = new Veterano(usuario.getNome(),
					usuario.getLogin());
			veterano.setJogosComprados(usuario.getJogosComprados());
			veterano.setQuantDinheiro(usuario.getQuantDinheiro());
			veterano.setX2p(usuario.getX2p());
			return veterano;
		}
		return usuario;

	}

	public Usuario downgrade(String loginDoUsuario) throws StringInvalidaException {

		Usuario usuario = procuraUsuario(loginDoUsuario);

		if (usuario instanceof Noob && usuario.getX2p() < 1000) {
			throw new StringInvalidaException("O usuario ja eh Noob.");
		}
		if (usuario instanceof Noob && usuario.getX2p() >= 1000) {
			throw new StringInvalidaException(
					"O usuario ja eh Noob, porem possuiu x2p suficientes para ser Veterano.");
		}
		if (usuario instanceof Veterano && usuario.getX2p() < 1000) {
			Noob noob = new Noob(usuario.getNome(), usuario.getLogin());
			noob.setJogosComprados(usuario.getJogosComprados());
			noob.setQuantDinheiro(usuario.getQuantDinheiro());
			noob.setX2p(usuario.getX2p());
			return noob;
		}
		
		return usuario;

	}

	public Usuario procuraUsuario(String loginDoUsuario) {

		Usuario usuario = null;
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			if (listaDeUsuarios.get(i).getLogin().equals(loginDoUsuario)) {
				usuario = listaDeUsuarios.get(i);
			}
		}
		return usuario;

	}

	@Override
	public String toString() {
		String imprimir = "=== Central P2-CG ===\n\n";

		double precoTotal = 0;
		double precoComDesconto = 0;
		for (int i = 0; i < listaDeUsuarios.size(); i++) {
			precoTotal = calculaPrecototalJogos(listaDeUsuarios.get(i));
			precoComDesconto = calculaPrecoComDescontoJogos(listaDeUsuarios.get(i));
			imprimir += listaDeUsuarios.get(i).toString() + "\n" + "Jogador "
					+ listaDeUsuarios.get(i).getClass().getSimpleName() + ": "
					+ listaDeUsuarios.get(i).calculaX2PTotal() + " x2p \n";

			imprimir += "+ " + listaDeUsuarios.get(i).getJogosComprados().get(i).getNome() + " - "
					+ listaDeUsuarios.get(i).getJogosComprados().get(i)
							.getClass().getSimpleName()
					+ "\n"
					+ "==> Jogou " + listaDeUsuarios.get(i).getJogosComprados().get(i).getQuantVezesJogou()	+ " vez(es)\n"
					+ "==> Zerou " + listaDeUsuarios.get(i).getJogosComprados().get(i).getQuantVezesZerou()	+ " vez(es)\n"
					+ "==> Maior Score " + listaDeUsuarios.get(i).getJogosComprados().get(i).getScore() + " vez(es)\n\n";
		}
		imprimir += "Total de preço dos Jogos: R$" + precoTotal;
		imprimir += "\nTotal arrecadado com vendas de jogos: R$" + precoComDesconto;
		return imprimir;
	}

	private Double calculaPrecototalJogos(Usuario usuario) {
		double precoTotal = 0;
		for (int i = 0; i < usuario.getJogosComprados().size(); i++) {
			precoTotal += usuario.getJogosComprados().get(i).getPreco();
		}
		return precoTotal;
	}

	private Double calculaPrecoComDescontoJogos(Usuario usuario) {
		double precoTotal = 0;
		for (int i = 0; i < usuario.getJogosComprados().size(); i++) {
			if (usuario instanceof Noob) {
				precoTotal += (usuario.getJogosComprados().get(i).getPreco() - (usuario.getJogosComprados().get(i).getPreco() * 0.1));
			}
			if(usuario instanceof Veterano) {
				precoTotal += (usuario.getJogosComprados().get(i).getPreco() - (usuario.getJogosComprados().get(i).getPreco() * 0.2));
			}
		}

		return precoTotal;
	}
}
