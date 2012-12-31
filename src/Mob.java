import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Mob extends DoubleRectangle{
	
	public int[] id;
	
	public double fallSpeed = 1;
	public double movingSpeed = 0.5;
	public double jumpSpeed = 1;
	
	public double dir = movingSpeed;
	
	public int jumpHeight = 50,jumpingCount = 0;
	public int animation = 0,animationFrame = 0,animationTime = 20;
	private boolean isJumping = false;
	private boolean isMoving = false;
	private boolean isFalling = false;
	
	public Mob(int x,int y,int width,int height, int[] id){
		setBounds(x,y,width,height);
		
		this.id = id;
	}
	
	public void tick(){
		if(!isJumping && !isCollidingWithBlock(new Point((int) x + 2,(int) (y + height)),new Point ((int) (x + width - 2),(int) (y + height)))){
		y += fallSpeed;
		isFalling = true;
		}else if(!isJumping){
			isFalling = false;
			if(new Random().nextInt(100) < 3){
				
				isMoving = true;
				
				if(new Random().nextInt(100) < 40){
					dir = -movingSpeed;
				}else if(new Random().nextInt(100) < 40){
					dir = movingSpeed;
				}else{
					dir = 0;
				}
			}
		}
		
		if (isMoving){
			boolean canMove = false;
			
			if(dir == movingSpeed){	
				canMove = isCollidingWithBlock(
						new Point(
								(int)(x + width),
								(int) y),
						new Point(
								(int)(x + width),
								(int) (y + height - 2)));
				
			}else if(dir == -movingSpeed){
				canMove = isCollidingWithBlock(
						new Point(
								(int) x,
								(int) y),
						new Point(
								(int) x,
								(int) (y + height - 2)));
			}else if(dir == 0){
				canMove = isCollidingWithBlock(
						new Point(
								(int) x,
								(int) y),
						new Point(
								(int) x,
								(int) (y + height - 2)));
			}
			
			if(canMove && !isFalling){
				isJumping = true;
			}
			
			if(animationFrame >= animationTime){
				if(animation > 1 && id != Tile.pig){
					animation = 1;
				}else if(animation > 2 && id==Tile.pig){
					animation =2;
				}else if(id != Tile.pig){
				animation++;
				}else{
					animation+=2;
				}
				
				animationFrame = 0;
			}else{
				animationFrame++;
			}
			
			if(!canMove){
			x += dir;
			}
		}
		
		if(isJumping){
			if(!isCollidingWithBlock(new Point((int) (x + width),(int) y),new Point((int)(x + width - 2),(int) y))){
				if(jumpingCount >= jumpHeight){
					isJumping = false;
					jumpingCount = 0;
					
				} else {
					
					y-=jumpSpeed;
					jumpingCount++;
					
				}
			}else{
				isJumping = false;
				jumpingCount = 0;
			}
		}
		
		if(Sky.time == Sky.day && id == Tile.mobRed && new Random().nextInt(7000) < 2){
			Component.mob.remove(this);
			Spawner.totalMobs -=1;
			System.out.println("Mob (zombie) Despawned");
		}
		if(Sky.time == Sky.day && id == Tile.bob && new Random().nextInt(7000) < 2){
			Component.mob.remove(this);
			Spawner.totalMobs -=1;
			System.out.println("Mob (bob) Despawned");
		}
		if(Sky.time == Sky.day && id == Tile.bat && new Random().nextInt(7000) < 2){
			Component.mob.remove(this);
			Spawner.batCount -=1;
			System.out.println("Bat Despawned");
		}
		
	}
	
	public boolean isCollidingWithBlock(Point pt1,Point pt2){
		for(int x = (int) (this.x/Tile.tileSize);x < (int) (this.x/Tile.tileSize + 3);x++){
			for(int y = (int) (this.y/Tile.tileSize);y < (int) (this.y/Tile.tileSize + 3);y++){
				if(x >= 0 && y >= 0 && x < Component.level.block.length && y < Component.level.block[0].length){
					if(Component.level.block[x][y].id != Tile.air && Component.level.block[x][y].id != Tile.jared && Component.level.block[x][y].id != Tile.stars && Component.level.block[x][y].id != Tile.water){
						if(Component.level.block[x][y].contains(pt1)||Component.level.block[x][y].contains(pt2)){
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public void render(Graphics g){
			if(dir == movingSpeed){
			g.drawImage(Tile.tileset_terrain,
					(int) x - (int)Component.sX,
					(int) y - (int)Component.sY,
					(int) (x + width) - (int)Component.sX,
					(int) (y + height) - (int)Component.sY,
					(id[0] * Tile.tileSize) + (Tile.tileSize * animation),
					id[1] * Tile.tileSize,
					id[0] * Tile.tileSize + (Tile.tileSize * animation) + (int) width,
					id[1] *Tile.tileSize + (int) height,
					null);
			}else{ // Harrison was here 03/12/2012
				g.drawImage(Tile.tileset_terrain,
						(int) x - (int)Component.sX,
						(int) y - (int)Component.sY,
						(int) (x + width) - (int)Component.sX,
						(int) (y + height) - (int)Component.sY,
						id[0] * Tile.tileSize + (Tile.tileSize * animation) + (int) width,
						id[1] * Tile.tileSize,
						(id[0] * Tile.tileSize) + (Tile.tileSize * animation),
						id[1] *Tile.tileSize + (int) height,
						null);
		}
	}
}
