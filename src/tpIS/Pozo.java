package tpIS;

public class Pozo {
	private Estado estado;
	private int presion;
	private int capacidad;
	
	public Pozo(	 Estado estado, int presion, int capacidad){
		this.estado = estado;
		this.presion = presion;
		this.capacidad = capacidad;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public int getPresion() {
		return presion;
	}
	public Estado getEstado() {
		return estado;
	}

}
