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
	//Variables para parcela
	private Map<Integer, Integer> presionInicialDeParcelas;
	private Map<Integer,Integer> tipoDeParcelas;
	private Map<Integer,Integer>	 profundidaDeParcelas;
	//Variables para Rig
	private int cantidadDeModelosDeRigs;
	private Map<Integer, Integer> metrosXDiaRig;
	private Map<Integer,Double> consumoRig;
	private Map<Integer,Double>	 PrecioRig;
	private Map<Integer,Integer> cantidadMinimaDeDiasRig;


	public Reader(){
		BufferedReader br = null;
		FileReader fr = null;
		String fileName = this.path();
		try {

			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			/*
			 * Los tipos de Parcelas son n tipos, es decir son un un numero fijo
			 * estos valores se representan mediante los numero del 0 a n-1.
			 * Estos valores son especificado por nostros, por ejempolo 0 representa el tipo Rocoso, etc.
			 * 
			 */
			
			/*
			 * 5 	// 1 Cantida de Parcelas
			 * 20	// 2 Composicion de Agua numero entre 0 y 100
			 * 30	// 3 Composicin de Gas numero entre 0 y 100
			 * 50 	// 4 Composicin de Petroleo numero entre 0 y 100
			 * 4 	// 5 cantidad maÌ�xima de RIGS 
			 * 3000 // 6 volumen de Yacimiento
			 * 1	 2 1000// Presion inicial de boca de poso de la primer Parcela 1, tipo de Parcela de la parcela 1, profundidad(en metros)
			 *	"""
			 *	"""
			 *	"""
			 *	"""
			 *	5 	//Cantidad de modelos de rigs a ingresar
			 *	20 5 100 8 //Cantidad de metros q cava por dia el Rig 1, consumo de combustible, precio de alquiler x dia, dias minimos de alquiler
			 *	""""
			 *	""""
			 *	""""
			 *	""""
			 *
			 */
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
			String[] str;
			Integer presionInicial;
			Integer tipoDeParecela;
			Integer profundidadDeParcela;
			for( int i = 0; i < cantidadDeParcelas; ++i){
				Integer j = new Integer(i);
			    str = null;
				String linea = br.readLine();
			    str = linea.split(" ");
			    presionInicial = new Integer(Integer.parseInt(str[0]));
			    tipoDeParecela = new Integer(Integer.parseInt(str[1]));
				profundidadDeParcela = new Integer(Integer.parseInt(str[2]));
			    presionInicialDeParcelas.put(j, presionInicial);
			    tipoDeParcelas.put(j,tipoDeParecela);
			    profundidaDeParcelas.put(j,profundidadDeParcela);
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
	
	/*
	public List<Parcela> getParcelas(){
		List<Parcela> result = new ArrayList<Parcela>();
		
		for( int i = 0; i < cantidadDeParcelas; ++i){
			Parcela parcela  = new Parcela(profundidaDeParcelas.get(i),
					new TerrenoRocoso(80), presionInicialDeParcelas.get(i));
			result.add(parcela);
		}
				
		return result;
	}
	*/
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
	
	/*
	
	public List<Rig> getRigs(){
		List<Rig> result = new ArrayList<Rig>();
		for( int i = 0; i < cantidadDeModelosDeRigs; ++i){
			Rig rig  = new Rig(metrosXDiaRig.get(i), consumoRig.get(i));
			result.add(rig);
		}
		//result.add(new Rig(55, 100000));
				
		return result;
	}
	*/
	/*
	public Yacimiento getYacimiento(){
		int volumen = this.getVolumenYacimiento();
		Composicion composition = this.getComposicion();			
		List<Parcela> parcelas = this.getParcelas();
		Yacimiento result= new Yacimiento(volumen,composition,parcelas);			
		return result;
	}
	*/

	
	public int getLimitDaysQuantity(){
		return this.limitDayQuantity;
	}

	/*
	public Presupuesto getPresupuesto(){
		return new Presupuesto();
	}
	*/
	
	/*
	public EstadoFinanciero getEstadoFinanciero(){
		//FIX ME! READ THE INITIAL STATUS FROM FILE
		return new EstadoFinanciero(10000);
	}
	*/
	
}
