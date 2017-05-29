package tpIS;

import java.util.List;

public class CriterioDePerforacionEnTodaParcela extends CriterioDePerforacion{
	
	public CriterioDePerforacionEnTodaParcela(Equipo equipo) {
		super(equipo);		
		this._reader = equipo._reader;		
		this._yacimiento = equipo._yacimiento;
		this._presupuesto = equipo._presupuesto;
		this._estadoFinanciero = equipo._estadoFinanciero;
	}

	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function perforar = new Function() {
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	for(int i = 0; i< equipo._yacimiento.listaDeParcelas.size(); i++){		        		
		        		
		        		Rig rig = context.getRigs().get(0);
		        		rig.cavarPozoEnParcela(equipo._yacimiento.listaDeParcelas.get(i));		        		
		        		
		        		//double costo =  presupuesto.getCostoDeRig(rigs.get(0));
		        		//estado.debit(costo);		        		
		        	}
		        }
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  
	
	
}
