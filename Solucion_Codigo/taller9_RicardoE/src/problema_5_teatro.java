//AUTOR: RICARDO FABIAN ESPINOSA LARGO
import java.util.Scanner;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Random;

public class problema_5_teatro {
    public static void main(String[] args) {
        //INSTANCIAR LAS ZONAS
        Zona principal = new Zona("PRINCIPAL", 200, 25, 17.5);
        Zona palcoB = new Zona("PALCOB", 40, 70, 40);
        Zona central = new Zona("CENTRAL", 400, 20, 14);
        Zona lateral = new Zona("LATERAL", 100, 15.5, 10);
        
        //METER EN UNA LISTA LAS ZONAS
        ArrayList<Zona> listaZonas = new ArrayList<>();
        listaZonas.add(principal);
        listaZonas.add(palcoB);
        listaZonas.add(central);
        listaZonas.add(lateral);
        
        //NECESARIO
        int opcion = 0, seguir = 0, numZona = 0, tipoEntrada = 0, IDconsulta = 0;
        Scanner tc = new Scanner(System.in);
        ArrayList<Entrada> compradas = new ArrayList<>();
        
        System.out.println("*******TEATRO CANGREJERO*******");
        do{
            System.out.println("QUE DESEAS HACER??");
            System.out.println("[1] --> VENDER ENTRADA");
            System.out.println("[2] --> CONSULTAR ENTRADA");
            System.out.println("[3] --> SALIR");
            opcion = tc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("QUE ZONA DESEAS?");
                    System.out.println("[1] -> PRINCIPAL");
                    System.out.println("[2] -> PALCOB");
                    System.out.println("[3] -> CENTRAL");
                    System.out.println("[4] -> LATERAL");
                    numZona = tc.nextInt();
                    switch(numZona){
                        case 1:
                            if(principal.verificarPuesto()){
                                System.out.println("INGRESA EL NOMBRE DEL ESPECTADOR: ");
                                String nombreEspectador = tc.next();
                                
                                System.out.println("INGRESA EL TIPO DE ENTRADA:");
                                System.out.println("[1] -> NORMAL");
                                System.out.println("[2] -> ABONADO");
                                System.out.println("[3] -> REDUCIDO");
                                tipoEntrada = tc.nextInt();
                                
                                switch(tipoEntrada){
                                    case 1:
                                        EntradaNormal entrada = new EntradaNormal(principal, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada.calcularPrecioEntrada();
                                        entrada.asignarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        EntradaAbonado entrada1 = new EntradaAbonado(principal, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.asignarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        EntradaReducida entrada2 = new EntradaReducida(principal, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.asignarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                    default:
                                        System.out.println("TIPO DE ENTRADA INCORRECTO");
                                        break;
                                }
                            }else{
                                System.out.println("NO HAY CUPOS PARA EZA ZONA");
                            }
                            break;
                        case 2:
                            if(palcoB.verificarPuesto()){
                                System.out.println("INGRESA EL NOMBRE DEL ESPECTADOR: ");
                                String nombreEspectador = tc.next();
                                
                                System.out.println("INGRESA EL TIPO DE ENTRADA:");
                                System.out.println("[1] -> NORMAL");
                                System.out.println("[2] -> ABONADO");
                                System.out.println("[3] -> REDUCIDO");
                                tipoEntrada = tc.nextInt();
                                
                                switch(tipoEntrada){
                                    case 1:
                                        EntradaNormal entrada = new EntradaNormal(palcoB, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada.calcularPrecioEntrada();
                                        entrada.asignarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        EntradaAbonado entrada1 = new EntradaAbonado(palcoB, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.asignarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        EntradaReducida entrada2 = new EntradaReducida(palcoB, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.asignarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                    default:
                                        System.out.println("TIPO DE ENTRADA INCORRECTO");
                                        break;
                                }
                            }else{
                                System.out.println("NO HAY CUPOS PARA EZA ZONA");
                            }
                            break;
                        case 3:
                            if(central.verificarPuesto()){
                                System.out.println("INGRESA EL NOMBRE DEL ESPECTADOR: ");
                                String nombreEspectador = tc.next();
                                
                                System.out.println("INGRESA EL TIPO DE ENTRADA:");
                                System.out.println("[1] -> NORMAL");
                                System.out.println("[2] -> ABONADO");
                                System.out.println("[3] -> REDUCIDO");
                                tipoEntrada = tc.nextInt();
                                
                                switch(tipoEntrada){
                                    case 1:
                                        EntradaNormal entrada = new EntradaNormal(central, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada.calcularPrecioEntrada();
                                        entrada.asignarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        EntradaAbonado entrada1 = new EntradaAbonado(central, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.asignarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        EntradaReducida entrada2 = new EntradaReducida(central, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.asignarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                    default:
                                        System.out.println("TIPO DE ENTRADA INCORRECTO");
                                        break;
                                }
                            }else{
                                System.out.println("NO HAY CUPOS PARA EZA ZONA");
                            }
                            break;
                        case 4:
                            if(lateral.verificarPuesto()){
                                System.out.println("INGRESA EL NOMBRE DEL ESPECTADOR: ");
                                String nombreEspectador = tc.next();
                                
                                System.out.println("INGRESA EL TIPO DE ENTRADA:");
                                System.out.println("[1] -> NORMAL");
                                System.out.println("[2] -> ABONADO");
                                System.out.println("[3] -> REDUCIDO");
                                tipoEntrada = tc.nextInt();
                                
                                switch(tipoEntrada){
                                    case 1:
                                        EntradaNormal entrada = new EntradaNormal(lateral, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada.calcularPrecioEntrada();
                                        entrada.asignarID();
                                        compradas.add(entrada);
                                        System.out.println(entrada);
                                        break;
                                    case 2:
                                        EntradaAbonado entrada1 = new EntradaAbonado(lateral, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada1.calcularPrecioEntrada();
                                        entrada1.asignarID();
                                        compradas.add(entrada1);
                                        System.out.println(entrada1);
                                        break;
                                    case 3:
                                        EntradaReducida entrada2 = new EntradaReducida(lateral, nombreEspectador);
                                        principal.ocuparPuesto();
                                        entrada2.calcularPrecioEntrada();
                                        entrada2.asignarID();
                                        compradas.add(entrada2);
                                        System.out.println(entrada2);
                                        break;
                                    default:
                                        System.out.println("TIPO DE ENTRADA INCORRECTO");
                                        break;
                                }
                            }else{
                                System.out.println("NO HAY CUPOS PARA ESA ZONA");
                            }
                            break;
                        default:
                            System.out.println("ZONA INCORRECTA");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("INGRESA EL ID DE LA ENTRADA QUE VAS A CONSULTAR");
                    IDconsulta = tc.nextInt();
                    for (int i = 0; i < compradas.size(); i++) {
                        if(compradas.get(i).id == IDconsulta){
                            System.out.println("ENTRADA:");
                            System.out.println("COMPRADOR: "+compradas.get(i).nombreComprador);
                            System.out.println("PRECIO: "+compradas.get(i).precio);
                            System.out.println("ZONA: "+compradas.get(i).zona.nombre);
                        }
                    }
                    break;
                case 3:
                    System.out.println("GRACIAS POR USAR ESTE PROGRAMA");
                    seguir = 1;
                    break;
            }
        }while(seguir == 0);
    }
}
class Zona{
    //ATRIBUTOS
    public String nombre;
    public int capacidad;
    public double precioNormal;
    public double precioAbonado;
    
    //CONSTRUCTOR
    public Zona(String nombre, int capacidad, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
    }
    
    //METODOS ESPECIALES
    public boolean verificarPuesto(){
        if(this.capacidad > 0){
            return true;
        }
        return false;
    }
    public void ocuparPuesto(){
        this.capacidad -= 1;
    }
    
}

//CLASE PADRE
class Entrada{
    //ATRIBUTOS
    public Zona zona;
    public int id;
    public String nombreComprador;
    public double precio;
    
    //CONSTRUCTOR
    public Entrada(Zona zona, String nombreComprador) {
        this.zona = zona;
        this.nombreComprador = nombreComprador;
    }
    
    //METODOS ESPECIALES
    public double calcularPrecioEntrada(){
        this.precio = this.zona.precioNormal;
        return precio;
    }
    
    public void asignarID(){
        Random random = new Random();
        int numeroAleatorio = 10000 + random.nextInt(90000);
        this.id = numeroAleatorio;
    }
    
    //TOSTRING
    @Override
    public String toString() {
        return "Entrada{" + "id=" + id + ", precio=" + precio + '}';
    }
    
}

//CLASE HIJA 1
class EntradaNormal extends Entrada{
    //CONSTRUCTOR
    public EntradaNormal(Zona zona, String nombreComprador){
        super(zona, nombreComprador);
    }
}

//CLASE HIJA 2
class EntradaReducida extends Entrada{
    //CONSTRUCTOR
    public EntradaReducida(Zona zona, String nombreComprador){
        super(zona, nombreComprador);
        
    }

    //METODOS ESPECIALES
    @Override
    public double calcularPrecioEntrada() {
        this.precio = super.calcularPrecioEntrada()*0.85;
        return precio;
    }
}

//CLASE HIJA 3
class EntradaAbonado extends Entrada{
    //CONSTRUCTOR
    public EntradaAbonado(Zona zona, String nombreComprador){
        super(zona, nombreComprador); 
    }

    //METODOS ESPECIALES
    @Override
    public double calcularPrecioEntrada() {
        this.precio = this.zona.precioAbonado;
        return precio;
    }
}