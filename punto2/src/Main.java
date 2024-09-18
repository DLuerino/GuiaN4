import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char confirm='s';

        Persona p1 = new Persona();
        Persona p2 = new Persona("Godie", 23, "h", 80.5, 178.0);
        Persona p3 = new Persona("Gote", 23, "M");

        while (confirm=='s') {
            System.out.println("Ingrese su Nombre: ");
            p1.setNombre(sc.next());
            System.out.println(" Ingrese su edad: ");
            p1.setEdad(sc.nextInt());
            System.out.println(" Ingrese su sexo: ");
            p1.comprobarSexo(sc.next());
            System.out.println(" Ingrese su peso (en KG): ");
            p1.setPeso(sc.nextDouble());
            System.out.println(" Ingrese su altura (en Metros): ");
            p1.setAltura(sc.nextDouble());

            System.out.println(" Desea ingresar una persona? s/n");
            confirm = sc.next().charAt(0);
        }


        /*System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());*/

        HashMap<Integer, Persona> personas=new HashMap<>();
        personas.put(p1.getDni(), p1);
        personas.put(p2.getDni(), p2);
        personas.put(p3.getDni(), p3);

        for (Persona persona : personas.values()) {
            System.out.println(persona);
            int imcResultado=persona.calcularIMC();

            switch (imcResultado) {
                case -1:
                    System.out.println(" Esta por debajo del peso ideal ");
                    break;
                case 0:
                    System.out.println(" Esta en su peso ideal ");
                    break;
                case 1:
                    System.out.println(" Tiene sobrepeso ");
                    break;
                    default:
                        System.out.println("NO FUNCIONA");
                        break;
            }

            if(persona.legalidad()==true){
                System.out.println(" Es mayor de edad ");
            }else{
                System.out.println(" Es menor de edad ");
            }

            System.out.println();
        }

        sc.close();

    }
}