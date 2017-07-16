package tpIS;

import java.util.Map;

public class Presupuesto {	
	
	private Map<Object, Double> _costs;
	
	public Presupuesto(Map<Object, Double> costs) {		
		this._costs = costs;
	}
	
	public void agregarArticulo(Object unArticulo, double unCostos) {
		
	}

	public double getCostoDeRig(ModeloRig rigModel){
		return _costs.get((Object)rigModel);
	}
	
	public double getCostoDeRigHastaElDia(int CantidadDeDias, ModeloRig rigModel){	
							
		double costoRig = 10; // _costs.get((Object)rigModel);
		
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
		return 100;//_costs.get((Object)plantModel);
	}
	
	public double getCostoDeTanque(ModeloTanque tankModel){
		//FIX ME: NO SESETEAN COSTOS EN EL READER
		return  100;// _costs.get((Object)tankModel);
	}
	
	public double getPrice(Object obj){
		//FIX ME: NO SESETEAN COSTOS EN EL READER
		double result =10;//this._costs.get(obj);		
		return result; 
	}
	
	public double getPrecioPetroleo(){
		//FIX ME: NO SESETEAN COSTOS EN EL READER
		double result =20;//this._costs.get(obj);		
		return result; 
	}
	
}
