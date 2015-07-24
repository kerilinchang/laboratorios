/* 114111365 - Kerilin Laine Andrade Chang: LAB 4 - Turma 3 */

package lab4;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaPerfilPlaylist {

	private PerfilSimples meuPerfil;
	private Musica chandelier, elasticHeart, cellophane, cherie, solei, si, sensible, canaille;
	private Album meusAlbuns, meusAlbuns2;
	
	@Before
	public void setUp() throws Exception{
		meuPerfil = new PerfilSimples("Chang");
		
		chandelier = new Musica("Chandelier",3,"Pop");
		elasticHeart = new Musica("Elastic Heart",3,"Pop");
		cellophane = new Musica("Cellophane",4,"Pop");
		cherie = new Musica("Cherie",5,"Pop");
		solei = new Musica("solei", 6, "Pop");
		si = new Musica("Si", 3, "Pop");
		sensible = new Musica("Sensible", 2, "Pop");
		canaille = new Musica ("Canaille", 3, "Pop");
		
		meusAlbuns = new Album("Zaz", "Paris", 2008);
		meusAlbuns2 = new Album ("Francoi", "Solei", 1978);
		
		meusAlbuns.addMusica(chandelier);
		meusAlbuns.addMusica(elasticHeart);
		meusAlbuns.addMusica(cellophane);
		meusAlbuns.addMusica(cherie);
		meusAlbuns.addMusica(solei);
		
		meusAlbuns2.addMusica(si);
		meusAlbuns2.addMusica(sensible);
		meusAlbuns2.addMusica(canaille);
		
		meuPerfil.adicionaAlbum(meusAlbuns);
		meuPerfil.adicionaAlbum(meusAlbuns2);
		
	}
		
	@Test	
	public void testeAddPlaylist() {
		try{
		meuPerfil.adicionaPlaylist("Pra relaxar", "Paris", 4);
		meuPerfil.adicionaPlaylist("Pra descansar", "Solei", 2);
		}
		catch (Exception e){
			e.printStackTrace();
			Assert.fail();
		}
		
		try{
			meuPerfil.adicionaPlaylist("Pra relaxar", "Stromae", 5);
			Assert.fail();
		}
		catch (Exception e){
			Assert.assertEquals("Álbum não pertence ao Perfil especificado", e.getMessage());
		}
		
		Assert.assertTrue(meuPerfil.getPlaylists().get("Pra relaxar").contains(solei));
		Assert.assertTrue(meuPerfil.getPlaylists().get("Pra descansar").contains(canaille));
	} // fecha p testeAddPlaylist
		
}// fecha o TestaPerfilPlaylist