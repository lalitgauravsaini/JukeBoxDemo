package data;

public class Songs {

    private String songName;
    private double songDuration;
    private  String songPath;
    private Genre genre;
    private Artist artist;

    public Songs() {
    }

    public Songs(String songName, double duration, String songPath, Genre genre,  Artist artist) {
        this.songName = songName;
        this.songDuration = duration;
        this.songPath = songPath;
        this.genre = genre;
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public double getDuration() {
        return songDuration;
    }

    public void setDuration(double duration) {
        this.songDuration = duration;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
