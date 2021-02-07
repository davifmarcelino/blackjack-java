package entidades;

public class Humano extends Jogador {
	

	public Humano() {
	}
	@Override
	public boolean decisao(Jogador humano, Baralho baralho) {
		System.out.println();
		System.out.println("Deseja comprar uma carta?(s ou n)");
		char resposta = Jogo.sc.next().charAt(0);
		if (resposta == 'S' || resposta == 's') {
			System.out.println();
			humano.saque(baralho);
			System.out.print("Sua mao : ");
			humano.imprimirmao();
			return true;
		} else {
			return false;
		}
	}
}
