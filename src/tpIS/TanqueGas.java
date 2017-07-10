package tpIS;

public class TanqueGas extends Tanque {

	public TanqueGas(ModeloTanque unModelo, Context unContexto) {
		super(unModelo, unContexto);
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
