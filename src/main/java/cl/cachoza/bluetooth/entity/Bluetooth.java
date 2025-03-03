package cl.cachoza.bluetooth.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Bluetooth", schema = "yourdatabase")
public class Bluetooth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombreDispositivo; 	//	Nombre del dispositivo Bluetooth
    private String direccionMac;     	// 	Direccion MAC del dispositivo
    private Integer rangoSenal;      	// 	Intensidad de la senal RSSI
    private String tipoDispositivo;  	// 	Tipo de dispositivo auricular, altavoz, etc.
    private String uuidServicio;    	// 	UUID del servicio Bluetooth
    private Integer rangoDistancia; 	// 	Rango de distancia en metros
    
    

}