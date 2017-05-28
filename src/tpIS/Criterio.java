package tpIS;

public abstract class Criterio {

	public abstract Closure Evaluate(Context context, Yacimiento yacimiento, Presupuesto presupuesto, EstadoFinanciero estado);
	
}
