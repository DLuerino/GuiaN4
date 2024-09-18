import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Usuario> userRegistrados = new ArrayList<>();
        Usuario user = new Usuario("Diego", true);
        Usuario user2 = new Usuario("Lolo", false);
        userRegistrados.add(user);
        userRegistrados.add(user2);

        Artista art1 = new Artista("Zeballos", 22, "Uruguay");
        Album alb1 = new Album("Por si mañana", art1, 2019);

        Artista art2 = new Artista("Kase O", 44, "España");
        Album alb2 = new Album("El circulo", art2, 2016);

        Artista art3 = new Artista("Indio Solari", 75, "Argentina");
        Album alb3 = new Album("El Tesoro de Los Inocentes", art3, 2004);

        Song can1 = new Song("1 de cada 1000", 3.18, Genero.HIPHOP, alb1);
        Song can2 = new Song("El Tesoro de Los Inocentes", 4.19, Genero.ROCK, alb3);
        Song can3 = new Song("Yemen", 4.23, Genero.HIPHOP, alb2);

        ListaReproduccion playlist = new ListaReproduccion();
        playlist.addCancion(can1);
        playlist.addCancion(can2);
        playlist.addCancion(can3);

        ListaBasica list2 = new ListaBasica("Mi Lista Basica");
        list2.addCancion(can1);
        list2.addCancion(can2);
        list2.addCancion(can3);

        ListaPremium miListaPremium = new ListaPremium();
        miListaPremium.addCancion(can1);
        miListaPremium.addCancion(can2);
        miListaPremium.addCancion(can3);

        //System.out.println(playlist.verMiLista());
        //System.out.println(playlist.reproducir(can1));

        //AUX
        int opcion;
        Usuario prueba = new Usuario();
        Usuario userActual = new Usuario();
        userActual = null;
        Scanner sc = new Scanner(System.in);
        Song repro = new Song();
        //repro=null;

        System.out.println("Introduzca su nombre de usuario: ");
        prueba.setNombre(sc.nextLine());

        for (Usuario userP : userRegistrados) {
            if (userP.getNombre().equals(prueba.getNombre())) {
                userActual = userP;
                break;
            }
        }

