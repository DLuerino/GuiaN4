import java.util.Stack;

public class ListaBasica implements Reproductor{
    private String nombre;
    private Stack<Song> miLista = new Stack<Song>();

    public ListaBasica(String nombre) {
        this.nombre = nombre;
        this.miLista = miLista;
    }

    @Override
    public String addCancion(Song cancion) {
        miLista.add(cancion);
        return cancion.getName();
    }

    @Override
    public String deleteCancion(Song cancion) {
        return "Para acceder a estas opciones, compre el paquete PREMIUM";
    }

    @Override
    public Song cambiarCancion(Song cancion) {
        return cancion;
    }

    @Override
    public String reproducir(Song cancion) {
        if(miLista.isEmpty()) {
            return "No hay canciones en la lista. ";
        }

        Song primeraCancion=miLista.firstElement();
        miLista.remove(0);
        miLista.push(primeraCancion);
        return "[ Reproduciendo: "+primeraCancion.toString()+" ]";
    }

    @Override
    public String verMiLista() {
        if(miLista.isEmpty()) {
            return "No hay canciones en la lista. ";
        }
        StringBuilder sb = new StringBuilder("[ Lista de reproduccion ]\n");
        for(Song cancion: miLista) {
            sb.append(cancion.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String pausar(Song cancion) {
        return ""+cancion.getName()+"Esta pausada.";
    }
}
