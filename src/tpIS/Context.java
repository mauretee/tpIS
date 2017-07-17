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
	private List<Tanque> _tanquesAgua;	
	private List<Tanque> _tanquesGas;
	private List<ContextObserver> Observadores;
	//private Parcela parcela_ACavar;
	private Rig rigElegido;
	private double volumenExtraido;
	
	public Context(){
			
		this._actualDay = 0;
		this._continue = true;		
		Observadores = new ArrayList<ContextObserver>();
		rigsAlquilados = new ArrayList<Rig>();
		_plantas = new ArrayList<Planta>();
		_tanquesAgua = new ArrayList<Tanque> ();
		_tanquesGas = new ArrayList<Tanque> ();
		//TerrenoArenoso terrenoNulo = new TerrenoArenoso(1);
		//Parcela unaParcela = new Parcela(0 ,terrenoNulo , 0, 0);
		
		//parcela_ACavar = unaParcela;
		
	}
	
	public int GetDay(){
		return this._actualDay;		
	}
	
	public void FinishDay(){		
		this._actualDay+=1;
		for (ContextObserver observer : Observadores) 
	         observer.updateDay();
		
		actualizarRigs();		
		this._lastEventToLog= "";
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
	
	public void addVolumenExtraido(double volumen){
		this.volumenExtraido+=volumen;
		System.out.println(volumenExtraido);
	}
	
	public double getVolumenExtraido(){
		return this.volumenExtraido;
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
	
	public List<Tanque> getTanquesDeAgua(){	
		return this._tanquesAgua;
	}
	
	public List<Tanque> getTanquesDeGas(){
		return this._tanquesGas;
	}
		
	
	public void attach(ContextObserver observer){
		Observadores.add(observer);		
	}
	
	public void attachPlanta(Planta unaPlanta) {
		this._plantas.add(unaPlanta);
	}
	
	public void attachTanqueAgua(Tanque unTanque) {
		_tanquesAgua.add(unTanque);
	}
	
	public void attachTanqueGas(Tanque unTanque) {
		_tanquesGas.add(unTanque);
	}

/*	public Parcela getParcela_ACavar() {
		if(parcela_ACavar != null)
			return parcela_ACavar;
		else {
			System.err.println("ERROR en Contexto! No hay parcela para cavar elegida.");
			TerrenoArenoso terrenoNulo = new TerrenoArenoso(1);
			Parcela unaParcela = new Parcela(0 ,terrenoNulo , 0, 0);
			return unaParcela;
		}
	}*/

	/*public void setParcela_ACavar(Parcela parcela_ACavar) {
		this.parcela_ACavar = parcela_ACavar;
	}*/

	public Rig getRigElegidoParaCavar() {
		return rigElegido;
	}

	public void elegirRigParaCavar(Rig rigElegido) {
		 this.rigElegido = rigElegido;
	}
	
	public int getCapacityToExtract(){
		int globalCapacity = 0;
		
		for(Planta planta : this.getPlantas()){
			if(!planta.plantaEnConstruccion()){
				globalCapacity += planta.getCapacidadDeProcesamientoRestante();	
			}
			
		}
				
		return globalCapacity;
	}
	
	/*
	 * Porq el contexto decide de q pozo extraer??
	 * Ni se fija si el pozo esta abierto o en reinyeccion.
	 */
	
	public void SalePetroleo(double volumen){
		this.volumenExtraido -= volumen;
		System.out.println(volumenExtraido);
	}
	
	public void Extract(Pozo pozo, double volumen, Yacimiento yacimiento){
		
		pozo.extraer();
		double realVolumenToExtract = this.CalculateRealVolumenToExtract(volumen);
		
		for(Planta planta: this.getPlantas()){
	
			if(realVolumenToExtract>0 && !planta.plantaEnConstruccion()){

	
				if(planta.getCapacidadDeProcesamientoRestante() >= volumen ){
					planta.procesar(volumen);

					//agregar volumen de petroleo extraido y almacenar agua y gas
					this.addVolumenExtraido(volumen * yacimiento.getComposicion().getPetroleo()/100);

					this.addExtractProduct(volumen * yacimiento.getComposicion().getGas()/100, this.getTanquesDeGas());
					
					this.addExtractProduct(volumen * yacimiento.getComposicion().getAgua()/100, this.getTanquesDeAgua());
					break;
				}
				else{
					realVolumenToExtract -= planta.getCapacidadDeProcesamientoRestante();

					this.addVolumenExtraido(planta.getCapacidadDeProcesamientoRestante() * yacimiento.getComposicion().getPetroleo()/100);

					this.addExtractProduct(planta.getCapacidadDeProcesamientoRestante() * yacimiento.getComposicion().getGas()/100, this.getTanquesDeGas());
					
					this.addExtractProduct(planta.getCapacidadDeProcesamientoRestante() * yacimiento.getComposicion().getAgua()/100 , this.getTanquesDeAgua());
					
					
					planta.procesar(planta.getCapacidadDeProcesamientoRestante());
					
				}				
				
			}
						
		}
		
			
	}
	
	
	private void addExtractProduct(double vol, List<Tanque> tanks){
		for(Tanque tank: tanks){
			if(vol>0 && tank.estaConstruido()){
				if(tank.getCapacidadAlmacenamientoRestante() >= vol ){
					tank.llenar(vol);
				}
				else{
					vol -= tank.getCapacidadAlmacenamientoRestante();
					tank.llenar(tank.getCapacidadAlmacenamientoRestante());
				}
				
			}
		}
		
		
	}
	
	private double CalculateRealVolumenToExtract(double volumen){
		double result = volumen;		
		double gasStorageCapacity = this.GetStorageCapacity(this.getTanquesDeGas());
		if(gasStorageCapacity < result){
			result = gasStorageCapacity;
		}
		double waterStorageCapacity = this.GetStorageCapacity(this.getTanquesDeAgua());
		if(waterStorageCapacity < result){
			result = waterStorageCapacity;
		}
		
		return result;
	}
	
	
	private double GetStorageCapacity(List<Tanque> tanques){
		double result = 0;
		for(Tanque tanque: tanques){
			result += tanque.getCapacidadAlmacenamientoRestante();
		}
		return result;
	}
}

