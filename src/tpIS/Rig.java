package tpIS;

public class Rig {
	private int velocidadDeCavadoXDia = 1;
	private double consumCombustibleXDia = 1;
	private int metrosCavados = 0;
	private boolean cavando = false;
	private Parcela parcelaATrabajar;
	
	public Rig(int VelocidadDeCavadoXDIA, double ConsumoDeCombustibleXDIA) {
		velocidadDeCavadoXDia = VelocidadDeCavadoXDIA;
		consumCombustibleXDia = ConsumoDeCombustibleXDIA;
	}
	
	public void cavarPozoEnParcela(Parcela unaParcela) {
		if(!cavando) {
			cavando = true;
			parcelaATrabajar = unaParcela;
			seguirCavando();
		}
		else 
			System.err.println("Un Rig no puede cavar en mas de un pozo a la ves");
	}
	
	public void seguirCavando() {
		if(cavando) {
			if(metrosCavados < parcelaATrabajar.getProfundidad()) {
				metrosCavados += (velocidadDeCavadoXDia*parcelaATrabajar.getTipoDeTerreno().tipoDeTerreno())/100;
			}
			else {
				parcelaATrabajar.crearPoso();
				metrosCavados =0;
				cavando = false;
				parcelaATrabajar = null;
			}
		}
		else
			System.err.println("Este Rig no esta asignado a ningun pozo.");
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
