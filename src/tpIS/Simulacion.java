package tpIS;
import java.util.ArrayList;
import java.util.List;
import tpIS.Closure;

public class Simulacion {
	private Composicion _composicion;
	private List<Parcela> _parcelas;
	private Equipo _equipoIngenieria;
	private Yacimiento _yacimiento;
	private Presupuesto _presupuesto;
	private EstadoFinanciero _estadoFinanciero;
	private Context _context;
	private Logger _logger;
	private List<Rig> _listaRigs;
	//private Reader _reader;
	
	public Simulacion(Reader _reader){
		this._composicion = new Composicion(_reader.getComposicionDeAgua(),
				_reader.getComposicionDePetroleo(),_reader.getComposicionDeGas());
		this._parcelas = new ArrayList<Parcela>();
		for( int i = 0; i < _reader.getCantidadDeParcelas(); ++i){
			Parcela parcela  = new Parcela(_reader.getPresionInicialDeParcelas().get(i),
					new TerrenoRocoso(80), _reader.getPresionInicialDeParcelas().get(i), _reader.getResistenciaDeParcelas().get(i));
			this._parcelas.add(parcela);
		}
		
		this._listaRigs = new ArrayList<Rig>();
		List<costoDelRig> costosRigs = new ArrayList<costoDelRig>();
		/*
		 * Creamos la lista de rigs que podemos alquilar, y al mismo tiempo creamos su lista
		 * de precios para poder agregarla al presupuesto (indexado por el mismo orden por ahora)
		 */

		//FIX ME FALTA Q EL READER LEVANTE LOS PRECIOS DE PLANTAS Y TANQUES!
		List<Double> preciosPlantas = new ArrayList<Double>();
		List<Double> preciosTanques = new ArrayList<Double>();
		
		this._yacimiento = new Yacimiento(_reader.getVolumenYacimiento(),_composicion,
				this._parcelas);
		this._presupuesto = new Presupuesto(5, 5, 5, costosRigs, preciosPlantas, preciosTanques);
		this._estadoFinanciero = new EstadoFinanciero(1000); //FIX ME! READ THE INITIAL STATUS FROM FILE
		this._equipoIngenieria = new EquipoIngenieria(_yacimiento,_presupuesto,_estadoFinanciero);
		
		this._context = new Context(this._listaRigs, _reader.getLimitDaysQuantity());  
		
		for( int i = 0; i < _reader.getMaximaCantidadDeRigs(); ++i){
			Rig rig  = new Rig(_reader.getMetrosXDiaRig().get(i), _reader.getConsumoRig().get(i), _context);
			this._listaRigs.add(rig);
			costoDelRig rigCost = new costoDelRig(_reader.getPrecioRig().get(i), _reader.getConsumoRig().get(i), _reader.getCantidadMinimaDeDiasRig().get(i), rig);
			costosRigs.add(rigCost);
		}
		
		this._logger= new Logger();
	}


	public void Simular(){
		while(this._context.Continue()){
			this._logger.Log("Inicia el dia "+ String.valueOf(this._context.GetDay()));
			List<Closure> actions = this._equipoIngenieria.Evaluate(this._context);
			for(Closure action : actions)
			{
				action.Apply(this._context, this._equipoIngenieria);
				this._logger.Log(this._context.GetLastEventsToLog());				
			}
			tareasEnSimulacion();
			/*this._logger.Log("Estado financiero actual: "+
					String.valueOf(this._equipoIngenieria.getEstadoFinanciero().getStatus()));*/
			this._logger.Log("Finaliza el dia "+ String.valueOf(this._context.GetDay()));
			this._context.FinishDay();

		}

	}
	
	private void tareasEnSimulacion() {
		//Seguimos contrullendo los pozos
		/*List<Rig> rigs =_context.getRigs();
		if(!rigs.isEmpty()) {
			for(Rig unRig : _context.getRigs()){
				if(unRig.isCavando())
					unRig.seguirCavando();
			}
		}*/
		//seguimos construllendo los tanques
		List<Tanque> tanques = _context.getTanques();
		if(!tanques.isEmpty()){
			for(Tanque unTanque : tanques){
				if(!unTanque.estaCosntruido())
					unTanque.construirUnDia();
			}
		}
		//Seguimos construllendo plantas
		List<Planta> plantas = _context.getPlantas();
		if(!plantas.isEmpty()){
			for(Planta unaPlanta : plantas){
				if(unaPlanta.plantaEnConstruccion())
					unaPlanta.construirUnDia();
			}
		}
	}
}
