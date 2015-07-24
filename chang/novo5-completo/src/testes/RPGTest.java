package testes;

import jogo.RPG;
import org.junit.*;
import exceptions.*;

public class RPGTest {

	@Test
	public void testaContrutor() throws StringInvalidaException, InteiroInvalidoException {
		try {
			RPG RPG = new RPG("Mortal Kombat", 50.0);

			Assert.assertEquals("Mortal Kombat", RPG.getNome());
			Assert.assertNotEquals("Bamby", RPG.getNome());

		} catch (Exception e) {
			Assert.fail("Nao deveria entrar aqui, o metodo nao lanca excecao");
		}

	}

	@Test
	public void testaNomeInvalido() throws StringInvalidaException, InteiroInvalidoException {
		try {
			RPG RPG = new RPG(null, 50.0);
			Assert.fail();

		} catch (StringInvalidaException e) {
			Assert.assertEquals("Nome do Jogo invalido.", e.getMessage());
		}

		try {
			RPG RPG = new RPG("", 50.0);
			Assert.fail();

		} catch (StringInvalidaException e) {
			Assert.assertEquals("Nome do Jogo invalido.", e.getMessage());
		}

	}

	@Test
	public void testaPrecoInvalido() throws StringInvalidaException, InteiroInvalidoException {
		try {
			RPG RPG = new RPG("Mortal Kombat", -50.0);
			Assert.fail();

		} catch (InteiroInvalidoException e) {
			Assert.assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}
	}

}
