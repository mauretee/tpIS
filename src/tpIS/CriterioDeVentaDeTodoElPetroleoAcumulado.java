package tpIS;

import java.util.List;

public class CriterioDeVentaDeTodoElPetroleoAcumulado extends CriterioVentaPetroleo {
	
	
	public CriterioDeVentaDeTodoElPetroleoAcumulado(Equipo equipo) {
		super(equipo);			
	}

	
	
	@Override
	public List<Closure> Evaluate(Context context) {
		// TODO Auto-generated method stub
		
		List<Closure> result = super.Evaluate(context);
		if(context.getVolumenExtraido()>0){
			
			Function vender = new Function() {
				private String textToLog ="";
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	textToLog ="se venden: "+ context.getVolumenExtraido() +"m3 a un precio de: "+equipo.getPresupuesto()
        			.getPrecioPetroleo()+"por m3";
		        			        	
		        	//FIX: esto deberia hacerlo el calculador
		        	equipo.getEstadoFinanciero().acredit(equipo.getPresupuesto()
		        			.getPrecioPetroleo() * context.getVolumenExtraido());
		        	context.SalePetroleo(context.getVolumenExtraido());
		        }
		        @Override
		        public void LogAction(Context context)  {
		        	if(textToLog != null && textToLog!=""){
		        		context.SetLastEventsToLog(textToLog);	
		        	}
		        	
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