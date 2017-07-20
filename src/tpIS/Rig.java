package tpIS;

public class Rig extends ContextObserver {
	private int diasAlquilado=1;
	private int diasUsado;
	private ModeloRig modelo;
	
	private boolean cavando = false;
	
	public Rig(ModeloRig Modelo, Context unContexto, int cantidadDeDiasDeAlquiler) {
		super(unContexto);
		modelo = Modelo;
		diasUsado = 1;
		diasAlquilado = cantidadDeDiasDeAlquiler;
	}
	
	public void cavarPozoEnParcela(Parcela unaParcela) {
		if(!cavando) {
			this.actualizarEstadoCavando(true);
			unaParcela.cavar(modelo.getVelocidadDeCavadoXDia()/((modelo.getVelocidadDeCavadoXDia()*unaParcela.getTipoDeTerreno().resistenciaAlRig())/100));
		}
		else 
			System.err.println("Un Rig no puede cavar en mas de un pozo a la ves");
	}

	private void actualizarEstadoCavando(boolean isCavando){
		this.cavando = isCavando;
	}
	
	public boolean isCavando() {
		return cavando;
	}
	
	public void updateDay() {
		cavando = false;
		diasUsado++;
	}
	
	public ModeloRig getModelo() {
		return modelo;
	}
	
	public int getLimiteDeDiasEnAlquiler() {
		return diasAlquilado;
	}
	
	public int getDiasQueLlevaAlquilado() {
		return diasUsado;
	}
	
}
