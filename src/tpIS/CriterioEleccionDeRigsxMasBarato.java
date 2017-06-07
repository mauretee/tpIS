package tpIS;

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
				 * Jamas en mi vida vi algo tan feo
				 */
				
		        @Override
		        public void Apply(Context context, Equipo equipo, Object rigElejido)  {
		        	if(!context.getRigs().isEmpty()) {
		        		Rig MenorRig;
		        		MenorRig= context.getRigs().get(0);
		        		
		        		for(Rig unRig : context.getRigs()) {
		        			if(!unRig.isCavando())
			        			if(MenorRig.getModelo().getconsumCombustibleXDia() > unRig.getModelo().getconsumCombustibleXDia())
			        				MenorRig = unRig;		        				
		        		}
		        		
		        		if(!MenorRig.isCavando()) {
		        			rigElejido = (Object) MenorRig;
		        		}
		        		
		        	}
		        	else {
		        		if(!equipo.unCatalogoDeRigs.getModelosRigs().isEmpty()) {
		        			ModeloRig mejorModelo = equipo.unCatalogoDeRigs.getModelosRigs().get(0);
			        		for(ModeloRig unModelo : equipo.unCatalogoDeRigs.getModelosRigs()) {
			        			if(unModelo.getPrecioRig() < mejorModelo.getPrecioRig())
			        				mejorModelo = unModelo;
			        		}
			        		rigElejido= (Object) new Rig(mejorModelo, context);
		        		}
		        	}
		        	
		        }
		    };
		    result.add(new Closure(elegirRig));
		    return result;	
	}  

}
