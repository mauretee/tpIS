package tpIS;

import java.util.ArrayList;
import java.util.List;

public class CriterioEleccionDeRigsxMasBarato extends CriterioEleccionDeRigs{
	
	public CriterioEleccionDeRigsxMasBarato(Equipo equipo) {
		super(equipo);			
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
		        	 * Este criterio en particular ignora por completo la parcela.
		        	 * Buscamos el rig mas barato en la lista de rigs alquilados
		        	 * de no haber ninguno que se pueda utilizar alli, creamos el modelo mas barato
		        	 */
		        	boolean noElegido = true;
		        	
		        	if(!context.getRigs().isEmpty()) {
		        		Rig MenorRig;
		        		MenorRig= context.getRigs().get(0);
		        		List<Rig> YaElegidos = new ArrayList<Rig>();
		        		
		        		while(noElegido) {
			        		for(Rig unRig : context.getRigs()) {
			        			if(!YaElegidos.contains(unRig))
				        			if(MenorRig.getModelo().getconsumCombustibleXDia() > unRig.getModelo().getconsumCombustibleXDia())
				        				MenorRig = unRig;		        				
			        		}
			        		YaElegidos.add(MenorRig);
			        		
			        		if(!MenorRig.isCavando()) {
			        			context.elegirRigParaCavar(MenorRig);
			        			noElegido = false;
			        		}
			        		
			        		if(YaElegidos.size() == context.getRigs().size()) {
			        			System.err.println("ERROR al elegir rigs, Estan todos cavando!");
			        			noElegido=false;
			        		}
		        		}
		        	}
		        	else 
		        		System.err.println("ERROR en criterio de eleccion de rig. No hay rigs alquilados.");
		        }
		        
		        @Override
		        public void LogAction(Context context)  {
		        	context.SetLastEventsToLog("se elige rig");
		        }
		        
		    };
		    result.add(new Closure(elegirRig));
		    return result;	
	}  

}
