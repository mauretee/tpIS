package tpIS;

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

			this._logger.Log(this._context.GetDay().ToString());
			List<Closure> actions = this._equipoIngenieria.WhatToDo(this._context);
			
			foreach(v action in actions){
				action.Execute();
				this.logger.Log(this._context.GetLastEventsToLog());
			}

		}

	}
	
}
