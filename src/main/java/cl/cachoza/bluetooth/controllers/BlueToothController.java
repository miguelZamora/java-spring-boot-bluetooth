package cl.cachoza.bluetooth.controllers;

import cl.cachoza.bluetooth.entity.Bluetooth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.cachoza.bluetooth.services.BluetoothServiceImpl;
import cl.cachoza.bluetooth.services.BluetoothService;

import java.util.List;
import java.util.Optional;

import javax.bluetooth.RemoteDevice;

import cl.cachoza.bluetooth.dto.BuscarDispositivoRequest;
import cl.cachoza.bluetooth.dto.ConectarDispositivoReq;

@RestController
@RequestMapping("/api/bluetooth")
public class BlueToothController {

	@Autowired
	BluetoothServiceImpl serviceBluetooth;
	
	@Autowired
	BluetoothService sBluetooth;

	
	@GetMapping("/dispositivos")
	public ResponseEntity<List<RemoteDevice>> listarDispositivos() {
		List<RemoteDevice> dispositivos = sBluetooth.escanearDispositivos();
		if (!dispositivos.isEmpty()) {
			return ResponseEntity.ok(dispositivos);
		}
		return ResponseEntity.noContent().build();  
	}

	@GetMapping("/buscar_dispositivos")
	public ResponseEntity<List<Bluetooth>> buscarSeñalBluetooth(@RequestBody BuscarDispositivoRequest request) {
		List<Bluetooth> dispositivos_new =  serviceBluetooth.findAll();
		if (!dispositivos_new.isEmpty()) {
			return ResponseEntity.ok(dispositivos_new);
		}
		return ResponseEntity.noContent().build(); // Retorna 204 si no hay dispositivos
	}

	@PostMapping("/conectar")
    public ResponseEntity<String> conectarDispositivo(@RequestBody ConectarDispositivoReq req) {
	        String direccion = req.getDireccion();
	        String nombreDispositivo = req.getNombreDispositivo();

	        try {
	            sBluetooth.conectarDispositivo(direccion);
	            return ResponseEntity.ok("Conexión establecida con el dispositivo: " + nombreDispositivo);
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Error al conectarse al dispositivo: " + nombreDispositivo);
	        }
	    }
	
	  
	@GetMapping("/dispositivos/{id}")
	public ResponseEntity<Bluetooth> obtenerDispositivoPorId(@PathVariable Long id) {
		Optional<Bluetooth> dispositivo = serviceBluetooth.findById(id);
		return dispositivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 si
																										// no se
																										// encuentra
	}

}
