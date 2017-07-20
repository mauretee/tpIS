package tpIS;

import java.util.List;

public class CriterioDeParadaXPerdidaDeCapital extends CriterioAdherido {
	
private double limitCapital;
	
	public CriterioDeParadaXPerdidaDeCapital(Criterio criterio, double limitCapital) {
		super(criterio);			
		this.limitCapital = limitCapital;
	}

	
	
	@Override
	public List<Closure> Evaluate(Context context, EstadoFinanciero estadoFinanciero) {
		// TODO Auto-generated method stub
		List<Closure> result = super.Evaluate(context, estadoFinanciero);
		if(estadoFinanciero.getStatus() < this.limitCapital){
			Function parar = new Function() {
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		            context.Finish();
		        }
		        @Override
		        public void LogAction(Context context)  {
		        	context.SetLastEventsToLog("se llegó al criterio de parada por falta de capital"+ System.lineSeparator());
		        }
		    };
		    
		    result.add(new Closure(parar));
		    
		}else{
			result.add(new Closure());		    
		}  
		return result;
	}

}