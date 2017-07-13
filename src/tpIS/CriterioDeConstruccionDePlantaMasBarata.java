package tpIS;

import java.util.List;

public class CriterioDeConstruccionDePlantaMasBarata extends CriterioDeConstruccionDePlanta {

	public CriterioDeConstruccionDePlantaMasBarata(Equipo equipo) {
		super(equipo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
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
		        	ModeloPlanta MP = new ModeloPlanta(1,2);
					Planta P= new Planta(MP ,context);
		        	context.attachPlanta(P);
		        }
		        @Override
		        public void LogAction(Context context)  {
		        	context.SetLastEventsToLog("se Comienza la construccion de una planta, de modelo: ");
		        }
		        
		    };
		    result.add(new Closure(elegirRig));
		    return result;	
	}  
}
