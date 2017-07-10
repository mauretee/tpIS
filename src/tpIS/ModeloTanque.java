package tpIS;

public class ModeloTanque {
	private int diasDeConstruccionTotal;
	private double volumenTotal;

	public ModeloTanque(int diasDeConstruccion, double volumen) {
		diasDeConstruccionTotal = diasDeConstruccion;
		volumenTotal = volumen;
	}

	public int getDiasDeConstruccionTotal() {
		return diasDeConstruccionTotal;
	}
	
	public double getVolumenTotal() {
		return volumenTotal;
	}

}
