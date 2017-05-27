package tpIS;

class Closure implements Function{
	   Function f;

	   @Override
	   public void Apply(Context context)  {
		  f.Apply(context);
	   }
	   
	   public Closure(Function function) {		  
		  f = function;		
	   }
	   
	   public Closure() {		  
		  f = new Function() {
		        @Override
		        public void Apply(Context context)  {
		        	
		        }
		    };
	   }
		
}