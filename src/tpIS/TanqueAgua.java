package tpIS;

public class TanqueAgua extends Tanque {
	public TanqueAgua(ModeloTanque unModelo, Context unContexto) {
		super(unModelo, unContexto);
		// TODO Auto-generated constructor stub
	}

	public void reinyectar(double cantidad) {
		extraerVol(cantidad);
	}
	
	public void updateDay() {
		if(!estaCosntruido())
			construirUnDia();
	}
}
