package tpIS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Scanner;
import java.util.*;

public class Reader {
	//"/Users/mauro/Desktop/Computacion/IS1/Tp/tpIS/src/tpIS/input.txt"
	private int cantidadDeParcelas;
	private int composicionDeAgua;
	private int composicionDeGas;
	private int composicionDePetroleo;
	private int maximaCantidadDeRigs;
	private int volumenYacimiento;
	private int limitDayQuantity;
	private int limitFinancialStatus;
	//Variables para parcela
	private Map<Integer, Integer> presionInicialDeParcelas;
	private Map<Integer,Integer> tipoDeParcelas;
	private Map<Integer,Integer>	 profundidaDeParcelas;
	private Map<Integer, Integer> resistenciaDeParcelas;
	//Variables para Rig
	private int cantidadDeModelosDeRigs;
	private Map<Integer, Integer> metrosXDiaRig;
	private Map<Integer,Double> consumoRig;
	private Map<Integer,Double>	 PrecioRig;
	private Map<Integer,Integer> cantidadMinimaDeDiasRig;
	//Variable para Pozo
	private int cantidadDePososAConstruir;
	//Variable para Planta
	private int cantidadDePlantas;
	private Map<Integer, Integer> cantidadDeProcesamiento;
	private Map<Integer, Integer> cantidadDeDiasDeConstrucion;
	private Map<Integer, Integer> costoDePlantas;
	//Variable para Tange
	private int cantidaDeModelosDeTanque;
	private Map<Integer, Integer> capacidadDeTanques;
	private Map<Integer, Integer> tipoDeTanques;
	private Map<Integer, Integer> diasDeConstrucionDeTanque;
	private Map<Integer, Integer> costoDeTanques;
	// Precios
	private int precioDeCompraDeAgua;
	private int ventaDePetroleo;
	private int precioCompraConbustibleRigs; 
	private double alfa1;
	private double alfa2;
	private double volumenMaxDeReinyecionDiario;
	private double montoMinimoDeGastos;
	private double presionCritica;
	private double dilucionCritica; // ?
	public Reader(){
		BufferedReader br = null;
		FileReader fr = null;
		String fileName = this.path();
		try {

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String firstLine = br.readLine();
			this.cantidadDeParcelas = Integer.parseInt(firstLine);
			System.out.println(cantidadDeParcelas);
			
			String seconLine = br.readLine(); 
			this.composicionDeAgua = Integer.parseInt(seconLine);
			System.out.println(composicionDeAgua);

			String thirdLine = br.readLine(); 
			this.composicionDeGas =Integer.parseInt(thirdLine);
			System.out.println(composicionDeGas);
			
			String fourLine = br.readLine(); 
			this.composicionDePetroleo = Integer.parseInt(fourLine);
			System.out.println(composicionDePetroleo);
			
			String five = br.readLine(); 
			this.maximaCantidadDeRigs = Integer.parseInt(five);
			System.out.println(maximaCantidadDeRigs);
		
			String six = br.readLine(); 
			this.volumenYacimiento = Integer.parseInt(six);
			System.out.println(volumenYacimiento);
			/*
			 * Leemos los parametros de cada parcela
			 */
			
			presionInicialDeParcelas = new HashMap<Integer, Integer>();
			tipoDeParcelas = new HashMap<Integer, Integer>();
			profundidaDeParcelas = new HashMap<Integer, Integer>();
			resistenciaDeParcelas = new HashMap<Integer, Integer>();
			String[] str;
			Integer presionInicial;
			Integer tipoDeParecela;
			Integer profundidadDeParcela;
			Integer resistenciaDeParcela;
			for( int i = 0; i < cantidadDeParcelas; ++i){
				Integer j = new Integer(i);
			    str = null;
				String linea = br.readLine();
			    str = linea.split(" ");
			    presionInicial = new Integer(Integer.parseInt(str[0]));
			    tipoDeParecela = new Integer(Integer.parseInt(str[1]));
				profundidadDeParcela = new Integer(Integer.parseInt(str[2]));
				resistenciaDeParcela = new Integer(Integer.parseInt(str[3]));
			    presionInicialDeParcelas.put(j, presionInicial);
			    tipoDeParcelas.put(j,tipoDeParecela);
			    profundidaDeParcelas.put(j,profundidadDeParcela);
			    resistenciaDeParcelas.put(j, resistenciaDeParcela);
			}
			String ten = br.readLine(); 
			this.limitDayQuantity = Integer.parseInt(ten);
			
			System.out.println(limitDayQuantity);			
			System.out.println(presionInicialDeParcelas);
			System.out.println(tipoDeParcelas);
			System.out.println(profundidaDeParcelas);
			
			/*
			 * Leemos los parametros de cada RIG
			 */
			
			String rigsCant =  br.readLine(); 
			this.cantidadDeModelosDeRigs = Integer.parseInt(rigsCant);

			metrosXDiaRig = new HashMap<Integer, Integer>();
			cantidadMinimaDeDiasRig = new HashMap<Integer, Integer>();
			consumoRig = new HashMap<Integer, Double>();
			PrecioRig = new HashMap<Integer, Double>();
			String[] Entrada;
			Integer metrosRig;
			Double combustible;
			Double precio;
			Integer minimo;
			for( int i = 0; i < cantidadDeModelosDeRigs; ++i){ 
				Integer indice = new Integer(i);
				Entrada = null;
				String linea = br.readLine();
				Entrada = linea.split(" ");
			    metrosRig = new Integer(Integer.parseInt(Entrada[0]));
			    combustible = new Double(Double.parseDouble(Entrada[1]));
				precio = new Double(Double.parseDouble(Entrada[2]));
				minimo = new Integer(Integer.parseInt(Entrada[3]));
				metrosXDiaRig.put(indice, metrosRig);
				consumoRig.put(indice,combustible);
				PrecioRig.put(indice, precio);
				cantidadMinimaDeDiasRig.put(indice,minimo);	
			}
			String lineaQuince = br.readLine();
			cantidadDePososAConstruir = 	new Integer(Integer.parseInt(lineaQuince));
			String linea = br.readLine();
			cantidadDePlantas = new Integer(Integer.parseInt(linea));

			cantidadDeProcesamiento = new HashMap<Integer, Integer>();
			cantidadDeDiasDeConstrucion = new HashMap<Integer, Integer>();
			costoDePlantas = new HashMap<Integer, Integer>();
			Integer cantidadDeProcesamientoInt;
			Integer cantidadDeDiasDeConstrucionInt;
			Integer costoDePlantasInt;
			cantidadDeProcesamiento = new HashMap<Integer, Integer>();
			cantidadDeDiasDeConstrucion = new HashMap<Integer, Integer>();
			costoDePlantas = new HashMap<Integer, Integer>();
			
			
			for(int i = 0; i < cantidadDePlantas; ++i){
				Integer indice = new Integer(i);
				String line = br.readLine();
				Entrada = line.split(" ");
				cantidadDeProcesamientoInt = new Integer(Integer.parseInt(Entrada[0]));
				cantidadDeDiasDeConstrucionInt = new Integer(Integer.parseInt(Entrada[1]));
				costoDePlantasInt = new Integer(Integer.parseInt(Entrada[2]));
				cantidadDeProcesamiento.put(indice,cantidadDeProcesamientoInt);
				cantidadDeDiasDeConstrucion.put(indice,cantidadDeDiasDeConstrucionInt);
				costoDePlantas.put(indice, costoDePlantasInt);
			}
			/*
			private int cantidaDeModelosDeTanque;
			private Map<Integer, Integer> capacidadDeTanques;
			private Map<Integer, Integer> tipoDeTanques;
			private Map<Integer, Integer> diasDeConstrucionDeTanque;
			private Map<Integer, Integer> costoDeTanques;
			*/
			capacidadDeTanques = new HashMap<Integer, Integer>();
			tipoDeTanques = new HashMap<Integer, Integer>();
			diasDeConstrucionDeTanque = new HashMap<Integer, Integer>();
			costoDeTanques = new HashMap<Integer, Integer>();
			String lineaVeinte = br.readLine();
			cantidaDeModelosDeTanque = Integer.parseInt(lineaVeinte);
			Integer capacidaDeTanquesInt;
			Integer tipoDeTanquesInt;
			Integer diasDeConstrucionDeTanqueInt;
			Integer costoDeTanquesInt;
			
			capacidadDeTanques = new HashMap<Integer, Integer>();
			tipoDeTanques = new HashMap<Integer, Integer>();
			diasDeConstrucionDeTanque = new HashMap<Integer, Integer>();
			costoDeTanques = new HashMap<Integer, Integer>();
			
			for(int i = 0; i < cantidaDeModelosDeTanque; ++i){
				Integer indice = new Integer(i);
				String line = br.readLine();
				Entrada = line.split(" ");
				capacidaDeTanquesInt = new Integer(Integer.parseInt(Entrada[0]));
				tipoDeTanquesInt = new Integer(Integer.parseInt(Entrada[1]));
				diasDeConstrucionDeTanqueInt = new Integer(Integer.parseInt(Entrada[2]));
				costoDeTanquesInt = new Integer(Integer.parseInt(Entrada[3]));
				capacidadDeTanques.put(indice, capacidaDeTanquesInt);
				tipoDeTanques.put(indice, tipoDeTanquesInt);
				diasDeConstrucionDeTanque.put(indice, diasDeConstrucionDeTanqueInt);
				costoDeTanques.put(indice, costoDeTanquesInt);
			}
			
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		 
	}
	

	public  String path(){
		System.out.println("Ingresar el path del archivos:");
		
		Scanner scanner = new Scanner(System.in);
		
		// Ingreso del path donde esta el archivo que tengo que leer
		String pathOfFileInput = scanner.nextLine();
		
		scanner.close();
		return pathOfFileInput;
	}
	
	public int getCantidadDeParcelas() {
		return cantidadDeParcelas;
	}

	public int getComposicionDeAgua() {
		return composicionDeAgua;
	}

	public int getComposicionDeGas() {
		return composicionDeGas;
	}

	public int getComposicionDePetroleo() {
		return composicionDePetroleo;
	}

	public int getMaximaCantidadDeRigs() {
		return maximaCantidadDeRigs;
	}
	public int getVolumenYacimiento() {
		return volumenYacimiento;
	}
	
	public Map<Integer, Integer> getPresionInicialDeParcelas(){
		return presionInicialDeParcelas;
	}

	public Map<Integer, Integer> getTipoDeParcelas(){
		return tipoDeParcelas;
	}
	
	public Map<Integer, Integer> getProfundidaDeParcelas(){
		return profundidaDeParcelas;
	}
	
	public Map<Integer, Integer> getResistenciaDeParcelas(){
		return resistenciaDeParcelas;
	}
	
	public int getCantidadDeModelosDeRigs(){
		return this.cantidadDeModelosDeRigs;
	}
	
	public Map<Integer, Integer> getMetrosXDiaRig(){
		return this.metrosXDiaRig;
	}
	public Map<Integer, Double> getConsumoRig(){
		return this.consumoRig;
	}
	
	public Map<Integer, Double> getPrecioRig() {
		return PrecioRig;
	}
	
	public Map<Integer, Integer> getCantidadMinimaDeDiasRig() {
		return cantidadMinimaDeDiasRig;
	}
	
	public int getLimitDaysQuantity(){
		return this.limitDayQuantity;
	}

	public int getLimitFinancialStatus(){
		return this.limitFinancialStatus;
	}
	
	public int getCantidadDePososAConstruir(){
		return cantidadDePososAConstruir;
	}
	
	public int getPrecioDeCompraDeAgua(){
		return precioDeCompraDeAgua;
	}
	
	public int getVentaDePetroleo(){
		return ventaDePetroleo;
	}
	public int getPrecioCompraConbustibleRigs(){
		return precioCompraConbustibleRigs;
	}
	public double getAlfa1(){
		return alfa1;
	}
	public double getAlfa2(){
		return alfa2;
	}

	public double getVolumenMaxDeReinyecionDiario(){
		return volumenMaxDeReinyecionDiario;
	}
	public double getMontoMinimoDeGastos(){
		return montoMinimoDeGastos;
	}
	public double getPresionCritica(){
		return presionCritica;
	}
	public double getDilucionCritica(){
		return dilucionCritica;
	}

	public Composicion getComposicion(){
		Composicion result = new Composicion(this.getComposicionDeAgua(),
				this.getComposicionDePetroleo(),this.getComposicionDeGas());
		return result;
	}
	
	
	public List<Parcela> getParcelas(){
		List<Parcela> parcels = new ArrayList<Parcela>();
		for( int i = 0; i < this.getCantidadDeParcelas(); ++i){
			Parcela parcela  = new Parcela(this.getPresionInicialDeParcelas().get(i),
					new TerrenoRocoso(80), this.getPresionInicialDeParcelas().get(i), this.getResistenciaDeParcelas().get(i));
			parcels.add(parcela);
		}
		return parcels;
	}
	
	public Yacimiento getYacimiento(){
		Yacimiento deposit = new Yacimiento(this.getVolumenYacimiento(),this.getComposicion(),
				this.getParcelas());
		
		return deposit;		
	}
	
	public Presupuesto getPresupuesto(){
		Map<Object, Double> costos = new HashMap<Object, Double>();
		Presupuesto budget = new Presupuesto(costos);
		return budget;
	}
	
	public EstadoFinanciero getEstadoFinanciero(){
		return new EstadoFinanciero(1000);
	}
	
	public Equipo getEquipoIngenieria(){
		Equipo result = new EquipoIngenieria(this);
		result = new CriterioParadaPorDia(result);		
		result = new CriterioDeParadaXPerdidaDeCapital(result);
		return result;
	}
	
	
	//FIX ME IMPLEMENTAR LA FUNCION DE CREACION DEL CATALOGO DE RIGS
	public CatalogoDeRigs getCatalogoDeRigs() {
		List<ModeloRig> Modelos = new ArrayList<ModeloRig>();
		//metrosXDiaRig.i
		for(int i = 0; i < this.getCantidadDeModelosDeRigs(); ++i){
			ModeloRig nuevoModelo = new ModeloRig(PrecioRig.get(i),consumoRig.get(i),cantidadMinimaDeDiasRig.get(i),metrosXDiaRig.get(i));
			Modelos.add(nuevoModelo);
		}		
		CatalogoDeRigs catalogo = new CatalogoDeRigs(Modelos);	
		return catalogo;
	}
}