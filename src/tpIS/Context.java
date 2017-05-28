package tpIS;

public class Context {

	private String _lastEventToLog = ""; 
	private int _actualDay;
	private Boolean _continue;
	
	public Context(){
		this._actualDay = 0;
		this._continue = true;
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
	
	public void Perforar(Parcela parcela){
		this._lastEventToLog = "perforar parcela";
	}
	
}

