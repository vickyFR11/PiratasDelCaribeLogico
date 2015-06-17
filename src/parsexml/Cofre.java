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
    private int totalActual;
    public static int pesoOro = 25;
    public static int pesoPlata = 50;
    public static int pesoPerlas = 10;
    public static int pesoMonedas = 15;
    public static int pesoJoyas = 15;
    public static int pesoPiedras = 10;
    public static int pesoCorazon = 5;

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
        this.oro = oro*pesoOro;
        this.plata = plata*pesoPlata;
        this.perlas = perlas*pesoPerlas;
        this.monedasOro = monedasOro*pesoMonedas;
        this.joyas = joyas*pesoJoyas;
        this.piedrasPreciosas = piedrasPreciosas*pesoPiedras;
        this.corazonPrincesa = corazonPrincesa*pesoCorazon;
        this.capacidad = capacidad;
    }
    
    public int getCapacidadActual(){
        this.totalActual = this.oro + this.plata + this.perlas + this.monedasOro + this.joyas + this.piedrasPreciosas + this.corazonPrincesa;
        
        return totalActual;
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
