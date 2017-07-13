package tpIS;

import java.util.List;

public class CriterioConstruccionDeDiezPlantas extends CriterioDeConstruccionDePlanta{
	
	public CriterioConstruccionDeDiezPlantas(Equipo equipo) {
		super(equipo);			
	}
	
	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function construirPlanta = new Function() {
				/*
				 * (non-Javadoc)
				 * @see tpIS.Function#Apply(tpIS.Context, tpIS.Equipo, java.lang.Object)
				 */
				private String textToLog="";
				
				@Override
		        public void Apply(Context context, Equipo equipo)  {
		        	/*
		        	 * Este criterio Construlle la planta mas barata q encuentre en el presupuesto.
		        	 */
		        	//TODO No tenemos modelos de plantas... ??
		        	//for(Planta unaPlanta : equipo._presupuesto.getPlantas() ?????)
					if(context.getPlantas().isEmpty() || context.getPlantas().size() < 10){
						ModeloPlanta MP = new ModeloPlanta(1,2);
						Planta P= new Planta(MP ,context);
			        	context.attachPlanta(P);
						this.textToLog = "se construye planta procesadora con capacidad diaria de procesamiento de: "+ String.valueOf(P.getModelo().getPoderProcesamientoDia()) ;
					}
					else{
						this.textToLog = "";
					}
		        	
		        }
		        @Override
		        public void LogAction(Context context)  {
		        	if(this.textToLog != null && this.textToLog != "")
		        	context.SetLastEventsToLog(this.textToLog);
		        }		        
		    };
		    result.add(new Closure(construirPlanta));
		    return result;	
	}  

}
