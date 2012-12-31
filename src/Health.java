import java.awt.*;
import java.util.*;

public class Health {
	
	public static int playerHealth = 500;
	
	public int delay = 1000;
	
	public static boolean playerIsDead;
	public static boolean healthRegen = false;
	
	public static Rectangle healthBar = new Rectangle(5,5,playerHealth,10);
	
	public Health(){
		
		switch(playerHealth){
		case 100:
			healthBar.width = 100;
			playerIsDead = false;
			break;
		case 90:
			healthBar.width = 90;
			playerIsDead = false;
			break;
		case 80:
			healthBar.width = 80;
			playerIsDead = false;
			break;
		case 70:
			healthBar.width = 70;
			playerIsDead = false;
			break;
		case 60:
			healthBar.width = 60;
			playerIsDead = false;
			break;
		case 50:
			healthBar.width = 50;
			playerIsDead = false;
			break;
		case 40:
			healthBar.width = 40;
			playerIsDead = false;
			break;
		case 30:
			healthBar.width = 30;
			playerIsDead = false;
			break;
		case 20:
			healthBar.width = 20;
			playerIsDead = false;
			break;
		case 10:
			healthBar.width = 10;
			playerIsDead = false;
			break;
		case 0:
			healthBar.width = 0;
			playerIsDead = true;
			break;
		}
	}
	
	public void tick(){
		if(Component.character.isCollidingWithEnemy() == true || Component.character.isCollidingWithEnemy2() == true ){
			if(healthBar.width > 0){
				healthBar.width -=2;
			}
		}
		if(healthBar.width < 500 && !Component.character.isCollidingWithEnemy() && !Component.character.isCollidingWithEnemy2() && new Random().nextInt(100) > 97){
			healthBar.width += 1;
		}
		if(healthBar.width == 0){
			playerIsDead = true;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		if(!playerIsDead){
			g.fillRect(10, 10, healthBar.width / 5, 10);
			g.setColor(Color.orange);
			g.drawString("Health: " + healthBar.width/5, 20, 19);
		}else{
			g.setColor(Color.red);
			g.drawString("You Died!", 95, 80);
			g.drawString("Press Enter to Exit", 77, 93);
		}
	}
}