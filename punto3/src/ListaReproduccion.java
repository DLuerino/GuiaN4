import java.util.ArrayList;

public class ListaReproduccion implements Reproductor {
    protected ArrayList<Song> listaReproduccion=new ArrayList<>();
    Song cancion;

    /*@Override
    public String reproducir() {
        return "Reproduciendo: "+cancion.getName();
    }*/

    @Override
    public String reproducir(Song s) {
        for(Song cancion : listaReproduccion){
            if(cancion.equals(s)){
                return "Se esta reproduciendo: "+cancion.toString();
            }
        }
        return "No se encontro la cancion deseada";
    }

    @Override
    public String pausar(Song cancion) {
        return ""+cancion.getName()+" ha sido pausada. ";
    }

    @Override
    public String addCancion(Song cancion) {
        listaReproduccion.add(cancion);
        return "Cancion añadida: "+cancion.getName();
    }

    @Override
    public String deleteCancion(Song eliminada) {
        for(Song cancion : listaReproduccion){
            if(cancion.equals(eliminada)){
                listaReproduccion.remove(cancion);
                return "Cancion eliminada: "+eliminada.getName();
            }
        }

        return " No se encontro el cancion deseada! ";
    }

    @Override
    public String verMiLista() {

        String devolucion="";

        if(listaReproduccion.isEmpty()){
            devolucion= " No hay canciones en la lista de reproduccion!! ";
            return devolucion;
        }else{
            devolucion+=" [ LISTA DE REPRODUCCION ] \n";
            for(Song cancion : listaReproduccion){
                devolucion+=cancion.toString()+",\n\n ";
            }
        }
        return devolucion;
    }

    @Override
    public Song cambiarCancion(Song cancion) {
        return cancion;
    }
}