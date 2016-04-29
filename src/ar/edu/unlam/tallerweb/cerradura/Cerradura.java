package ar.edu.unlam.tallerweb.cerradura;

public class Cerradura {
	
	private Integer claveApertura;
	private Boolean estado;
	private Integer bloqueada;
	private Integer intentosApertura=0;
	private Integer aperturaExitosa=0;
	private Integer aperturasFallidas=0;
	
	public Cerradura(Integer clave, Integer cantidadFallosBloquean){
		claveApertura = clave;
		bloqueada = cantidadFallosBloquean;
	}

	public Boolean abrir(Integer clave) {
		if(clave.equals(claveApertura)){
			intentosApertura=0;
			aperturaExitosa=aperturaExitosa+1;
			estado=true;
			return estado;
		}
		else{
			aperturasFallidas=aperturasFallidas+1;
			intentosApertura=intentosApertura+1;
			estado=false;
			return estado;
		}
	}

	public Boolean estaAbierta() {
		if(estado)
			return true;
		else
			return false;
	}

	public Boolean estaCerrada() {
		if(!estado)
			return true;
		else
			return false;
	}

	public void cerrar() {
		estado = false;
		
	}

	public Boolean fueBloqueada() {
		if(intentosApertura==bloqueada){
			return true;
		}
		else{
			return false;
		}
	}

	public Integer contarAperturasExistosas() {
		
		return aperturaExitosa;
	}

	public Integer contarAperturasFallidas() {
		// TODO Auto-generated method stub
		return aperturasFallidas;
	}
	

	
	
}
