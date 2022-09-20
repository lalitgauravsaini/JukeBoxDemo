package operation;

import data.Songs;
import main.Implementation;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class AudioPlayer {
    List<Songs> songsList;
    int songIndex;

    public void PlaySong(List<Songs> songsList) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Scanner scanner = new Scanner(System.in);
        this.songsList = songsList;
        for (int i = 0; i < songsList.size(); i++) {
            songIndex = i;
            PlaySong(songsList.get(i).getSongPath());
        }
    }

    public void PlaySong(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {


        Scanner scanner = new Scanner(System.in);
        try {
            File file = new File(songPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";

            while (!response.equals("Press for Q")) {
                System.out.println("Press for P = play," +
                        " Press for T= Pause," +
                        " Press for S=Stop," +
                        " Press for L=Loop," +
                        "Press for  R = Reset," +
                        " Press for Q = Quit," +
                        "Press for N = NextSong," +
                        "Press for O = previousSong," +
                        "Press for M = MAIN MENU");
                System.out.print("Enter your choice: ");

                response = scanner.next();
                response = response.toUpperCase();


                switch (response) {
                    case ("Press for P"): {
                        clip.start();
                        break;
                    }
                    case ("Press for T"): {
                        clip.stop();
                        break;
                    }
                    case ("Press for S"): {
                        clip.setMicrosecondPosition(0);
                        clip.stop();
                        break;
                    }
                    case ("Press for L"): {
                        clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                    }

                    case ("Press for R"):
                        clip.setMicrosecondPosition(0);
                        break;

                    case ("Press for Q"):
                        clip.close();
                        break;
                    case ("Press for N"):
                        clip.close();
                        songIndex += 1;
                        PlaySong(songsList.get(songIndex).getSongPath());
                        break;
                    case ("Press for O"):
                        clip.close();
                        songIndex -= 1;
                        PlaySong(songsList.get(songIndex).getSongPath());
                        break;
                    case ("Press for M"):
                        String[] arg = new String[0];
                        Implementation.main(arg);
                        break;
                    case ("Press for E"):
                        System.exit(0);
                        break;

                    default:
                        System.err.println("PLEASE SELECT THE CORRECT OPTION");

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}