package parsexml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author vicky
 */
public class Barco implements java.io.Serializable{
    private String nombre;
    private int tripulacion;
    private int comida;
    private int municiones;
    private int tipo;
    private Cofre cofre;
    private int maxTripulacion;
    private int maxComida;
    private int maxMuniciones;

    public void reabastecer(){
        this.setTripulacion(this.getMaxTripulacion());
        this.setComida(this.getMaxComida());
        this.setMuniciones(this.getMaxMuniciones());
    }
    
    public void setMaxTripulacion(int maxTripulacion) {
        this.maxTripulacion = maxTripulacion;
    }

    public void setMaxComida(int maxComida) {
        this.maxComida = maxComida;
    }

    public void setMaxMuniciones(int maxMuniciones) {
        this.maxMuniciones = maxMuniciones;
    }
    
    public int getMaxTripulacion() {
        return maxTripulacion;
    }

    public int getMaxComida() {
        return maxComida;
    }

    public int getMaxMuniciones() {
        return maxMuniciones;
    }
       
    public void llamadaRMI(String ip, String nombreSitio){
        try{
            int puerto = 8050;
            String URLRegistro = "rmi://"+ip+":"+puerto+"/barco";
            
            InputStreamReader ent = new InputStreamReader(System.in);
            BufferedReader buf = new BufferedReader(ent);
                        
            RMIInterface objetoRemoto = (RMIInterface)Naming.lookup(URLRegistro);
            if(objetoRemoto.desembarcar(this, nombreSitio)){
                System.out.println("Barco enviado exitosamente");
            }else{
                System.out.println("Error al cruzar de nodo.");
            }
        }catch(NotBoundException e){
            System.out.println("Error al conectar: "+e);
        } catch (MalformedURLException e) {
            System.out.println("Error al conectar: "+e);
        } catch (RemoteException e) {
            System.out.println("Error al conectar: "+e);
        }
    }
    
