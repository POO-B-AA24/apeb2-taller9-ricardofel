//AUTOR: RICARDO FABIAN ESPINOSA LARGO
public class problema_1_libro {
    public static void main(String[] args) {
        //INSTANCIAR PALABRA
        Palabra palabra = new Palabra(5, "Clock");
        
        //INSTANCIAR SENTENCIA
        Sentencia sentencia = new Sentencia(1, palabra);
        
        //INSTANCIAR FIGURA Y PARRAFO
        Figura figura = new Figura();
        Parrafo parafo = new Parrafo(1,sentencia,palabra);
        
        //INSTANCIAR COMPONENTE Y SECCION
        ComponenteSeccion componente = new ComponenteSeccion();
        Seccion seccion1 = new Seccion(componente);
        
        //INSTANCIAR CAPITULO
        CapituloLibro cap1 = new CapituloLibro("LA ERA FINAL", 10, seccion1);
        System.out.println(cap1);
    }
}

class CapituloLibro {
    public String nombre;
    public int paginas;
    public Seccion seccion;
    public CapituloLibro(String nombreCap, int numPags, Seccion seccion) {
        this.nombre = nombreCap;
        this.paginas = numPags;
        this.seccion = seccion;
    }
    @Override
    public String toString() {
        return "CapituloLibro{" + "nombreCap=" + nombre + ", numPags=" + paginas + ", seccion=" + seccion + '}'; 
    }
}


class Seccion {
    public ComponenteSeccion compSecc;
    public Seccion(ComponenteSeccion compSecc) {
        this.compSecc = compSecc;
    }
    @Override
    public String toString() {
        return "Seccion{" + "compSecc=" + compSecc + '}';
    }
}


class ComponenteSeccion {}


class Figura extends ComponenteSeccion {}


class Parrafo extends ComponenteSeccion {
    public int numParrafos;
    public Sentencia sentencia;
    public Palabra palabra;
    public Parrafo(int numParrafos, Sentencia sentencia, Palabra palabra) {
        this.numParrafos = numParrafos;
        this.sentencia = sentencia;
        this.palabra = palabra;
    }  
    @Override
    public String toString() {
        return "Parrafo{" + "numParrafos=" + numParrafos + ", sentencia=" + sentencia + ", palabra=" + palabra + '}';
    }
}
class Sentencia {
    public int numPalabras;
    public Palabra palabra;
    public Sentencia(int numPalabras, Palabra palabra) {
        this.numPalabras = numPalabras;
        this.palabra = palabra;
    }
    @Override
    public String toString() {
        return "Sentencia{" + "numPalabras=" + numPalabras + '}';
    }
}
class Palabra {
    public int numLetras;
    public String palabra;
    public Palabra(int numLetras, String palabra) {
        this.numLetras = numLetras;
        this.palabra = palabra;
    }
    @Override
    public String toString() {
        return "Palabra{" + "numLetras=" + numLetras + ", palabra=" + palabra + '}';
    }
}