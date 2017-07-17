package tpIS;

public class Parcela {
	private int profundidadNecesaria;
	private int profundidadActua;
	private int presionInicial;
	private Terreno tipoDeTerreno;
	private Pozo pozo;
	
	public Parcela(int profundidad, Terreno tipoDeTerreno, int presion, int resistencia){
		//super(unContexto);
		this.profundidadNecesaria =profundidad;
		this.tipoDeTerreno = tipoDeTerreno;
		this.presionInicial = presion;
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
			pozo = new Pozo(unEstado, presionInicial);
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
		if(tienePozo())
			return pozo;
		else
			System.err.println("Esta parzela NO TIENE POZO AUN!!!");
		
		Estado unEstado = Estado.ParadoPorSindicato ;
		Pozo dummy = new Pozo(unEstado, 0);
		return dummy;
	}
	
	/*public void updateDay() {
		if(tienePozo()) 
			pozo.cerrarValvula();
	}*/
	
	public void updatePresionPozo(double volumenR, double volumenTotal) {
		if(tienePozo()) {
			pozo.cerrarValvula();
			double beta = 0.1*(volumenR/volumenTotal)/(Math.pow(pozo.getCantidadTotalDePozos(), ((double)2/3)));
			pozo.actualizarPresion(Math.pow(Math.E, -beta));
		}
		
	}
	
}
