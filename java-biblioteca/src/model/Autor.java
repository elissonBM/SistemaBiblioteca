package model;

/**
 * Classe para atribuir os atributos ao autor
 * @author Elisson Barbieri Machado
 * @since 18 de fev. de 2021
 */
public class Autor {
	
	//construtor	
	public Autor() {
		
	}
	
	//declarando os atributos
	private int codigo;
	private String nome;
	private String nacionalidade;
	
	//getters e setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	
}
