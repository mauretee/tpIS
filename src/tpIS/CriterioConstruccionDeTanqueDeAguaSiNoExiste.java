package tpIS;

import java.util.List;

public class CriterioConstruccionDeTanqueDeAguaSiNoExiste extends CriterioAdherido{
	
	public CriterioConstruccionDeTanqueDeAguaSiNoExiste(Criterio criterio) {
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
		        			        	
					if(context.getTanquesDeAgua().isEmpty() ){
						ModeloTanque MP = equipo.getCatalogo().getModelosDeTanques().get(0);
						//ModeloPlanta MP = new ModeloPlanta(1,2);
						Tanque tanque= new TanqueAgua(MP ,context);			        	
			        	equipo.getEstadoFinanciero().debit(equipo.getPresupuesto()
			        			.getCostoDeTanque(tanque.getModelo()));
						this.textToLog = "se construye tanque de agua"+ System.lineSeparator();
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
