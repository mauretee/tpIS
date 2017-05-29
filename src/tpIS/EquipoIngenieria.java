package tpIS;

import java.util.ArrayList;
import java.util.List;
//
public class EquipoIngenieria extends Equipo{
	
		
	public EquipoIngenieria(Yacimiento yacimiento, Presupuesto presupuesto, EstadoFinanciero estadoFinanciero){
		//this._reader = reader;		
		this._yacimiento = yacimiento; //reader.getYacimiento();
		this._presupuesto = presupuesto; //reader.getPresupuesto();
		this._estadoFinanciero = estadoFinanciero; //reader.getEstadoFinanciero();		
	}
	
	@Override
	public List<Closure> Evaluate(Context context){
		
		List<Closure> actions = new ArrayList<Closure>(); 		
		return actions; 
	}
	
	public EstadoFinanciero getEstadoFinanciero(){
		return this._estadoFinanciero;		
	}
	
}
