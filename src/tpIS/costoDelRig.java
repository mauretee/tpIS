package tpIS;
/*
 * Esta clase va a ser borrada!!!
 */
public class costoDelRig {
	private double precioRig;
	private double combustibleDelRig;
	private int diasMinimoDeAlquiler;
	private Rig rigAsociado;
	
	public costoDelRig(double precio, double combustible, int dias, Rig _rig) {
		precioRig = precio;
		combustibleDelRig = combustible;
		diasMinimoDeAlquiler = dias;
		rigAsociado = _rig;
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
	
	public Rig getRigAsociado() {
		return rigAsociado;
	}
}
