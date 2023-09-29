
public class Enemy {
	private String nome;
	int pv;
	private int dano;
	private int defesa;
	private int agilidade;
	boolean defesaDobrada;

	public Enemy(String nome, int pv, int dano, int defesa, int agilidade) {
		this.nome = nome;
        this.pv = pv;
        this.dano = dano;
        this.defesa = defesa;
        this.agilidade = agilidade;
        
        
	}
	
	public int getDano() {
		return dano;
	}
	public int getDefesa() {
		return defesa;
	}
	public int getAgilidade() {
		return agilidade;
	}
	public String getNome() {
		return nome;
	}
	
	

}
