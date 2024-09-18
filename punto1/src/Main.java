import java.util.Scanner;

public class    Main {
    public static void main(String[] args) {
        Libro l1=new Libro("Popeye", "GerchoSport", 1500.99, 1990);
        Libro l2 = new Libro("1984", "George Orwell", 900.75, 1949);
        Libro l3 = new Libro("El principito", "Antoine de Saint-Exupéry", 850.99, 1943);
        Libro l4 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", 1350.00, 1605);
        Libro l5 = new Libro("El hobbit", "J.R.R. Tolkien", 1000.45, 1937);
        Libro l6 = new Libro("Fahrenheit 451", "Ray Bradbury", 1100.30, 1953);
        Libro l7 = new Libro("La sombra del viento", "Carlos Ruiz Zafón", 1250.65, 2001);
        Libro l8 = new Libro("Crimen y castigo", "Fiódor Dostoyevski", 950.40, 1866);

        Inventario tienda=new Inventario();

        System.out.println(tienda.mostrarLibro());

        tienda.agregarLibro(l1);
        tienda.agregarLibro(l2);
        tienda.agregarLibro(l3);
        tienda.agregarLibro(l4);
        tienda.agregarLibro(l5);
        tienda.agregarLibro(l6);
        tienda.agregarLibro(l7);
        tienda.agregarLibro(l8);

        System.out.println(tienda.mostrarLibro());

        Libro busqueda=new Libro();
        String titulo;

        Scanner sc=new Scanner(System.in);
        String confirm;
        int pos;
        String busq;
        double precio;

        int opcion;

        do{
            System.out.println("\n\n Elija una opcion... ");
            System.out.println("[ 1- Buscar un libro ]");
            System.out.println("[ 2- Mostrar libros ]");
            System.out.println("[ 3- Actualizar precio de un libro ]");
            System.out.println("[ 4- Calcular precio total ]");
            System.out.println("[ 5- Contar cantidad de libros ]");
            System.out.println("[ 6- Encontrar libro mas caro y mas barato ]");
            System.out.println("[ 7- Eliminar un libro del inventario ]");
            System.out.println("[ 8- Cerrar programa ]");
            opcion= sc.nextInt();
            sc.nextLine();

            if(opcion<1 || opcion>8 && opcion!=1){
                System.out.println(" Opcion invalida ");
            }

            switch(opcion){
                case 1:
                    System.out.println(" Ingrese el titulo del libro que desea buscar: ");
                    titulo=sc.nextLine();
                    busqueda=tienda.buscarLibro(titulo);

                    if(busqueda==null){
                        System.out.println("\n[ No se encontro libro ]");
                    }else{
                        System.out.println("\n"+busqueda.toString());
                    }

                    break;

                case 2:
                    System.out.println(tienda.mostrarLibro());
                    break;

                case 3:
                    int bus;

                    System.out.println(" Desea modificar el precio de algun libro??");
                    System.out.println(" 1- Modificar mediante posicion. ");
                    System.out.println(" 2- Modificar mediante titulo ");
                    bus=sc.nextInt();
                    sc.nextLine();
                    if(bus==1){
                        System.out.println(" Ingrese la posicion del libro que desea modificar: ");
                        pos=sc.nextInt();
                        sc.nextLine();
                        System.out.println("\n Ingrese el nuevo precio del libro: ");
                        precio=sc.nextDouble();
                        sc.nextLine();
                        System.out.println(tienda.modificarLibroPorPosicion(pos,precio));
                    } else if (bus==2) {
                        System.out.println(" Ingrese el titulo del libro: ");
                        busq=sc.nextLine();
                        System.out.println(" Ingrese el nuevo precio del libro: ");
                        precio=sc.nextDouble();
                        sc.nextLine();
                        System.out.println(tienda.modificarLibroXtitulo(busq,precio));
                    }

                    break;

                case 4:
                    System.out.println("\n\n El precio total de todo el stock de libros es: "+tienda.precioTotal());
                    break;

                case 5:
                    System.out.println(" La cantidad total de libros en stock es de: "+tienda.cantLibros());
                    break;

                case 6:
                    System.out.println("\n El libro mas barato es: "+tienda.masBarato().toString());
                    System.out.println("\n El libro mas caro es: "+tienda.masCaro().toString());
                    break;

                case 7:
                    System.out.println(" Que libro desea eliminar? ");
                    titulo=sc.nextLine();
                    tienda.eliminarLibro(busqueda.setTitulo(titulo));
                    break;

                case 8:
                    System.out.println(" Cerrando programa ");
            }
        }while(opcion!=8);

        sc.close();

    }
}