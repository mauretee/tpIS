package tpIS;

import java.util.List;

public class CriterioParadaPorDia extends CriterioParada {

	private int _limitDay;
	public CriterioParadaPorDia(Equipo equipo) {
		super(equipo);
		this._limitDay = super._reader.getLimitDaysQuantity();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public List<Closure> Evaluate(Context context) {
		// TODO Auto-generated method stub
		List<Closure> result = super.Evaluate(context);
		if(context.GetDay() >= this._limitDay){
			Function parar = new Function() {
		        @Override
		        public void Apply(Context context)  {
		            context.Finish();
		        }
		    };
		    
		    result.add(new Closure(parar));
		    
		}else{
			result.add(new Closure());		    
		}  
		return result;
	}
}
