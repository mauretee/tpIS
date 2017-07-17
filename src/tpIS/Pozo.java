package tpIS;

public class Pozo {
	private Estado estado;
	private int presion;
	//private int capacidadPotencial;
	private static int cantidadPozosAbiertos;
	private static int cantidadDePozos;
	
	public Pozo( Estado estado, int presion){
		this.estado = estado;
		this.presion = presion;
		//this.capacidadPotencial = capacidad;
		cantidadDePozos++;
		//System.out.println("LA CANTIDAD DE POZOS ACTUALS ES: " +cantidadDePozos+ " "+ cantidadPozosAbiertos);
	}
	public double getCapacidadPotencial(double alpha1, double alpha2) {
		//return capacidadPotencial;
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
	public int getPresion() {
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
	//FIXME PRESION ES UN INT O UN DOUBLE?????
	public void actualizarPresion(double eBeta) {
		presion = (int) (presion * eBeta);
	}
	public static int getCantidadTotalDePozos() {
		return cantidadDePozos;
	}

}
