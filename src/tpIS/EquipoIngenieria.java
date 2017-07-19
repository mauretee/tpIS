package tpIS;

import java.util.ArrayList;
import java.util.List;
//
public class EquipoIngenieria extends Equipo{
	
		
	public EquipoIngenieria(Reader reader, Context unContexto){
		this._reader = reader;		
		this._yacimiento = reader.getYacimiento(unContexto);
		this._presupuesto = reader.getPresupuesto();
		this._estadoFinanciero = reader.getEstadoFinanciero();	
		this.unCatalogo = reader.getCatalogo(_presupuesto);
		this._criterio = reader.getCriterio();
		this._calculadorPotencialExtraccion = new CalculadorPotencialDeExtraccion();
	}
	
	@Override
	public List<Closure> Evaluate(Context context){
		
		List<Closure> actions = this._criterio.Evaluate(context, this.getEstadoFinanciero());		
		return actions; 
	}
	
	public EstadoFinanciero getEstadoFinanciero(){
		return this._estadoFinanciero;		
	}

	
}
