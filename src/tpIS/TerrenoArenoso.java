package tpIS;

public class TerrenoArenoso implements Terreno {
	private int resistencia = 0;
	
	
	public TerrenoArenoso(int resistenciaDelTerreno) {
		resistencia = resistenciaDelTerreno;
	}
	
	@Override
	public int tipoDeTerreno(){
        System.out.println("Arenoso");
        return 1;
	}
	
	@Override
	public int resistenciaAlRig() {
		return resistencia;
	}

}
