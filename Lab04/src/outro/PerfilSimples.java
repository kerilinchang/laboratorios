package outro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import outro.*;

public class PerfilSimples {

	private String nome;
	private List<Album> albunsDoPerfil;
	private List<Album> albunsFavoritos;
	private HashMap<String, ArrayList<Musica>> playlists;
			
	public PerfilSimples(String nome) {
		this.nome = nome;
		
		albunsDoPerfil = new ArrayList<Album>();
		albunsFavoritos = new ArrayList<Album>();
		playlists = new HashMap<String, ArrayList<Musica>>();
	} // fecha o construtor

	public void adicionaAlbum(Album meuAlbum) throws Exception{
		if(meuAlbum == null){
			throw new Exception("a musica nao foi adicionada ao album");
			}
			albunsDoPerfil.add(meuAlbum);
		}
	
	public void adicionaAosFavritos(Album album) throws Exception{
		
		if(!(albunsDoPerfil.contains(album))){
			throw new Exception("o album nao esta no album do perfil");
		}
		albunsFavoritos.add(album);
	}	
	
	public void adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception{
	if (!(playlists.containsKey(nomePlaylist))){
		playlists.put(nomePlaylist, new ArrayList<Musica>());
	}
	
	Musica musica = verificaAlbum(nomeAlbum).getMusica(faixa);
	playlists.get(nomePlaylist).add(musica);
		
	}

	public Album verificaAlbum(String nomeAlbum) throws Exception{
		for(Album album: albunsDoPerfil){
			if (nomeAlbum.equals(album.getTitulo())) {
				return album;
			}
		}
		throw new Exception("Album nao pertence ao Perfil especificado");	
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Album> getAlbunsDoPerfil() {
		return albunsDoPerfil;
	}

	public void setAlbunsDoPerfil(List<Album> albunsDoPerfil) {
		this.albunsDoPerfil = albunsDoPerfil;
	}

	public List<Album> getAlbunsFavoritos() {
		return albunsFavoritos;
	}

	public void setAlbunsFavoritos(List<Album> albunsFavoritos) {
		this.albunsFavoritos = albunsFavoritos;
	}
	
	public HashMap<String, ArrayList<Musica>> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(HashMap<String, ArrayList<Musica>> playlists) {
		this.playlists = playlists;
	}
	
	public boolean equals(Object objeto){
		if(!(objeto instanceof PerfilSimples)){
			return false;
		}
		PerfilSimples novoPerfil = (PerfilSimples) objeto;
		if(novoPerfil.getNome().equals(this.nome) && novoPerfil.getAlbunsDoPerfil().equals(this.albunsDoPerfil) && novoPerfil.getAlbunsFavoritos().equals(this.albunsFavoritos)){
			return true;
		}
		return false;
	}	
	
} // fecha a classe PerfilSimples
