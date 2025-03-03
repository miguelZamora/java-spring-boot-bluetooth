package cl.cachoza.bluetooth.dto;


import lombok.Data;

@Data
public class BuscarDispositivoRequest {
    
	private String 	nombreDispositivo; 	//	Nombre del dispositivo Bluetooth
    private String 	direccionMac;     	// 	Direccion MAC del dispositivo
    private Integer rangoSenal;      	// 	Intensidad de la senal RSSI
    private String 	tipoDispositivo;  	// 	Tipo de dispositivo auricular, altavoz, etc.
    private String 	uuidServicio;    	// 	UUID del servicio Bluetooth
    private Integer rangoDistancia; 	// 	Rango de distancia en metros

    // Getters y Setters
    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }

    public Integer getRangoSenal() {
        return rangoSenal;
    }

    public void setRangoSenal(Integer rangoSenal) {
        this.rangoSenal = rangoSenal;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getUuidServicio() {
        return uuidServicio;
    }

    public void setUuidServicio(String uuidServicio) {
        this.uuidServicio = uuidServicio;
    }

    public Integer getRangoDistancia() {
        return rangoDistancia;
    }

    public void setRangoDistancia(Integer rangoDistancia) {
        this.rangoDistancia = rangoDistancia;
    }
}