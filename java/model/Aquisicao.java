package model;

public class Aquisicao {
	
	private int id_Aquisicao;
	private String data_Aquisicao;
	private String nome;
	private Aluno aluno;
	private Evento evento;

	public Aquisicao() {
	}

	public Aquisicao(int id_Aquisicao, String data_Aquisicao, String nome, Aluno aluno, Evento evento) {
		this.id_Aquisicao = id_Aquisicao;
		this.data_Aquisicao = data_Aquisicao;
		this.nome = nome;
		this.aluno = aluno;
		this.evento = evento;
	}


	public Aquisicao(String data_Aquisicao, String nome, Aluno aluno, Evento evento) {
		this.data_Aquisicao = data_Aquisicao;
		this.nome = nome;
		this.aluno = aluno;
		this.evento = evento;
	}

		public int getId_Aquisicao() {
		return id_Aquisicao;
	}

	public void setId_Aquisicao(int id_Aquisicao) {
		this.id_Aquisicao = id_Aquisicao;
	}

	public String getdata_Aquisicao() {
		return data_Aquisicao;
	}

	public void setdata_Aquisicao(String data_Aquisicao) {
		this.data_Aquisicao = data_Aquisicao;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Aquisicao [id_Aquisicao=" + id_Aquisicao + ", data_Aquisicao=" + data_Aquisicao+ ", nome=" + nome + ",  id_Curso=";
	}

	}

	

	