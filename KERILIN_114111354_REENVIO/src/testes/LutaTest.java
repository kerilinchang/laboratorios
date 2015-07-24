/* 114111365 - Kerilin Laine Andrade Chang: LAB 5 - Turma 3 */

package testes;

import jogo.Luta;

import org.junit.*;

import exceptions.*;

public class LutaTest {

	@Test
	public void testaContrutor() throws StringInvalidaException, InteiroInvalidoException {
		try {
			Luta luta = new Luta("Mortal Kombat", 50.0);

			Assert.assertEquals("Mortal Kombat", luta.getNome());
			Assert.assertNotEquals("Bamby", luta.getNome());

		} catch (Exception e) {
			Assert.fail("Nao deveria entrar aqui, o metodo nao lanca excecao");
		}

	}

	@Test
	public void testaNomeInvalido() throws StringInvalidaException, InteiroInvalidoException {
		try {
			Luta luta = new Luta(null, 50.0);
			Assert.fail();

		} catch (StringInvalidaException e) {
			Assert.assertEquals("Nome do Jogo invalido.", e.getMessage());
		}

		try {
			Luta luta = new Luta("", 50.0);
			Assert.fail();

		} catch (StringInvalidaException e) {
			Assert.assertEquals("Nome do Jogo invalido.", e.getMessage());
		}

	}

	@Test
	public void testaPrecoInvalido() throws StringInvalidaException, InteiroInvalidoException {
		try {
			Luta luta = new Luta("Mortal Kombat", -50.0);
			Assert.fail();

		} catch (InteiroInvalidoException e) {
			Assert.assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}
	}

}
