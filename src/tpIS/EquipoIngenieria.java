package tpIS;

import java.util.ArrayList;
import java.util.List;

public class EquipoIngenieria {
	
	private List<Criterio> _criterios;
	private Yacimiento _yacimiento;
	private Presupuesto _presupuesto;
	private EstadoFinanciero _estadoFinanciero;
	
	public EquipoIngenieria(){
		Reader reader = new Reader();
		this._criterios = reader.getCriterios();
		this._yacimiento = reader.getYacimiento();
	}
	
	public List<Closure> WhatToDo(Context context){
		
		List<Closure> actions = new ArrayList<Closure>(); 
		for(Criterio unCriterio : _criterios){
			actions.add(unCriterio.Evaluate(context, this._yacimiento, this._presupuesto, this._estadoFinanciero));
		}
		
		return actions; 
	}
	
}
