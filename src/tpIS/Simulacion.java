package tpIS;
import java.util.List;
import tpIS.Closure;

public class Simulacion {

	private Equipo _equipoIngenieria;
	private Context _context;
	private Logger _logger;
	private Reader _reader;

	public Simulacion(){
		this._reader = new Reader();
		this._equipoIngenieria=  this._reader.getEquipoIngenieria();// new EquipoIngenieria(this._reader);
		this._context= new Context(this._reader);
		this._logger= new Logger();
	}


	public void Simular(){
		while(this._context.Continue()){
			this._logger.Log("Inicia el dia "+ String.valueOf(this._context.GetDay()));
			List<Closure> actions = this._equipoIngenieria.Evaluate(this._context);
			for(Closure action : actions)
			{
				action.Apply(this._context, this._equipoIngenieria);
				this._logger.Log(this._context.GetLastEventsToLog());				
			}
			/*this._logger.Log("Estado financiero actual: "+
					String.valueOf(this._equipoIngenieria.getEstadoFinanciero().getStatus()));*/
			this._logger.Log("Finaliza el dia "+ String.valueOf(this._context.GetDay()));
			this._context.FinishDay();

		}

	}
	
}
