package tpIS;

public class TanqueGas extends Tanque {

	public TanqueGas(double volumen, int diasDeConstruccion, Context unContexto) {
		super(volumen, diasDeConstruccion, unContexto);
		// TODO Auto-generated constructor stub
	}
	
	public void venderGas(double cantidad) {
		extraerVol(cantidad);
	}
	
	public void updateDay() {
		if(!estaCosntruido())
			construirUnDia();
	}
}
