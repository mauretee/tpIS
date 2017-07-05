package tpIS;

import java.util.List;

public class CriterioDeParadaXPerdidaDeCapital extends CriterioParada {
	
private double limitCapital;
private EstadoFinanciero unEstadoFinanciero;
	
	public CriterioDeParadaXPerdidaDeCapital(Equipo equipo) {
		super(equipo);	
		unEstadoFinanciero = equipo._estadoFinanciero; 
		this.limitCapital = this._reader.getLimitFinancialStatus();
	}

	
	
	@Override
	public List<Closure> Evaluate(Context context) {
		// TODO Auto-generated method stub
		List<Closure> result = super.Evaluate(context);
		if(unEstadoFinanciero.getStatus() < this.limitCapital){
			Function parar = new Function() {
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		            context.Finish();
		        }
		        @Override
		        public void LogAction(Context context)  {
		        	context.SetLastEventsToLog("se llegó al criterio de parada por falta de capital");
		        }
		    };
		    
		    result.add(new Closure(parar));
		    
		}else{
			result.add(new Closure());		    
		}  
		return result;
	}

}