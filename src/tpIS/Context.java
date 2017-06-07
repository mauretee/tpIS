package tpIS;

import java.util.ArrayList;
import java.util.List;

public class Context {

	private String _lastEventToLog = ""; 
	private int _actualDay;
	private Boolean _continue;	
	private List<Rig> rigsAlquilados;
	private List<Planta> _plantas;
	private List<Tanque> _tanques;	
	private List<ContextObserver> Observadores;
	
	public Context(){
			
		this._actualDay = 0;
		this._continue = true;		
		Observadores = new ArrayList<ContextObserver>();
		rigsAlquilados = new ArrayList<Rig>();
		_plantas = new ArrayList<Planta>();
		_tanques = new ArrayList<Tanque> ();
		
		
	}
	
	public int GetDay(){
		return this._actualDay;		
	}
	
	public void FinishDay(){		
		this._actualDay+=1;
		for (ContextObserver observer : Observadores) 
	         observer.updateDay();		
	}
	
	public String GetLastEventsToLog(){
		return this._lastEventToLog;
	}
	
	public Boolean Continue(){
		return this._continue;
	}
	
	public void Finish(){
		this._continue = false;
		this._lastEventToLog = "Finalizando simulación";
	}
	
	public List<Rig> getRigs(){
		return this.rigsAlquilados;
	}
	
	public List<Planta> getPlantas(){
		return this._plantas;
	}
	
	public List<Tanque> getTanques(){
		return this._tanques;
	}
		
	
	public void attach(ContextObserver observer){
		Observadores.add(observer);		
	}
	
	public void attachPlanta(Planta unaPlanta) {
		_plantas.add(unaPlanta);
	}
	
	public void attachTanque(Tanque unTanque) {
		_tanques.add(unTanque);
	}
	
}

