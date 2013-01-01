import javax.sound.sampled.*;

public class Sound {
	public synchronized void music(){
		new Thread(new Runnable(){
		public void run(){
			try{
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(Component.class.getResourceAsStream("backgroundMusic.wav"));
					clip.open(inputStream);
					clip.start();
					System.out.println("Music Started");
					clip.loop(10000);
			}catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		}).start();
		
	}
}
