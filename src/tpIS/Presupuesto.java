package tpIS;

import java.util.List;
import java.util.Map;

public class Presupuesto {	
	
	
	private Map<Object, Double> _costs;
	
	public Presupuesto(Map<Object, Double> costs) {		
		this._costs = costs;
	}

	public double getCostoDeRig(Rig rig){		
		return 0;
	}
	
	public double getCostoDeRigHastaElDia(int CantidadDeDias, Rig rig){	
		//costoDelRig costoRig;
					
		double costoRigByDay= this._costs.get((Object)rig);		
		double costoRig = 0;
		/*
		if(rig.getDiasMinimoDeAlquiler() >= CantidadDeDias) {
			costoRig = costoRigByDay*CantidadDeDias + this._costs.get(rig.getTipoCombustible()) *CantidadDeDias;
		}
		else{
			costoRig = costoRigByDay*rig.getDiasMinimoDeAlquiler() + this._costs.get(rig.getDiasMinimoDeAlquiler()) *CantidadDeDias;
		}
		*/
		return costoRig; //??
	}

	
	public double getPrice(Object obj){
		double result =this._costs.get(obj);		
		return result; 
	}
	
	
}
