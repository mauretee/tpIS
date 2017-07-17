package tpIS;

import java.util.Map;

public class Presupuesto {	
	
	private Map<Object, Double> _costs;
	private double precioPetroleo;
	private double precioGas;
	private double precioAgua;
	
	public Presupuesto(Map<Object, Double> costs, double petroleo, double gas, double agua) {		
		this._costs = costs;
		precioPetroleo = petroleo;
		precioGas = gas;
		precioAgua = agua;
	}
	
	public void agregarArticulo(Object unArticulo, double unCostos) {
		Double price = new Double(unCostos);
		_costs.put(unArticulo, price);
	}

	public double getCostoDeRig(ModeloRig rigModel){
		return _costs.get((Object)rigModel);
	}
	
	public double getCostoDeRigHastaElDia(int CantidadDeDias, ModeloRig rigModel){	
							
		double costoRig = _costs.get((Object)rigModel);
		
		if(rigModel.getDiasMinimoDeAlquiler() <= CantidadDeDias) {
			costoRig *= CantidadDeDias;
		}
		else{
			System.err.println("La cantidad de dias de alquiler debe ser mayor o igual a la minima del Rig");
		}
		
		return costoRig; //??
	}

	public double getCostoDePlanta(ModeloPlanta plantModel){
		//FIX ME: NO SESETEAN COSTOS EN EL READER
		return _costs.get((Object)plantModel);
	}
	
	public double getCostoDeTanque(ModeloTanque tankModel){
		return _costs.get((Object)tankModel);
	}
	
	public double getPrice(Object obj){
		double result =this._costs.get(obj);		
		return result; 
	}
	
	public double getPrecioPetroleo(){	
		return precioPetroleo; 
	}

	public double getPrecioGas() {
		return precioGas;
	}

	public double getPrecioAgua() {
		return precioAgua;
	}
	
}
