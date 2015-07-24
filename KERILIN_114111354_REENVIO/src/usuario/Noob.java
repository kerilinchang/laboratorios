/* 114111365 - Kerilin Laine Andrade Chang: LAB 5 - Turma 3 */

package usuario;

import exceptions.InteiroInvalidoException;
import exceptions.StringInvalidaException;
import jogo.*;


public class Noob extends Usuario {

	private final double DESCONTO_NOOB = 0.1;

	public Noob(String nome, String login) throws StringInvalidaException {
		super(nome, login);
	}

	@Override
	public Jogo compraJogo(Jogo jogo) throws InteiroInvalidoException {
		
		double precoComDesconto = jogo.getPreco()
				- (jogo.getPreco() * DESCONTO_NOOB);

		if (precoComDesconto <= getQuantDinheiro()) {
			double dinheiroRestante = getQuantDinheiro() - precoComDesconto;
			setQuantDinheiro(dinheiroRestante);
			getJogosComprados().add(jogo);
			setX2p((int) (10*jogo.getPreco()));
			return jogo;
		}else{
			throw new InteiroInvalidoException("Usuario nao possue dinheiro suficiente.");
		}

	}

	@Override
	public void recompensar(String nomeDoJogo, int ScoreObtido, boolean zerouJogo) {

		Jogo jogo = procuraJogo(nomeDoJogo);
		
		if(jogo.getJogabilidades().contains(Jogabilidade.OFFLINE)){
			setX2p(30);
		}
		if(jogo.getJogabilidades().contains(Jogabilidade.MULTIPLAYER)){
			setX2p(10);
		}
		
	}

	@Override
	public void punir(String nomeDoJogo, int ScoreObtido, boolean zerouJogo) {
		
		Jogo jogo = procuraJogo(nomeDoJogo);
		
		if(jogo.getJogabilidades().contains(Jogabilidade.ONLINE)){
			setX2p(-10);
		}
		if(jogo.getJogabilidades().contains(Jogabilidade.COMPETITIVO)){
			setX2p(-20);
		}
		if(jogo.getJogabilidades().contains(Jogabilidade.COOPERATIVO)){
			setX2p(-50);
		}
		
	}
}
