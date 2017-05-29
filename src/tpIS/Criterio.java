package tpIS;

import java.util.List;

public abstract class Criterio extends Equipo{
	
	public Equipo _equipo;
		
	public Criterio(Equipo equipo){
		this._equipo = equipo;
		this._reader = equipo._reader;		
		this._yacimiento = equipo._yacimiento;
		this._presupuesto = equipo._presupuesto;
		this._estadoFinanciero = equipo._estadoFinanciero;

	}
		
	public List<Closure> Evaluate(Context context){
		return this._equipo.Evaluate(context);
	}
}