    /**
     *  Función recoger, recoge y deja objetos en el cofre dependiendo del valor.
     *  Evalua si cambiar el mapa actual por el que está en el cofre, si lo hay.
     *  Retorna true si encontró el corazon de la princesa.
     * @param sitio
     * @return 
     */
    public boolean recoger(Sitio sitio){
        Mapa auxMapa;
        int nroObjetos;
        
        //Recoger todo lo que entre en el cofre. Si el corazón de la princesa
        //no entra en el cofre dejar algo.
    
        //Corazon
        if(sitio.getCofre().getCorazonPrincesa()>0){
            if(sitio.getCofre().getCapacidadActual() + Cofre.pesoCorazon >= sitio.getCofre().getCapacidad()){
                Cofre.liberarEspacio((int)Cofre.pesoCorazon, this.cofre, sitio.getCofre());
            }
            sitio.getCofre().setCorazonPrincesa(0);
            this.cofre.setCorazonPrincesa((int)Cofre.pesoCorazon);
            return true;
        }
    
        //Oro
        if(sitio.getCofre().getOro() > 0 && 
        (this.cofre.getCapacidadActual()+Cofre.pesoOro) <= this.cofre.getCapacidad()){
            nroObjetos = sitio.getCofre().getOro()/(int)Cofre.pesoOro;
            this.cofre.setOro(this.cofre.getOro()+((int)Cofre.pesoOro*nroObjetos));
            sitio.getCofre().setOro(sitio.getCofre().getOro()-((int)Cofre.pesoOro*nroObjetos));
        }
    
        //Plata
        if(sitio.getCofre().getPlata() > 0 && 
        (this.cofre.getCapacidadActual()+Cofre.pesoPlata) <= this.cofre.getCapacidad()){
            nroObjetos = sitio.getCofre().getPlata()/(int)Cofre.pesoPlata;
            this.cofre.setPlata(this.cofre.getPlata()+((int)Cofre.pesoPlata*nroObjetos));
            sitio.getCofre().setPlata(sitio.getCofre().getPlata()-((int)Cofre.pesoPlata*nroObjetos));
        }
    
        //Perlas
        if(sitio.getCofre().getPerlas() > 0 && 
        (this.cofre.getCapacidadActual()+Cofre.pesoPlata) <= this.cofre.getCapacidad()){
            nroObjetos = sitio.getCofre().getPerlas()/(int)Cofre.pesoPlata;
            this.cofre.setPerlas(this.cofre.getPerlas()+((int)Cofre.pesoPlata*nroObjetos));
            sitio.getCofre().setPerlas(sitio.getCofre().getPerlas()-((int)Cofre.pesoPlata*nroObjetos));
        }
    
        //Monedas
        if(sitio.getCofre().getMonedasOro() > 0 && 
        (this.cofre.getCapacidadActual()+Cofre.pesoPlata) <= this.cofre.getCapacidad()){
            nroObjetos = sitio.getCofre().getMonedasOro()/(int)Cofre.pesoPlata;
            this.cofre.setMonedasOro(this.cofre.getMonedasOro()+((int)Cofre.pesoPlata*nroObjetos));
            sitio.getCofre().setMonedasOro(sitio.getCofre().getMonedasOro()-((int)Cofre.pesoPlata*nroObjetos));
        }
    
        //Joyas
        if(sitio.getCofre().getJoyas() > 0 && 
        (this.cofre.getCapacidadActual()+Cofre.pesoPlata) <= this.cofre.getCapacidad()){
            nroObjetos = sitio.getCofre().getJoyas()/(int)Cofre.pesoPlata;
            this.cofre.setJoyas(this.cofre.getJoyas()+((int)Cofre.pesoPlata*nroObjetos));
            sitio.getCofre().setJoyas(sitio.getCofre().getJoyas()-((int)Cofre.pesoPlata*nroObjetos));
        }
    
        //Piedras
        if(sitio.getCofre().getPiedrasPreciosas() > 0 && 
        (this.cofre.getCapacidadActual()+Cofre.pesoPlata) <= this.cofre.getCapacidad()){
            nroObjetos = sitio.getCofre().getPiedrasPreciosas()/(int)Cofre.pesoPlata;
            this.cofre.setPiedrasPreciosas(this.cofre.getPiedrasPreciosas()+((int)Cofre.pesoPlata*nroObjetos));
            sitio.getCofre().setPiedrasPreciosas(sitio.getCofre().getPiedrasPreciosas()-((int)Cofre.pesoPlata*nroObjetos));
        }        
        
        //Recoger mapa
        if(sitio.getCofre().getMapa() != null){
            if(this.cofre.getMapa().getSitiosVisitados() > sitio.getCofre().getMapa().getRuta().size()){
                auxMapa = this.cofre.getMapa();
                this.cofre.setMapa(sitio.getCofre().getMapa());
                this.cofre.setMapa(auxMapa);
                System.out.println("Barco: "+this.nombre+" intercambió tesoro");
            }
        }
        
        return false;
    }
    
    /**
     * Descuenta los recursos del barco, según los costos del sitio, 
     * y de alguna calamidad. Retorna true si luego de descontar queda con
     * menos de 1/3 de los recursos
     * @param sitio
     * @return 
     */
    public boolean descontarRecursos(Sitio sitio){
        this.comida -= sitio.getCostoComida();
        this.tripulacion -= sitio.getCostoTripulacion();
        
        if(sitio.getCalamidad() != null){
            this.comida -= sitio.getCalamidad().getCostoComida();
            this.municiones -= sitio.getCalamidad().getCostoMuniciones();
            this.tripulacion -= sitio.getCalamidad().getCostoHombres();
            
            //Ejecutar calamidad
        }
        
        //Si tiene menos de 1/3 de recursos retornar true
        
        return false;
    }
    
    /**
     * Si el sitio es local, se mueve al sitio, sino se mueve al límite del mapa
     * correspondiente, hace llamada RMI y se mueve al sitio remoto. Luego
     * ejecuta los métodos correspondientes.
     * @param sitio
     */
    public void irASitio(String sitio){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTripulacion(int tripulacion) {
        this.tripulacion = tripulacion;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public void setMuniciones(int municiones) {
        this.municiones = municiones;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setCofre(Cofre cofre) {
        this.cofre = cofre;
    }

    public int getTripulacion() {
        return tripulacion;
    }

    public int getComida() {
        return comida;
    }

    public int getMuniciones() {
        return municiones;
    }

    public int getTipo() {
        return tipo;
    }

    public Cofre getCofre() {
        return cofre;
    }
    
}
