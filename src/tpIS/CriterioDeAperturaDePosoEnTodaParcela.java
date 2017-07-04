package tpIS;

import java.util.List;

public class CriterioDeAperturaDePosoEnTodaParcela extends CriterioDeAperturaDePoso {

	public CriterioDeAperturaDePosoEnTodaParcela(Equipo equipo) {
		super(equipo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Closure> Evaluate(Context context) {

		List<Closure> result = super.Evaluate(context);
			Function perforar = new Function() {
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        	for(Parcela parcela : equipo._yacimiento.listaDeParcelas){		        		
		        		if(parcela.tienePozo()) {
		        			
		        			/*
		        			 * Este criterio abre el pozo de todas las parcelas q tengan pozo, todos los dias.
		        			 */
		        			parcela.getPozo().extraer();
		        			
			        		//TODO: llamar al calculador de costo y 
		        		}
		        		
		        	}
		        }
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  


}
