package model.vo;

public class VoPesquisa {
	private String titulo;
	private String autor;
	private int aInicio;
	private int aFim;

	public VoPesquisa() {
	}
	
	
	public VoPesquisa(String titulo, String autor, String aInicio, String aFim) {
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setaInicio(aInicio);
		this.setaFim(aFim);	
				}
	
	
	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo.equals("")) { this.titulo = "NULL";}
		else this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if(autor.equals("")) { this.autor = "NULL";}
		else this.autor = autor;
	}

	public int getaInicio() {
		return aInicio;
	}

	public void setaInicio(String aInicio) {
		if(aInicio.equals("")) { this.aInicio = 0;}
		else this.aInicio = Integer.valueOf(aInicio);
	}
	public void setaInicio(int aInicio) {
		this.aInicio = aInicio;
	}

	public int getaFim() {
		return aFim;
	}

	public void setaFim(String aFim) {
		if(aFim.equals("")) { this.aFim = 9999;}
		else this.aFim = Integer.valueOf(aFim);
	}
	public void setaFim(int aFim) {
		this.aFim = aInicio;
	}


	}
	
	
