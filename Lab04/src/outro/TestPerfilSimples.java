package outro;

import static org.junit.Assert.*;
import lab4.Album;
import lab4.Musica;
import lab4.PerfilSimples;
import outro.*;

import org.junit.*;

public class TestPerfilSimples {

	private PerfilSimples meuPerfil;
	private Album meuAlbum;
	private Musica chandelier, elasticHeart, cellophane, cherie;
	
	@Before
	public void setUp() throws Exception{
		PerfilSimples meuPerfil = new PerfilSimples("Chang");
		
		Musica chandelier = new Musica("Chandelier",3,"Pop");
		Musica elasticHeart = new Musica("Elastic Heart",3,"Pop");
		Musica cellophane = new Musica("Cellophane",4,"Pop");
		Musica cherie = new Musica("Cherie",5,"Pop");
		
		meuAlbum = new Album("Zaz", "Paris", 2010);
	}
	
	
	@Test
	public void testaCriarPerfil() {

		try {
			PerfilSimples perfilInvalido = new PerfilSimples("");
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("nome do perfil invalido.", e.getMessage());
		}
		
		try {
			PerfilSimples perfilInvalido = new PerfilSimples(null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("nome do perfil invalido.",e.getMessage());
		}
	}



	@Test
	public void testeAdicionaAlbum() throws Exception{
		
		try {
			meuPerfil.adicionaAlbum(null);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("a musica nao foi adicionada ao album", e.getMessage());
		}
		
		meuPerfil.adicionaAlbum(meuAlbum);
		Assert.assertTrue(meuPerfil.getAlbunsDoPerfil().contains(meuAlbum));
	}

	
	@Test
	public void testeAdicionaAosFavoritos() throws Exception{
		
		try {
			meuPerfil.adicionaAosFavoritos(meuAlbum);
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("o album nao esta no album do perfil", e.getMessage());
		}
		
		meuPerfil.adicionaAlbum(meuAlbum);
		meuPerfil.adicionaAosFavoritos(meuAlbum);
		
		Assert.assertTrue(meuPerfil.getAlbunsFavorito().contains(meuAlbum));
		
	}
	
}
