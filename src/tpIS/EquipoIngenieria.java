package tpIS;

import java.util.ArrayList;
import java.util.List;

public class EquipoIngenieria {

	
	private List<Criterio> _criterios;
	
	public EquipoIngenieria(){
		Reader reader = new Reader();
		this._criterios = reader.getCriterios(); 
	}
	
	public List<Closure> WhatToDo(Context context){
		
		return new ArrayList<Closure>();
	}
	
}
