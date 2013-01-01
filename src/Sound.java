import sun.audio.*;
import java.io.*;

import javax.sound.sampled.*;

public class Sound {
	public static synchronized void music(){
		new Thread(new Runnable(){
		public void run(){
			try{
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(Component.class.getResourceAsStream("backgroundMusic.wav"));
					clip.open(inputStream);
					clip.start();
					clip.loop(10000);
			}catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		}).start();
		
	}
}
