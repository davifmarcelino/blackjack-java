package entidades;

public class Carta {
	
	private String nipe;
	private String valor;
	
	public Carta(String nipe, String valor) {
		this.nipe = nipe;
		this.valor = valor;
	}
	public String getNipe() {
		return nipe;
	}
	public void setNipe(String nipe) {
		this.nipe = nipe;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Carta [nipe=" + nipe + ", valor=" + valor + "]";
	}
	
	
}
