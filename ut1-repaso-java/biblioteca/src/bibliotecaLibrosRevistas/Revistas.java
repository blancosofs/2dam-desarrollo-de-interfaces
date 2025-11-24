package bibliotecaLibrosRevistas;

public class Revistas extends Materiales{

	protected int numero;
	
	public Revistas() {}
	
	public Revistas(int isbn, String titulo, int añoPublicacion, int numero) {
		super(isbn, titulo, añoPublicacion);
		this.numero=numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Numero.......:").append(this.getNumero()).append("\n");
		return sb.toString();
	}
}
