package bibliotecaLibrosRevistas;

public class Libros extends Materiales implements Prestable{
	boolean prestado; 

	public Libros(){}

	public Libros(int isbn, String titulo, int añoPublicacion,boolean prestado){
		super(isbn, titulo, añoPublicacion);
		this.prestado=false;
	}


	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Prestado.......:").append(this.isPrestado()).append("\n");
		return sb.toString();
	}

	@Override
	public void prestar() {
		prestado=true;
	}

	@Override
	public void devolver() {
		prestado=false;
	}

	@Override
	public boolean prestado() {
		return prestado;
	}

}
