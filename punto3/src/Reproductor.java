public interface Reproductor {
    String reproducir(Song cancion);
    String pausar(Song cancion);
    String  addCancion(Song cancion);
    String deleteCancion(Song cancion);
    String verMiLista();
    Song cambiarCancion(Song cancion);
}
