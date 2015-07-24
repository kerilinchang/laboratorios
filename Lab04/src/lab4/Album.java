/* 114111365 - Kerilin Laine Andrade Chang: LAB 4 - Turma 3 */

package lab4;

import java.util.ArrayList;
import java.util.List;

public class Album {
	
	private String artista;
	private String titulo;
	private int lancamento;
	private List<Musica> album;
	
	
	public Album(String artista, String titulo, int lancamento) throws Exception {
	
		if (artista.equals("") || artista == null){
			throw new Exception("O nome do artista nao pode ser vazio.");
		}
		
		if (titulo == null || titulo.equals("")){
			throw new Exception("o nome do album nao pode ser vazio.");
		}
		
		if (lancamento < 0){
			throw new Exception("o ano de lancamneto do album nao pode ser negativo.");
		}
		this.artista = artista;
		this.titulo = titulo;
		this.lancamento = lancamento;
		this.album = new ArrayList<Musica>();
		
	} // fecha o metodo album
	
	
	public boolean addMusica(Musica novaMusica) throws Exception{
		if (!album.contains(novaMusica)){
			album.add(novaMusica);
			return true;
		}
		return false;
	}

	public boolean removeMusica(Musica musica) throws Exception{
		if(album.contains(musica)){
			album.remove(musica);
			return true;
		}
		return false;
	}
	
	public int getDuracaoAlbum(){
		int duracaoAlbum = 0;
		for (int i = 0; i < album.size(); i++) {
			duracaoAlbum += album.get(i).getDuracao();
		}
		return duracaoAlbum;
	}
	
	public String getArtista(){
		return artista;
	}

	public String getTitulo(){
		return titulo;
	}

	public void setTitulo(String novoTitulo){
		this.titulo = novoTitulo;
	}
	
	public int getLancamento(){
		return lancamento;
	}
	
	public void setLancamento(
			int novoLancamento){
		this.lancamento = novoLancamento;
	}
	
	public List<Musica> getAlbum(){
		return album;
	}


	public void setArtista(String novoArtista){
		this.artista = novoArtista;
	}

	public Musica getMusica(int faixa){
		return this.album.get(faixa);
	}


	public void setAlbum(ArrayList<Musica> meuAlbum){
		this.album = meuAlbum;
	}
	
	// implementar o equals para verificar se um algum é igual a outro
	
	public boolean equals(Object objeto){
		if (!(objeto instanceof Album)){
			return false;	
		}
		
		Album novoAlbum = (Album) objeto;
		if (novoAlbum.getArtista().equals(this.artista) && novoAlbum.getTitulo().equals(this.titulo)){
			return true;
		}
		return false;
		
		// é o mesmo album se tiver o mesmo titulo e o mesmo artista
		
	} // fecha o equals
	
} // fecla a classe album
