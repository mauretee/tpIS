package tpIS;

import java.util.List;

public abstract class Equipo {

	public Yacimiento _yacimiento;
	public Presupuesto _presupuesto;
	public Catalogo unCatalogo;
	public EstadoFinanciero _estadoFinanciero;	
	public Reader _reader;
	
	public abstract List<Closure> Evaluate(Context context);
	
	
	public Catalogo getCatalogo(){
		return this.unCatalogo;		
	}
	
	
	public Presupuesto getPresupuesto(){
		return this._presupuesto;		
	}
	
	public EstadoFinanciero getEstadoFinanciero(){
		return this._estadoFinanciero;		
	}
	
	
	public Yacimiento getYacimiento(){
		return this._yacimiento;		
	}
	
	public double getAlpha1() {
		return _reader.getAlfa1();
	}
	public double getAlpha2() {
		return _reader.getAlfa2();
	}

}
