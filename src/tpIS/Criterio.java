package tpIS;

import java.util.List;

public abstract class Criterio{
			
	public Criterio _criterio;
		
	public List<Closure> Evaluate(Context context, EstadoFinanciero estado){
		return this._criterio.Evaluate(context, estado);
	}
}
