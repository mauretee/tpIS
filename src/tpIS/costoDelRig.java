package tpIS;

public class costoDelRig {
	private double precioRig;
	private double combustibleDelRig;
	private int diasMinimoDeAlquiler;
	
	public costoDelRig(double precio, double combustible, int dias) {
		precioRig = precio;
		combustibleDelRig = combustible;
		diasMinimoDeAlquiler = dias;
	}
	
	public int getDiasMinimoDeAlquiler() {
		return diasMinimoDeAlquiler;
	}

	public double getCombustibleDelRig() {
		return combustibleDelRig;
	}

	public double getPrecioRigs() {
		return precioRig;
	}
}
