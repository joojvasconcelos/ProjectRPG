import java.util.Random;
import java.util.Scanner;

public class Player {

	private String nome;
	int pv;
	private int forca;
	private int constituicao;
	private int agilidade;
	private int destreza;
	Arma arma;
	Armadura armadura;
	boolean defesaDobrada;

	public void Personagem(String nome) {
		this.nome = nome;
		this.forca = 0;
		this.constituicao = 0;
		this.agilidade = 0;
		this.destreza = 0;
		this.pv = 0;
	}

	Scanner sc = new Scanner(System.in);

	public void distribuirPontos(int pontos) {

		while (pontos > 0) {
			System.out.println("Pontos disponíveis: " + pontos);
			System.out.println("1. Adicionar pontos em Força=" + forca);
			System.out.println("2. Adicionar pontos em Constituição=" + constituicao);
			System.out.println("3. Adicionar pontos em Agilidade="+ agilidade);
			System.out.println("4. Adicionar pontos em Destreza="+ destreza);

			int escolha = sc.nextInt();
			int pontosEscolhidos;

			
			switch (escolha) {
			case 1:
				System.out.print("Digite a quantidade de pontos de Força a adicionar: ");
				pontosEscolhidos = sc.nextInt();
				if (pontosEscolhidos > pontos || pontosEscolhidos < 0) {
					System.out.println("Quantidade de pontos inválida.");
					continue;
				}				
				forca += pontosEscolhidos;
				pontos -= pontosEscolhidos;
				break;
			case 2:
				System.out.print("Digite a quantidade de pontos de Constituição a adicionar: ");
				pontosEscolhidos = sc.nextInt();
				if (pontosEscolhidos > pontos || pontosEscolhidos < 0) {
					System.out.println("Quantidade de pontos inválida.");
					continue;
				}
				constituicao += pontosEscolhidos;
				pontos -= pontosEscolhidos;
				break;
			case 3:
				System.out.print("Digite a quantidade de pontos de Agilidade a adicionar: ");
				pontosEscolhidos = sc.nextInt();
				if (pontosEscolhidos > pontos || pontosEscolhidos < 0) {
					System.out.println("Quantidade de pontos inválida.");
					continue;
				}
				agilidade += pontosEscolhidos;
				pontos -= pontosEscolhidos;
				break;
			case 4:
				System.out.print("Digite a quantidade de pontos de Destreza a adicionar: ");
				pontosEscolhidos = sc.nextInt();
				if (pontosEscolhidos > pontos || pontosEscolhidos < 0) {
					System.out.println("Quantidade de pontos inválida.");
					continue;
				}
				destreza += pontosEscolhidos;
				pontos -= pontosEscolhidos;
				break;
			default:
				System.out.println("Escolha inválida.");
			}
		}

		pv = rolarD6() + rolarD6() + rolarD6() + constituicao;
	}

	private static int rolarD6() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

	public void equiparArma(Arma arma) {
		this.arma = arma;
	}

	public void equiparArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

	public int calcularDano() {
		if (arma.getCategoria().equals("pesada")) {
			int constanteDano = arma.getConstanteDano();
			return rolarD12() + (int) (1.5 * forca) + constanteDano;
		} else {
			int constanteDano = arma.getConstanteDano();
			return rolarD6() + rolarD6() + rolarD4() + destreza + constanteDano;
		}
	}

	private int rolarD12() {
		Random random = new Random();
		return random.nextInt(12) + 1;
	}

	private int rolarD4() {
		Random random = new Random();
		return random.nextInt(4) + 1;
	}

	public int calcularDefesa() {
		int constanteDefesa = armadura.getConstanteDefesa();
		return (int) (1.5 * constituicao) + constanteDefesa;
	}

	public int getPV() {
		return pv;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public int getForca() {
		return forca;
	}

	public int getConstituicao() {
		return constituicao;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
