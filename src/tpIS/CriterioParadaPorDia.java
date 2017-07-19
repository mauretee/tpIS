package tpIS;

import java.util.List;

public class CriterioParadaPorDia extends CriterioAdherido {

	private int _limitDay;
	
	public CriterioParadaPorDia(Criterio criterio, int limitDay) {
		super(criterio);				
		this._limitDay = limitDay;
	}

	
	
	@Override
	public List<Closure> Evaluate(Context context, EstadoFinanciero estado) {

		List<Closure> result = super.Evaluate(context, estado);
		if(context.GetDay() >= this._limitDay){
			Function parar = new Function() {
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		            context.Finish();
		        }
		        @Override
		        public void LogAction(Context context)  {
		        	context.SetLastEventsToLog("se llego al criterio de parada por dia");
		        }
		    };
		    
		    result.add(new Closure(parar));
		    
		}else{
			result.add(new Closure());		    
		}  
		return result;
	}
}
