package entidades;

public class Robo extends Jogador {

	public Robo() {
	}

	@Override
	public boolean decisao(Jogador robo, Baralho baralho) {
		if (Math.random() > 0.05) {
			if (getSoma() > 17) {
				imprimircartas();
				return false;// para de comprar
			} else {
				System.out.println();
				System.out.println("Robo sacou uma carta");
				robo.saque(baralho);
				imprimircartas();
				return true;// saca
			}
		} else {
			System.out.println();
			System.out.println("Robo sacou uma carta");
			robo.saque(baralho);
			imprimircartas();
			return true;// saca
		}
	}

	public void imprimircartas() {
		System.out.println();
		System.out.print("Cartas na mao do robo: ");
		for (Carta carta : getMao()) {
			System.out.print(" |XX| ");
		}
		System.out.println();
	}

}
