package tpIS;

import java.util.List;

public class CriterioDePerforacionEnTodaParcela extends CriterioDePerforacion{
	
	public CriterioDePerforacionEnTodaParcela(Equipo equipo) {
		super(equipo);			
	}

	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function perforar = new Function() {
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	int i = 0;
		        	for(Parcela parcela : equipo._yacimiento.listaDeParcelas){		        		
		        		if(i<context.getRigs().size() && !parcela.tienePozo() && !context.getRigs().get(i).isCavando()){
		        			Rig rig = context.getRigs().get(i);
			        		rig.cavarPozoEnParcela(parcela);
			        		//TODO: llamar al calculador de costo y 
		        		}
		        				        		
		        		i++;
		        		
		        	}
		        }
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  
	
	
}
