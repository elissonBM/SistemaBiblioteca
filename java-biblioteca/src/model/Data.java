package model;

/**
 * Classe para armazenar os atributos do objeto data
 * 
 * @author Elisson Barbieri Machado
 * @since 18 de fev. de 2021
 */
public class Data {

	public Data() {

	}

	// declarando os atributos
	private int dia;
	private int mes;
	private int ano;

	// getters e setters
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		// retorna a data formatada
		return dia + "/" + mes + "/" + ano;
	}
}
