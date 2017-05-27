package tpIS;

public class CriterioParadaPorDia extends CriterioParada {

	private int _limitDay;
	
	public CriterioParadaPorDia(Reader reader){
		
		this._limitDay = reader.getLimitDaysQuantity();
	}
	
	@Override
	public Closure Evaluate(Context context) {
		// TODO Auto-generated method stub
		return new Closure();
		
	}
}
