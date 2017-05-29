package tpIS;

public abstract class Tanque {
	protected int diasDeConstruccionActual;
	protected int diasDeConstruccionTotal;
	//protected double costoConstruccion;
	protected double volumenTotal;
	protected double volumenOcupadoActual;
	
	public Tanque(double volumen, int diasDeConstruccion) {
		diasDeConstruccionTotal= diasDeConstruccion;
		volumenTotal = volumen;
		volumenOcupadoActual =0;
		diasDeConstruccionActual =0;
	}
	
	public double getVolumenTotal() {
		return volumenTotal;
	}
	public double getVolumenOcupadoActual() {
		return volumenOcupadoActual;
	}
	
	protected void extraerVol(double vol) {
		this.volumenOcupadoActual -= vol;
	}
	
	public void llenar(double vol) {
		volumenOcupadoActual += vol;
	}
	
	public boolean estaCosntruido() {
		return diasDeConstruccionActual == diasDeConstruccionTotal;
	}
}
