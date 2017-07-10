package tpIS;

public class ModeloPlanta {
	private int diasDeConstruccionTotal;
	private double poderProcesamientoDia;
	
	public ModeloPlanta(int diasDeConstruccionTotal, double poderProcesamientoDia) {
		this.diasDeConstruccionTotal = diasDeConstruccionTotal;
		this.poderProcesamientoDia = poderProcesamientoDia;
	}

	public int getDiasDeConstruccionTotal() {
		return diasDeConstruccionTotal;
	}

	public double getPoderProcesamientoDia() {
		return poderProcesamientoDia;
	}

}
