package Prog3;

 /* 114111365 - Kerilin Laine Andrade Chang: LAB 3 - Turma 3 */

import java.util.Scanner;

public class EconomizaP2 {

	private int quant_vendas;
	private float preco_produto;
	private float preco_arrecadado;
	private Produto[] listaDeProdutos = new Produto[2];
	private int indexDoProdutoAtual = 0;
	private Scanner entrada = new Scanner(System.in);

	public void addProduto() {

		String nome = entradaNome();
		System.out.print("Digite o preco uniturio do Produto: ");
		double preco = entrada.nextDouble();
		entrada.nextLine();
		System.out.print("Digite o tipo do produto: ");
		String tipo = entrada.next();
		System.out.print("Digite a quantidade no estoque: ");
		int quantidade = entrada.nextInt();
		entrada.nextLine();

		Produto produto = new Produto(nome, preco, tipo, quantidade);
		cadastrarProduto(produto);

		System.out.println(quantidade + " " + nome + "(s)"
				+ " cadastrado com sucesso.\n");
	}

	public String entradaNome() {
		System.out.print("Digite o nome do produto: ");// quebra de linha aqui
		String nome = entrada.nextLine();
		return nome;
	}
	

	public void cadastrarProduto(Produto produto) {
		if (listaEstaCheia() == true) {
			dobraLista();
		}
		adicionaProdutoNaLista(produto);
	}

	public void adicionaProdutoNaLista(Produto produto) {
		listaDeProdutos[indexDoProdutoAtual] = produto;
		indexDoProdutoAtual++;
	}

	public void venderProduto() {
		String entrada_produto = entradaNome();
		Produto meuProduto = pesquisarProduto(entrada_produto);
		
		if (meuProduto != null) {
			System.out.println(meuProduto.getName() + "("
					+ meuProduto.getTipo() + "). R$" + meuProduto.getPreco());
			System.out.println("\nDigite a quantidade que deseja vender: ");
			quant_vendas = entrada.nextInt();
			entrada.nextLine();
			verificaQuantidadeProduto(entrada_produto, meuProduto);
		} else {
			System.out.println("==>" + entrada_produto + " nao cadastrado no sistema.");
		}
		System.out.println("Deseja vender outro produto? ");

	}

	public void verificaQuantidadeProduto(String entrada_produto,
			Produto meuProduto) {
		if (quant_vendas > meuProduto.getQuantidade()) {
			System.out.println("Nao e possivel vender pois nao ha "
					+ entrada_produto + " suficiente.");
		} else {
			preco_produto = (float) (meuProduto.getPreco() * quant_vendas);
			preco_arrecadado += preco_produto;
			meuProduto.setQuantidade(quant_vendas);

			System.out.println("==> Total arrecadado: R$ " + preco_produto);
		}
	}

	public Produto pesquisarProduto(String nomeProduto) {

		for (int i = 0; i < indexDoProdutoAtual; i++) { // alterei aqui listaDeProdutos.length
			if (listaDeProdutos[i].getName().equals(nomeProduto)) { 
				return listaDeProdutos[i];
			}
		}
		return null;
	}

	public void imprimeBalanco() {
		System.out.println("==== Impressao de Balanco ====\n"
				+ "Produtos cadastrados:\n");

		int contador = 1;
		float pode_arrecadar = 0;
		for (int i = 0; i < indexDoProdutoAtual ; i++) { // listaDeProdutos.length 
			System.out.println(contador + ") " + listaDeProdutos[i].getName()
					+ "(" + listaDeProdutos[i].getTipo() + "). " + "R$ "
					+ listaDeProdutos[i].getPreco() + " Restante: "
					+ (listaDeProdutos[i].getQuantidade()));
			contador++;
			pode_arrecadar += listaDeProdutos[i].getPreco()
					* (listaDeProdutos[i].getQuantidade());
		}

		mostraArrecadacao(pode_arrecadar);

	}

	public void mostraArrecadacao(float pode_arrecadar) {
		System.out.println("\nTotal arrecadado em vendas: " + "R$ "
				+ preco_arrecadado + "\n");
		System.out.println("Total que pode ser arrecadado: R$ "
				+ pode_arrecadar);
	}

	
	public void dobraLista() {
		Produto[] novoArray = new Produto[(listaDeProdutos.length) * 2];
		for (int i = 0; i < listaDeProdutos.length; i++) {
			novoArray[i] = listaDeProdutos[i];
		}
		listaDeProdutos = novoArray;
	}

	public boolean listaEstaCheia() {
		return indexDoProdutoAtual == listaDeProdutos.length;
	}

	public int getQuantidadeDeProdutos() {
		return indexDoProdutoAtual;
	}
}
