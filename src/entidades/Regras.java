package entidades;

public class Regras {

	public static int pesoCarta(Carta carta) {
		int peso;
		if (carta.getValor() == "Q" || carta.getValor() == "J" || carta.getValor() == "K") {
			peso = 10;
		} else if (carta.getValor() == "A") {
			peso = 1;
		} else {
			peso = Integer.parseInt(carta.getValor());
		}
		return peso;
	}

	public static String ganhador(Humano humano, Robo robo) {
		if (humano.getSoma() > robo.getSoma() && humano.getSoma()<=21 || robo.getSoma() > 22) {
			humano.pontou();
			System.out.println();
			System.out.print("Mao do robo : ");
			robo.imprimirmao();
			System.out.println();
			return "Voce ganhou";
		} else if (humano.getSoma() == 21 && robo.getSoma() ==  21) {
			System.out.println();
			System.out.print("Mao do robo : ");
			robo.imprimirmao();
			System.out.println();
			return "Empate";
		} else {
			robo.pontou();
			System.out.println();
			System.out.print("Mao do robo : ");
			robo.imprimirmao();
			System.out.println();
			return "Robo ganhou";
		}
	}
	
}
