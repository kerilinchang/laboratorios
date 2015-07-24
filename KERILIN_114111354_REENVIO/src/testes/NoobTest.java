/* 114111365 - Kerilin Laine Andrade Chang: LAB 5 - Turma 3 */

package testes;

import org.junit.*;
import exceptions.StringInvalidaException;
import usuario.Noob;

public class NoobTest {

	@Test
	public void testNoob() {

		try {
			Noob noob = new Noob("Chang", "chang.ling");

			Assert.assertEquals("Chang", noob.getNome());
			Assert.assertSame("chang.ling", noob.getLogin());
		} catch (Exception e) {

			Assert.fail("Nao deveria entrar aqui, o metodo nao lanca excecao");

		}

	}

	@Test
	public void testNoobInvalido() {

		try {

			Noob nomeNull = new Noob(null, "hiago");
			Assert.fail("Deve entrar aqui, o metodo lanca excecao");

		} catch (StringInvalidaException e) {

			Assert.assertEquals("Nome do usuario ou login invalido.",
					e.getMessage());

		}

		try {

			Noob nomeVazio = new Noob("", "hiago");
			Assert.fail("Deve entrar aqui, o metodo lanca excecao");

		} catch (StringInvalidaException e) {

			Assert.assertEquals("Nome do usuario ou login invalido.",
					e.getMessage());

		}

		try {

			Noob loginNull = new Noob("Hiago", null);
			Assert.fail("Deve entrar aqui, o metodo lanca excecao");

		} catch (StringInvalidaException e) {

			Assert.assertEquals("Nome do usuario ou login invalido.",
					e.getMessage());

		}

		try {

			Noob loginVazio = new Noob("Hiago", "");
			Assert.fail("Deve entrar aqui, o metodo lanca excecao");

		} catch (StringInvalidaException e) {

			Assert.assertEquals("Nome do usuario ou login invalido.",
					e.getMessage());

		}

	}
}
