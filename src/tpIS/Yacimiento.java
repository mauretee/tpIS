package tpIS;
//import java.util.Collection;
import java.util.List;

public class Yacimiento {
	private int volumen;
	private Composicion composicion;
	List<Parcela> listaDeParcelas;
	public Yacimiento(int volumen, Composicion composicion,List<Parcela> listaDeParcelas){
		this.volumen = volumen;
		this.composicion = composicion;
		this.listaDeParcelas = listaDeParcelas;
	}
	public int getVolumen() {
		return volumen;
	}
	public Composicion getComposicion() {
		return composicion;
	}

}
