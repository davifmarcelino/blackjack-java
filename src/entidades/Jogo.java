package entidades;

import java.util.Scanner;

public class Jogo {

	public static Scanner sc = new Scanner(System.in);

	public static void inicio(Baralho baralho, Humano humano, Robo robo) {
		humano.resetar();
		robo.resetar();
		baralho.embaralhar();
		humano.saque(baralho);
		robo.saque(baralho);
		humano.saque(baralho);
		robo.saque(baralho);
	}

	public static Jogador comeca(Humano humano, Robo robo) {
		if (Math.random() < 0.5) {
			System.out.println("Voce começa!!!");
			return humano;

		} else {
			System.out.println("Robo começa!!!");
			return robo;
		}
	}

	public static void Jogar() {
		Baralho baralho = new Baralho(Baralho.criarBaralho());
		Humano humano = new Humano();
		Robo robo = new Robo();
		boolean deNovo = true;
		boolean primeira = true;

		while (deNovo) {
			boolean fim = true;
			boolean continuaH = true;
			boolean continuaR = true;
			if (Jogo.comeca(humano, robo) == humano) {
				Jogo.inicio(baralho, humano, robo);
				System.out.println();
				System.out.print("Sua mao : ");
				humano.imprimirmao();
				while (continuaH || continuaR) {
					if (continuaH) {
						continuaH = humano.decisao(humano, baralho);
					}
					if (humano.getSoma() > 21) {
						continuaH = false;
						continuaR = false;
					}
					if (continuaR) {
						continuaR = robo.decisao(robo, baralho);
					}

					if (humano.getSoma() > 21 || robo.getSoma() > 21) {
						continuaH = false;
						continuaR = false;
					}

				}
			} else {
				Jogo.inicio(baralho, humano, robo);
				System.out.println();
				System.out.print("Sua mao : ");
				humano.imprimirmao();
				while (continuaH || continuaR) {

					if (continuaR) {
						continuaR = robo.decisao(robo, baralho);
					}
					if (robo.getSoma() > 21) {
						continuaH = false;
						continuaR = false;
					}
					if (continuaH) {
						continuaH = humano.decisao(humano, baralho);
					}
					if (humano.getSoma() > 21 || robo.getSoma() > 21) {
						continuaH = false;
						continuaR = false;
					}

				}
			}

			System.out.println(Regras.ganhador(humano, robo));

			while (fim) {
				if (primeira)
					primeira = false;
				else {
					System.out.println();
					System.out.println("deseja jogar novamente? s ou n");
					char novo = sc.next().charAt(0);
					if (novo == 'S' || novo == 's') {
						fim = false;
						baralho.setBaralho(Baralho.criarBaralho());
						baralho.embaralhar();
						System.out.println("===========================");
					} else {
						deNovo = false;
						System.out.println();
						System.out.println("===========================");
						System.out.println("Placar: Humano " + humano.getPontos() + " : " + robo.getPontos());
						fim = false;
					}
				}
			}
		}
	}
}