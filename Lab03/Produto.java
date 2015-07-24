/* 114111365 - Kerilin Laine Andrade Chang: LAB 3 - Turma 3 */

public class Produto {
	
	private String nome;
	private double preco;
	private String tipo;
	private int quantidade;

	public Produto(String nome, double preco, String tipo, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidade = quantidade;
	}
	

	public String getName(){
		return this.nome;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	
	public int getQuantidade(){
		return this.quantidade;
	}
	
	public void setName(String novoNome){
		this.nome = novoNome;
	}
	
	public void setPreco(double novoPreco){
		this.preco = novoPreco;
	}
	
	public  void setTipo(String novoTipo){
		this.tipo = novoTipo;
	}
	
	public void setQuantidade(int novaQuantidade){
		this.quantidade = quantidade - novaQuantidade;
	}
	
	
}
