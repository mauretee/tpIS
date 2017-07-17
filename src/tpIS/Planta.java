package tpIS;

public class Planta extends ContextObserver {
	private int diasDeConstruccionActual;
	private double cantidadProcesamientoRestante;
	private ModeloPlanta modelo;
	
	public Planta(ModeloPlanta unModelo, Context unContexto) {
		super(unContexto);
		modelo = unModelo;
		diasDeConstruccionActual = 0;
		cantidadProcesamientoRestante = unModelo.getPoderProcesamientoDia();
		unContexto.attachPlanta(this);
	}
	
	private void construirUnDia() {
		if(plantaEnConstruccion())
			diasDeConstruccionActual++;
		else
			System.err.println("Esta planta no esta en construccion.");
		
	}
	
	public boolean plantaEnConstruccion() {
		return diasDeConstruccionActual < modelo.getDiasDeConstruccionTotal();
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
	
	public double getCapacidadDeProcesamientoRestante() {
		return cantidadProcesamientoRestante;
	}
	
	public void updateDay() {
		if(plantaEnConstruccion()){
			construirUnDia();
		}
		else{
			cantidadProcesamientoRestante = this.modelo.getPoderProcesamientoDia();
		}
			
	}

	public ModeloPlanta getModelo() {
		return modelo;
	}
}
