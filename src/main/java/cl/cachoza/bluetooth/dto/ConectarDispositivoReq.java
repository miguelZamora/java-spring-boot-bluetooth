package cl.cachoza.bluetooth.dto;

public class ConectarDispositivoReq {
    
	private String direccion;
    private String nombreDispositivo;
    
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}
 
}