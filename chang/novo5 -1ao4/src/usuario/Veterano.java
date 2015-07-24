package usuario;

import jogo.Jogo;

public class Veterano extends Usuario {

	private final double DESCONTO_VETERANO = 0.2;

	public Veterano(String nome, String login) {
		super(nome, login);
	}

	@Override
	public void compraJogo(Jogo jogo) {

		double precoComDesconto = jogo.getPreco()
				- (jogo.getPreco() * DESCONTO_VETERANO);

		if (precoComDesconto <= getQuantDinheiro()) {
			double dinheiroRestante = getQuantDinheiro() - precoComDesconto;
			setQuantDinheiro(dinheiroRestante);
		}

	}

} // fecha a class Veterano
