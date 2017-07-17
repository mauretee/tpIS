package tpIS;

public abstract class ContextObserver {
	protected Context unContexto;
	
	public ContextObserver(Context UnContexto) {
		unContexto = UnContexto;
		unContexto.attach(this);
	}
	
	public void updateDay(){}

}
