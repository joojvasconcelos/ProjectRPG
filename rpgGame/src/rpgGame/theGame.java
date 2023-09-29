import java.util.Random;
import java.util.Scanner;

public class theGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcao;
		Player personagem = null;
		Porcao pocao = new Porcao(3);
		int nivelJogador = 0;

		do {
			System.out.println("______________________");
			System.out.println("1. Começar Jogo");
			System.out.println("2. História Principal");
			System.out.println("3. Fechar Jogo");
			System.out.println("______________________");
			System.out.println("Opção: ");

			opcao = sc.nextInt();
			
			limparTela.limpaConsole();

			switch (opcao) {
			case 1:
				System.out.println("Você Selecionou Começar Jogo.");
				nivelJogador = 0;
				personagem = criarPersonagem();
				while (personagem.getPV() > 0) {
					Enemy adversario = gerarAdversarioAleatorio(nivelJogador);
					combate(personagem, adversario, pocao);
					if (personagem.getPV() <= 0) {
						System.out.println("Você morreu! O jogo acabou.");
						break;
					} else {
						nivelJogador++;
					}
					if (nivelJogador == 1 && personagem.getPV() > 0) {
						System.out.println("Você subiu de nível!");
						System.out.println("Você recebeu 5 pontos de atributo adicionais.");
						personagem.distribuirPontos(5);
						System.out.println("Escolha uma nova arma:");
						Arma novaArma = escolherArma(nivelJogador);
						personagem.equiparArma(novaArma);
					} else if (nivelJogador == 2 && personagem.getPV() > 0) {
						System.out.println("Você subiu de nível!");
						System.out.println("Você recebeu 10 pontos de atributo adicionais.");
						personagem.distribuirPontos(10);
						System.out.println("Escolha uma nova armadura:");
						Armadura novaArmadura = escolherArmadura(nivelJogador);
						personagem.equiparArmadura(novaArmadura);

					} else if (nivelJogador == 3 && personagem.getPV() > 0) {
						System.out.println("Você venceu o jogo! Parabéns!\n");
						break;
					}
				}
				personagem = null;
				break;
			case 2:
				System.out.println("Você Selecionou História Principal.");
				historiaPrincipal();
				break;
			case 3:
				System.out.println("Você Selecionou Fechar Jogo.");
				break;
			default:
				System.out.println("Opção inválida.");
			}
		} while (opcao != 3);
	}

	private static Player criarPersonagem() {
		Scanner scanner = new Scanner(System.in);
		Player personagem = new Player();
		System.out.print("Digite o nome do seu personagem: ");
		String nome = scanner.nextLine();
		personagem.setNome(nome);

		
		
		limparTela.limpaConsole();

		System.out.println("Distribua 15 pontos nos atributos:");
		personagem.distribuirPontos(15);

		System.out.println("Escolha uma arma inicial:");
		Arma armaInicial = escolherArma(0);
		personagem.equiparArma(armaInicial);

		System.out.println("Escolha uma armadura inicial:");
		Armadura armaduraInicial = escolherArmadura(0);
		personagem.equiparArmadura(armaduraInicial);

		System.out.println("Personagem criado com sucesso!");
		System.out.println("Nome: " + personagem.getNome());
		System.out.println("Pontos de Vida (PV): " + personagem.getPV());
		System.out.println("Força: " + personagem.getForca());
		System.out.println("Constituição: " + personagem.getConstituicao());
		System.out.println("Agilidade: " + personagem.getAgilidade());
		System.out.println("Destreza: " + personagem.getDestreza());
		System.out.println("Arma Equipada: " + personagem.arma.getCategoria());
		System.out.println("Dano da Arma Equipada: " + personagem.calcularDano());
		System.out.println("Armadura Equipada: Defesa " + personagem.calcularDefesa());
		

		return personagem;
	}

	private static Arma escolherArma(int nivel) {
		Scanner sc = new Scanner(System.in);

		if (nivel == 0) {

			System.out.println("Escolha uma arma:");
			System.out.println("1. Arma Pesada (Dano: 5)");
			System.out.println("2. Arma Media (Dano: 4)");
			System.out.println("3. Arma Leve (Dano: 3)");

			int escolha = sc.nextInt();

			switch (escolha) {
			case 1:
				return new Arma("pesada", 5);
			case 2:
				return new Arma("media", 4);
			case 3:
				return new Arma("leve", 3);
			default:
				System.out.println("Opção inválida, a arma pesada foi escolhida por padrão.");
				return new Arma("pesada", 5);
			}
		}

		if (nivel == 1) {

			System.out.println("Escolha uma arma:");
			System.out.println("1. Arma Celestial (Dano: 9)");
			System.out.println("2. Arma do Poder (Dano: 7)");
			System.out.println("3. Arma de ferro (Dano: 5)");

			int escolha2 = sc.nextInt();

			switch (escolha2) {
			case 1:
				return new Arma("pesada", 9);
			case 2:
				return new Arma("media", 7);
			case 3:
				return new Arma("leve", 5);
			default:
				System.out.println("Opção inválida, a arma pesada foi escolhida por padrão.");
				return new Arma("pesada", 9);
			}
		}

		return null;
	}

	private static Armadura escolherArmadura(int nivel) {
		Scanner sc = new Scanner(System.in);

		if (nivel == 0) {

			System.out.println("Escolha uma armadura:");
			System.out.println("1. Armadura Leve (Defesa: 3)");
			System.out.println("2. Armadura Média (Defesa: 4)");
			System.out.println("3. Armadura Pesada (Defesa: 5)");

			int escolha = sc.nextInt();

			switch (escolha) {
			case 1:
				return new Armadura(3);
			case 2:
				return new Armadura(4);
			case 3:
				return new Armadura(5);
			default:
				System.out.println("Opção inválida, a armadura leve foi escolhida por padrão.");
				return new Armadura(3);
			}
		}

		if (nivel == 2) {

			System.out.println("Escolha uma armadura:");
			System.out.println("1. Armadura de bronze (Defesa: 7)");
			System.out.println("2. Armadura de ferro (Defesa: 8)");
			System.out.println("3. Armadura de diamante (Defesa: 9)");

			int escolha2 = sc.nextInt();

			switch (escolha2) {
			case 1:
				return new Armadura(7);
			case 2:
				return new Armadura(8);
			case 3:
				return new Armadura(9);
			default:
				System.out.println("Opção inválida, a armadura leve foi escolhida por padrão.");
				return new Armadura(7);
			}
		}
		return null;
	}

	private static void historiaPrincipal() {
		System.out.println("Em uma simples cidade, uma mansão guarda um segredo, um misterioso assassinato é o maior misterio cidade, ");
		System.out.println("quem poderia ser tão cruel de destruir asssim uma familia? E como este local ainda aparenta ter vida?");
		System.out.println("você é um detetive que busca entender os mistérios desta mansão, porquê ela é tão perigosa? o que aconteceu? ");
		System.out.println("você se pergunta antes de entrar neste local...");
		System.out.println("você resolve entrar pela porta principal, a entrada tem uma escada cde pedras coberta de limo e folhas secas,");
		System.out.println("observando a porta pode notar que ela está arrombada, andando você ascende sua lanterna e vê o lugar revirado,");
		System.out.println("até então tudo normal você começa a notar manchas vermelhas pelo chão, logo a frente com um odor insuportavel,");
		System.out.println("existe uma pilha de ossos e alguns corpos em decomposição, o lugar não é seguro e você descide pegar equipamentos");
		System.out.println("que estavam pelo chão... bem vindo a devil's house...");
		System.out.println("Pressione Enter para continuar...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}

	private static Porcao pocoesDisponiveis() {

		return new Porcao(3);
	}

	private static Enemy gerarAdversarioAleatorio(int nivel) {

		Random random = new Random();
		int escolha = random.nextInt(3);
		int escolha2 = random.nextInt(2);
		int escolha3 = random.nextInt(1);

		if (nivel == 0) {

			return switch (escolha) {
			case 0 -> new Enemy("Bartolomeu", 40, 16, 3, 2);
			case 1 -> new Enemy("Severo", 30, 12, 2, 3);
			case 2 -> new Enemy("Grap", 50, 20, 4, 1);
			default -> new Enemy("Fu", 25, 14, 3, 2);
			};

		}

		if (nivel == 1) {

			return switch (escolha2) {
			case 0 -> new Enemy("Sósia do Neymar", 60, 16, 5, 4);
			case 1 -> new Enemy("Messi Autista", 70, 15, 14, 3);
			default -> new Enemy("Penaldo", 25, 14, 3, 2);
			};

		}

		if (nivel == 2) {

			return switch (escolha3) {
			case 0 -> new Enemy("Gol D. Cu", 90, 40, 12, 10);
			default -> new Enemy("Gol D. Cu", 90, 40, 12, 10);
			};

		}
		return null;

	}

	private static void combate(Player personagem, Enemy adversario, Porcao Pocao) {
		System.out.println("\nIniciando combate contra " + adversario.getNome() + "!");
		Scanner scanner = new Scanner(System.in);
		int rodada = 1;

		while (true) {
			System.out.println("Rodada " + rodada + "\n");
			int agilidadeJogador = personagem.getAgilidade();
			int agilidadeAdversario = adversario.getAgilidade();
			int pocoesDisponiveis = Pocao.pocoesDisponiveis;

			if (agilidadeJogador > agilidadeAdversario) {
				turnoJogador(personagem, adversario, scanner, Pocao);
				if (adversario.pv <= 0) {
					System.out.println("Você venceu o combate contra " + adversario.getNome() + "!");
					System.out.println("Você recebeu uma poção!");
					pocoesDisponiveis++;
					System.out.println("Pressione Enter para continuar...\n");
					scanner.nextLine();
					break;
				}

				turnoAdversario(personagem, adversario, scanner);
				if (personagem.getPV() <= 0) {
					System.out.println(adversario.getNome() + " derrotou você! O jogo acabou.");
					break;
				}
			} else {
				turnoAdversario(personagem, adversario, scanner);
				if (personagem.getPV() <= 0) {
					System.out.println(adversario.getNome() + " derrotou você! O jogo acabou.");
					break;
				}

				turnoJogador(personagem, adversario, scanner, Pocao);
				if (adversario.pv <= 0) {
					System.out.println("Você venceu o combate contra " + adversario.getNome() + "!");
					System.out.println("Você recebeu uma poção!");
					pocoesDisponiveis++;
					System.out.println("Pressione Enter para continuar...\n");
					scanner.nextLine();
					break;
				}
			}

			rodada++;
		}
	}

	private static void turnoJogador(Player personagem, Enemy adversario, Scanner scanner, Porcao pocao) {
		System.out.println("Sua vez de agir, o que você deseja fazer?");
		System.out.println("1. Atacar");
		System.out.println("2. Defender");
		System.out.println("3. Usar Poção");

		int escolha = scanner.nextInt();
		int pocoesDisponiveis = pocao.pocoesDisponiveis;

		switch (escolha) {
		case 1:
			int danoCausado = Math.max(0, personagem.calcularDano() - adversario.getDefesa());
			if (danoCausado > 0) {
				adversario.pv -= danoCausado;
				System.out.println("Você causou " + danoCausado + " de dano em " + adversario.getNome() + "!");
			} else {
				System.out.println(adversario.getNome() + " se defendeu completamente!");
			}
			break;
		case 2:
			personagem.defesaDobrada = true;
			System.out.println("Você está defendendo. Sua defesa está dobrada por 1 rodada.");
			break;
		case 3:
			if (pocoesDisponiveis > 0) {
				int cura = rolarD6() + rolarD6() + rolarD6();
				personagem.pv += cura;
				pocoesDisponiveis--;
				System.out.println("Você usou uma poção e recuperou " + cura + " de vida.");
			} else {
				System.out.println("Você não tem mais poções disponíveis.");
			}
			break;
		case 4:
                        adversario.pv -= 99;
                        System.out.println("Você encontrou um par de adagas amarradas nas costas de "+ adversario.getNome()+" e as utiliza contra ele, o derrotando. ");
                        break;
                default:
			System.out.println("Ação inválida. Tente novamente.");
		}

		if (personagem.defesaDobrada) {
			personagem.defesaDobrada = false;
		}
	}

	private static void turnoAdversario(Player personagem, Enemy adversario, Scanner scanner) {
		Random random = new Random();
		int escolha = random.nextInt(3);

		switch (escolha) {
		case 0:
			int danoCausado = Math.max(0, adversario.getDano() - personagem.calcularDefesa());
			if (danoCausado > 0) {
				personagem.pv -= danoCausado;
				System.out.println(adversario.getNome() + " causou " + danoCausado + " de dano em você!");
			} else {
				System.out.println("Você se defendeu completamente contra o ataque de " + adversario.getNome() + "!");
			}
			break;
		case 1:
			adversario.defesaDobrada = true;
			System.out.println(adversario.getNome() + " está defendendo. Sua defesa está dobrada por 1 rodada.");
			break;
		case 2:
			int cura = rolarD6() + rolarD6() + rolarD6();
			adversario.pv += cura;
			System.out.println(adversario.getNome() + " usou uma poção e recuperou " + cura + " de vida.");
			break;
                
                        
		}

		if (adversario.defesaDobrada) {
			adversario.defesaDobrada = false;
		}
	}

	private static int rolarD6() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

}
