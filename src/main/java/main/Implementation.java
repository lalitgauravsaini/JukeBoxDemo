package main;

import data.Songs;
import operation.JukeOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Implementation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       System.out.println("WELCOME TO YOUR  MUSIC SYSTEM");
        System.out.println("PLEASE SELECT THE OPTION FROM THE MENU");
        System.out.println("1 : Search A Song");
        System.out.println("2 : Create A PlayList");
        System.out.println("3 : Open A Existing PlayList");
        int optionOfMainMenu = scanner.nextInt();

        switch (optionOfMainMenu) {

            case (1):
                JukeOperation jukeOperation = new JukeOperation();
                System.out.println("Search song based on following option");
                System.out.println("1 : Display all Songs");
                System.out.println("2 : Artist Name");
                System.out.println("3 : Genre");
                System.out.println("4 : Song Name");
                System.out.println("5 : GO BACK TO PREVIOUS MENU");
                try {

                    int option = scanner.nextInt();
                    switch(option) {

                        case(1):
                            List<Songs> allSongs = jukeOperation.displayAllSongs();

                        break;
                        case(2):
                            System.out.println("PLEASE ENTER THE ARTIST NAME YOU WANT TO SEARCH");
                            scanner.nextLine();
                            String artistName = scanner.nextLine();
                            jukeOperation.searchArtistByArtistName(artistName);
                        break;
                        case(3):
                            System.out.println("PLEASE ENTER THE GENRE TYPE YOU WANT TO SEARCH");
                            String genreType = scanner.nextLine();
                            jukeOperation.searchGenreByGenreType(genreType);
                            // display list of song
                            // display the play option
                            //create playlist
                            //
                        break;
                        case(4):
                            System.out.println("PLEASE ENTER THE SONG NAME YOU WANT TO SEARCH");
                            scanner.nextLine();
                            String songName = scanner.nextLine();
                            jukeOperation.searchSongBySongName(songName);
                        break;
                        case(5):
                            String [] arg = new String[0];
                            Implementation.main(arg);
                        break;

                        default:
                            System.err.println("PLEASE SELECT THE RIGHT OPTION");
                            option = scanner.nextInt();


                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case(2):




        }
    }
}
