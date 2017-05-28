package tpIS;

import java.util.ArrayList;
import java.util.List;

public class EquipoIngenieria {
	
	private List<Criterio> _criterios;
	private Yacimiento _yacimiento;
	private Presupuesto _presupuesto;
	private EstadoFinanciero _estadoFinanciero;
	
	public EquipoIngenieria(Reader reader){		
		this._criterios = reader.getCriterios();
		this._yacimiento = reader.getYacimiento();
		this._presupuesto = reader.getPresupuesto();
		this._estadoFinanciero = reader.getEstadoFinanciero();
	}
	
	public List<Closure> WhatToDo(Context context){
		
		List<Closure> actions = new ArrayList<Closure>(); 
		for(int i = 0; i< this._criterios.size(); i++){
			actions.add(this._criterios.get(i).Evaluate(context, this._yacimiento, this._presupuesto, this._estadoFinanciero));
		}
		
		return actions; 
	}
	
}
