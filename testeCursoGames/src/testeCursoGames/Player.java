package testeCursoGames;

public class Player {
	public int hp = 10;
	public String nome = "Raul";
	
	public void lostHp() {
		hp-=1;
	}
	
	public void gainHp(int heal) {
		hp+=heal;
	}

}
