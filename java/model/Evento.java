package model;

public class Evento {

    //atributos
	private int id_Evento;
	private String nome;
	private String data_Evento;
	
	
	//construtor
	public Evento () {
	}

	public Evento(int id_Evento, String nome, String data_Evento) {
		this.id_Evento = id_Evento;
		this.nome = nome;
		this.data_Evento = data_Evento;
		
	}

	public  Evento(String nome, String email, String data_Evento) {
		this.nome = nome;
		this.data_Evento = data_Evento;
		
	}
	

	//getters e setters	
	public int getId_Evento() {
		return id_Evento;
	}

	public void setId_Evento(int id_Evento) {
		this.id_Evento = id_Evento;
	}
	
	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}
	
	public String getdata_Evento() {
		return data_Evento;
	}

	public void setdata_Evento(String data_Evento) {
		this.data_Evento = data_Evento;
	}

	

	//toString
	
	@Override
	public String toString() {
		return "Evento [id_Evento=" + id_Evento + ", nome=" + nome + ", data_Evento=" + data_Evento + "]";
	}

	public void mostrar1() {
		// TODO Auto-generated method stub
		
	}

	public void mostrar11() {
		// TODO Auto-generated method stub
		
	}

	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	
		
}
