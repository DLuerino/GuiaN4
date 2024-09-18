import java.util.Objects;

public class Usuario {
    private String nombre;
    private boolean premium;

    public Usuario(String nombre, boolean premium) {
        this.nombre = nombre;
        this.premium = premium;
    }

    public Usuario() {

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPremium() {
        return premium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
