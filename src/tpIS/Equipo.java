package tpIS;

import java.util.List;

public abstract class Equipo {

	public Yacimiento _yacimiento;
	public Presupuesto _presupuesto;
	public CatalogoDeRigs unCatalogoDeRigs;
	public EstadoFinanciero _estadoFinanciero;
	public Criterio criteriosDeSeleccionDeRigs;
	public Criterio criteriosDePerforacionDeParcela;
	public Criterio criteriosDeParada;
	public Reader _reader;
	
	public abstract List<Closure> Evaluate(Context context);

}
