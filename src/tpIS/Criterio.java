package tpIS;

import java.util.List;

public abstract class Criterio extends Equipo{
	
	private Equipo _equipo;
		
	public Criterio(Equipo equipo){
		this._equipo = equipo;
	}
		
	public List<Closure> Evaluate(Context context){
		return this._equipo.Evaluate(context);
	}
}
