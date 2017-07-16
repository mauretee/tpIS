package tpIS;

public class TanqueAgua extends Tanque {
	public TanqueAgua(ModeloTanque unModelo, Context unContexto) {
		super(unModelo, unContexto);
		unContexto.attachTanqueAgua(this);
		// TODO Auto-generated constructor stub
	}

	public void reinyectar(double cantidad) {
		extraerVol(cantidad);
	}
	
	public void updateDay() {
		if(!estaConstruido())
			construirUnDia();
	}
}
