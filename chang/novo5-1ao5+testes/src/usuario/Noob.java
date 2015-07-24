package usuario;

import exceptions.StringInvalidaException;
import jogo.Jogo;

public class Noob extends Usuario {

	private final double DESCONTO_NOOB = 0.1;

	public Noob(String nome, String login) throws StringInvalidaException {
		super(nome, login);
	}

	@Override
	public void compraJogo(Jogo jogo) {
		
		
		double precoComDesconto = jogo.getPreco()
				- (jogo.getPreco() * DESCONTO_NOOB);

		if (precoComDesconto <= getQuantDinheiro()) {
			double dinheiroRestante = getQuantDinheiro() - precoComDesconto;
			setQuantDinheiro(dinheiroRestante);
			getJogosComprados().add(jogo);
			setX2p((int) (10*jogo.getPreco()));
		}

	}
}
