package entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Jogador {

	private List<Carta> mao = new ArrayList<>();
	private Integer soma;
	private int pontos;

	public Jogador() {
		this.soma = 0;
		this.pontos = 0;
	}

	public List<Carta> getMao() {
		return mao;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public void setMao(List<Carta> mao) {
		this.mao = mao;
	}

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}

	public void saque(Baralho baralho) {
		Carta carta = baralho.saqueTopo();
		mao.add(carta);
		soma += Regras.pesoCarta(carta);
	}

	public abstract boolean decisao(Jogador robo, Baralho baralho);
	
	public void pontou() {
		pontos++;
	}
	
	public void resetar() {
		mao.clear();
		soma=0;
	}
	
	public void imprimirmao() {
		for(Carta carta:mao) {
			System.out.print(" |"+carta.getNipe()+carta.getValor()+"| ");
		}
		System.out.println();
		System.out.println("valor total na mao: "+soma);
	}

}
