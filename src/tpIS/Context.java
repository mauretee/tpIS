package tpIS;

public class Context {

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
		return "hola";
	}
	
	public Boolean Continue(){
		return this._continue;
	}
	
	public void Finish(){
		this._continue = false;
	}
	
}

