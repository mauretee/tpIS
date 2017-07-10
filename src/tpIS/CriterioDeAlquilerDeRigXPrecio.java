package tpIS;

import java.util.List;

public class CriterioDeAlquilerDeRigXPrecio extends CriterioEleccionDeRigs {

	public CriterioDeAlquilerDeRigXPrecio(Equipo equipo) {
		super(equipo);
	}
	
	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function elegirRig = new Function() {
				/*
				 * (non-Javadoc)
				 * @see tpIS.Function#Apply(tpIS.Context, tpIS.Equipo, java.lang.Object)
				 */
				
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	/*
		        	 * Este criterio en particular ignora por completo la parcela.
		        	 * Buscamos el rig mas barato en la lista de rigs alquilados
		        	 * de no haber ninguno que se pueda utilizar alli, creamos el modelo mas barato
		        	 */
		        	
	        		if(!equipo.getCatalogo().getModelosRigs().isEmpty()) {
	        			ModeloRig mejorModelo = equipo.getCatalogo().getModelosRigs().get(0);
		        		for(ModeloRig otroModelo : equipo.getCatalogo().getModelosRigs()) {
		        			if(otroModelo.getPrecioRig() < mejorModelo.getPrecioRig())
		        				mejorModelo = otroModelo;
		        		}
		        		Rig rigElegido= new Rig(mejorModelo, context, mejorModelo.getDiasMinimoDeAlquiler());
		        		context.alquilarUnRig(rigElegido);
		        		//TODO falta calcular el costo!
		        		//TODO AGREGAR LOS COSTOS AL HASH MAP DEL PRESUPUESTO, EL COSTO TIENE QUE SER POR MODELO Y HAY Q PASARLE EL MODELO ELEGIDO,
		        		//NO UN NUEVO RIG XQ NO LO VA A ENCONTRAR NUNCA EN EL HASHMAP
		        		//equipo.getEstadoFinanciero().debit(equipo.getPresupuesto().getCostoDeRigHastaElDia(mejorModelo.getDiasMinimoDeAlquiler(), rigElegido.getModelo()));
	        		}
	        		else {
		        		System.err.println("NO EXITEN MODELOS DE RIGS");
		        	}
		        }
		        
		        @Override
		        public void LogAction(Context context)  {
		        	context.SetLastEventsToLog("se Alquila un rig de modelo: ");
		        }
		        
		    };
		    result.add(new Closure(elegirRig));
		    return result;	
	}

}
