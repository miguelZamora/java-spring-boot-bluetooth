package cl.cachoza.bluetooth.listener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

public class BluetoothDiscoveryListener implements DiscoveryListener {

	private final List<RemoteDevice> dispositivosEncontrados = new ArrayList<>();

	@Override
	public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
 
		
        try {
			System.out.println("Dispositivo encontrado: " + btDevice.getBluetoothAddress() + " Nombre: " + btDevice.getFriendlyName(false));
			/*
			 * en esta clase se debe ingresar el dispositivo 
			 * */
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		dispositivosEncontrados.add(btDevice);
		
	}

	@Override
	public void inquiryCompleted(int discType) {
		System.out.println("Escaneo completado.");
	}

	@Override
	public void serviceSearchCompleted(int transID, int respCode) {
	}

	@Override
	public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
	}

	public List<RemoteDevice> getDispositivosEncontrados() {
		return dispositivosEncontrados;
	}
	
	
}