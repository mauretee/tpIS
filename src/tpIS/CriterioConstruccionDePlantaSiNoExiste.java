package tpIS;

import java.util.List;

public class CriterioConstruccionDePlantaSiNoExiste extends CriterioDeConstruccionDePlanta{
	
	public CriterioConstruccionDePlantaSiNoExiste(Equipo equipo) {
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
				
				@Override
		        public void Apply(Context context, Equipo equipo)  {
		        	/*
		        	 * Este criterio Construlle la planta mas barata q encuentre en el presupuesto.
		        	 */
		        	//TODO No tenemos modelos de plantas... ??
		        	//for(Planta unaPlanta : equipo._presupuesto.getPlantas() ?????)
					if(context.getPlantas().isEmpty()){
						ModeloPlanta MP = new ModeloPlanta(1,2);
						Planta P= new Planta(MP ,context);
			        	context.attachPlanta(P);
						
					}
		        	
		        }
		        @Override
		        public void LogAction(Context context)  {
		        	context.SetLastEventsToLog("se construye planta");
		        }		        
		    };
		    result.add(new Closure(construirPlanta));
		    return result;	
	}  

}
