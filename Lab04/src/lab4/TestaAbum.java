/* 114111365 - Kerilin Laine Andrade Chang: LAB 4 - Turma 3 */

package lab4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaAbum {

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
	public void testeAbumInvalido() {
		
		try {
			Album albumInvalido = new Album("", "Flores", 2010);
			Assert.fail();
		}
		 catch (Exception e) {
			 Assert.assertEquals("O nome do artista nao pode ser vazio.", e.getMessage());
		 }

		try {
			Album albumInvalido = new Album("Abalhas", "", 2001);
			Assert.fail();
		}	
			catch (Exception e){
				Assert.assertEquals("o nome do album nao pode ser vazio.",  e.getMessage());
			}
			
		try {
			Album albumInvalido = new Album("Quitote", "Pegadas", -2012);
				Assert.fail();
			}
			catch (Exception e){
				Assert.assertEquals("o ano de lancamneto do album nao pode ser negativo.", e.getMessage());
			}
		
	} // fecha o testeAlbumInvalido
	
	@Test
	public void testeAddMusicaAlbum() throws Exception{
		//sempre tem que inicializar os objetos
			
		
		Assert.assertEquals(meuAlbum.getDuracaoAlbum(), 0);

		meuAlbum.addMusica(chandelier);
		Assert.assertEquals(meuAlbum.getDuracaoAlbum(), 3);

		meuAlbum.addMusica(elasticHeart);
		Assert.assertEquals(meuAlbum.getDuracaoAlbum(), 6);

		meuAlbum.addMusica(cellophane);
		Assert.assertEquals(meuAlbum.getDuracaoAlbum(), 10);
			
		Assert.assertEquals(meuAlbum.getAlbum().get(0), chandelier);
		Assert.assertEquals(meuAlbum.getAlbum().get(1), elasticHeart);
		Assert.assertEquals(meuAlbum.getAlbum().get(2), cellophane);
	}// fecha o testeAddMusicaAlbum
	
	@Test
	public void testeRemoveMusica() throws Exception{
		meuAlbum.addMusica(chandelier);
		meuAlbum.addMusica(elasticHeart);
		meuAlbum.addMusica(cellophane);
		
		Assert.assertTrue(meuAlbum.removeMusica(chandelier));
		Assert.assertEquals(2, meuAlbum.getAlbum().size());		
	} // fecha o testeRemoveMusica
	
} // fecha o testaalbum	