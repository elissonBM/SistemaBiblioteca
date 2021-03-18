package model;

/**
 * Classe para atribuir os atributos e metodos ao objeto editora
 * @author Elisson Barbieri Machado
 * @since 18 de fev. de 2021
 */
public class Editora {
	
	//construtor
	public Editora() {
	} 
	
	//declarando atributos
	private int codigo;
	private String nome;
	private String pais;
	
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	

}
