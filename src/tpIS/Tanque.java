package tpIS;

public abstract class Tanque extends ContextObserver {
	protected int diasDeConstruccionActual;
	protected double volumenOcupadoActual;
	protected ModeloTanque modelo;
	
	public Tanque(ModeloTanque unModelo, Context unContexto) {
		super(unContexto);
		volumenOcupadoActual =0;
		diasDeConstruccionActual =0;
		this.modelo= unModelo;
	}
	
	public double getVolumenTotal() {
		return modelo.getVolumenTotal();
	}
	public double getVolumenOcupadoActual() {
		return volumenOcupadoActual;
	}
	
	public double getCapacidadAlmacenamientoRestante() {
		return this.modelo.getVolumenTotal() - volumenOcupadoActual;
	}
	
	public ModeloTanque getModelo() {
		return modelo;
	}
	
	protected void extraerVol(double vol) {
		this.volumenOcupadoActual -= vol;
	}
	
	public void llenar(double vol) {
		volumenOcupadoActual += vol;
	}
	
	public boolean estaConstruido() {
		return diasDeConstruccionActual == modelo.getDiasDeConstruccionTotal();
	}
	
	protected void construirUnDia() {
		if(!estaConstruido())
			diasDeConstruccionActual++;
		else
			System.err.println("El talque ya esta construido.");
	}
}
