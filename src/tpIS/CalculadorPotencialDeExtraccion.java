package tpIS;

public class CalculadorPotencialDeExtraccion {

	public CalculadorPotencialDeExtraccion(){
		
	}
	
	public double Calculate(double presion, int cantidadPozosAbiertos, double alpha1, double alpha2){
		double num = presion/cantidadPozosAbiertos;
		double potencial = alpha1*num + alpha2*Math.pow(num, 2);
		return potencial;
	}
	
}
