package tpIS;

import java.util.List;

public class CriterioDePerforacionEnTodaParcela extends CriterioDePerforacion{

	
	public CriterioDePerforacionEnTodaParcela(Reader reader){
		
	}
	
	@Override
	public Closure Evaluate(Context context, Yacimiento yacimiento, Presupuesto presupuesto, EstadoFinanciero estado) {
		// TODO Auto-generated method stub		
			Function perforar = new Function() {
		        @Override
		        public void Apply(Context context)  {
		        	for(int i = 0; i< yacimiento.listaDeParcelas.size(); i++){		        		
		        		
		        		Rig rig = context.getRigs().get(0);
		        		rig.cavarPozoEnParcela(yacimiento.listaDeParcelas.get(i));
		        		
		        		
		        		//double costo =  presupuesto.getCostoDeRig(rigs.get(0));
		        		//estado.debit(costo);		        		
		        	}
		        }
		    };
	
		    return new Closure(perforar);
	
	}  
	
	
}
