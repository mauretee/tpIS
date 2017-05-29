package tpIS;

public class Parcela {
	private int profundidad;
	private int presionInicial;
	private Terreno tipoDeTerreno;
	private int resistencia;
	private Pozo pozo;
	
	public Parcela(int profundidad, Terreno tipoDeTerreno, int presion, int resistencia){
		this.profundidad =profundidad;
		this.tipoDeTerreno = tipoDeTerreno;
		this.presionInicial = presion;
		this.resistencia = resistencia;
	}
	public Terreno getTipoDeTerreno() {
		return tipoDeTerreno;
	}
	public int getProfundidad() {
		return profundidad;
	}
	
	public int getResistencia(){
		return resistencia;
	}

	/*
	 * FIX ME: Con esta implementacion, muchos Rigs pueden construir el mismo pozo!!!
	 */
	public void crearPozo() {
		if(!tienePozo()) {
			Estado unEstado = Estado.ParadoPorSindicato ;
			int capacidad = 10; // QUE ERA ESTO ??
			pozo = new Pozo(unEstado, presionInicial, capacidad);
		}
		else 
			System.err.println("Esta parcela ya posee un pozo.");
	}
	
	public boolean tienePozo() {
		return pozo!=null;
	}
}
