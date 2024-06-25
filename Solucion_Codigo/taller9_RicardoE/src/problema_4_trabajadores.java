//AUTOR: RICARDO FABIAN ESPINOSA LARGO
import java.util.ArrayList;

public class problema_4_trabajadores {
    public static void main(String[] args) {
        //INSTANCIAR JEFES PARA TRABAJADORES QUE NO SON JEFES
        Jefe jefe1 = new Jefe("RICARDO", "ESPINOSA", "URB PANCETA", "0000000000");
        Jefe jefe2 = new Jefe("JUAN", "GARCIA", "URB CANGREJERA", "111111111");
        Jefe jefe3 = new Jefe("DIEGO", "PONCE", "URB LOPEZ", "2222222222");
        Jefe jefe4 = new Jefe("PEDRO", "LARGO", "URB TEC", "3333333333");
        Jefe jefe5 = new Jefe("MARIO", "LANDI", "URB PRIVADA1", "4444444444");
        Jefe jefe6 = new Jefe("CAMILO", "LOPEZ", "URB TENTRAMITROZON", "5555555555");
        
        //INSTANCIAR TRABAJADORES FIJOS MENSUALES
        FijoMensual fijomensual1 = new FijoMensual(jefe1, "FABIAN", "CAICEDO", "URB PILETA", "6666666666");
        FijoMensual fijomensual2 = new FijoMensual(jefe2, "LOCO", "CAICEDO", "URB OESTE", "7777777777");
        
        //INSTANCIAR TRABAJADORES COMISIONISTAS
        Comisionista comisionista1 = new Comisionista(jefe2, 5, "IGNACIO", "ROBLES", "URB SUR", "8888888888");
        Comisionista comisionista2 = new Comisionista(jefe2, 5, "EMILIO", "ROMAN", "URB ESTE", "9999999999");
        
        //INSTANCIAR TRABAJADORES POR HORAS
        PorHoras porhoras1 = new PorHoras(jefe3, 45, "JOSE", "LOPEZ", "URB TEATRO", "101010101010");
        PorHoras porhoras2 = new PorHoras(jefe3, 45, "KEVIN", "GAMBOY", "URB NORTE", "202020202020");
        
        //INSTANCIAR JEFES SOLOS
        Jefe jefe7 = new Jefe("NELSON", "PERERO", "AV CESAR CHAVEZ", "3030303030");
        Jefe jefe8 = new Jefe("ALLAN", "TORRES", "AV OLMENDO", "4040404040");
        
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<>();
        listaTrabajadores.add(jefe1);
        listaTrabajadores.add(jefe2);
        listaTrabajadores.add(jefe3);
        listaTrabajadores.add(jefe4);
        listaTrabajadores.add(jefe5);
        listaTrabajadores.add(jefe6);
        listaTrabajadores.add(jefe7);
        listaTrabajadores.add(jefe8);
        listaTrabajadores.add(fijomensual1);
        listaTrabajadores.add(fijomensual2);
        listaTrabajadores.add(comisionista1);
        listaTrabajadores.add(comisionista2);
        listaTrabajadores.add(porhoras1);
        listaTrabajadores.add(porhoras2);
        
        //INSTANCIAR NOMINA COMPLETA
        NominaTrabajadores nomina = new NominaTrabajadores(listaTrabajadores);
        
        //ASIGNAR EL SUELDO DE TODOS LOS TRABAJADORES
        for(Trabajador trabajador : nomina.listaTrabajadores){
            trabajador.calcularSueldo();
        }
        
        //PRUEBA DE METODOS
        nomina.darAltaTrabajador("6666666666"); //NO DEBE APARECER EN LA LISTA EL TRABAJADOR CON ID: 6666666666
        nomina.fijarHorasRealizadas();
        nomina.fijarVentasRealizadas();
        
        //MOSTRAR LA LISTA
        System.out.println(nomina.imprimirNomina());
    }
}

class NominaTrabajadores{
    //ATRIBUTOS
    public ArrayList<Trabajador> listaTrabajadores;
    public int horasRealizadas;
    public int ventasRealizadas;
    
