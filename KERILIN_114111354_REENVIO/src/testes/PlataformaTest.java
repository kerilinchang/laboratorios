/* 114111365 - Kerilin Laine Andrade Chang: LAB 5 - Turma 3 */

package testes;

import jogo.Plataforma;
import org.junit.*;
import exceptions.*;

public class PlataformaTest {

	@Test
	public void testaContrutor() throws StringInvalidaException, InteiroInvalidoException {
		try {
			Plataforma plataforma = new Plataforma("Mortal Kombat", 50.0);

			Assert.assertEquals("Mortal Kombat", plataforma.getNome());
			Assert.assertNotEquals("Bamby", plataforma.getNome());

		} catch (Exception e) {
			Assert.fail("Nao deveria entrar aqui, o metodo nao lanca excecao");
		}

	}

	@Test
	public void testaNomeInvalido() throws StringInvalidaException, InteiroInvalidoException {
		try {
			Plataforma plafaforma = new Plataforma(null, 50.0);
			Assert.fail();

		} catch (StringInvalidaException e) {
			Assert.assertEquals("Nome do Jogo invalido.", e.getMessage());
		}

		try {
			Plataforma plafaforma = new Plataforma("", 50.0);
			Assert.fail();

		} catch (StringInvalidaException e) {
			Assert.assertEquals("Nome do Jogo invalido.", e.getMessage());
		}

	}

	@Test
	public void testaPrecoInvalido() throws StringInvalidaException, InteiroInvalidoException {
		try {
			Plataforma plafaforma = new Plataforma("Mortal Kombat", -50.0);
			Assert.fail();

		} catch (InteiroInvalidoException e) {
			Assert.assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}
	}

}
