package tpIS;

public class Parcela {
	private int profundidadNecesaria;
	private int profundidadActua;
	private int presionInicial;
	private Terreno tipoDeTerreno;
	//private int resistencia; //Deprecated (?
	private Pozo pozo;
	
	public Parcela(int profundidad, Terreno tipoDeTerreno, int presion, int resistencia){
		this.profundidadNecesaria =profundidad;
		this.tipoDeTerreno = tipoDeTerreno;
		this.presionInicial = presion;
		//this.resistencia = resistencia;
	}
	
	public Terreno getTipoDeTerreno() {
		return tipoDeTerreno;
	}
	public int getProfundidadNecesaria() {
		return profundidadNecesaria;
	}
	
	/*public int getResistencia(){
		return resistencia;
	}*/

	private void crearPozo() {
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
	
	public int getProfundidadActua() {
		return profundidadActua;
	}
	
	public void cavar(int cantidad) {
		if(!tienePozo()) {
			this.profundidadActua += cantidad;
			if(profundidadActua >= profundidadNecesaria)
				crearPozo();
		}
		else
			System.err.println("La profundidad necesaria ya fue alcanzada en el pozo de esta parcela");
	}
	
	public boolean pozoEnConstruccion() {
		return (profundidadActua > 0) && (profundidadActua < profundidadNecesaria);
	}
	
	public Pozo getPozo() {
		Estado unEstado = Estado.ParadoPorSindicato ;
		Pozo dummy = new Pozo(unEstado, 0, 0);
		if(tienePozo())
			return pozo;
		else
			System.err.println("Esta parzela NO TIENE POZO AUN!!!");
		
		return dummy;
	}
	
}
