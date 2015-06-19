package parsexml;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
//Imports RMI
import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 *
 * @author vicky
 */
public class ParseXML {

    public static void main(String[] args) {
        int i, cofres;
        List<String> ruta;
        String nCalamidad;
        int oro, plata, perlas, monedas, joyas, piedras, corazon, capac;
        int cHombres, cComida, cMuniciones;
        //Variables Jose
        InputStreamReader ent = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(ent);
        String numPuerto, URLRegistro;
       
        System.setProperty("java.rmi.server.hostname", "192.168.110.102");
        
        try {
 
		File file = new File("src/parsexml/configXML/maquina01.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Maquina.class);
 
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Maquina objeto = (Maquina) jaxbUnmarshaller.unmarshal(file);
                
                Barco barco = objeto.getBarco();
                Cofre cBarco = new Cofre(objeto.getBarco().getCofre().getCapacidad());
                
                barco.setCofre(cBarco);
                barco.reabastecer();
                
                //System.out.println(barco.getComida());
                
                for (i=0 ; i< objeto.getSitio().size(); i++){
                    oro = objeto.getSitio().get(i).getCofre().getOro();
                    plata = objeto.getSitio().get(i).getCofre().getPlata();
                    perlas = objeto.getSitio().get(i).getCofre().getPerlas();
                    monedas = objeto.getSitio().get(i).getCofre().getMonedasOro();
                    joyas = objeto.getSitio().get(i).getCofre().getJoyas();
                    piedras = objeto.getSitio().get(i).getCofre().getPiedrasPreciosas();
                    corazon = objeto.getSitio().get(i).getCofre().getCorazonPrincesa();
                    capac = objeto.getSitio().get(i).getCofre().getCapacidad();
                   
                    ruta = objeto.getSitio().get(i).getCofre().getMapa().getRuta();
                    
                    //System.out.println(objeto.getSitio().get(i).getCalamidad());
                    
                    if (objeto.getSitio().get(i).getCalamidad() != null){
                        nCalamidad = objeto.getSitio().get(i).getCalamidad().getNombre();
                        cHombres = objeto.getSitio().get(i).getCalamidad().getCostoHombres();
                        cMuniciones = objeto.getSitio().get(i).getCalamidad().getCostoMuniciones();
                        cComida = objeto.getSitio().get(i).getCalamidad().getCostoComida();

                        Calamidad calamidad = new Calamidad(nCalamidad, cHombres, cMuniciones, cComida);
                        objeto.getSitio().get(i).setCalamidad(calamidad);
                    }
                    
                    Mapa mapa = new Mapa(ruta);

                    Cofre cofre = new Cofre(mapa, oro,plata,perlas,monedas,joyas,piedras,corazon,capac);
                    
                    objeto.getSitio().get(i).setCofre(cofre);
                    
                    //System.out.println(objeto.getSitio().get(i).getCofre());
                }
                
	  } catch (JAXBException e) {
		System.out.println("error");
	  }
        
        //RMI Server
        
        try{
           numPuerto = Integer.toString(8050);
           System.out.println("Iniciando server RMI. Port:  "+numPuerto);
           arrancarRegistro(numPuerto);
           RemoteClass objetoRemoto = new RemoteClass();
           URLRegistro = "rmi://192.168.110.102:"+numPuerto+"/barco";
           
           Naming.rebind(URLRegistro,objetoRemoto);
           System.out.println("Servidor registrado. El registro contiene actualmente:");
           listaRegistro(URLRegistro);
           System.out.println("Servidor barco preparado.");
       }catch(RemoteException excr){
           System.out.println("Excepción en el servidor.main:"+excr);
       } catch (MalformedURLException excr) {
           System.out.println("Excepción en el servidor.main:"+excr);
        }
    }

    private static void arrancarRegistro(String nroPuertoRMI) throws RemoteException{
        try{
            Registry registro = LocateRegistry.getRegistry(nroPuertoRMI);
            registro.list();
        }catch(RemoteException e){
            System.out.println("Registro RMI no encontrado en el puerto: "+nroPuertoRMI);
            Registry registro = LocateRegistry.createRegistry(Integer.parseInt(nroPuertoRMI));
            System.out.println("Registro RMI creado en el puerto "+nroPuertoRMI);
        }
    }
    
    private static void listaRegistro(String URLRegistro) 
            throws RemoteException, MalformedURLException{
        System.out.println("REgistro "+URLRegistro+" contiene: ");
        String [] nombres = Naming.list(URLRegistro);
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}

