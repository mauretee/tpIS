package tpIS;

import java.util.List;

public class CriterioDeExtraccionEnTodaParcela extends CriterioExtraccion{
	
	public CriterioDeExtraccionEnTodaParcela(Equipo equipo) {
		super(equipo);			
	}

	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function perforar = new Function() {
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	for(Parcela parcela : equipo.getYacimiento().listaDeParcelas){		        		
		        		if(parcela.tienePozo() && parcela.getPozo().getEstado()!= Estado.Extrayendo && context.getCapacityToExtract()>0 ) {
		        					        		
		        			//revisar
		        			context.Extract(parcela.getPozo(), parcela.getPozo().getCapacidad());		        			
		        					        					        						        		
		        		}
		        		
		        	}
		        }
		        
		        @Override
		        public void LogAction(Context context)  {
		        	context.SetLastEventsToLog("se extrae en parcela");
		        }
		        
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  
	
	
}
