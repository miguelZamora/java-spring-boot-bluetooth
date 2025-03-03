package cl.cachoza.bluetooth.services;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

import org.springframework.stereotype.Service;

import cl.cachoza.bluetooth.listener.BluetoothDiscoveryListener;

@Service
public class BluetoothService {
	
	
	public List<RemoteDevice> escanearDispositivos() {
        try {
            // Obtener el dispositivo local
            LocalDevice localDevice = LocalDevice.getLocalDevice();
            DiscoveryAgent agent = localDevice.getDiscoveryAgent();

            // Crear el listener
            BluetoothDiscoveryListener listener = new BluetoothDiscoveryListener();

            // Iniciar el escaneo
            agent.startInquiry(DiscoveryAgent.GIAC, listener);

            // Esperar a que el escaneo termine (puedes ajustar el tiempo)
            Thread.sleep(10000); // 10 segundos

            // Retornar los dispositivos encontrados
            return listener.getDispositivosEncontrados();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(); // Retorna una lista vacía en caso de error
        }
    }
	
	public void conectarDispositivo(String direccion)  {
		try {
			
		
	    String connectionURL = "btspp://" + direccion + ":1;authenticate=false;encrypt=false;master=false";
	    StreamConnection streamConnection = (StreamConnection) Connector.open(connectionURL);

	    InputStream inputStream = streamConnection.openInputStream();
	    OutputStream outputStream = streamConnection.openOutputStream();

	    // Aquí puedes leer y escribir datos del dispositivo
	    byte[] buffer = new byte[1024];
	    int bytesRead = inputStream.read(buffer);
	    String response = new String(buffer, 0, bytesRead);

	    System.out.println("Respuesta del dispositivo: " + response);

	    inputStream.close();
	    outputStream.close();
	    streamConnection.close();

	    System.out.println("Conexión establecida con el dispositivo: " + direccion);
	    
			} catch (Exception e) {
				System.out.println("Error : " + e);
		}
		
		
	}

 
	
	

}
