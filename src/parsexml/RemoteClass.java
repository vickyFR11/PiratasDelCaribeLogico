/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsexml;

import static java.lang.Integer.parseInt;
import java.rmi.*;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jose Gabriel
 */
public class RemoteClass extends UnicastRemoteObject implements RMIInterface{
    private Maquina maquina;
    
    public RemoteClass(Maquina maquina) throws RemoteException{
        super();
        this.maquina = maquina;
    }
    
    @Override
    public boolean desembarcar(Barco barco, String nombreSitio, int idMaquina) throws RemoteException{
        String id[];
        for (int i=0; i < this.maquina.getPuntoSalida().size(); i++){
            id = this.maquina.getPuntoSalida().get(i).split("-");
            
            if (idMaquina == parseInt(id[0])){
                //aparecer el barco
                Hilo hilo = new Hilo(barco,nombreSitio);
        
                hilo.start();
                break;
            }
        }     
        
        System.out.println("Objeto remoto enviado exitosamente");
        System.out.println("Nombre barco: "+barco.getNombre() +" -- Va: "+nombreSitio);

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
            String dato[];
            dato = nombreSitio.split("-");
            
            while(true){
                //Si son diferentes es Remoto, sino es Local
                if (parseInt(dato[0]) != maquina.getId()){
                    //Mover al limite
                    for (int i=0; i < maquina.getSitioRemoto().size(); i++){
                        String ip[];
                        ip = maquina.getIpRemota().get(i).split("-");
                        if (dato[0].equals(ip[0]) == true){
//                            if (barco.llamadaRMI(ip[1], dato[0]+"-"+dato[1], maquina.getId()) == false){
//                                
//                            }
                            break;
                        }
                    }
                    
                    //Desaparecer barco
                }
                //mover al sitio
                //Esperar retorno funcion. Mover Sitio
                
                for (int i=0; i < maquina.getSitio().size(); i++){
                    if (dato[1].equals(maquina.getSitio().get(i).getNombreSitio()) == true){
                        //Retorna true: Cuando se queda sin recursos.
                        if (barco.descontarRecursos(maquina.getSitio().get(i)) == true){
                            //mover a punto de origen (segun el tipo)
                         
                        //Recoger: True si encontro el corazon de la princesa    
                        }else if (barco.recoger(maquina.getSitio().get(i)) == true){
                            //mover a punto de origen (segun el tipo)
                        }
                        break;
                    }
                }
                
                barco.getCofre().getMapa().setSitioActual();
                dato = barco.getCofre().getMapa().getRuta().get(barco.getCofre().getMapa().getSitioActual()).split("-");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RemoteClass.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
//            System.out.println("Entro hilo");
//            for (int i=0; i<5; i++){
//                try {
//                    System.out.println("BARCO: "+barco.getNombre());
//                    Thread.sleep(5000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(RemoteClass.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
         
    }
    
}
