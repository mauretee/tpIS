package tpIS;

import java.util.List;

public class CriterioConstruccionDeTanqueDeGasSiNoExiste extends CriterioDeConstruccionDeTanque{
	
	public CriterioConstruccionDeTanqueDeGasSiNoExiste(Equipo equipo) {
		super(equipo);			
	}
	
	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function construirTanque = new Function() {
				/*
				 * (non-Javadoc)
				 * @see tpIS.Function#Apply(tpIS.Context, tpIS.Equipo, java.lang.Object)
				 */
				private String textToLog="";
				
				@Override
		        public void Apply(Context context, Equipo equipo)  {
		        			        	
					if(context.getTanquesDeGas().isEmpty() ){
						ModeloTanque MP = equipo.getCatalogo().getModelosDeTanques().get(0);
						//ModeloPlanta MP = new ModeloPlanta(1,2);
						Tanque tanque= new TanqueGas(MP ,context);			        	
			        	equipo.getEstadoFinanciero().debit(equipo.getPresupuesto()
			        			.getCostoDeTanque(tanque.getModelo()));
						this.textToLog = "se construye tanque de gas";
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
		    result.add(new Closure(construirTanque));
		    return result;	
	}  

}
