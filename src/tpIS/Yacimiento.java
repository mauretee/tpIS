package tpIS;
//import java.util.Collection;
import java.util.List;

public class Yacimiento extends ContextObserver {
	private double volumenInicial;
	private double volumenActual;
	private Composicion composicion;
	List<Parcela> listaDeParcelas;
	private int cantidadDePozosCavados;
	
	public Yacimiento(double volumen, Composicion composicion,List<Parcela> listaDeParcelas, Context unContexto){
		super(unContexto);
		this.volumenInicial = volumen;
		this.composicion = composicion;
		this.listaDeParcelas = listaDeParcelas;
		volumenActual = volumen;
		cantidadDePozosCavados = 0;
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
	public int getCantidadDePozosCavados() {
		return cantidadDePozosCavados;
	}
	/*public void addNewPozo() {
		cantidadDePozosCavados++;
	}*/
	
	public void updateDay() {
		for(Parcela unaParcela :listaDeParcelas) {
			unaParcela.updatePresionPozo(volumenInicial, volumenActual);
		}
	}

}
