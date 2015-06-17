package parsexml;

import javax.xml.bind.annotation.*;
/**
 *
 * @author vicky
 */

public class Cofre implements java.io.Serializable{
    private Mapa mapa;
    private int oro;
    private int plata;
    private int perlas;
    private int monedasOro;
    private int joyas;
    private int piedrasPreciosas;
    private int corazonPrincesa;
    private int capacidad;

    public Cofre() {
        this.mapa = null;
        this.oro = 0;
        this.plata = 0;
        this.perlas = 0;
        this.monedasOro = 0;
        this.joyas = 0;
        this.piedrasPreciosas = 0;
        this.corazonPrincesa = 0;
        this.capacidad = 0;
    }
    
    public Cofre(int capacidad) {
        this.mapa = null;
        this.oro = 0;
        this.plata = 0;
        this.perlas = 0;
        this.monedasOro = 0;
        this.joyas = 0;
        this.piedrasPreciosas = 0;
        this.corazonPrincesa = 0;
        this.capacidad = capacidad;
    }
    
    public Cofre(Mapa mapa,int oro, int plata, int perlas, int monedasOro, int joyas, int piedrasPreciosas, int corazonPrincesa, int capacidad) {
        this.mapa = mapa;
        this.oro = oro*25;
        this.plata = plata*50;
        this.perlas = perlas*10;
        this.monedasOro = monedasOro*15;
        this.joyas = joyas*15;
        this.piedrasPreciosas = piedrasPreciosas*10;
        this.corazonPrincesa = corazonPrincesa*5;
        this.capacidad = capacidad;
    }
    
    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public void setPerlas(int perlas) {
        this.perlas = perlas;
    }

    public void setMonedasOro(int monedasOro) {
        this.monedasOro = monedasOro;
    }

    public void setJoyas(int joyas) {
        this.joyas = joyas;
    }

    public void setPiedrasPreciosas(int piedrasPreciosas) {
        this.piedrasPreciosas = piedrasPreciosas;
    }

    public void setCorazonPrincesa(int corazonPrincesa) {
        this.corazonPrincesa = corazonPrincesa;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public int getOro() {
        return oro;
    }

    public int getPlata() {
        return plata;
    }

    public int getPerlas() {
        return perlas;
    }

    public int getMonedasOro() {
        return monedasOro;
    }

    public int getJoyas() {
        return joyas;
    }

    public int getPiedrasPreciosas() {
        return piedrasPreciosas;
    }

    public int getCorazonPrincesa() {
        return corazonPrincesa;
    }

    public int getCapacidad() {
        return capacidad;
    }
    
}
