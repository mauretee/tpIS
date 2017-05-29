package tpIS;
import java.util.ArrayList;
import java.util.List;
import tpIS.Closure;

public class Simulacion {

	private Equipo _equipoIngenieria;
	private Context _context;
	private Logger _logger;
	private Reader _reader;
	private List<Rig> rigsCavando;
	private List<Tanque> tanquesEnConstruccion;
	private List<Planta> plantasEnConstruccion;

	public Simulacion(){
		this._reader = new Reader();
		this._equipoIngenieria=  this._reader.getEquipoIngenieria();// new EquipoIngenieria(this._reader);
		this._context= new Context(this._reader);
		this._logger= new Logger();
		
		rigsCavando = new ArrayList<Rig>();
		tanquesEnConstruccion = new ArrayList<Tanque>();
		plantasEnConstruccion = new ArrayList<Planta>();
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
			tareasEnSimulacion();
			/*this._logger.Log("Estado financiero actual: "+
					String.valueOf(this._equipoIngenieria.getEstadoFinanciero().getStatus()));*/
			this._logger.Log("Finaliza el dia "+ String.valueOf(this._context.GetDay()));
			this._context.FinishDay();

		}

	}
	
	private void tareasEnSimulacion() {
		//Seguimos contrullendo los pozos
		if(!rigsCavando.isEmpty()) {
			for(Rig unRig : rigsCavando){
				if(unRig.isCavando())
					unRig.seguirCavando();
				else
					rigsCavando.remove(unRig);
			}			
		}
		//seguimos construllendo los tanques
		if(!tanquesEnConstruccion.isEmpty()){
			for(Tanque unTanque : tanquesEnConstruccion){
				if(!unTanque.estaCosntruido())
					unTanque.construirUnDia();
				else
					tanquesEnConstruccion.remove(unTanque);
			}
		}
		if(!plantasEnConstruccion.isEmpty()){
			for(Planta unaPlanta : plantasEnConstruccion){
				if(!unaPlanta.plantaEnConstruccion())
					unaPlanta.construirUnDia();
				else
					plantasEnConstruccion.remove(unaPlanta);
			}
		}
	}
}
