package operation;

import data.Songs;
import data_accessing_object.ArtistDAO;
import data_accessing_object.GenreDAO;
import utility.DB_connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JukeOperation {

    public List<Songs> displayAllSongs() throws SQLException, ClassNotFoundException {

        List<Songs> allSongsList = new ArrayList<>();
        Connection connection = DB_connection.getConnection();
        String sql = "Select songId,songName,duration,songPath from songs; ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

       ResultSet resultSet = preparedStatement.executeQuery();
       while(resultSet.next()){
           allSongsList.add(new Songs(resultSet.getInt(1),resultSet.getString(2),
                   resultSet.getDouble(3),resultSet.getString(4)));
       }

       return allSongsList;
    }

    public List<Songs> searchArtistByArtistName(String searchAlphabet) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        Connection connection = DB_connection.getConnection();
        String sql = "Select artistID,artistName from artist where artistName like ? ;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,searchAlphabet + "%" );
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Please Select the Artist");
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString(2));
        }
        int artistId = scanner.nextInt();
        ArtistDAO artistDAO = new ArtistDAO();
        List<Songs> songs = artistDAO.songsOfArtist(artistId);
        return songs;

    }

    public List<Songs> searchGenreByGenreType(String searchAlphabet) throws SQLException, ClassNotFoundException {

        int artistId = 0;
        Scanner scanner = new Scanner(System.in);
        Connection connection = DB_connection.getConnection();
        String sql = "Select genreId,genreType from genre where genreType like ? ;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,searchAlphabet + "%" );
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Please Select the Genre");
        while(resultSet.next()){
            System.out.print(resultSet.getInt(1) + " ");
            System.out.println(resultSet.getString(2));
        }
        int genreId = scanner.nextInt();
        GenreDAO genreDAO = new GenreDAO();
        List<Songs> songs = genreDAO.songsOfGenre(genreId);
        return songs;
    }

    public List<Songs> searchSongBySongName(String searchAlphabet) throws SQLException, ClassNotFoundException {

        Connection connection = DB_connection.getConnection();
        List<Songs> songsList = new ArrayList<>();
        String sql = "Select songId,songName,duration,songPath from songs where songName like ? ;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,searchAlphabet + "%" );
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Please Select the song");

        while(resultSet.next()){
            songsList.add(new Songs(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getDouble(3),resultSet.getString(4)));
        }

        return songsList;
    }




}
