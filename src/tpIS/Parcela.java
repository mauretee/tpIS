package tpIS;

public class Parcela {
	private int profundidad;
	private int presion;
	private Terreno tipoDeTerreno;
	private Pozo pozo;
	public Parcela(int profundidad, Terreno tipoDeTerreno, int presion){
		this.profundidad =profundidad;
		this.tipoDeTerreno = tipoDeTerreno;
		this.presion = presion;
	}
	public Terreno getTipoDeTerreno() {
		return tipoDeTerreno;
	}
	public int getProfundidad() {
		return profundidad;
	}
	public void setPozo(Pozo pozo){
		this.pozo = pozo;
	}
}
