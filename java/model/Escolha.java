package model;

public class Escolha {
	
	private int id_Escolha;
	private String data_Escolha;
	private String nome;
	private Aluno aluno;
	private Curso curso;

	public Escolha() {
	}

	public Escolha(int id_Escolha, String data_Escolha, String nome, Aluno aluno, Curso curso) {
		this.id_Escolha = id_Escolha;
		this.data_Escolha = data_Escolha;
		this.nome = nome;
		this.aluno = aluno;
		this.curso = curso;
	}


	public Escolha(String data_Escolha, String nome, Aluno aluno , Curso curso) {
		this.data_Escolha = data_Escolha;
		this.nome = nome;
		this.aluno = aluno;
		this.curso = curso;
	}

	public int getId() {
		return id_Escolha;
	}

	public void setId(int id_Escolha) {
		this.id_Escolha = id_Escolha;
	}

	public String getData_Escolha() {
		return data_Escolha;
	}

	public void setData_Escolha(String data_Escolha) {
		this.data_Escolha = data_Escolha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Escolha [id_Escolha=" + id_Escolha + ", data_Escolha=" + data_Escolha+ ", nome=" + nome + "]";
	}

	

	}