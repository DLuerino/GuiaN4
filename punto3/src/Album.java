public class Album {
    private String title;
    private Artista artist;
    private int year;

    public Album(String title, Artista artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public Album(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artista getArtist() {
        return artist;
    }

    public void setArtist(Artista artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist=" + artist +
                ", year=" + year +
                '}';
    }
}
