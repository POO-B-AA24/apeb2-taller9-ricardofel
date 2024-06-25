//AUTOR: RICARDO FABIAN ESPINOSA LARGO
/*
    Para resolver el ejercicio estableci los siguientes lineamientos:
    -LAS PELICULAS SE CLASIFICAN EN:
        *EXCLUSIVO
        *TODO PUBLICO
        *INFANTIL
    -LOS COSTOS DE ALQUILER DE LAS PELICULAS SE CALCULAN EN BASE A ESA CLASIFICACION.
        *EXCLUSIVO = $20
        *TODO PUBLICO = $10
        *INFANTIL = $8
    Esto lo hice debido a que en el problema dice que se calcula el costo en base al
    tipo de pelicula, entonces cree un atributo extra en la clase Pelicula para guardar
    el tipo(clasificacion).
        
    -LA EJECUCION SE HACE CON 5 PELICULAS.
    
    -EL PROBLEMA PIDE QUE PARA LOS DVD TENGAN VARIOS IDIOMAS Y LOS VHS SOLO UNO, PARA DAR
    SOLUCION A ESO, HICE QUE EL ATRIBUTO IDIOMA EN LA CLASE PELICULA SEA UN ARRAYLIST, YA QUE
    PUEDE CONTENER YA SEA UN SOLO IDIOMA(PARA VHS) O VARIOS IDIOMAS (PARA DVD).

    -HAY UNIDADES ILIMITADAS DE CADA PELICULA
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class problema_2_peliculas {
    public static void main(String[] args) {
        //INSTANCIAR EL OBJETO PARA LA GENERACION ALEATORIA
        Random aleatorio = new Random();

        //ARREGLOS PARA EL USO ALEATORIO DE DATOS
        //EXCLUSIVO
        String[] exclusivo = {"Misión Mortal","Espadas en Acción","Operación Bollo",
            "El Control Remoto Perdido 2","El Último Guerrero","Batalla de Consolas",
            "Ecos de Venganza","Encrucijada de Fuego","Laberinto Mortal","El Regreso del USB"};
        //TODO PUBLICO
        String[] todoPublico = {
            "Aventura en la Selva", "El Tesoro Perdido", "Un Viaje Extraordinario",
            "Amigos Inseparables", "El Misterio del Faro", "Vacaciones en el Lago",
            "El Gran Desafio", "El Secreto del Bosque", "Historias de Heroes",
            "La Magia del Circo"};
        //INFANTIL
        String[] infantil = {
            "El Reino de los Juguetes", "La Princesa Valiente", "Aventuras en el Espacio",
            "El Bosque Encantado", "El Dragon Amigable", "El Castillo de los Suenios",
            "Los Amigos del Zoologico", "El Misterio del Arcoiris", "Viaje a la Isla de la Fantasia",
            "El Gran Festival de la Musica"};
        //AUTORES
        String[] autores = {
            "Ricardo P.", "Ana G.", "Luis M.",
            "Maria R.", "Pedro L.", "Laura T.",
            "Carlos S.", "Elena B.", "Diego C.",
            "Sofia J."};

        //INSTANCIAR OBJETOS PARA LOS SOPORTES DE LAS PELICULAS
        DVD soporteP1 = new DVD(3.7); //PELICULA 1 - DVD
        VHS soporteP2 = new VHS("ESTANDAR"); //PELICULA 2 - VHS
        DVD soporteP3 = new DVD(3.9); //PELICULA 3 - DVD
        VHS soporteP4 = new VHS("MAGNETICA"); //PELICULA 4 - VHS
        DVD soporteP5 = new DVD(4.1); //PELICULA 5 - DVD
        
        //CREAR ARRAYLIST PARA IDIOMAS
        ArrayList<String> idiomaP1 = new ArrayList<>(Arrays.asList("ESPANIOL","INGLES","PORTUGUES","ESPERANTO")); //DVD - P1
        ArrayList<String> idiomaP2 = new ArrayList<>(Arrays.asList("INGLES")); //VHS - P2
        ArrayList<String> idiomaP3 = new ArrayList<>(Arrays.asList("INGLES","ITALIANO","CASTELLANO")); //DVD -P3
        ArrayList<String> idiomaP4 = new ArrayList<>(Arrays.asList("BULGARO")); //VHS -P4
        ArrayList<String> idiomaP5 = new ArrayList<>(Arrays.asList("ESPANIOL","FRANCES","LATIN")); //DVD ´P5
        
        //INSTANCIAR LAS PELICULAS
        ArrayList<Pelicula> listaPelis = new ArrayList<>();
        //PELICULA 1: EXCLUSIVO - DVD
        listaPelis.add(new Pelicula(exclusivo[aleatorio.nextInt((9 - 0) + 1) + 0], 
                autores[aleatorio.nextInt((9 - 0) + 1) + 0], 2015, idiomaP1, 
                "EXCLUSIVO", soporteP1));
        //PELICULA 2: EXCLUSIVO - VHS
        listaPelis.add(new Pelicula(exclusivo[aleatorio.nextInt((9 - 0) + 1) + 0], 
                autores[aleatorio.nextInt((9 - 0) + 1) + 0], 1999, idiomaP2, 
                "EXCLUSIVO", soporteP2));
        //PELICULA 3: TODO PUBLICO - DVD
        listaPelis.add(new Pelicula(todoPublico[aleatorio.nextInt((9 - 0) + 1) + 0], 
                autores[aleatorio.nextInt((9 - 0) + 1) + 0], 2021, idiomaP3, 
                "TODO PUBLICO", soporteP3));
        //PELICULA 4: TODO PUBLICO - VHS
        listaPelis.add(new Pelicula(todoPublico[aleatorio.nextInt((9 - 0) + 1) + 0], 
                autores[aleatorio.nextInt((9 - 0) + 1) + 0], 1998, idiomaP4, 
                "TODO PUBLICO", soporteP4));
        //PELICULA 5: INFANTIL - DVD
        listaPelis.add(new Pelicula(infantil[aleatorio.nextInt((9 - 0) + 1) + 0], 
                autores[aleatorio.nextInt((9 - 0) + 1) + 0], 2018, idiomaP5, 
                "INFANTIL", soporteP5));
       
        //CALCULAR LOS COSTOS DE ALQUILER PARA CADA PELICULA
        for (Pelicula peli : listaPelis){
            peli.calcularCostoAlquiler();
        }
        
        //MENU
        Scanner tc = new Scanner(System.in);
        int seguir = 0,opcion = 0, numPelicula = 0, pago = 0;
        double total = 0;
        ArrayList<String>pelisElegidas = new ArrayList<>();
        
        System.out.println("*******RICKY STORE*******");
        do{
            System.out.println("QUE DESEAS HACER?");
            System.out.println("[1] --> MOSTRAR PELICULAS DISPONIBLES");
            System.out.println("[2] --> AGREGAR UNA PELICULA AL CARRITO");
            System.out.println("[3] --> PAGAR Y SALIR");
            opcion = tc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("PELICULAS DISONIBLES PARA ALQUILAR:");
                    System.out.println("NOTA: HAY UNIDADES ILIMITADAS DE CADA PELICULA\n");
                    for (int i = 0; i < listaPelis.size(); i++) {
                        System.out.println("PELICULA "+(i+1));
                        System.out.println(listaPelis.get(i));
                    }
                    break;
                case 2:
                    System.out.println("INGRESA EL NUMERO DE PELICULA QUE DESEAS AGEGAR:");
                    numPelicula = tc.nextInt();
                    System.out.println("HAS AGREGADO LA PELICULA: ");
                    System.out.println(listaPelis.get(numPelicula-1).titulo);
                    
                    //ACUMULAR PARA EL TOTAL
                    pelisElegidas.add(listaPelis.get(numPelicula-1).titulo);
                    total += listaPelis.get(numPelicula-1).costoAlquiler;
                    break;
                case 3:
                    System.out.println("HAZ ELEGIDO LAS PELICULAS:");
                    for (String titulo : pelisElegidas){
                        System.out.println(titulo);
                    }
                    System.out.println("EL TOTAL ES: "+total);
                    System.out.println("PARA HACER EL PAGO INGRESA CUALQUIER NUMERO");
                    pago = tc.nextInt();
                    break;
                default:
                    System.out.println("OPCION INCORRECTA, VUELVE A INGRESAR EL NUMERO");
                    break;
            }
            if(opcion == 3){
                seguir = 1;
                System.out.println("GRACIAS POR USAR EL PROGRAMA");
            }
        }while(seguir == 0);
    }
}

class Pelicula {
    //ATRIBUTOS
    public String titulo;
    public String autor;
    public int anioedicion;
    public ArrayList<String> idioma;
    public String clasificacion;
    public double costoAlquiler;
    public Soporte soporte;

    //CONSTRUCTOR
    public Pelicula(String titulo, String autor, int anioedicion, ArrayList<String> idioma, String clasificacion, Soporte soporte) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioedicion = anioedicion;
        this.idioma = idioma;
        this.clasificacion = clasificacion;
        this.soporte = soporte;
    }

    //METODOS EXTRA
    public void calcularCostoAlquiler() {
        //CALCULAR EL COSTO ORIGINAL DE LAS PELICULAS
        if(this.clasificacion.equalsIgnoreCase("EXCLUSIVO"))
            this.costoAlquiler = 20;
        else if(this.clasificacion.equalsIgnoreCase("TODO PUBLICO"))
            this.costoAlquiler = 10;
        else if(this.clasificacion.equalsIgnoreCase("INFANTIL"))
            this.costoAlquiler = 8;
        
        //HACER QUE LAS DVD SEAN 10% MAS CARAS
        if (soporte instanceof DVD) {
            this.costoAlquiler *= 1.1;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public double getCostoAlquiler() {
        return costoAlquiler;
    }
    
    //TOSTRING
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append("TITULO: ").append(this.titulo).append("\n");
        cadena.append("AUTOR: ").append(this.autor).append("\n");
        cadena.append("CLASIFICACION: ").append(this.clasificacion).append("\n");
        cadena.append("ANIO EDICION: ").append(this.anioedicion).append("\n");
        cadena.append("IDIOMA(S): ").append(this.idioma).append("\n");
        cadena.append("COSTO DE ALQUILER: ").append(this.costoAlquiler).append("\n");
        cadena.append("SOPORTE: ").append(this.soporte).append("\n");
        return cadena.toString();
    }
}

//CLASE PADRE
class Soporte {

}

//CLASE HIJA 1
class DVD extends Soporte {

    //ATRIBUTOS
    private double capacidadGB;

    //CONSTRUCTOR
    public DVD(double capacidadGB) {
        this.capacidadGB = capacidadGB;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "DVD{" + "CAPACIDAD EN GB = " + capacidadGB + '}';
    }
}

//CLASE HIJA 2
class VHS extends Soporte {

    //ATRIBUTOS
    private String tipoCinta;

    //CONSTRUCTOR
    public VHS(String tipoCinta) {
        this.tipoCinta = tipoCinta;
    }

    //TOSTRING
    @Override
    public String toString() {
        return "VHS{" + "TIPO DE CINTA = " + tipoCinta + '}';
    }
}