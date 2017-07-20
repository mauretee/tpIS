package tpIS;

import java.util.List;

public class CriterioConstruccionDePlantaSiNoExiste extends CriterioAdherido{
	
	public CriterioConstruccionDePlantaSiNoExiste(Criterio criterio) {
		super(criterio);			
	}
	
	@Override
	public List<Closure> Evaluate(Context context, EstadoFinanciero estado) {

		List<Closure> result = super.Evaluate(context, estado);
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
					if(context.getPlantas().isEmpty()){
						ModeloPlanta MP = equipo.getCatalogo().getModeloPlantas().get(0);
						//ModeloPlanta MP = new ModeloPlanta(1,2);
						Planta P= new Planta(MP ,context);
			        	context.attachPlanta(P);
			        	equipo.getEstadoFinanciero().debit(equipo.getPresupuesto()
			        			.getCostoDePlanta( P.getModelo()));
						this.textToLog = "se construye planta"+ System.lineSeparator();;
					}
					else{
						this.textToLog = "";
					}
		        	
		        }
		        @Override
		        public void LogAction(Context context)  {		        	
		        	context.SetLastEventsToLog(this.textToLog);
		        }		        
		    };
		    result.add(new Closure(construirPlanta));
		    return result;	
	}  

}
