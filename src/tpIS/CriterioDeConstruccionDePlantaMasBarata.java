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
		        	 * Este criterio Construlle la planta mas barata q encuentre en el presupuesto.
		        	 */
		        	//TODO No tenemos modelos de plantas... ??
		        	//for(Planta unaPlanta : equipo._presupuesto.getPlantas() ?????)
		        	Planta P= new Planta(1,2,context);
		        	context.attachPlanta(P);
		        }
		        
		    };
		    result.add(new Closure(elegirRig));
		    return result;	
	}  
}
