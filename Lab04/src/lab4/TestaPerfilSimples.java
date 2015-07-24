/* 114111365 - Kerilin Laine Andrade Chang: LAB 4 - Turma 3 */

package lab4;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestaPerfilSimples {

	private PerfilSimples meuPerfil;
	private Musica chandelier, elasticHeart, cellophane, cherie;
	private Album meusAlbuns, meusAlbuns2;
	
	@Before
	public void setUp() throws Exception{
		meuPerfil = new PerfilSimples("Chang");
		chandelier = new Musica("Chandelier",3,"Pop");
		elasticHeart = new Musica("Elastic Heart",3,"Pop");
		cellophane = new Musica("Cellophane",4,"Pop");
		cherie = new Musica("Cherie",5,"Pop");
		
		meusAlbuns = new Album("Zaz", "Paris", 2008);
		meusAlbuns2 = new Album ("Francoi", "Solei", 1978);	
	}
	
	@Test
	public void testeCriaPerfil(){
		try {
			PerfilSimples perfilInvalido = new PerfilSimples("");
			Assert.fail();
		}
		catch (Exception e){
			Assert.assertEquals("nome do perfil invalido.", e.getMessage());
		}

		try {
			PerfilSimples perfilInvalido = new PerfilSimples(null);
			Assert.fail();
		}
		catch (Exception e){ 
			Assert.assertEquals("nome do perfil invalido.", e.getMessage());		
		}	
	}// fecha teste cria perfil
	
		
	@Test
	public void testeAdicionaAlbum() throws Exception{
	
		try{
			meuPerfil.adicionaAlbum(null);
			Assert.fail();
			}
		catch (Exception e){
			Assert.assertEquals("a musica nao foi adicionada ao album", e.getMessage());
		}
		
		meuPerfil.adicionaAlbum(meusAlbuns);
		
		Assert.assertTrue(meuPerfil.getAlbunsDoPerfil().contains(meusAlbuns));
		
	} // fecha o testeAddAlbum
	
	@Test
	public void testeAdicionaAosFavoritos() throws Exception{
		try{
			meuPerfil.adicionaAosFavoritos(meusAlbuns);
			Assert.fail();
		}
		catch (Exception e){
			Assert.assertEquals("o album nao esta no album do perfil", e.getMessage());
		}
		
		meuPerfil.adicionaAlbum(meusAlbuns);
		meuPerfil.adicionaAosFavoritos(meusAlbuns);
		
		Assert.assertTrue(meuPerfil.getAlbunsFavorito().contains(meusAlbuns));	
		
	} // fecha o teste add aos favoritos
		
} // fecha testa perfil simples
