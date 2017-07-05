package tpIS;
import tpIS.TerrenoArenoso;
import java.util.ArrayList;
import java.util.List;

public class Context {

	private String _lastEventToLog = ""; 
	private int _actualDay;
	private Boolean _continue;	
	private List<Rig> rigsAlquilados;
	private List<Planta> _plantas;
	private List<Tanque> _tanques;	
	private List<ContextObserver> Observadores;
	private Parcela parcela_ACavar;
	private Rig rigElegido;
	private int volumenExtraidoHoy;
	
	public Context(){
			
		this._actualDay = 0;
		this._continue = true;		
		Observadores = new ArrayList<ContextObserver>();
		rigsAlquilados = new ArrayList<Rig>();
		_plantas = new ArrayList<Planta>();
		_tanques = new ArrayList<Tanque> ();
		TerrenoArenoso terrenoNulo = new TerrenoArenoso(1);
		Parcela unaParcela = new Parcela(0 ,terrenoNulo , 0, 0, this);
		
		parcela_ACavar = unaParcela;
		
	}
	
	public int GetDay(){
		return this._actualDay;		
	}
	
	public void FinishDay(){		
		this._actualDay+=1;
		for (ContextObserver observer : Observadores) 
	         observer.updateDay();
		
		actualizarRigs();
		this.volumenExtraidoHoy = 0;
	}
	
	private void actualizarRigs() {
		List<Rig> rigsToRemove = new ArrayList<Rig>();
		for(Rig unRig : rigsAlquilados) {
			if(unRig.getDiasQueLlevaAlquilado()>= unRig.getLimiteDeDiasEnAlquiler())
				rigsToRemove.add(unRig);				
		}
		
		for(Rig unRig : rigsToRemove) {			
			rigsAlquilados.remove(unRig);				
		}
		
	}
	
	public String GetLastEventsToLog(){
		return this._lastEventToLog;
	}
	
	public void SetLastEventsToLog(String value){
		this._lastEventToLog = value;
	}
	
	
	public Boolean Continue(){
		return this._continue;
	}
	
	public void Finish(){
		this._continue = false;
		this._lastEventToLog = "Finalizando simulación";
	}
	
	public List<Rig> getRigs(){
		return this.rigsAlquilados;
	}
	
	public void alquilarUnRig(Rig unRig) {
		rigsAlquilados.add(unRig);
	}
	
	public List<Planta> getPlantas(){
		return this._plantas;
	}
	
	public List<Tanque> getTanques(){
		return this._tanques;
	}
		
	
	public void attach(ContextObserver observer){
		Observadores.add(observer);		
	}
	
	public void attachPlanta(Planta unaPlanta) {
		_plantas.add(unaPlanta);
	}
	
	public void attachTanque(Tanque unTanque) {
		_tanques.add(unTanque);
	}

	public Parcela getParcela_ACavar() {
		if(parcela_ACavar != null)
			return parcela_ACavar;
		else {
			System.err.println("ERROR en Contexto! No hay parcela para cavar elegida.");
			TerrenoArenoso terrenoNulo = new TerrenoArenoso(1);
			Parcela unaParcela = new Parcela(0 ,terrenoNulo , 0, 0, this);
			return unaParcela;
		}
	}

	public void setParcela_ACavar(Parcela parcela_ACavar) {
		this.parcela_ACavar = parcela_ACavar;
	}

	public Rig getRigElegidoParaCavar() {
		return rigElegido;
	}

	public void elegirRigParaCavar(Rig rigElegido) {
		this.rigElegido = rigElegido;
	}
	
	public int getCapacityToExtract(){
		int globalCapacity = 0;
		
		for(Planta planta : this.getPlantas()){
			globalCapacity += planta.getCapacidadDeProcesamientoRestante();
		}
				
		return globalCapacity;
	}
	
	public void Extract(Pozo pozo, double volumen){
		pozo.extraer();
		for(Planta planta: this.getPlantas()){
	
			if(volumen>0){
				
				if(planta.getCapacidadDeProcesamientoRestante() >= volumen){
					planta.procesar(volumen);
					break;
				}
				else{
					volumen -= planta.getCapacidadDeProcesamientoRestante();
					planta.procesar(planta.getCapacidadDeProcesamientoRestante());
			
				}				
				
			}
						
		}
	
	}
}

