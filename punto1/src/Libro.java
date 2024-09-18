import java.util.Objects;

public class Libro {
    protected String titulo;
    protected String autor;
    protected double precio;
    protected int anoPublicacion;

    public Libro(String titulo, String autor, double precio, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.anoPublicacion = anoPublicacion;
    }

    public Libro(){
    }

    public String getTitulo() {
        return titulo;
    }

    public String setTitulo(String titulo) {
        this.titulo = titulo;
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(titulo, libro.titulo);
    }


    @Override
    public String toString() {
        return "Libro [ " +
                "Titulo='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", Precio=" + precio +
                ", Año Publicacion=" + anoPublicacion +
                " ]";
    }
}
