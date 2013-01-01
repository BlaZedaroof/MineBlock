import java.awt.*;
import java.util.*;

public class Health {
	
	public static int playerHealth = 500;
	
	public int delay = 1000;
	
	public static boolean playerIsDead;
	public static boolean healthRegen = false;
	
	public static Rectangle healthBar = new Rectangle(5,5,playerHealth,10);
	
	public Health(){
		
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