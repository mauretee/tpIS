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
	
	public double getCostoDeRigHastaElDia(int CantidadDeDias, Rig rig){	
		costoDelRig costoRig;
		costoRig= costosDeLosRigs.get(0);
		for(int i=0; i<costosDeLosRigs.size();i++) {
			if(costosDeLosRigs.get(i).getRigAsociado().equals(rig)) {
				costoRig= costosDeLosRigs.get(i);
				break;
			}
		}
		
		if(costoRig.getDiasMinimoDeAlquiler() >= CantidadDeDias) {
			return costoRig.getPrecioRigs() + costoRig.getCombustibleDelRig()*CantidadDeDias;
		}
		else
			System.err.println("La cantidad de dias debe ser >= que la minima de alquiler");
	return 0; //??
	}

	public double getPrecioPetroleo() {
		return precioPetroleo;
	}

	public double getPrecioGas() {
		return precioGas;
	}

	public double getPrecioDeCompraDeAgua() {
		return precioDeCompraDeAgua;
	}

	public List<costoDelRig> getCostosDeLosRigs() {
		return costosDeLosRigs;
	}

	public List<Double> getPrecioDePlantas() {
		return precioDePlantas;
	}

	public List<Double> getPrecioDeTanques() {
		return precioDeTanques;
	}
	
}
