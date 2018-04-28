package model;

public class Disciplina {
	
	private int iddisciplina;
	private int idProfessor;
	private String nome;
	private String curso;
	private int cargahoraria;
	
	
	
	
	
	public Disciplina(int iddisciplina, int idProfessor, String nome, String curso, int cargahoraria) {
		super();
		this.iddisciplina = iddisciplina;
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.curso = curso;
		this.cargahoraria = cargahoraria;
	}
	
	
	
	public int getIddisciplina() {
		return iddisciplina;
	}
	public void setIddisciplina(int iddisciplina) {
		this.iddisciplina = iddisciplina;
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
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getCargahoraria() {
		return cargahoraria;
	}
	public void setCargahoraria(int cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	
	

}
