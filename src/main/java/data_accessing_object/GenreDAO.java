package data_accessing_object;

import data.Songs;
import utility.DB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {

    public List<Songs> songsOfGenre(int genreID) throws SQLException, ClassNotFoundException {

        List<Songs> songsListOfGenre = new ArrayList<>();
        Songs songs = new Songs();
        Connection connection = DB_connection.getConnection();
        String sql = "Select songId,songName,duration,songPath from songs where genreID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,genreID);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            songsListOfGenre.add(new Songs(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getDouble(3),resultSet.getString(4)));
        }

        return songsListOfGenre;
    }
}
