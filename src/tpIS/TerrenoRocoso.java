package tpIS;

public class TerrenoRocoso implements Terreno{
	private int resistencia = 0;
	
	public TerrenoRocoso(int resistenciaDelTerreno) {
		resistencia = resistenciaDelTerreno;
	}
	
	@Override
	public int tipoDeTerreno(){
        System.out.println("Rocoso");
        return 1;
	}
	
	@Override
	public int resistenciaAlRig() {
		return resistencia;
	}
}
 