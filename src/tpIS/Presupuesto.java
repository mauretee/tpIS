package tpIS;

import java.util.List;

public class Presupuesto {	
	
	private double precioPetroleo;
	private double precioGas;
	private double precioDeCompraDeAgua; //para los camionsitos de agua
	private List<costoDelRig> costosDeLosRigs;
	private List<Double> precioDePlantas;
	private List<Double> precioDeTanques; //hay precio distinto por tanque de agua o gas??
	
	
	public Presupuesto(double precioPetroleo, double precioGas, double precioDeCompraDeAgua,
			List<costoDelRig> costosDeLosRigs, List<Double> precioDePlantas, List<Double> precioDeTanques) {
		super();
		this.precioPetroleo = precioPetroleo;
		this.precioGas = precioGas;
		this.precioDeCompraDeAgua = precioDeCompraDeAgua;
		this.costosDeLosRigs = costosDeLosRigs;
		this.precioDePlantas = precioDePlantas;
		this.precioDeTanques = precioDeTanques;
	}

	public double getCostoDeRig(Rig rig){		
		return 0;
	}
	
}
