package usuario;

import exceptions.StringInvalidaException;
import jogo.Jogo;

public class Veterano extends Usuario {

	private final double DESCONTO_VETERANO = 0.2;

	public Veterano(String nome, String login) throws StringInvalidaException {
		super(nome, login);
	}

	@Override
	public void compraJogo(Jogo jogo) {

		double precoComDesconto = jogo.getPreco()
				- (jogo.getPreco() * DESCONTO_VETERANO);

		if (precoComDesconto <= getQuantDinheiro()) {
			double dinheiroRestante = getQuantDinheiro() - precoComDesconto;
			setQuantDinheiro(dinheiroRestante);
			getJogosComprados().add(jogo);
			setX2p((int) (10*jogo.getPreco()));
		}

	}

} // fecha a class Veterano
