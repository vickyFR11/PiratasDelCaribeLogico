package parsexml;

import java.util.*;
import javax.xml.bind.annotation.*;
/**
 *
 * @author vicky
 */
@XmlRootElement
public class Maquina {
    private int id;
    private String ip;
    private List<String> puntoSalida;
    private Barco barco;
    private List<Sitio> sitio;

    public Barco getBarco() {
        return barco;
    }
    
    @XmlElement(name = "barco") 
    public void setBarco(Barco barco) {
        this.barco = barco;
    }
    
    public List<Sitio> getSitio() {
        return sitio;
    }

    @XmlElement(name = "sitio") 
    public void setSitio(List<Sitio> sitio) {
        this.sitio = sitio;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public List<String> getPuntoSalida() {
        return puntoSalida;
    }
    
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @XmlElement(name = "salida")
    public void setPuntoSalida(List<String> puntoSalida) {
        this.puntoSalida = puntoSalida;
    }
    
    
 
}
