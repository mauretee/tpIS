package tpIS;

import java.util.List;

public abstract class Equipo {

	public Yacimiento _yacimiento;
	public Presupuesto _presupuesto;
	public EstadoFinanciero _estadoFinanciero;
	//public Reader _reader;
	
	public abstract List<Closure> Evaluate(Context context);

}
