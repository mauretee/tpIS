package tpIS;

public class Parcela {
	private int profundidad;
	private Terreno tipoDeTerreno;
	private Pozo pozo;
	public Parcela(int profundidad, Terreno tipoDeTerreno){
		this.profundidad =profundidad;
		this.tipoDeTerreno = tipoDeTerreno;
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
