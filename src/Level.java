import java.awt.*;
import java.util.*;

public class Level {
	public static int worldW = 800, worldH = 800;
	public static int diamondCount = 0;
	public static int coalCount = 0;
	public static int redstoneCount = 0;
	public static int lapizCount = 0;
	public static int goldCount = 0;
	public static int platinumCount = 0;
	public static int stoneCount = 0;
	public static int emeraldCount = 0;
	public static int rubyCount = 0;
	public static int saphireCount = 0;

	public Block[][] block = new Block[worldW][worldH];
	
	public Level(){
		for(int x=0; x<block.length; x++){
			for(int y=0; y<block[0].length; y++){
				block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.air);
			}
		}
		
		generateLevel();
	}
	
	// Randomly Generates Level
	
	public void generateLevel(){
		
		//Generating Mountains, earth & grass
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(y > worldH/7){
					if(new Random().nextInt(100) > 20){
						try{
							if(block[x-1][y-1].id == Tile.earth){
								block[x][y].id = Tile.earth;
							}
						}catch(Exception e){}
					}
					if(new Random().nextInt(100) > 30){
						try{
							if(block[x+1][y-1].id == Tile.earth){
								block[x][y].id = Tile.earth;
							}
						}catch(Exception e){}
					}

					try{
						if(block[x][y-1].id == Tile.earth){
							block[x][y].id = Tile.earth;
						}
					}catch(Exception e){}
					
					if(new Random().nextInt(100) < 2){
						block[x][y].id = Tile.earth;
					}
				}
			}
		}
		
		//Placing Trees
		for(int y=0; y<block.length;y++){
			for(int x=0; x<block[0].length;x++){
				try{
					if(block[x][y + 1].id == Tile.earth && block[x][y].id == Tile.air){
						if(new Random().nextInt(100) <= 5){
						for(int i = 0; i < new Random().nextInt(5) + 4; i++){
							block[x][y - i].id = Tile.wood;
						}
						block[x][y].id = Tile.wood;
					}
					
			}
				}catch(Exception e){}
			}
		}
		//Places Leaves
		for(int y=0; y<block.length;y++){
			for(int x=0; x<block[0].length; x++){
				try{
				if(block[x+1][y].id == Tile.wood || block[x-1][y].id == Tile.wood){
						if(block[x][y+1].id != Tile.earth && block[x][y+2].id !=Tile.earth && block[x][y+3].id != Tile.earth){
							block[x][y].id = Tile.leaves;
							if(block[x+1][y].id == Tile.air){
							block[x+1][y].id = Tile.leaves;
							}
							if(block[x-1][y].id == Tile.air){
							block[x-1][y].id = Tile.leaves;
							}
						}
					}
				if(block[x][y+1].id == Tile.wood && block[x][y-1].id == Tile.air){
					block[x][y].id = Tile.leaves;
					block[x+1][y].id = Tile.leaves;
					block[x-1][y].id = Tile.leaves;
					block[x][y-1].id = Tile.leaves;
					block[x][y-2].id = Tile.leaves;

				}
				}catch(Exception e){}
			}
		}
		// Placing Grass Blocks on top layer
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(block[x][y].id == Tile.earth && block[x][y-1].id == Tile.air){
					block[x][y].id = Tile.grass;
				}
			}
		}
		// Places Stone
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(y >  worldH/3.8 && new Random().nextInt(100) < 99){
					block[x][y].id = Tile.stone;
					stoneCount++;
				}
				if(y > worldH/4.2 && new Random().nextInt(100) < 80){
					block[x][y].id = Tile.stone;
					stoneCount++;
				}
				if(y > worldH/4.4 && new Random().nextInt(100) < 69){
					block[x][y].id = Tile.stone;
					stoneCount++;
				}
				if(y > worldH/4.5 && new Random().nextInt(100) < 35){
					block[x][y].id = Tile.stone;
					stoneCount++;
				}
				if(y > worldH/4.8 && new Random().nextInt(100) < 25){
					block[x][y].id = Tile.stone;
					stoneCount++;
				}
			}
		}
		// Places Coal
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(y > worldH/4.7 && new Random().nextInt(100) < 0.7){
					block[x][y].id = Tile.coal;
					coalCount++;
				}
			}
		}
		// Places Lapiz
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(y > worldH/1.4 && new Random().nextInt(100) < 0.5){
					block[x][y].id = Tile.lapiz;
					lapizCount ++;
				}
			}
		}
		// Places Redstone ore
				for(int y=0; y<block.length; y++){
					for(int x=0; x<block[0].length; x++){
						if(y > worldH/1.7 && new Random().nextInt(150) < 1){
							block[x][y].id = Tile.redstone;
							redstoneCount++;
						}
					}
				}
		// Places Diamond Ore
				for(int y=0; y<block.length; y++){
					for(int x=0; x<block[0].length; x++){
						if(y > worldH/1.025 && new Random().nextInt(750) < 2){
							block[x][y].id = Tile.diamond;
							diamondCount ++;
						}
					}
				}
		// Places Emerald Ore
				for(int y=0; y<block.length; y++){
					for(int x=0; x<block[0].length; x++){
						if(y > worldH/1.025 && new Random().nextInt(500) < 2){
							block[x][y].id = Tile.emerald;
							emeraldCount ++;
						}
					}
				}
		// Places Ruby Ore
				for(int y=0; y<block.length; y++){
					for(int x=0; x<block[0].length; x++){
						if(y > worldH/1.025 && new Random().nextInt(500) < 2){
							block[x][y].id = Tile.ruby;
							rubyCount ++;
						}
					}
				}
		// Places Saphire Ore
				for(int y=0; y<block.length; y++){
					for(int x=0; x<block[0].length; x++){
						if(y > worldH/1.025 && new Random().nextInt(750) < 4){
							block[x][y].id = Tile.saphire;
							saphireCount ++;
						}
					}
				}
				
		// Places Platinum Ore
				for(int y=0; y<block.length; y++){
					for(int x=0; x<block[0].length; x++){
						if(y > worldH/1.5 && new Random().nextInt(200) < 1){
							block[x][y].id = Tile.platinum;
							platinumCount ++;
						}
					}
				}
		// Places Gold Ore
				for(int y=0; y<block.length; y++){
					for(int x=0; x<block[0].length; x++){
						if(y > worldH/1.5 && new Random().nextInt(175) < 1){
							block[x][y].id = Tile.gold;
							goldCount ++;
						}
					}
				}
		
		// Places Invisible Solid Blocks
		for(int y=0; y<block.length; y++){
			for(int x=0; x<block[0].length; x++){
				if(x == 0 || y == 0 || x == block[0].length-1){
					block[x][y].id = Tile.solidAir;
				}
			}
		}
	// Place Bedrock
	for(int y=0; y<block.length; y++){
		for(int x=0; x<block[0].length; x++){
			if(y == block[0].length-1){
				block[x][y].id = Tile.bedrock;
			}
			if(y == block[0].length-2 && new Random().nextInt(100) < 80){
				block[x][y].id = Tile.bedrock;
			}
			if(y == block[0].length-3 && new Random().nextInt(100) < 50){
				block[x][y].id = Tile.bedrock;
			}
		}
	}
	System.out.println("Diamonds Spawned: " + diamondCount);
	System.out.println("Emeralds Spawned: " + emeraldCount);
	System.out.println("Rubys Spawned: " + rubyCount);
	System.out.println("Saphires Spawned: " + saphireCount);
	System.out.println("Coal Spawned: " + coalCount);
	System.out.println("Gold Spawned: " + goldCount);
	System.out.println("Redstone Spawned: " + redstoneCount);
	System.out.println("Lapiz Spawned: " + lapizCount);
	System.out.println("Platinum Spawned: " + platinumCount);
	System.out.println("Stone Spawned: " + stoneCount);
}
	public void building(int camX, int camY, int renW, int renH){
		// Sand Physics
		for(int x= (camX/Tile.tileSize); x<(camX/ Tile.tileSize) + renW; x++){
			for(int y= (camY/Tile.tileSize); y<(camY/ Tile.tileSize) + renH; y++){
				if(x >=0 && y >= 0 && x< worldW && y < worldH){
					if(block[x][y].id == Tile.sand && block[x][y+1].id == Tile.air){
						block[x][y+1].id = Tile.sand;
						block[x][y].id = Tile.air;
						try{
							Thread.sleep(23);
							break;
						}catch(Exception e){}
						
					}
				}		
				if(x >=0 && y >= 0 && x< worldW && y < worldH){
					if(Sky.time == Sky.night && block[x][y].id == Tile.air){
							block[x][y].id = Tile.stars;
					}
				if(Sky.time == Sky.day && block[x][y].id == Tile.stars){
					block[x][y].id = Tile.air;
				}
				if(Sky.time == Sky.night && block[x][y].id == Tile.glass){
					block[x][y].id = Tile.nightGlass;
				}
				if(Sky.time == Sky.day && block[x][y].id == Tile.nightGlass){
					block[x][y].id = Tile.glass;
				}
			}
			// Water Physics
				/* try{
					if(block[x][y].id == Tile.water && block[x+1][y].id == Tile.air && block[x+1][y+1].id != Tile.air){
						block[x+1][y].id = Tile.water1;
					}else if(block[x][y].id == Tile.water1 && block[x+1][y].id == Tile.air && block[x+1][y+1].id != Tile.air && block[x+1][y+1].id != Tile.water1){
						block[x+1][y].id = Tile.water2;
					}else if(block[x][y].id == Tile.water2 && block[x+1][y].id == Tile.air && block[x+1][y+1].id != Tile.air){
						block[x+1][y].id = Tile.water3;
					}else if(block[x][y].id == Tile.water3 && block[x+1][y].id == Tile.air && block[x+1][y+1].id != Tile.air){
						block[x+1][y].id = Tile.water4;
					}else if(block[x][y].id == Tile.water && block[x][y+1].id == Tile.air){
						block[x][y+1].id = Tile.water;
					}else if(block[x][y].id == Tile.water && block[x-1][y].id == Tile.air && block[x+1][y+1].id !=Tile.air){
						block[x-1][y].id = Tile.water1;
					}
				}catch(Exception e){}
				*/
	// Allow the player to build & Destroy blocks
		if(Component.isMouseLeft || Component.isMouseRight){
					if(x >=0 && y >= 0 && x< worldW && y < worldH){
						if(block[x][y].contains(new Point ((Component.mse.x / Component.pixelSize) + (int)Component.sX, (Component.mse.y / Component.pixelSize) + (int)Component.sY))) {
							int sid[] = Inventory.invBar[Inventory.selected].id;
							
							if(Component.isMouseLeft){	
								if(block[x][y].id != Tile.solidAir && block[x][y].id != Tile.bedrock && block[x][y].id != Tile.stars){
									block[x][y].id = Tile.air;	
								}
							}else if(Component.isMouseRight){
								if(block[x][y].id == Tile.air || block[x][y].id == Tile.stars){
									if(sid != Tile.air) {
										block[x][y].id = sid;
										
										if(block[x][y + 1].id == Tile.grass){
											block[x][y + 1].id = Tile.earth;
										}
									}
								}
							}
							break;
						}
					}
				}
			}
		}
	}
	
	public void tick(int camX, int camY, int renW, int renH){
		if(!Inventory.isOpen){
		building(camX, camY, renW, renH);
		}
	}
	
	
	public void render(Graphics g, int camX, int camY, int renW, int renH){
		for(int x= (camX/Tile.tileSize); x<(camX/ Tile.tileSize) + renW; x++){
			for(int y= (camY/Tile.tileSize); y<(camY/ Tile.tileSize) + renH; y++){
				if(x >=0 && y >= 0 && x< worldW && y < worldH){
					block[x][y].render(g);
					
					if(block[x][y].id != Tile.air && block[x][y].id != Tile.solidAir  && block[x][y].id != Tile.stars && !Inventory.isOpen){
						if(block[x][y].contains(new Point ((Component.mse.x / Component.pixelSize) + (int)Component.sX, (Component.mse.y / Component.pixelSize) + (int)Component.sY))) {
							g.setColor(new Color(255,255,255, 60));
							g.fillRect(block[x][y].x - camX, block[x][y].y - camY, block[x][y].width, block[x][y].height);
						}
					}else{
						if(!Inventory.isOpen)
							if(block[x][y].contains(new Point ((Component.mse.x / Component.pixelSize) + (int)Component.sX, (Component.mse.y / Component.pixelSize) + (int)Component.sY))) {
								g.setColor(new Color(255,255,255, 60));
								g.drawRect(block[x][y].x - camX, block[x][y].y - camY, block[x][y].width -1, block[x][y].height -1);
							}
						}
					}
				}
			}
		}
	}
