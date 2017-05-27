package tpIS;

public class Context {

	private int _actualDay; 
	
	public Context(){
		this._actualDay = 0;
	}
	
	public int GetDay(){
		return this._actualDay; 
	}
	
	public void FinishDay(){
		this._actualDay+=1;
	}
}

