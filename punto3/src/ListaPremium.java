import java.util.LinkedList;

public class ListaPremium implements Reproductor{
    private String nombre;
    private LinkedList<Song> miLista=new LinkedList<>();

    public ListaPremium() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String addCancion(Song cancion) {

            miLista.addFirst(cancion);
            return "La cancion "+cancion.getName()+" se añadio al principio. ";

//            miLista.addLast(cancion);
//            return "La cancion "+cancion.getName()+" se añadio al final. ";
    }

    @Override
    public String deleteCancion(Song eliminada) {
        for(Song cancion : miLista){
            if(cancion.equals(eliminada)){
                miLista.remove(cancion);
                return "Cancion eliminada: "+eliminada.getName();
            }
        }

        return " No se encontro el cancion deseada! ";
    }

    @Override
    public String verMiLista() {
        if(miLista.isEmpty()){
            return "La lista esta vacia!. ";
        }

        StringBuilder sb = new StringBuilder(" [ Lista de reproduccion PREMIUM ]\n");
        for(Song cancion: miLista){
            sb.append(cancion.toString()).append("\n");
        }

        return sb.toString();

    }

    @Override
    public String reproducir(Song repro) {
        verMiLista();
        String s="";
        for(Song cancion: miLista){
            if(repro.equals(cancion)){
                s="Se esta reproduciendo "+cancion.toString();
            }else{
                s="No se encontro la cancion en la playlist!. ";
            }
        }

        return s;
    }

    @Override
    public String pausar(Song cancion) {
        return ""+cancion.getName()+" ha sido pausada. ";
    }

    @Override
    public Song cambiarCancion(Song ant) {
        Song sig=new Song();

        for(Song cancion: miLista){
            if(cancion!=ant){
                sig=cancion;
            }
        }

        return sig;
    }


}
