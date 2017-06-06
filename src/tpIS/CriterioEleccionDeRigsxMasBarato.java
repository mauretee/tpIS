package tpIS;

import java.util.List;

public class CriterioEleccionDeRigsxMasBarato extends CriterioEleccionDeRigs{
	
	public CriterioEleccionDeRigsxMasBarato(Equipo equipo) {
		super(equipo);			
	}
	
	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function perforar = new Function() {
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	if(!context.getRigs().isEmpty()) {
		        		Rig MenorRig;
		        		MenorRig= context.getRigs().get(0);
		        		
		        		for(Rig unRig : context.getRigs()) {
		        			if(MenorRig.getModelo().getconsumCombustibleXDia() > unRig.getModelo().getconsumCombustibleXDia()) {
		        				MenorRig = unRig;
		        				//FIX ver si esta cavando
		        			}
		        		}
		        	}
		        	
		        }
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  

}
