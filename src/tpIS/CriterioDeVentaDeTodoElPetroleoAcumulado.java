package tpIS;

import java.util.List;

public class CriterioDeVentaDeTodoElPetroleoAcumulado extends CriterioAdherido {
	
	
	public CriterioDeVentaDeTodoElPetroleoAcumulado(Criterio criterio) {
		super(criterio);			
	}

	
	
	@Override
	public List<Closure> Evaluate(Context context, EstadoFinanciero estado) {

		List<Closure> result = super.Evaluate(context, estado);
		if(context.getVolumenExtraido()>0){
			
			Function vender = new Function() {
				private String textToLog ="";
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	textToLog ="se venden: "+ context.getVolumenExtraido() +"m3 a un precio de: $"+equipo.getPresupuesto()
        			.getPrecioPetroleo()+"por m3"+ System.lineSeparator();
		        			        	
		        	//FIX: esto deberia hacerlo el calculador
		        	equipo.getEstadoFinanciero().acredit(equipo.getPresupuesto()
		        			.getPrecioPetroleo() * context.getVolumenExtraido());
		        	context.SalePetroleo(context.getVolumenExtraido());
		        }
		        @Override
		        public void LogAction(Context context)  {		        	
		        	context.SetLastEventsToLog(textToLog);			        	
		        }
		    };
			
		    result.add(new Closure(vender));	
		}		
		else{
			result.add(new Closure());		    
		}  
		return result;
	}

}