package parsexml;

import java.util.*;

/**
 *
 * @author vicky
 */
public class Mapa implements java.io.Serializable{
    private List<String> ruta; //posicion es el sitio, elemento dentro del ArrayList es IP
    private int nroSitiosVisitados;

    public Mapa() {
        this.ruta = null;
        this.nroSitiosVisitados = 0;
    }
    
    public Mapa(List<String> ruta) {
        this.ruta = ruta;
    }

    public void setRuta(List<String> ruta) {
        this.ruta = ruta;
    }

    public void setSitiosVisitados(int nroSitiosVisitados) {
        this.nroSitiosVisitados = nroSitiosVisitados;
    }

    public List<String> getRuta() {
        return ruta;
    }

    public int getSitiosVisitados() {
        return nroSitiosVisitados;
    }
    
    
}
