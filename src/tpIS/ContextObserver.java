package tpIS;

public abstract class ContextObserver {
	Context unContexto;
	
	public ContextObserver(Context UnContexto) {
		unContexto = UnContexto;
		unContexto.attach(this);
	}
	
	public void updateDay(){}

}
