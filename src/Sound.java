import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
					clip.loop(Clip.LOOP_CONTINUOUSLY);
			}catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		}).start();
	}
}