package tpIS;

public class Rig extends ContextObserver {
	private int velocidadDeCavadoXDia = 1;
	private double consumCombustibleXDia = 1;
	private boolean cavando = false;
	
	public Rig(int VelocidadDeCavadoXDIA, double ConsumoDeCombustibleXDIA, Context unContexto) {
		super(unContexto);
		velocidadDeCavadoXDia = VelocidadDeCavadoXDIA;
		consumCombustibleXDia = ConsumoDeCombustibleXDIA;
	}
	
	public void cavarPozoEnParcela(Parcela unaParcela) {
		if(!cavando) {
			cavando = true;
			unaParcela.cavar(velocidadDeCavadoXDia/((velocidadDeCavadoXDia*unaParcela.getTipoDeTerreno().resistenciaAlRig())/100));
		}
		else 
			System.err.println("Un Rig no puede cavar en mas de un pozo a la ves");
	}

	public int getVelocidadDeCavadoXDia() {
		return velocidadDeCavadoXDia;
	}

	public double getConsumCombustibleXDia() {
		return consumCombustibleXDia;
	}

	public boolean isCavando() {
		return cavando;
	}
	
	public void updateDay() {
		cavando = false;
	}
	
}
