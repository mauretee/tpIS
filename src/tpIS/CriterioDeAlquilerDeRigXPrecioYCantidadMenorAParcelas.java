package tpIS;

import java.util.List;

public class CriterioDeAlquilerDeRigXPrecioYCantidadMenorAParcelas extends CriterioAdherido {

	public CriterioDeAlquilerDeRigXPrecioYCantidadMenorAParcelas(Criterio criterio) {
		super(criterio);
	}
	
	@Override
	public List<Closure> Evaluate(Context context, EstadoFinanciero estado) {

		List<Closure> result = super.Evaluate(context, estado);
			Function elegirRig = new Function() {
				/*
				 * (non-Javadoc)
				 * @see tpIS.Function#Apply(tpIS.Context, tpIS.Equipo, java.lang.Object)
				 */

				private String textToLog="";
				
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	/*
		        	 * Este criterio en particular ignora por completo la parcela.
		        	 * Buscamos el rig mas barato en la lista de rigs alquilados
		        	 * de no haber ninguno que se pueda utilizar alli, creamos el modelo mas barato
		        	 */
		        	this.textToLog="";
		        	if(context.getRigs().size() < equipo.getYacimiento().listaDeParcelas.size() 
		        			&& context.getRigs().size() < equipo._reader.getMaximaCantidadDeRigs() ){
		        	
		        		if(!equipo.getCatalogo().getModelosRigs().isEmpty()) {
		        			ModeloRig mejorModelo = equipo.getCatalogo().getModelosRigs().get(0);
			        		for(ModeloRig otroModelo : equipo.getCatalogo().getModelosRigs()) {
			        			if(otroModelo.getPrecioRig() < mejorModelo.getPrecioRig())
			        				mejorModelo = otroModelo;
			        		}
			        		Rig rigElegido= new Rig(mejorModelo, context, mejorModelo.getDiasMinimoDeAlquiler());
			        		context.alquilarUnRig(rigElegido);			        		
			        		this.textToLog = "se Alquila un rig por el precio de: "+ String.valueOf(rigElegido.getModelo().getPrecioRig())+"- cantidad de rigs alquilados :"+ String.valueOf(context.getRigs().size()) ;

			        		equipo.getEstadoFinanciero().debit(equipo.getPresupuesto().getCostoDeRigHastaElDia(mejorModelo.getDiasMinimoDeAlquiler(), rigElegido.getModelo()));
		        		}
		        		else {
		        			this.textToLog = "NO EXITEN MODELOS DE RIGS";		        		
			        	}	
		        	}
		        	else{
		        		this.textToLog = "NO SE ALQUILAN RIGS";
		        	}
	        		
		        }
		        
		        @Override		        
		        public void LogAction(Context context)  {
		        	if(this.textToLog != null && this.textToLog != "")
		        	context.SetLastEventsToLog(this.textToLog);
		        }		        
		        
		    };
		    result.add(new Closure(elegirRig));
		    return result;	
	}

}
