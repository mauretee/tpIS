package tpIS;

public class Rig extends ContextObserver {
	private int diasAlquilado=1;
	private ModeloRig modelo;
	
	private boolean cavando = false;
	
	public Rig(ModeloRig Modelo, Context unContexto) {
		super(unContexto);
		modelo = Modelo;
	}
	
	public void cavarPozoEnParcela(Parcela unaParcela) {
		if(!cavando) {
			cavando = true;
			unaParcela.cavar(modelo.getVelocidadDeCavadoXDia()/((modelo.getVelocidadDeCavadoXDia()*unaParcela.getTipoDeTerreno().resistenciaAlRig())/100));
		}
		else 
			System.err.println("Un Rig no puede cavar en mas de un pozo a la ves");
	}

	public boolean isCavando() {
		return cavando;
	}
	
	public void updateDay() {
		cavando = false;
		diasAlquilado++;
	}
	
	public ModeloRig getModelo() {
		return modelo;
	}
	
}
