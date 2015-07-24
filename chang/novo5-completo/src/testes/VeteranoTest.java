package testes;

import org.junit.*;
import exceptions.StringInvalidaException;
import usuario.Veterano;

public class VeteranoTest {

	@Test
	public void testVeterano() {

		try {
			Veterano veterano = new Veterano("Chang", "chang.ling");

			Assert.assertEquals("Chang", veterano.getNome());
			Assert.assertSame("chang.ling", veterano.getLogin());
		} catch (Exception e) {

			Assert.fail("Nao deveria entrar aqui, o metodo nao lanca excecao");

		}

	}

	@Test
	public void testNoobInvalido() {

		try {

			Veterano nomeNull = new Veterano(null, "hiago");
			Assert.fail("Deve entrar aqui, o metodo lanca excecao");

		} catch (StringInvalidaException e) {

			Assert.assertEquals("Nome do usuario ou login invalido.",
					e.getMessage());

		}

		try {

			Veterano nomeVazio = new Veterano("", "hiago");
			Assert.fail("Deve entrar aqui, o metodo lanca excecao");

		} catch (StringInvalidaException e) {

			Assert.assertEquals("Nome do usuario ou login invalido.",
					e.getMessage());

		}

		try {

			Veterano loginNull = new Veterano("Hiago", null);
			Assert.fail("Deve entrar aqui, o metodo lanca excecao");

		} catch (StringInvalidaException e) {

			Assert.assertEquals("Nome do usuario ou login invalido.",
					e.getMessage());

		}

		try {

			Veterano loginVazio = new Veterano("Hiago", "");
			Assert.fail("Deve entrar aqui, o metodo lanca excecao");

		} catch (StringInvalidaException e) {

			Assert.assertEquals("Nome do usuario ou login invalido.",
					e.getMessage());

		}

	}
}
