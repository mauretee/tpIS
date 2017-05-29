package tpIS;

import java.util.List;

public class Context {

	private String _lastEventToLog = ""; 
	private int _actualDay;
	private Boolean _continue;	
	private List<Rig> _rigs;
	private List<Planta> _plantas;
	private List<Tanque> _tanques;	
	
	public Context(List<Rig> _rigs){
		
		this._actualDay = 0;
		this._continue = true;
		this._rigs = _rigs; 
	}
	
	public int GetDay(){
		return this._actualDay;		
	}
	
	public void FinishDay(){		
		this._actualDay+=1;
		
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
		return this._rigs;
	}
	
	public List<Planta> getPlantas(){
		return this._plantas;
	}
	
	public List<Tanque> getTanques(){
		return this._tanques;
	}
	
}

