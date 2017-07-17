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
		        private String textToLog ="";
				@Override
		        public void Apply(Context context, Equipo equipo)  {
		        	int nroParcela = 0;
		        	for(Parcela parcela : equipo.getYacimiento().listaDeParcelas){		        		
		        		if(parcela.tienePozo() && parcela.getPozo().getEstado()!= Estado.Extrayendo && context.getCapacityToExtract()>0 ) {
		        					        		
		        			//revisar
		        			context.Extract(parcela.getPozo(), parcela.getPozo().getCapacidadPotencial(equipo.getAlpha1(), equipo.getAlpha2()), equipo.getYacimiento());
		        			if(!this.textToLog.isEmpty()){
	        					this.textToLog = this.textToLog+ " - ";	
	        				}
	        				this.textToLog = this.textToLog + "se extrae en parcela nro: "+String.valueOf(nroParcela);
		        					        					        						        		
		        		}
		        		nroParcela++;
		        	}
		        }
		        
		        @Override
		        public void LogAction(Context context)  {
		        	if(this.textToLog != null && this.textToLog != ""){
		        		context.SetLastEventsToLog(this.textToLog);
		        		
		        	}
		        	
		        }
		        
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  
	
	
}