//        if(userActual==null){
//            System.out.println("El usuario no esta registrado. Intente de nuevo! ");
//        }

        if (userActual == null) {
            int hacer;
            Usuario userAux = new Usuario();

            System.out.println("Su usuario no esta registrado. Que Desea hacer?.");
            System.out.println("1- Crear cuenta. ");
            System.out.println("2- Salir del programa. ");
            hacer = sc.nextInt();
            sc.nextLine();

            switch (hacer) {
                case 1:
                    int esPremium;

                    System.out.println("Ingrese su nombre de usuario: ");
                    userAux.setNombre(sc.nextLine());
                    System.out.println(" Desea convertirse en PREMIUM?");
                    System.out.println("1: SI -- 2: NO");
                    esPremium = sc.nextInt();
                    sc.nextLine();
                    if (esPremium == 1) {
                        Usuario userPremium = new Usuario(userAux.getNombre(), true);
                        userRegistrados.add(userPremium);
                    } else if (esPremium == 2) {
                        Usuario userNOpremium = new Usuario(userAux.getNombre(), false);
                        userRegistrados.add(userNOpremium);
                        System.out.println("Su cuenta sera no PREMIUM. Continuamos");
                    }

                    break;

                case 2:
                    System.out.println(" Saliendo del programa. ");
                    break;

                default:
                    break;
            }
        } else if (userActual.isPremium() == false) {
            System.out.println("Bienvenido " + userActual.getNombre() + "! Eres un usuario NO premium.");

            do {
                System.out.println("[ Que desea hacer? ]");
                System.out.println("1- Reproducir una cancion. ");
                System.out.println("2- Eliminar una cancion. (Requiere Premium)");
                System.out.println("3- Cambiar cancion. (Requiere Premium)");
                System.out.println("4- Ver la lista de reproduccion. ");
                System.out.println("5- Salir del programa. ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println(list2.reproducir(repro));
                        break;

                    case 2:
                        System.out.println(list2.deleteCancion(repro));
                        break;

                    case 3:
                        System.out.println("La cancion" + list2.deleteCancion(repro) + " no puede saltearse. Compre el paquete PREMIUM.");
                        break;

                    case 4:
                        System.out.println(list2.verMiLista());

                    case 5:
                        System.out.println(" Saliendo del programa. ");
                        break;

                    default:
                        System.out.println(" Opcion invalida. Intente de nuevo!");
                        break;
                }
            } while (opcion != 5);
        } else if (userActual.isPremium() == true) {
            System.out.println("Bienvenido " + userActual.getNombre() + "! Eres un usuario PREMIUM.");

            do {
                System.out.println("[ Que desea hacer? ]");
                System.out.println("1- Reproducir una cancion. ");
                System.out.println("2- Añadir una cancion. ");
                System.out.println("3- Eliminar una cancion. ");
                System.out.println("4- Ver la lista de reproduccion. ");
                System.out.println("5- Salir del programa. ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        char pausa;

                        System.out.println(miListaPremium.verMiLista());
                        System.out.println("Que cancion desea reproducir?");
                        repro.setName(sc.nextLine());
                        System.out.println(miListaPremium.reproducir(repro));
                        System.out.println("Ingrese 'P' para pausar la cancion. ");
                        System.out.println("Ingese 'S' para cambiar la cancion. ");
                        pausa = sc.next().charAt(0);
                        sc.nextLine();



                        if(pausa=='p'){
                            System.out.println(miListaPremium.pausar(repro));
                        }else if(pausa=='s'){
                            repro=miListaPremium.cambiarCancion(repro);
                            System.out.println("La cancion cambio a: "+repro);
                        }else{
                            System.out.println("Opcion invalida. Intente mas tarde!");
                        }

                        break;

                    case 2:
                        int gener;
                        int aux;
                        Album albAux = new Album();
                        Artista artAux = new Artista();

                        System.out.println(" Que cancion desea agregar? ");
                        repro.setName(sc.nextLine());
                        System.out.println(" Cual es la duracion de esta cancion? ");
                        repro.setLength(sc.nextDouble());
                        sc.nextLine();
                        System.out.println(" A que genero pertece tu cancion? ");
                        System.out.println("1- Rock");
                        System.out.println("2- Trap");
                        System.out.println("3- Jazz");
                        System.out.println("4- Hip-Hop");
                        System.out.println("5- Metal");
                        System.out.println("6- Clasica");
                        gener = sc.nextInt();
                        sc.nextLine();

                        switch (gener) {
                            case 1:
                                repro.setGener(Genero.ROCK);
                                break;
                            case 2:
                                repro.setGener(Genero.TRAP);
                                break;
                            case 3:
                                repro.setGener(Genero.JAZZ);
                                break;
                            case 4:
                                repro.setGener(Genero.HIPHOP);
                                break;
                            case 5:
                                repro.setGener(Genero.METAL);
                                break;
                            case 6:
                                repro.setGener(Genero.CLASICA);
                                break;
                            default:
                                break;
                        }

                        System.out.println(" Ingrese ALbum al que pertenece: ");
                        albAux.setTitle(sc.nextLine());
                        repro.setAlbum(albAux);

                        System.out.println("La cancion tiene un artista invitado? 1:SI, 2:NO");
                        aux = sc.nextInt();
                        sc.nextLine();
                        if (aux == 1) {
                            System.out.println(" Quien es el/los artista invitado? ");
                            artAux.setNombre(sc.nextLine());
                            repro.setFt(artAux);
                        } else if (aux == 2) {
                            System.out.println("Continuamos. Gracias! ");
                        }

                        miListaPremium.addCancion(repro);

                        break;
                    case 3:
                        System.out.println(miListaPremium.verMiLista());
                        ;
                        System.out.println("Que cancion desea eliminar?");
                        repro.setName(sc.nextLine());
                        System.out.println(miListaPremium.deleteCancion(repro));
                        break;

                    case 4:
                        System.out.println(miListaPremium.verMiLista());
                        break;

                    case 5:
                        System.out.println(" Saliendo del programa. ");
                        break;

                    default:
                        System.out.println(" Opcion invalida. Intente de nuevo!");
                        break;
                }

            } while (opcion != 5);
        }
        sc.close();
    }
}