package tpIS;
import java.util.List;
import tpIS.Closure;

public class Simulacion {

	private EquipoIngenieria _equipoIngenieria;
	private Context _context;
	private Logger _logger;

	public Simulacion(){
		this._equipoIngenieria= new EquipoIngenieria();
		this._context= new Context();
		this._logger= new Logger();
	}


	public void Simular(){
		while(this._context.Continue()){
			this._logger.Log("Inicia el dia "+ String.valueOf(this._context.GetDay()));
			List<Closure> actions = this._equipoIngenieria.WhatToDo(this._context);
			for(int i=0; i<actions.size(); i++)
			{
				actions.get(i).Apply(this._context);
				this._logger.Log(this._context.GetLastEventsToLog());				
			}
			this._logger.Log("Finaliza el dia "+ String.valueOf(this._context.GetDay()));
			this._context.FinishDay();

		}

	}
	
}
