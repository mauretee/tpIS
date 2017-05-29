package tpIS;
//import Reader;

public class Run {

	public static void main(String[] args) {	
		Reader _reader = new Reader(); // MAURO ESTE CAMBIO Q HICISTE NO PARECE Q FUNCIONE!
		Simulacion simulation = new Simulacion(_reader);
		simulation.Simular();
	}

}
