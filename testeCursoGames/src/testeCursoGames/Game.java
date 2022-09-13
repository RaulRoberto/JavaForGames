package testeCursoGames;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable , KeyListener{

	public static int WIDTH = 480, HEIGHT = 480;
	public Player player;
	public World world;
	// adding a comment to make another branch and test the github flow;
	
	
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		player = new Player(32,32);
		world =new World();
		
	}
	
	public void tick() {
		player.tick();
		
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g =bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH	,HEIGHT);
		
		player.render(g);
		world.render(g);
		
		
		bs.show();
		
		
	}
	
	public static void main(String[] args) {
		
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Biruleibe");
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		new Thread(game).start();
		
		
//		Player player = new Player();
//		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
//		ElfEnemy elf = new ElfEnemy();
//		
//		enemies.add(new Enemy());
//		enemies.add(new ElfEnemy());
//		
//		elf.takeDamage(10);
//		player.lostHp();		
//		System.out.println(player.hp);
//		player.gainHp(90);
//		System.out.println(player.hp);
//		System.out.println(elf.getHp());	
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.right = true;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			player.up = true;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			player.right = false;
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			player.left = false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			player.up = false;
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			player.down = false;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
