package model.vo;

public class VoAutor implements I_Vo {
	int id;
	String nome;
	
	
	//getters setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getnome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
