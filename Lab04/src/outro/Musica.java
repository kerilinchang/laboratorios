package outro;

import java.util.List;

public class Musica {
	
	private String nome;
	private int duracao;
	private String tipo;
	
	
	public Musica(String titulo, int duracao, String tipo)  throws Exception{
		
		/*if ((nome.equals(null) || nome.equals("")) && (tipo.equals(null) || tipo.equals(""))){
			throw new Exception ("O nome da musica e do genero nao podem serem vazias.");
		}*/
		
		
		if(nome.equals(null) || nome.equals("")){
			throw new Exception ("Titulo da musica nao pode ser vazio.");
		}
		
		if(duracao < 0){
			throw new Exception ("Duracao da musica nao pode ser negativa.");
		}
		
		if (tipo.equals(null) || tipo.equals("")){
			throw new Exception ("Genero da musica nao pode ser vazio.");
		}
		
		
		
		
		this.nome = titulo;
		this.duracao = duracao;
		this.tipo = tipo;
	} // fecha o contrutor
	
	
	
	
	
	
	
	
	public String getNome(){
		return this.nome = nome;
	}
	
	public void setNome(String novoNome){
		this.nome = novoNome;
	}


	public int getDuracao() {
		return duracao;
	}


	public void setDuracao(int Novaduracao) {
		this.duracao = Novaduracao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setGenero(String NovoTipo) {
		this.tipo = NovoTipo;
	}
	
	
	public boolean equals(Object objeto){
		if(!(objeto instanceof Musica)){
			return false;
		}
		
		Musica novaMusica = (Musica) objeto;
		if(novaMusica.getNome().equals(this.getNome()) && novaMusica.getDuracao() == this.getDuracao()){
			return true;
		}
		return false;
	} // fecha o metodo equals


	
	
	

} // fecha a classe Musica
