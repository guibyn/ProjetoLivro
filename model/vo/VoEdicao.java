package model.vo;

public class VoEdicao {
	int idLivro;
	int ano;
	int edicao;

	public VoEdicao() {
		
	}
	
	public VoEdicao(int idlivro, int ano, int edicao) {
		this.idLivro = idlivro;
		this.ano = ano;
		this.edicao = edicao;
	}
	
	
	

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdlLivro(int idlivro) {
		this.idLivro = idlivro;
		
	}
	
	public void serIdLivro(String idLivro) {	
		this.idLivro = Integer.valueOf(idLivro);
	}
	

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void setAno(String ano) {
		this.ano = Integer.valueOf(ano);
	}
	
	
	
	public int getEdicao() {
		return edicao;
		//edit
	}

	public void setEdicao(String edicao) {
		this.edicao = Integer.valueOf(edicao);
	}

	
	
	
	
	
}
