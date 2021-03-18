package model;


/**
 * Classe para atribuir os atributos e metodos ao objeto locação
 * @author Elisson Barbieri Machado
 * @since 18 de fev. de 2021
 */
public class Locacao {
	
	//construtor
	public Locacao() {
		// TODO Auto-generated constructor stub
	}
	private int codigo;
	private Data dataLocacao;
	private Data dataDevolucao;
	private Usuario usuario;
	private Livro livros[];
	
	//getters e setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Data getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Data dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Data getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Data dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro[] getLivros() {
		return livros;
	}
	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}


}
