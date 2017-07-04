package tpIS;

import java.util.ArrayList;
import java.util.List;
//
public class EquipoIngenieria extends Equipo{
	
		
	public EquipoIngenieria(Reader reader){
		this._reader = reader;		
		this._yacimiento = reader.getYacimiento();
		this._presupuesto = reader.getPresupuesto();
		this._estadoFinanciero = reader.getEstadoFinanciero();	
		unCatalogoDeRigs = reader.getCatalogoDeRigs();
		
		//TODO ITERACION 1 HARCODEADA
		criteriosDeParada = new CriterioParadaPorDia(this);
		criteriosDePerforacionDeParcela = new CriterioDePerforacionEnTodaParcela(this);
		criteriosDeSeleccionDeRigs = new CriterioEleccionDeRigsxMasBarato(this);
	}
	
	@Override
	public List<Closure> Evaluate(Context context){
		
		List<Closure> actions = new ArrayList<Closure>(); 		
		return actions; 
	}
	
	public EstadoFinanciero getEstadoFinanciero(){
		return this._estadoFinanciero;		
	}
	
}
