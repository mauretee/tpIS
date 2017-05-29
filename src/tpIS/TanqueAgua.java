package tpIS;

public class TanqueAgua extends Tanque {
	public TanqueAgua(double volumen, int diasDeConstruccion) {
		super(volumen, diasDeConstruccion);
		// TODO Auto-generated constructor stub
	}

	public void reinyectar(double cantidad) {
		extraerVol(cantidad);
	}
}
