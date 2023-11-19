package model;

public class Vaga {
	private int id_Vaga;
	private String data_Vaga;
	private String nome;

	public Vaga(int id_Vaga, String data_Vaga, String nome) {
		this.id_Vaga = id_Vaga;
		this.data_Vaga = data_Vaga;
		this.nome = nome;
		
	}

	public Vaga(String data_Vaga, String nome) {
		this.data_Vaga = data_Vaga;
		this.nome = nome;
		
	}

	public Vaga() {

	}

	public int getId_Vaga() {
		return id_Vaga;
	}

	public void setId_Vaga(int id_Vaga) {
		this.id_Vaga = id_Vaga;
	}

	public String getdata_Vaga() {
		return data_Vaga;
	}

	public void setdata_Vaga(String data_Vaga) {
		this.data_Vaga = data_Vaga;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	
	}

	@Override
	public String toString() {
		return "Vaga [id_Vaga=" + id_Vaga + ", data_Vaga=" + data_Vaga + ", nome=" + nome + "]";
	}

}
