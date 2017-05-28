package tpIS;

public class Rig {
	private int velocidadDeCavadoXDia = 1;
	private double consumCombustibleXDia = 1;
	private int metrosCavados = 0;
	private boolean cavando = false;
	
	public Rig(int VelocidadDeCavadoXDIA, double ConsumoDeCombustibleXDIA) {
		velocidadDeCavadoXDia = VelocidadDeCavadoXDIA;
		consumCombustibleXDia = ConsumoDeCombustibleXDIA;
	}
	
	public void cavarPozoEnParcela(Parcela unaParcela, EstadoFinanciero unEstadoFinanciero) {
		if(!cavando) {
			cavando = true;
			if(metrosCavados < unaParcela.getProfundidad()) {
				metrosCavados += velocidadDeCavadoXDia/ unaParcela.getTipoDeTerreno().tipoDeTerreno();
				unEstadoFinanciero.debit(consumCombustibleXDia);
			}
			else {
				unaParcela.crearPoso();
				metrosCavados =0;
				cavando = false;
			}
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

	public int getMetrosCavados() {
		return metrosCavados;
	}

	public boolean isCavando() {
		return cavando;
	}

	
	
}
