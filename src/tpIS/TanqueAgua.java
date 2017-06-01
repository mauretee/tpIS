package tpIS;

public class TanqueAgua extends Tanque {
	public TanqueAgua(double volumen, int diasDeConstruccion, Context unContexto) {
		super(volumen, diasDeConstruccion, unContexto);
		// TODO Auto-generated constructor stub
	}

	public void reinyectar(double cantidad) {
		extraerVol(cantidad);
	}
	
	public void updateDay() {
		
	}
}
