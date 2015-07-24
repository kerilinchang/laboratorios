/* 114111365 - Kerilin Laine Andrade Chang: LAB 4 - Turma 3 */

package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PerfilSimples {
	
	private String nome;
	private List<Album> albunsDoPerfil;
	private List<Album> albunsFavoritos;
	private HashMap<String, ArrayList<Musica>> playlists;
	
	public PerfilSimples(String nome) throws Exception{
		
		if (nome == null || nome.equals("")){
			throw new Exception("nome do perfil invalido.");
		}
		
		this.nome = nome;
		
		albunsDoPerfil = new ArrayList<Album>();
		albunsFavoritos = new ArrayList<Album>();
		playlists = new HashMap <String, ArrayList<Musica>>();
		
	} // fecha o construtor
	
	
	public void adicionaAlbum(Album album) throws Exception {
		if (album == null){
			throw new Exception("a musica nao foi adicionada ao album");	
		}
		albunsDoPerfil.add(album);
	} // fecha o matodo addalbum
	
	public void adicionaAosFavoritos(Album album) throws Exception {
		if (!albunsDoPerfil.contains(album)){
			throw new Exception("o album nao esta no album do perfil");
		}
		
		albunsFavoritos.add(album);
	}// fecha o metodo add aos favoritos
	
	
	public void adicionaPlaylist(String nomePlaylist,String nomeAlbum, int faixa) throws Exception{
		if (!(playlists.containsKey(nomePlaylist))){  
			playlists.put(nomePlaylist, new ArrayList<Musica>());
	
		}	
		Musica musica = verificaAlbum(nomeAlbum).getMusica(faixa);
		playlists.get(nomePlaylist).add(musica);
		
	}// fecha adiconaPlayList
	
	
	public Album verificaAlbum(String nomeAlbum) throws Exception{
		for(Album album: albunsDoPerfil){
			if (nomeAlbum.equals(album.getTitulo())){
				return album;
			}
		}
		throw new Exception("Álbum não pertence ao Perfil especificado");	
	}
	
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	
	public List<Album> getAlbunsDoPerfil() {
		return albunsDoPerfil;
	}

	public List<Album> getAlbunsFavorito() {
		return albunsFavoritos;
	}

	public HashMap<String, ArrayList<Musica>> getPlaylists(){
		return playlists;
	}

	public boolean equals(Object objeto){
		if(!(objeto instanceof PerfilSimples)){
			return false;
		}
		PerfilSimples novoPerfil = (PerfilSimples) objeto;
		if (novoPerfil.getNome().equals(this.nome) && novoPerfil.getAlbunsDoPerfil().equals(this.albunsDoPerfil) && novoPerfil.getAlbunsFavorito().equals(this.albunsFavoritos)){
			return true;
		}
		return false;
	} // fecha o equals
	
} // fecha a classe perfil simp0les
