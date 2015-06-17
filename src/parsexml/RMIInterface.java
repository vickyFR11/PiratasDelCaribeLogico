package parsexml;
import java.rmi.*;

/**
 *
 * @author Jose Gabriel
 */
public interface RMIInterface extends Remote{
    public boolean desembarcar(Barco barco, String nombreSitio)
            throws java.rmi.RemoteException;
}
