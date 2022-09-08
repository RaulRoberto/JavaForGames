package testeCursoGames;

public class Enemy {
	
	public int hp = 100;
	public String inimigoTipo = "Hadoop";
	public int ad = 5;
	
	public int getHp() {
		return hp;
	}
	public void takeDamage(int dmg) {
		hp-=dmg;
	}

}
