package tpIS;

public class TanqueGas extends Tanque {

	public TanqueGas(double volumen, int diasDeConstruccion) {
		super(volumen, diasDeConstruccion);
		// TODO Auto-generated constructor stub
	}
	
	public void venderGas(double cantidad) {
		extraerVol(cantidad);
	}
	
	public void construirUnDia() {
		if(!estaCosntruido())
			diasDeConstruccionActual++;
		else
			System.err.println("El talque de gas ya esta construido.");
	}

}
