package tpIS;

public class Pozo {
	private Estado estado;
	private double presion;
	private static int cantidadPozosAbiertos;
	private static int cantidadDePozos;
	
	public Pozo( Estado estado, int presion){
		this.estado = estado;
		this.presion = presion;
		cantidadDePozos++;
	}
	//Se calcula el potencial del Pozo en base a la formula 1 del tp
	public double getCapacidadPotencial(double alpha1, double alpha2) {
		if(cantidadPozosAbiertos > 0){
			double num = presion/cantidadPozosAbiertos;
			double potencial = alpha1*num + alpha2*Math.pow(num, 2);
			return potencial;
		}
		else {
			System.err.println("DIVICION POR 0 EN POZO");
			double potencial = 0;
			return potencial;
		}
	}
	public double getPresion() {
		return presion;
	}
	public Estado getEstado() {
		return estado;
	}
	
	public void extraer() {
		estado = Estado.Extrayendo;
		cantidadPozosAbiertos++;
	}
	
	public void reinyectarPozo() {
		if(estado == Estado.Extrayendo)
			cantidadPozosAbiertos--;
		
		estado = Estado.enReinyeccion;
	}
	
	public void cerrarValvula() {
		if(estado == Estado.Extrayendo)
			cantidadPozosAbiertos--;
		
		estado = Estado.ParadoPorSindicato;
		//calcularPrecion();
	}
	//Se calcula la nueva presion en base a la formula 2 del tp
	public void actualizarPresion(double eBeta) {
		presion = (presion * eBeta);
	}
	public static int getCantidadTotalDePozos() {
		return cantidadDePozos;
	}

}
