package tpIS;

import java.util.List;

public class CriterioDeConstruccionDePlantaMasBarata extends CriterioAdherido {

	public CriterioDeConstruccionDePlantaMasBarata(Criterio criterio) {
		super(criterio);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Closure> Evaluate(Context context, EstadoFinanciero estado) {

		List<Closure> result = super.Evaluate(context, estado);
			Function elegirRig = new Function() {
				/*
				 * (non-Javadoc)
				 * @see tpIS.Function#Apply(tpIS.Context, tpIS.Equipo, java.lang.Object)
				 */
				
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	/*
		        	 * Este criterio Construye la planta mas barata q encuentre en el presupuesto.
		        	 */
		        	//TODO No tenemos modelos de plantas... ??
		        	//for(Planta unaPlanta : equipo._presupuesto.getPlantas() ?????)
				ModeloPlanta MP = equipo.getCatalogo().getModeloPlantas().get(0);
		        	//ModeloPlanta MP = new ModeloPlanta(1,2);
				Planta P= new Planta(MP ,context);
		        	context.attachPlanta(P);
		        	
		        	equipo.getEstadoFinanciero().debit(equipo.getPresupuesto()
		        			.getCostoDePlanta( P.getModelo()));
		        }
		        @Override
		        public void LogAction(Context context)  {
		        	context.SetLastEventsToLog("se Comienza la construccion de una planta, de modelo: "+ System.lineSeparator());
		        }
		        
		    };
		    result.add(new Closure(elegirRig));
		    return result;	
	}  
}
