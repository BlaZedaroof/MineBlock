import java.util.*;

public class Spawner implements Runnable {
	public boolean isRunning = false;
	
	public static int totalMobs = 0;
	public static int animalCount = 0;
	public static int pigCount = 0;
	public static int batCount = 0;
	public static int chickenCount = 0;
	
	public Spawner(){
		isRunning = true;
		new Thread(this).start();
	}
	public void spawnMob(Mob mob){
		Component.mob.add(mob);
	}
	
	public void run() {
		while(isRunning){
			if(totalMobs < Tile.maxEnemies && Sky.time == Sky.night){
				// Spawning Mobs at Night
					spawnMob(new Red(new Random().nextInt((Level.worldW - 2) * Tile.tileSize) + Tile.tileSize + 30,50, Tile.tileSize, Tile.tileSize *2, Tile.mobRed));
					spawnMob(new Red(new Random().nextInt((Level.worldW - 2) * Tile.tileSize) + Tile.tileSize + 30,50, Tile.tileSize, Tile.tileSize *2, Tile.mobRed));
					spawnMob(new Bat(new Random().nextInt((Level.worldW - 2) * Tile.tileSize) + Tile.tileSize + 30,50, Tile.tileSize, Tile.tileSize, Tile.bat));
					if(new Random().nextInt(10) < 1){
						spawnMob(new Robot(new Random().nextInt((Level.worldW - 2) * Tile.tileSize) + Tile.tileSize + 30,50, Tile.tileSize, Tile.tileSize*2, Tile.robot));
						System.out.println("Robot Spawned");
						totalMobs += 1;
					}
					if(new Random().nextInt(100) < 10){
						spawnMob(new Bob(new Random().nextInt((Level.worldW - 2) * Tile.tileSize) + Tile.tileSize + 30,50, Tile.tileSize, Tile.tileSize *2, Tile.bob));
						System.out.println("Bob Spawned");
						totalMobs +=1;
					}
					totalMobs +=3;
					batCount += 1;
					System.out.println("Mobs Spawned: " + totalMobs);
					System.out.println("Bats Spawned: " + batCount);
				}
			try{
				Thread.sleep(new Random().nextInt(1000) + 5000);
			}catch(Exception e){}
			
			if(Component.mob.toArray().length < Tile.maxMobs){
				// Spawning Animals
				spawnMob(new Pig(new Random().nextInt((Level.worldW - 2) * Tile.tileSize) + Tile.tileSize + 30,50, Tile.tileSize*2, Tile.tileSize, Tile.pig));
				spawnMob(new Chicken(new Random().nextInt((Level.worldW - 2) * Tile.tileSize) + Tile.tileSize + 30,50, Tile.tileSize, Tile.tileSize, Tile.chicken));
				spawnMob(new Chicken(new Random().nextInt((Level.worldW - 2) * Tile.tileSize) + Tile.tileSize + 30,50, Tile.tileSize, Tile.tileSize, Tile.chicken));
				spawnMob(new Bat(new Random().nextInt((Level.worldW - 2) * Tile.tileSize) + Tile.tileSize + 30,50, Tile.tileSize, Tile.tileSize, Tile.bat));
				animalCount += 6;
				chickenCount += 2;
				pigCount += 1;
				System.out.println("Bat's Spawned: " + batCount);
				System.out.println("Chicken Spawned: " + chickenCount);
				System.out.println("Pig's Spawned: " + pigCount);
			}try{
				Thread.sleep(new Random().nextInt(20000) + 10000);
			}catch(Exception e){}
		}
	}
}
