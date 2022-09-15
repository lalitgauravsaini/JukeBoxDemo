package data;

public class Artist {

    private String artistName;
    private String dateOfBirth;
    private int artistTotalSongs;

    public Artist(String artistName, String dateOfBirth, int artistTotalSongs) {
        this.artistName = artistName;
        this.dateOfBirth = dateOfBirth;
        this.artistTotalSongs = artistTotalSongs;
    }

    public Artist() {
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getArtistTotalSongs() {
        return artistTotalSongs;
    }

    public void setArtistTotalSongs(int artistTotalSongs) {
        this.artistTotalSongs = artistTotalSongs;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistName='" + artistName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", artistTotalSongs=" + artistTotalSongs +
                '}';
    }
}
