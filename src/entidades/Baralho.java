package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {

	private List<Carta> baralho;

	public Baralho(List<Carta> baralho) {
		this.baralho = baralho;
	}

	public List<Carta> getBaralho() {
		return baralho;
	}

	public void setBaralho(List<Carta> baralho) {
		this.baralho = baralho;
	}

	
	public static List<Carta> criarBaralho() {
		String[] nipes = new String[]{"♠", "♣", "♥", "♦"};
		String[] valores = new String[]{"A","2","3","4","5","6","7","8","9","10","Q","J","K"};
		List<Carta> criar =  new ArrayList<>();
		for(String nipe : nipes) {
			for(String valor: valores) {
				criar.add(new Carta(nipe, valor));
			}
		}
		return criar;
	}
	
	public void embaralhar() {
		Collections.shuffle(baralho);
	}
	
	public Carta saqueTopo() {
		Carta sacada = baralho.get(0);
		baralho.remove(0);
		return sacada;
	}
		
}
