import java.util.Objects;

public class Song {
    protected String name;
    protected double length;
    protected Genero gener;
    protected Album album;
    protected Artista ft;

    public Song(String name, double length, Genero gener, Album album, Artista ft) {
        this.name = name;
        this.length = length;
        this.gener = gener;
        this.album = album;
        this.ft = ft;
    }

    public Song(String name, double length, Genero gener, Album album) {
        this.name = name;
        this.length = length;
        this.gener = gener;
        this.album = album;
    }

    public Song() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Genero getGener() {
        return gener;
    }

    public void setGener(Genero gener) {
        this.gener = gener;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artista getFt() {
        return ft;
    }

    public void setFt(Artista ft) {
        this.ft = ft;
    }

    @Override
    public String toString() {
        String resultado= "Cancion: "+getName()+" ("+getLength()+" min)"+ " Genero: "+getGener()+" Album: "+getAlbum();

        if(getFt()!=null){
            resultado+=", FT: "+getFt();
        }
        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return name.equalsIgnoreCase(song.name);
    }
}
