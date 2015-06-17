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
