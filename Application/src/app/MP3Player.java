package app;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3Player {

	public void play(String fileName) {
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			Player player = new Player(fis);
			player.play();
			fis.close();
		} catch (Exception e) {
			System.out.println("Error playing MP3 file: " + e);
			e.printStackTrace();
		}
	}
}
