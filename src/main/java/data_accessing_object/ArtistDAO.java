package data_accessing_object;

import data.Songs;
import utility.DB_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    public List<Songs> songsOfArtist(int artistID) throws SQLException, ClassNotFoundException {

        List<Songs> songsListOfArtist = new ArrayList<>();
        Songs songs = new Songs();
        Connection connection = DB_connection.getConnection();
        String sql = "Select songId,songName,duration,songPath from songs where artistID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,artistID);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            songsListOfArtist.add(new Songs(resultSet.getInt(1),resultSet.getString(2),
                    resultSet.getDouble(3),resultSet.getString(4)));
        }

        return songsListOfArtist;
    }
}
