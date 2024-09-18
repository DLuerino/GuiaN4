import java.util.ArrayList;
import java.util.Objects;

public class Inventario {
        protected ArrayList<Libro> inventario;
    //Libro libro;

    public Inventario() {
        inventario=new ArrayList<>();
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventario);
    }

    public void agregarLibro(Libro libro){
        inventario.add(libro);
    }

    public void eliminarLibro(String titulo){
        inventario.remove(titulo);
    }

    public String mostrarLibro(){

        String resultado="";

        for(Libro libro:  inventario) {
            resultado=resultado.concat( "\n\n| Titulo del libro: " + libro.getTitulo() + " | Autor: " + libro.getAutor() + " | Precio: " + libro.getPrecio() + " | Año de publicacion: " + libro.getAnoPublicacion()+" |");

        }

        if (resultado.isEmpty()) {
            return "No se encontro ningun libro";
        }

        return resultado;

    }

    /*public boolean buscarLibro(String titulo){
        boolean flag=false;
        for(Libro libro : inventario) {
            if (titulo.equals(libro.getTitulo())) {
                flag = true;
            } else {
                flag = false;
            }
        }

        return flag;
    }*/

    public Libro buscarLibro(String titulo){
        //Libro lib=new Libro(titulo, "asd",10,1900);
        Libro retorno=new Libro();
        Libro actual=new Libro();

        for(Libro libro : inventario){

           actual=libro;

            if(titulo.equals(actual.titulo)){
                    retorno=actual;
            }else{
                retorno=null;
            }
        }

        return retorno;
    }

    public String modificarLibroPorPosicion(int pos, double nuevoPrecio){
        if(pos>=0 && pos<inventario.size()){
            Libro libro=inventario.get(pos);
            libro.setPrecio(nuevoPrecio);
            return libro.toString();
        }else{
            return "No se encontro el libro ";
        }
    }

    public String modificarLibroXtitulo(String titulo, double nuevoPrecio){
        for(Libro libro:inventario){
            if(titulo.equals(libro.getTitulo())){
                libro.setPrecio(nuevoPrecio);
                return libro.toString();
            }
        }

        return "No se encontro el libro ";
    }

    public double precioTotal(){
        double total=0;
        for(Libro libro:inventario){
            total+=libro.getPrecio();
        }
        return total;
    }

    public int cantLibros(){
        return inventario.size();
    }

    public Libro masBarato(){
        Libro Lmenor=new Libro();
        double menor=0;

        for(Libro libro:inventario){
            while(menor>libro.getPrecio()){
                menor=libro.getPrecio();
                Lmenor=libro;
            }
        }

        return Lmenor;
    }

    public Libro masCaro(){
        Libro Lmayor=new Libro();
        double mayor=0;
        
        for(Libro libro:inventario){
            while(mayor<libro.getPrecio()){
                mayor=libro.getPrecio();
                Lmayor=libro;
            }
        }

        return Lmayor;
    }

}
