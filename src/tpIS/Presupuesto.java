package tpIS;

import java.util.Map;

public class Presupuesto {	
	
	
	private Map<Object, Double> _costs;
	
	public Presupuesto(Map<Object, Double> costs) {		
		this._costs = costs;
	}

	public double getCostoDeRig(ModeloRig rigModel){
		return _costs.get((Object)rigModel);
	}
	
	public double getCostoDeRigHastaElDia(int CantidadDeDias, ModeloRig rigModel){	
		//costoDelRig costoRig;
					
		//double costoRigByDay= this._costs.get((Object)rig);		
		double costoRig = _costs.get((Object)rigModel);
		
		if(rigModel.getDiasMinimoDeAlquiler() <= CantidadDeDias) {
			costoRig *= CantidadDeDias;
		}
		else{
			System.err.println("La cantidad de dias de alquiler debe ser mayor o igual a la minima del Rig");
		}
		
		return costoRig; //??
	}

	
	public double getPrice(Object obj){
		double result =this._costs.get(obj);		
		return result; 
	}
	
	
}
