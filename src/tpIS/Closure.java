package tpIS;

class Closure implements Function{
	   private int x = value;
	   Function f;
	   Function g;

	   @Override
	   public int Apply()  {
	    // print('inside foo, call to f(): ' + f()); // "2"
	    // inside apply, call to f.apply()
	    System.out.println("inside foo, call to f.apply(): " + f.Apply());
	    return 0;
	   }
	   
	   public Closure() {
		    f = new Function() {
		        @Override
		        public int Apply()  {
		            x+=1;
		            return x;
		        }
		    };
		    g = new Function() {
		        @Override
		        public int Apply()  {
		            x-=1;
		            return x;
		        }
		    };
		     x = 1;
		    
		   }
		}
}