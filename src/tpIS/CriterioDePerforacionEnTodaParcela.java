package tpIS;

import java.util.List;

public class CriterioDePerforacionEnTodaParcela extends CriterioDePerforacion{
	
	public CriterioDePerforacionEnTodaParcela(Equipo equipo) {
		super(equipo);			
	}

	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function perforar = new Function() {
		        @Override
		        public void Apply(Context context, Equipo equipo, Object anObject)  {
		        	//int i = 0;
		        	for(Parcela parcela : equipo._yacimiento.listaDeParcelas){		        		
		        		if(!parcela.tienePozo() && !parcela.pozoEnConstruccion()) {
		        			
		        			/*
		        			 * Suponiendo q esta chanchada funcione, faltaria que el equipo conosca fuertemente a los criterios
		        			 * y poder pedirle el criterio de rigs al equipo en ves de harcodearlo
		        			 */
		        			CriterioEleccionDeRigs unCriterioRig = new CriterioEleccionDeRigsxMasBarato(equipo);
		        			Rig Elejido= null;
		        			unCriterioRig.Evaluate(context).get(0).Apply(context, equipo, Elejido);
		        			Elejido = (Rig) Elejido;
		        			Elejido.cavarPozoEnParcela(parcela);
		        			
		        			/*Rig rig = context.getRigs().get(i);
			        		rig.cavarPozoEnParcela(parcela);*/
			        		//TODO: llamar al calculador de costo y 
		        		}
		        				        		
		        		//i++;
		        		
		        	}
		        }
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  
	
	
}
