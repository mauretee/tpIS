package tpIS;
//import java.util.Collection;
import java.util.List;

public class Yacimiento extends ContextObserver {
	private double volumenInicial;
	private double volumenActual;
	private Composicion composicion;
	List<Parcela> listaDeParcelas;
	
	public Yacimiento(double volumen, Composicion composicion,List<Parcela> listaDeParcelas, Context unContexto){
		super(unContexto);
		this.volumenInicial = volumen;
		this.composicion = composicion;
		this.listaDeParcelas = listaDeParcelas;
		volumenActual = volumen;
	}
	public double getVolumen() {
		return volumenActual;
	}
	public Composicion getComposicion() {
		return composicion;
	}
	public List<Parcela> getListaDeParcelas() {
		return listaDeParcelas;
	}
	
	public void extraerDelReservorio(double volumenAgua, double volumenPetroleo, double volumenGas) {
		//Ver como convertir en porsentajes y cambiar la compisicion.
	}
	
	public void reinyectarEnPozo(Pozo unPozo) {
		
	}
	
	public void updateDay() {
		for(Parcela unaParcela :listaDeParcelas) {
			unaParcela.updatePresionPozo(volumenInicial, volumenActual);
		}
	}

}
