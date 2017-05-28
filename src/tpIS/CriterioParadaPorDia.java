package tpIS;

public class CriterioParadaPorDia extends CriterioParada {

	private int _limitDay;
	
	public CriterioParadaPorDia(Reader reader){
		
		this._limitDay = reader.getLimitDaysQuantity();
	}
	
	@Override
	public Closure Evaluate(Context context, Yacimiento yacimiento) {
		// TODO Auto-generated method stub
		if(context.GetDay() >= this._limitDay){
			Function parar = new Function() {
		        @Override
		        public void Apply(Context context)  {
		            context.Finish();
		        }
		    };
		    return new Closure(parar);
		}else{
			
		    return new Closure();
		}  
	}
}
