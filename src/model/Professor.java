
package model;

public class Professor {
	
	private int idProfessor;
	private String nome;
	private String nomemae;
	private String datanasc;
	private int titulacao;
	
	

	public Professor(int idProfessor, String nome, String nomemae, String datanasc, int titulacao) {
		super();
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.nomemae = nomemae;
		this.datanasc = datanasc;
		this.titulacao = titulacao;
	}
	
	
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomemae() {
		return nomemae;
	}
	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}
	public String getDatanasc() {
		return datanasc;
	}
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	public int getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(int titulacao) {
		this.titulacao = titulacao;
	}
	
	
	
	
	

}
