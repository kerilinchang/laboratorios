package outro;

import java.util.ArrayList;
import java.util.List;

import outro.Musica;

public class Album {
	
	private String artista;
	private String titulo;
	private int lancamento;
	
	private List <Musica> album;
	
	public Album(String artista, String titulo, int lancamento) throws Exception{
		
		if(artista.equals(null) || artista.equals("")){
			throw new Exception("O nome do artista nao pode ser vazio.");
		}
		
		if(titulo.equals(null) || titulo.equals("")){
			throw new Exception("o nome do album nao pode ser vazio.");
		}
		
		if(lancamento < 0){
			throw new Exception("o ano de lancamneto do album nao pode ser negativo.");
		}
		
		// duvidaaaa!!!
		this.album = new ArrayList<Musica>();
		
		this.artista = artista;
		this.titulo = titulo;
		this.lancamento = lancamento;
		
	} // fecha o construtor
	
	
	public void addMusica(Musica novaMusica) throws Exception{
		if(!album.contains(novaMusica)){
			album.add(novaMusica);	
		}
	} // fecha o metodo addMusica
	
	
	public  boolean removeMusica(Musica novaMusica) {
		// primeiro: so posso remover uma musica q existe
		// depois de veririificar q a musica existe no album , eu posso remove-la
		if(!album.contains(novaMusica)){
			album.remove(novaMusica);
			return true;
		}
		return false;
	} // recha o metodo removeMusica
	
	
	public int duracaoDoAlbum(){
		int duracaoAlbum = 0;
		for(int i = 0; i < album.size(); i++){
			duracaoAlbum += album.get(i).getDuracao();
		}
		return duracaoAlbum;
	} // fecha o metodo DuracaoDoAlbum
	
	
	public boolean equals(Object objeto){
		if(!(objeto instanceof Album)){
			return false;
		}
		
		Album novoalbum = (Album) objeto;
		if(novoalbum.getAlbum().equals(this.artista) && novoalbum.getTitulo().equals(this.titulo)){
			return true;
		}
		return false;
	} // fecha a impelmentação do metodo equals
	

	
	public String getArtista(){
		return this.artista = artista;
	}
	
	public void setArtista(String novoArtista){
		this.artista = novoArtista;
	}
	
	public String getTitulo(){
		return this.titulo = titulo;
	}
	
	public void setTitulo(String novoTitulo){
		this.titulo = novoTitulo;
	}
	
	public int getLancamento(){
		return this.lancamento = lancamento;
	}
	
	public void setLancamento(int novoLancamento){
		this.lancamento = novoLancamento;
	}


	public List<Musica> getAlbum() {
		return album;
	}

	
	public void setAlbum(List<Musica> NovoAlbum) {
		this.album = NovoAlbum;
	}
	
	public Musica getMusica(int faixa){
		return this.album.get(faixa);
	}
	
	
	
	
	
	// metodo adiciona musica ao album

} // fecha a classe album
