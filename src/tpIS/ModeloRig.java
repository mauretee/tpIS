package tpIS;

public class ModeloRig {
	private double precioRig;
	private int diasMinimoDeAlquiler;
	private int velocidadDeCavadoXDia = 1;
	private double consumCombustibleXDia = 1;
	
	public ModeloRig(double precio, double combustible, int dias, int velocidad) {
		precioRig = precio;
		diasMinimoDeAlquiler = dias;
		velocidadDeCavadoXDia = 1;
		consumCombustibleXDia = combustible;
	}
	
	public int getDiasMinimoDeAlquiler() {
		return diasMinimoDeAlquiler;
	}

	public double getconsumCombustibleXDia() {
		return consumCombustibleXDia;
	}

	public double getPrecioRig() {
		return precioRig;
	}
	
	public int getVelocidadDeCavadoXDia() {
		return velocidadDeCavadoXDia;
	}

}
