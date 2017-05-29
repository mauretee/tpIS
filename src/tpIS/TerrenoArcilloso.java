package tpIS;

public class TerrenoArcilloso implements Terreno {
	private int resistencia = 0;
	
	public TerrenoArcilloso(int resistenciaDelTerreno) {
		resistencia = resistenciaDelTerreno;
	}
	
	@Override
	public int tipoDeTerreno(){
        System.out.println("Arcilloso");
        return 1;
	}
	
	@Override
	public int resistenciaAlRig() {
		return resistencia;
	}

}
