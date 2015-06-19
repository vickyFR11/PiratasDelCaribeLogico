package parsexml;

import static java.lang.Integer.parseInt;
import java.util.*;

/**
 *
 * @author vicky
 */
public class Mapa implements java.io.Serializable{
    private List<String> ruta; //posicion es el sitio, elemento dentro del ArrayList es IP
    private int nroSitiosVisitados;
    private int sitioActual;

    public Mapa() {
        this.ruta = null;
        this.nroSitiosVisitados = 0;
    }
    
    public Mapa(List<String> ruta) {
        this.ruta = ruta;
    }
    
    /**
     * Retorna true si debe viajar a otro continente, false si el destino es local
     * @param destino
     * @param idLocal
     * @return
     */
    public boolean evaluarDestino(String destino, int idLocal){
        String[] idRemoto;
        
        idRemoto = destino.split("-");
        
        if (parseInt(idRemoto[0]) == idLocal){
            return false;
        }
        return true;
    }

    public void setSitioActual(int sitioActual) {
        this.sitioActual = sitioActual;
    }

    public int getSitioActual() {
        return sitioActual;
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
