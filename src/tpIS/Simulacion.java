package tpIS;
import tpIS.Logger;
import java.util.List;
import tpIS.Closure;


public class Simulacion {	
	private Equipo _equipoIngenieria;	
	private Context _context;
	private Logger _logger;	

	
	public Simulacion(Reader _reader){			
		this._context = new Context();  	
		this._equipoIngenieria = _reader.getEquipoIngenieria(_context);  	
		this._logger= new Logger();
	}


	public void Simular(){
		while(this._context.Continue()){
			this._logger.Log("Inicia el dia "+ String.valueOf(this._context.GetDay()));
			List<Closure> actions = this._equipoIngenieria.Evaluate(this._context);
			for(Closure action : actions)
			{
				//System.out.println("Entro a las actions");
				action.Apply(this._context, this._equipoIngenieria);
				action.LogAction(this._context);
				if(this._context.GetLastEventsToLog()!= null && this._context.GetLastEventsToLog()!= ""){
					this._logger.Log(this._context);					
				}
									
			}
			/*this._logger.Log("Estado financiero actual: "+
					String.valueOf(this._equipoIngenieria.getEstadoFinanciero().getStatus()));*/
			this._logger.Log("Finaliza el dia "+ String.valueOf(this._context.GetDay()) + System.lineSeparator());
			this._logger.Log("El presupuesto actual es de "+ this._equipoIngenieria.getEstadoFinanciero().getStatus());
			this._context.FinishDay();

		}
		this._logger.Log("Finaliza la simulacion");

	}
	
}
