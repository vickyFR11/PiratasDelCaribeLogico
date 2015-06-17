/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsexml;

import java.rmi.*;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jose Gabriel
 */
public class RemoteClass extends UnicastRemoteObject implements RMIInterface{
    
    public RemoteClass() throws RemoteException{
        super();
    }
    
    @Override
    public boolean desembarcar(Barco barco, String nombreSitio) throws RemoteException{
        System.out.println("Objeto remoto enviado exitosamente");
        System.out.println("Nombre barco: "+barco.getNombre() +" -- Va: "+nombreSitio);
        Hilo hilo = new Hilo(barco,nombreSitio);
        
        hilo.start();
//        try {
//            hilo.run(barco, nombreSitio);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(RemoteClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return true;
    }
    
    public class Hilo extends Thread {
        private Barco barco;
        private String nombreSitio;

        public Hilo(Barco barco, String nombreSitio) {
            this.barco = barco;
            this.nombreSitio = nombreSitio;
        }

        @Override
        public void run(){
            System.out.println("Entro hilo");
            for (int i=0; i<5; i++){
                try {
                    System.out.println("BARCO: "+barco.getNombre());
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RemoteClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
         
    }
    
}
