
public class Arma {

	private String categoria;
	private int constanteDano;

	public Arma(String categoria, int constanteDano) {
		this.categoria = categoria;
		this.constanteDano = constanteDano;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getConstanteDano() {
		return constanteDano;

	}
}
