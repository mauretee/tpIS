package tpIS;

import java.util.List;

public class CriterioDeExtraccionEnTodaParcela extends CriterioAdherido{
	
	public CriterioDeExtraccionEnTodaParcela(Criterio criterio) {
		super(criterio);			
	}

	@Override
	public List<Closure> Evaluate(Context context, EstadoFinanciero estado) {

		List<Closure> result = super.Evaluate(context, estado);
			Function perforar = new Function() {
		        private String textToLog ="";
				@Override
		        public void Apply(Context context, Equipo equipo)  {
		        	int nroParcela = 0;
		        	for(Parcela parcela : equipo.getYacimiento().listaDeParcelas){		        		
		        		if(context.getCapacityToExtract()>0  && parcela.tienePozo() && parcela.getPozo().getEstado()!= Estado.Extrayendo  ) {
		        		//revisar
		        			context.Extract(parcela.getPozo(), parcela.getPozo().getCapacidadPotencial(equipo.getAlpha1(), equipo.getAlpha2(), equipo.getCalculadorPotencialDeExtraccion()), equipo.getYacimiento());		        			
	        				this.textToLog = this.textToLog + "se extrae en parcela nro: "+String.valueOf(nroParcela)+ System.lineSeparator();
		        					        					        						        		
		        		}else{
		        			this.textToLog = this.textToLog + "no se puede extraer en parcela nro: "+String.valueOf(nroParcela)+ System.lineSeparator();
		        		}
		        		nroParcela += 1;
		        	}
		        }
		        
		        @Override
		        public void LogAction(Context context)  {		        			        
		        	context.SetLastEventsToLog(this.textToLog);		        				        		        	
		        }
		        
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  
	
	
}
