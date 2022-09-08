package testeCursoGames;

import java.util.ArrayList;

public class Game {

	public static void main(String[] args) {
		Player player = new Player();
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		ElfEnemy elf = new ElfEnemy();
		
		enemies.add(new Enemy());
		enemies.add(new ElfEnemy());
		
		elf.takeDamage(10);
		player.lostHp();		
		System.out.println(player.hp);
		player.gainHp(90);
		System.out.println(player.hp);
		System.out.println(elf.getHp());
		
		
		
		
	}
}
