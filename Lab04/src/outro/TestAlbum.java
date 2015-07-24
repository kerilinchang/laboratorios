package outro;

import static org.junit.Assert.*;

import java.lang.reflect.Executable;

import lab4.Album;
import lab4.Musica;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAlbum {

	private Album meuAlbum;
	
	
	private final String CANTORA = "Zaz";
	private final String TITULO = "Paris";
	private final int LANCAMENTO = 2008;
	private Musica chandelier, elasticHeart, cellophane;
	
	
	@Before
	public void setUp() throws Exception{
		meuAlbum = new Album(CANTORA, TITULO, LANCAMENTO);
	
		
		chandelier = new Musica("Chandelier", 3, "Pop");
		elasticHeart = new Musica("Elastic Heart", 3, "Pop");
		cellophane = new Musica("Cellophane", 4, "Pop");
	}
	
	@Test
	public void testAlbumInvalido() {
	
		
		try {
			Album albumInvalido = new Album("", TITULO, LANCAMENTO);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("O nome do artista nao pode ser vazio.", e.getMessage());
		}
		
		
		try {
			Album albumInvalidos = new Album(CANTORA, null, LANCAMENTO);
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("o nome do album nao pode ser vazio.", e.getMessage());
		}
		
		try {
			Album albumInvalidos = new Album(CANTORA, "", LANCAMENTO);
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("o nome do album nao pode ser vazio.", e.getMessage());
		}
		
		try {
			Album albumInvalido = new Album(CANTORA, TITULO, -2000);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("o ano de lancamneto do album nao pode ser negativo.", e.getMessage());
		}	
	}
	
	
	
	
	@Test
	public void testAddMusicaAoAlbum() throws Exception{
		
		meuAlbum.addMusica(cellophane);
		Assert.assertEquals(meuAlbum.getDuracaoAlbum(), 4);
		
		//paraverificar se a musica esta na ordem certa
		Assert.assertEquals(meuAlbum.getAlbum().get(0), cellophane);
		
		meuAlbum.addMusica(elasticHeart);
		Assert.assertEquals(meuAlbum.getDuracaoAlbum(), 7);
		Assert.assertEquals(meuAlbum.getAlbum().get(1), elasticHeart);
	}
	
	
	@Test
	public void testeRemoveMusica() throws Exception{
		
		meuAlbum.addMusica(chandelier);
		meuAlbum.addMusica(elasticHeart);
		meuAlbum.addMusica(cellophane);
		
		Assert.assertTrue(meuAlbum.removeMusica(chandelier));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
