package model;


public class Inscricao {

		   private int id_Inscricao;
		   private String data_Inscricao;
		   private String nome;
		   private Aluno aluno;
		   private Vaga vaga;
		  
		   
		public Inscricao() {
		}
		public Inscricao(int id_Inscricao, String data_Inscricao, String nome, Aluno aluno, Vaga vaga) {
			
			this.id_Inscricao = id_Inscricao;
			this.data_Inscricao = data_Inscricao;
			this.nome = nome;
			this.aluno = aluno;
			this.vaga = vaga;
		}
				
		public Inscricao(String data_Inscricao, String nome, Aluno aluno, Vaga vaga) {
			super();
			this.data_Inscricao = data_Inscricao;
			this.nome = nome;
			this.aluno = aluno;
			this.vaga = vaga;
		}
		public int getId_Inscricao() {
			return id_Inscricao;
			
		}
		public void setId_Inscricao(int id_Inscricao) {
			this.id_Inscricao = id_Inscricao;
		}
		public String getData_Inscricao() {
			return data_Inscricao;
		}
		public void setData_Inscricao(String data_Inscricao) {
			this.data_Inscricao = data_Inscricao;
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
		public Vaga getvaga() {
			return vaga;
		}
		public void setVaga(Vaga vaga) {
			this.vaga = vaga;
		}
		public int getid_Inscricao() {
			return id_Inscricao;
		}
		@Override
		public String toString() {
			return "Inscricao [id_Inscricao=" + id_Inscricao + ", data_Inscricao=" + data_Inscricao + ", nome=" + nome
					+ ", aluno=" + aluno + ", vaga=" + vaga + "]";
		}
		
			
		}
	  


		   
			  
