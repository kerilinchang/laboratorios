/* 114111365 - Kerilin Laine Andrade Chang: LAB 4 - Turma 3 */

package lab4;

public class Musica {
	
	private String nome;
	private int duracao;
	private String tipo;

	
	public Musica(String nome, int duracao, String tipo) throws Exception{
		//criar as exessões para os erros
		
		if (nome.equals(null) || nome.equals("")){
			//colocar aqui a exeção
			throw new Exception ("Titulo da musica nao pode ser vazio.");
		}
		if (duracao < 0){
			throw new Exception ("Duracao da musica nao pode ser negativa.");
		}

		if (tipo.equals(null) || tipo.equals("")){
			throw new Exception ("Genero da musica nao pode ser vazio.");
		}
		
		this.nome = nome;
		this.duracao = duracao;
		this.tipo = tipo;
		
	} // fecha musica
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	
	public int getDuracao(){
		return duracao;
	}
	
	public void setDuracao(int novaDuracao){
		this.duracao = novaDuracao;
	}

	public String getTipo(){
		return tipo;
	}

	public void setTipo(String novoTipo){
		this.tipo = novoTipo;
	}

	// tem que implementar o equals para verificar se um objeto é igual a  outro
	
	public boolean equals(Object objeto){
		if (!(objeto instanceof Musica)){
			return false;
		}
		Musica novaMusica = (Musica) objeto;
		if (novaMusica.getNome().equals(this.getNome()) && novaMusica.getDuracao() == (this.getDuracao()) ){
			return true;
		}
		return false;
	}

} // fecha a classe musica