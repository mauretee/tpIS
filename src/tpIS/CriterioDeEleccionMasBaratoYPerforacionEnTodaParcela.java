package tpIS;

import java.util.ArrayList;
import java.util.List;

public class CriterioDeEleccionMasBaratoYPerforacionEnTodaParcela extends CriterioAdherido{
	
	public CriterioDeEleccionMasBaratoYPerforacionEnTodaParcela(Criterio criterio) {
		super(criterio);			
	}

	@Override
	public List<Closure> Evaluate(Context context, EstadoFinanciero estado) {

		List<Closure> result = super.Evaluate(context, estado);
			Function perforar = new Function() {

				private String textToLog = "";
				
				
		        @Override
		        public void Apply(Context context, Equipo equipo)  {
		        		int nroParcela = 0;
		        		for(Parcela parcela : equipo.getYacimiento().listaDeParcelas){		        		
			        		if(!parcela.tienePozo() && !parcela.pozoEnConstruccion()) {
			        			
			        			
			        			//ELECCION
					        	/*
					        	 * Este criterio en particular ignora por completo la parcela.
					        	 * Buscamos el rig mas barato en la lista de rigs alquilados
					        	 * de no haber ninguno que se pueda utilizar alli, creamos el modelo mas barato
					        	 */
					        	boolean noElegido = true;
					        	Rig selectedRig = null;
					        	if(!context.getRigs().isEmpty()) {
					        		Rig MenorRig;
					        		MenorRig= context.getRigs().get(0);
					        		List<Rig> YaElegidos = new ArrayList<Rig>();
					        		
					        		while(noElegido) {
						        		for(Rig unRig : context.getRigs()) {
						        			if(!YaElegidos.contains(unRig))
							        			if(MenorRig.getModelo().getconsumCombustibleXDia() > unRig.getModelo().getconsumCombustibleXDia())
							        				MenorRig = unRig;		        				
						        		}
						        		YaElegidos.add(MenorRig);
						        		
						        		if(!MenorRig.isCavando()) {
						        			selectedRig = MenorRig;
						        			noElegido = false;
						        		}
						        		
						        		if(YaElegidos.size() == context.getRigs().size()) {
						        			if(!this.textToLog.isEmpty()){
					        					this.textToLog = this.textToLog+ " - ";	
					        				}
					        				this.textToLog = this.textToLog + "no se puede perforar en parcela nro: "+String.valueOf(nroParcela) +" porque todos los rigs estan siendo utilizados";

						        			noElegido=false;
						        		}
					        		}
					        	}
			        			
			        			/*
			        			 * El criterio elige una parcela para cavar y se lo informa al contexto.
			        			 * Luego pide al equipo el criterio de eleccion de rig, y para esa parcela el criterio decide
			        			 * guardando q rig selecciono en el contexto.
			        			 */
			        					        			
			        			if(selectedRig!=null){
			        				selectedRig.cavarPozoEnParcela(parcela);
			        				if(!this.textToLog.isEmpty()){
			        					this.textToLog = this.textToLog+ " - ";	
			        				}
			        				this.textToLog = this.textToLog + "se cava en parcela nro: "+String.valueOf(nroParcela) +" con un rig de valor: "+ String.valueOf(selectedRig.getModelo().getPrecioRig());
			        			}
			        			/*else
			        				break;*/
			        			
			        		
			        			nroParcela +=1;
				        		//TODO: llamar al calculador de costo y 
			        		}
			        		
			        		
			        	}
		        	
		        
		        }
		        
		        @Override
		        public void LogAction(Context context)  {
		        	if(this.textToLog != null && this.textToLog != ""){
		        		context.SetLastEventsToLog(this.textToLog);	
		        	}		        	
		        }		        
		    };
		    result.add(new Closure(perforar));
		    return result;	
	}  
	
	
}
