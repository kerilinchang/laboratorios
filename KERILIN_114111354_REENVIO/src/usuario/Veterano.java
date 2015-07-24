/* 114111365 - Kerilin Laine Andrade Chang: LAB 5 - Turma 3 */

package usuario;

import exceptions.StringInvalidaException;
import jogo.Jogabilidade;
import jogo.Jogo;

public class Veterano extends Usuario {

	private final double DESCONTO_VETERANO = 0.2;

	public Veterano(String nome, String login) throws StringInvalidaException {
		super(nome, login);
	}

	@Override
	public Jogo compraJogo(Jogo jogo) {

		double precoComDesconto = jogo.getPreco()
				- (jogo.getPreco() * DESCONTO_VETERANO);

		if (precoComDesconto <= getQuantDinheiro()) {
			double dinheiroRestante = getQuantDinheiro() - precoComDesconto;
			setQuantDinheiro(dinheiroRestante);
			getJogosComprados().add(jogo);
			setX2p((int) (10*jogo.getPreco()));
			return jogo;
		}
		return null;
	}
	
	@Override
	public void recompensar(String nomeDoJogo, int ScoreObtido, boolean zerouJogo) {

		Jogo jogo = procuraJogo(nomeDoJogo);
		
		if(jogo.getJogabilidades().contains(Jogabilidade.ONLINE)){
			setX2p(10);
		}
		if(jogo.getJogabilidades().contains(Jogabilidade.COOPERATIVO)){
			setX2p(20);
		}
	}
	
	@Override
	public void punir(String nomeDoJogo, int ScoreObtido, boolean zerouJogo) {
		
		Jogo jogo = procuraJogo(nomeDoJogo);
		
		if(jogo.getJogabilidades().contains(Jogabilidade.COMPETITIVO)){
			setX2p(-20);
		}
		if(jogo.getJogabilidades().contains(Jogabilidade.COOPERATIVO)){
			setX2p(-20);
		}
		
	}

} // fecha a class Veterano