    //CONSTRUCTOR
    public NominaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }
    
    //METODOS ESPECIALES
    public void darAltaTrabajador(String DNI){
        for (int i = 0; i < listaTrabajadores.size(); i++) {
            if(listaTrabajadores.get(i).DNI.equalsIgnoreCase(DNI)){
                listaTrabajadores.remove(i);
            }
        }
    }
    
    public void fijarHorasRealizadas(){
        for(Trabajador trabajador : listaTrabajadores){
            if(trabajador instanceof PorHoras){
                this.horasRealizadas += ((PorHoras) trabajador).horasTrabajadas;
            }
        }
    }
    
    public void fijarVentasRealizadas(){
        for(Trabajador trabajador : listaTrabajadores){
            if(trabajador instanceof Comisionista){
                this.ventasRealizadas += ((Comisionista) trabajador).ventasRealizadas;
            }
        }
    }

    public String imprimirNomina(){
        StringBuilder cadena = new StringBuilder();
        cadena.append("NOMINA DE TRABAJADORES: ").append("\n");
        for(Trabajador trabajador : listaTrabajadores){
            cadena.append(trabajador).append("\n");
        }
        cadena.append("HORAS TOTALES: ").append(horasRealizadas).append("\n");
        cadena.append("VENTAS REALIZADAS: ").append(ventasRealizadas).append("\n");
        return cadena.toString();
    }
}

//CLASE PADRE
class Trabajador{
    //ATRIBUTOS
    public String nombre;
    public String apellido;
    public String direccion;
    public String DNI;
    public double sueldo;
    
    //CONSTRUCTOR
    public Trabajador(String nombre, String apellido, String direccion, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.DNI = DNI;
    } 
    
    //METODOS ESPECIALES
    public void calcularSueldo(){
        //SE ESTABLECE AQUI SOLO PARA PODER SACAR EL SUELDO DE TODA LA LISTA EN UN FOR
    }
    @Override
    public String toString() {
        return "nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", DNI=" + DNI + ", sueldo=" + sueldo;
    }
}

//CLASE HIJA 1
class FijoMensual extends Trabajador{
    //ATRIBUTOS
    public Jefe jefe;
    
    //CONSTRUCTOR
    public FijoMensual(Jefe jefe, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.jefe = jefe;
    }
    
    //METODOS ESPECIALES
    @Override
    public void calcularSueldo(){
        this.sueldo = 425; //SUELDO BASICO
    }
    
    @Override
    public String toString() {
        return super.toString() + " jefe=" + jefe.nombre;
    }
}

//CLASE HIJA 2
class Comisionista extends Trabajador{
    //ATRIBUTOS
    public Jefe jefe;
    public int ventasRealizadas;
    
    //CONSTRUCTOR
    public Comisionista(Jefe jefe, int ventasRealizadas, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.jefe = jefe;
        this.ventasRealizadas = ventasRealizadas;
    }
    
    //METODOS ESPECIALES
    @Override
    public void calcularSueldo(){
        //GANA UNA COMISION DEL 30& DE CADA VENTA REALIZADA
        //ASUMIENDO QUE CADA VENTA ES DE $100
        this.sueldo = (this.ventasRealizadas*100)*0.30;
    }

    @Override
    public String toString() {
        return super.toString() + " jefe=" + jefe.nombre + ", ventasRealiadas=" + ventasRealizadas;
    }
}

//CLASE HIJA 3
class PorHoras extends Trabajador{
    //ATRIBUTOS
    public Jefe jefe;
    public int horasTrabajadas;
    
    //CONSTRUCTOR
    public PorHoras(Jefe jefe, int horasTrabajadas, String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
        this.jefe = jefe;
        this.horasTrabajadas = horasTrabajadas;
    }
    
    //METODOS ESPECIALES
    @Override
    public void calcularSueldo(){
        //GANA 10 POR HORA
        this.sueldo = this.horasTrabajadas*10;
        //SI EXEDE DE 40 HORAS HORAS TRABAJADAS DESDE LA 41 GANA 20
        if(this.horasTrabajadas > 40){
            this.sueldo = (40*10)+(this.horasTrabajadas-40)*20;
            //VALOR DE LAS 40 PRIMERAS HORAS * 10 MAS LAS SIGUIENTES MULTIPLICADAS * 20
        }
    }

    @Override
    public String toString() {
        return super.toString() + " jefe=" + jefe.nombre + ", horasTrabajadas=" + horasTrabajadas;
    }
}

//CLASE HIJA 4
class Jefe extends Trabajador{
    //CONSTRUCTOR
    public Jefe(String nombre, String apellido, String direccion, String DNI) {
        super(nombre, apellido, direccion, DNI);
    }
    
    //METODOS ESPECIALES
    @Override
    public void calcularSueldo(){
        this.sueldo = 2000; //SUELDO DE JEFE
    }
}