
import java.util.ArrayList;
import java.util.Scanner;

//AUTOR: RICARDO FABIAN ESPINOSA LARGO
public class problema_3_mensajes {
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        SistemaMensajes sistemaMensajes = new SistemaMensajes();
        String remitente = "Pedro";
        String numMovil = "0987";

        while (true) {
            System.out.println("[1] Enviar mensaje");
            System.out.println("[2] Leer mensajes");
            int resp = tc.nextInt();
            if (resp == 1) {
                tc.nextLine();
                System.out.println("Ingrese el numero del destinario");
                String numMovilDest = tc.nextLine();
                System.out.println("Ingrese el nombre del destinario");
                String destinario = tc.nextLine();
                System.out.println("[1] TEXTO");
                System.out.println("[2] IMAGEN");
                int resp2 = tc.nextInt();
                if (resp2 == 1) {
                    tc.nextLine();
                    System.out.println("Ingrese el mensaje");
                    String mensaje = tc.nextLine();
                    sistemaMensajes.enviarMensaje(remitente, numMovil, mensaje, numMovilDest, destinario, resp2);
                }
                if (resp2 == 2) {
                    tc.nextLine();
                    System.out.println("Ingrese el nombre del fichero de la imagen");
                    String nombreFichero = tc.nextLine();
                    sistemaMensajes.enviarMensaje(remitente, numMovil, nombreFichero, numMovilDest, destinario, resp2);
                }
                System.out.println("======  MENSAJE ENVIADO  ======");
            }
            if (resp == 2) {
                System.out.println("Bandeja de entrada: \n" + sistemaMensajes.visualizarMensaje());
            }
            System.out.println("Desea Seguir Interactuando? [1]SI / [2] NO");
            int resp3 = tc.nextInt();
            if (resp3 == 2) {
                break;
            }
        }
    }
}

class SistemaMensajes {

    public ArrayList bandejaEntrada = new ArrayList(); // se crea un arraylist donde se almacenarian los mensajes que le llegan

    public void enviarMensaje(String remitente, String numMovil, String info, String numMovilDest, String destinario, int resp2) {
        Mensaje mensaje = new Mensaje(remitente, destinario, numMovil, numMovilDest);
        String datosMensaje=mensaje.toString();
        if(resp2==1){
            
            SMS sms = new SMS(info, datosMensaje);
            bandejaEntrada.add(sms);
            
        }
        if(resp2==2){
            MMS mms = new MMS(info, datosMensaje);
            bandejaEntrada.add(mms);
            
        }
        
    }

    public ArrayList visualizarMensaje() {

        return bandejaEntrada;
    }
}

class Mensaje {

    public String reminente;
    public String destinario;
    public String numMovilRemit;
    public String numMovilDest;


    

    public Mensaje(String reminente, String destinario, String numMovilRemit, String numMovilDest) {
        this.reminente = reminente;
        this.destinario = destinario;
        this.numMovilRemit = numMovilRemit;
        this.numMovilDest = numMovilDest;

    }
    public Mensaje() {
    }
    
    @Override
    public String toString() {
        return "Mensaje{" + "reminente=" + reminente + ", destinario=" + destinario + ", numMovilRemit=" + numMovilRemit + ", numMovilDest=" + numMovilDest + '}';
    }
}

class SMS extends Mensaje {

    public String caracteresMensaje;
    public String datosMensaje;

    public SMS(String caracteresMensaje, String datosMensaje) {
        this.caracteresMensaje = caracteresMensaje;
        this.datosMensaje = datosMensaje;
    }
   

    @Override
    public String toString() {
        return "SMS{ " +datosMensaje+ " caracteresMensaje=" + caracteresMensaje + "}\n";
    }

}

class MMS extends Mensaje {

    public String nombreFichero;
    public String datosMensaje;
    
    public MMS(String nombreFichero,String datosMensaje) {
        this.nombreFichero = nombreFichero;
        this.datosMensaje = datosMensaje;
    }

    @Override
    public String toString() {
        return "MMS{" + datosMensaje+"nombreFichero=" + nombreFichero + "}\n";
    }
}