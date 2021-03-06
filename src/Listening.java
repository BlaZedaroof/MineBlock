import java.awt.event.*;

public class Listening implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener{

	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){
		// Right
		case KeyEvent.VK_D:
			if(!Health.playerIsDead){
				Component.isMoving = true;
				Component.dir = Component.character.movementSpeed;
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			if(!Health.playerIsDead){
				Component.isMoving = true;
				Component.dir = Component.character.movementSpeed;
			}
			break;
			
			// Left
		
		case KeyEvent.VK_A:
			if(!Health.playerIsDead){
				Component.isMoving = true;
				Component.dir = -Component.character.movementSpeed;
			}
			break;
			 
		case KeyEvent.VK_LEFT:
			if(!Health.playerIsDead){
				Component.isMoving = true;
				Component.dir = -Component.character.movementSpeed;
			}
			break;
			
			// Up or Jump
		case KeyEvent.VK_W:
			if(!Health.playerIsDead){
				Component.isJumping = true;
			}
			break;
		
		case KeyEvent.VK_UP:
			if(!Health.playerIsDead){
				Component.isJumping = true;
			}
			break;
			
		case KeyEvent.VK_SPACE:
			if(!Health.playerIsDead){
				Component.isJumping = true;
			}	
			break;
			
		case KeyEvent.VK_ENTER:
			if(!Health.playerIsDead){
				
			}else if(Health.playerIsDead){
				System.exit(0);
			}
			break;
			
		case KeyEvent.VK_1:
			Inventory.selected = 0;
			break;
			
		case KeyEvent.VK_2:
			Inventory.selected = 1;
			break;
			
		case KeyEvent.VK_3:
			Inventory.selected = 2;
			break;
			
		case KeyEvent.VK_4:
			Inventory.selected = 3;
			break;
			
		case KeyEvent.VK_5:
			Inventory.selected = 4;
			break;
		case KeyEvent.VK_6:
			Inventory.selected = 5;
			break;
		case KeyEvent.VK_ESCAPE:
			if(Component.inGame){
				Component.inGame = false;
				System.out.println("Paused Game");
			}else if(!Component.inGame){
				Component.inGame = true;
				System.out.println("Game Unpaused");
			}
			break;
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){
		case KeyEvent.VK_D:
			if(Component.dir == Component.character.movementSpeed){
				Component.isMoving = false;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(Component.dir == Component.character.movementSpeed){
				Component.isMoving = false;
			}
			break;
		
		case KeyEvent.VK_A:
			if(Component.dir == -Component.character.movementSpeed){
				Component.isMoving = false;
			}
			break;
			
		case KeyEvent.VK_LEFT:
			if(Component.dir == -Component.character.movementSpeed){
				Component.isMoving = false;
			}
			break;
			
		case KeyEvent.VK_W:
			Component.isJumping = false;
			break;
		
		case KeyEvent.VK_UP:
			Component.isJumping = false;
			break;
			
		case KeyEvent.VK_SPACE:
			Component.isJumping = false;
			break;
			
		case KeyEvent.VK_E:
			if(Inventory.isOpen){
				Inventory.isOpen = false;
			}else{
				Inventory.isOpen = true;
			}
			break;
			
		case KeyEvent.VK_ESCAPE:
			if(Inventory.isOpen){
				Inventory.isOpen = false;
			}
			break;
		}
	}

	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation() > 0) { // Downward
			if(Inventory.selected < Tile.invLength - 1){
				Inventory.selected += 1;
			}else{
				Inventory.selected = 0;
			}
		}else if(e.getWheelRotation() < 0){ // Upward
			if(Inventory.selected > 0) {
				Inventory.selected -= 1;
			}else{
				Inventory.selected = Tile.invLength - 1;
			}
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		Component.mse.setLocation(e.getX(), e.getY());
	}
	
	public void mouseMoved(MouseEvent e) {
		Component.mse.setLocation(e.getX(), e.getY());
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			Component.isMouseLeft = true;
		}else if(e.getButton() == MouseEvent.BUTTON3){
			Component.isMouseRight = true;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			Component.isMouseLeft = false;
		}else if(e.getButton() == MouseEvent.BUTTON3){
			Component.isMouseRight = false;
		}
		
		Inventory.click(e);
	}

}
