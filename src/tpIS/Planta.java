package tpIS;

public class Planta extends ContextObserver {
	private int diasDeConstruccionActual;
	private int diasDeConstruccionTotal; //estaria bueno q fuera unsigned int
	private double poderProcesamientoDia;
	private double cantidadProcesamientoRestante;
	
	public Planta(int diasQueTardaEnConstruirse, double capacidadDeProsesamientoXDia, Context unContexto) {
		super(unContexto);
		diasDeConstruccionTotal = diasQueTardaEnConstruirse;
		diasDeConstruccionActual = 0;
		poderProcesamientoDia = capacidadDeProsesamientoXDia;
		cantidadProcesamientoRestante = poderProcesamientoDia;
	}
	
	private void construirUnDia() {
		if(plantaEnConstruccion())
			diasDeConstruccionActual++;
		else
			System.err.println("Esta planta no esta en construccion.");
		
	}
	
	public boolean plantaEnConstruccion() {
		return diasDeConstruccionActual < diasDeConstruccionTotal;
	}
	
	public void procesar(double cantidadProcesamiento) {
		if(!plantaEnConstruccion()) {
			if(cantidadProcesamientoRestante >= cantidadProcesamiento)
				cantidadProcesamientoRestante -= cantidadProcesamiento;
			else
				System.err.println("No hay sufucuente capacidad de procesamiento para procesar dicha cantidad");
		}
		else
			System.err.println("La planta no esta construida aun");
	}
	
	public double getCapacidadDeProcesamiento() {
		return poderProcesamientoDia;
	}
	
	public double getCapacidadDeProcesamientoRestante() {
		return cantidadProcesamientoRestante;
	}
	
	public void updateDay() {
		if(plantaEnConstruccion())
			construirUnDia();
	}
}
