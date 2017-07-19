package tpIS;

import java.util.ArrayList;
import java.util.List;

public class CriterioDeEquipo extends Criterio{
	
	
	public CriterioDeEquipo(){
		
	}	
	
	@Override
	public List<Closure> Evaluate(Context context, EstadoFinanciero estado) {
		List<Closure> actions = new ArrayList<Closure>();		
		return actions;
	}
		
}
