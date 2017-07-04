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
		        		
		        		for(Rig unRig : context.getRigs()) {
		        			if(!unRig.isCavando())
			        			if(MenorRig.getModelo().getconsumCombustibleXDia() > unRig.getModelo().getconsumCombustibleXDia())
			        				MenorRig = unRig;		        				
		        		}
		        		
		        		if(!MenorRig.isCavando()) {
		        			context.elegirRigParaCavar(MenorRig);
		        			noElegido = false;
		        		}
		        		
		        	}
		        	if(noElegido) {
		        		if(!equipo.unCatalogoDeRigs.getModelosRigs().isEmpty()) {
		        			ModeloRig mejorModelo = equipo.unCatalogoDeRigs.getModelosRigs().get(0);
			        		for(ModeloRig unModelo : equipo.unCatalogoDeRigs.getModelosRigs()) {
			        			if(unModelo.getPrecioRig() < mejorModelo.getPrecioRig())
			        				mejorModelo = unModelo;
			        		}
			        		Rig rigElegido= new Rig(mejorModelo, context, mejorModelo.getDiasMinimoDeAlquiler());
			        		context.elegirRigParaCavar(rigElegido);
			        		context.alquilarUnRig(rigElegido);
			        		//TODO falta calcular el costo!
			        		equipo._estadoFinanciero.debit(equipo._presupuesto.getCostoDeRigHastaElDia(mejorModelo.getDiasMinimoDeAlquiler(), rigElegido));
		        		}
		        		else {
			        		System.err.println("NO EXITEN MODELOS DE RIGS");
			        	}
		        	}
		        }
		        
		    };
		    result.add(new Closure(elegirRig));
		    return result;	
	}  

}
