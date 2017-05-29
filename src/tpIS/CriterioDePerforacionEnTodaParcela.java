package tpIS;

import java.util.List;

public class CriterioDePerforacionEnTodaParcela extends CriterioDePerforacion{
	public CriterioDePerforacionEnTodaParcela(Equipo equipo) {
		super(equipo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function perforar = new Function() {
		        @Override
		        public void Apply(Context context)  {
		        	for(int i = 0; i< _yacimiento.listaDeParcelas.size(); i++){		        		
		        		
		        		Rig rig = context.getRigs().get(0);
		        		rig.cavarPozoEnParcela(_yacimiento.listaDeParcelas.get(i));		        		
		        		
		        		//double costo =  presupuesto.getCostoDeRig(rigs.get(0));
		        		//estado.debit(costo);		        		
		        	}
		        }
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  
	
	
}
