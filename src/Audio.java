import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Audio {
 
	public void bulletSound(String fileName) {
		AudioPlayer loopMachine = AudioPlayer.player;
		try {
			InputStream song = new FileInputStream("Files" + File.separator + fileName+".wav");
			AudioStream BGM = new AudioStream(song);
			loopMachine.start(BGM);
		} catch (FileNotFoundException e) {
		} catch (IOException error) {
		}
	}
}
