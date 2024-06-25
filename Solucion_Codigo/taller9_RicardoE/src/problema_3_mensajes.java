//AUTOR: RICARDO FABIAN ESPINOSA LARGO

import java.util.ArrayList;
import java.util.Scanner;

public class problema_3_mensajes {
    //EJECUTOR
    
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        SistemaMensajes sistemaMensajes = new SistemaMensajes();
        
        String remitente = "RICARDO";
        String numMovil = "87528";

        while (true) {
            System.out.println("QUE DESEA HACER? ");
            System.out.println("[1] ENVIAR");
            System.out.println("[2] LEER");
            int resp = tc.nextInt();
            if (resp == 1) {
                tc.nextLine();
                System.out.println("INGRESA EL NUMERO DEL RECEPTOR");
                String numMovilDest = tc.nextLine();
                System.out.println("INGRESA EL NOMBRE DEL RECEPTOR");
                String destinario = tc.nextLine();
                System.out.println("[1] TEXTO");
                System.out.println("[2] IMAGEN");
                int resp2 = tc.nextInt();
                if (resp2 == 1) {
                    tc.nextLine();
                    System.out.println("INGRESA EL MENSAJE");
                    String mensaje = tc.nextLine();
                    sistemaMensajes.enviarMensaje(remitente, numMovil, mensaje, numMovilDest, destinario, resp2);
                }
                if (resp2 == 2) {
                    tc.nextLine();
                    System.out.println("INGRESA LA DIRECCION DEL ARCHIVO");
                    String nombreFichero = tc.nextLine();
                    sistemaMensajes.enviarMensaje(remitente, numMovil, nombreFichero, numMovilDest, destinario, resp2);
                }
                System.out.println("MENSAJE ENIADO CON EXITO");
            }
            if (resp == 2) {
                System.out.println("MENSAJES:: \n" + sistemaMensajes.visualizarMensaje());
            }
            System.out.println("DESEAS SEGUIR EN ELPROGRAMA? [1]SI / [2] NO");
            int resp3 = tc.nextInt();
            if (resp3 == 2) {
                break;
            }
        }
    }
}

class SistemaMensajes {

    public ArrayList bandejaEntrada = new ArrayList(); 

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

// CLASE PADRE
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

//CLASE HIJA 1
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

//CLASE HIJA 2
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