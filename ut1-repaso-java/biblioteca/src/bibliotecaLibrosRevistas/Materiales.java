package bibliotecaLibrosRevistas;

public abstract class Materiales {
	protected int isbn;
	protected String titulo;
	protected int añoPublicacion;

	public Materiales() {}

	public Materiales(int isbn, String titulo, int añoPublicacion) {
		this.isbn=isbn;
		this.titulo=titulo;
		this.añoPublicacion=añoPublicacion;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int codigo) {
		this.isbn = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ISBN...........:").append(this.getIsbn()).append("\n");
		sb.append("Titulo.........:").append(this.getTitulo()).append("\n");
		sb.append("Publicación....:").append(this.getAñoPublicacion()).append("\n");
		return sb.toString();
	}


}
