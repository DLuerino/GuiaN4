import java.util.Random;

public class Persona {
    protected String nombre;
    protected int edad;
    protected String sexo;//HoM
    protected int dni;
    protected double peso;
    protected double altura;

    public static int porDebajoDelPeso=-1;
    public static int pesoIdeal=0;
    public static int sobrepeso=1;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.dni = generarDni();
        this.sexo = "H";
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, String sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.dni = generarDni();
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.dni =generarDni();
        this.peso = 0;
        this.altura = 0;
    }

    public int generarDni(){
        Random random = new Random();
        return 10000000+random.nextInt(90000000);
    }

    private char calcularLetraDNI() {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = 23 % getDni();
        return letras.charAt(indice);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getDni() {
        return dni;
    }



    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc=peso/(Math.pow(altura,2));

        if(imc<20){
            return porDebajoDelPeso;
        }else if(imc>=20 && imc<25){
            return pesoIdeal;
        }else if(imc>25){
            return sobrepeso;
        }

        return 0;
    }

    public boolean legalidad(){
        if(getEdad()>=18){
            return true;
        }else if(getEdad()<18){
            return false;
        }

        return false;
    }

    public String comprobarSexo(String sexo){
       if(sexo=="H" || sexo== "M"){
           return sexo;
       }else{
           return "H";
       }
    }

    @Override
    public String toString() {
        return "\n| Persona | [" +
                "  nombre='" + nombre + '\'' +
                ", | edad=" + edad +
                ", | sexo='" + sexo + '\'' +
                ", | dni=" + dni +
                ", | peso=" + peso +
                ", | altura=" + altura +
                " ]";
    }


}
