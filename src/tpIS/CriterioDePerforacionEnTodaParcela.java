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
		        public void Apply(Context context, Equipo equipo)  {
		        	//int i = 0;
		        	for(Parcela parcela : equipo._yacimiento.listaDeParcelas){		        		
		        		if(!parcela.tienePozo() && !parcela.pozoEnConstruccion()) {
		        			
		        			/*
		        			 * El criterio elige una parcela para cavar y se lo informa al contexto.
		        			 * Luego pide al equipo el criterio de eleccion de rig, y para esa parcela el criterio decide
		        			 * guardando q rig selecciono en el contexto.
		        			 */
		        			context.setParcela_ACavar(parcela);
		        			/*CriterioEleccionDeRigs unCriterioRig = new CriterioEleccionDeRigsxMasBarato(equipo);
		        			unCriterioRig.Evaluate(context).get(0).Apply(context, equipo);*/
		        			equipo.criteriosDeSeleccionDeRigs.Evaluate(context).get(0).Apply(context, equipo);
		        			Rig rigElegido = context.getRigElegidoParaCavar();
		        			rigElegido.cavarPozoEnParcela(parcela);
		        			
			        		//TODO: llamar al calculador de costo y 
		        		}
		        		
		        	}
		        }
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  
	
	
}
