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
	private Map<Integer, Integer> presionInicialDeParcelas;
	private Map<Integer,Integer> tipoDeParcelas;
	private Map<Integer,Integer>	 profundidaDeParcelas;
		
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
			 * 4 	// 5 cantidad máxima de RIGS 
			 * 3000 // 6 volumen de Yacimiento
			 * 1	 2 1000// Presion inicial de boca de poso de la primer Parcela 1, tipo de Parcela de la parcela 1, profundidad(en metros)
			 *	"""
			 *	"""
			 *	"""
			 *	"""
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
			System.out.println(presionInicialDeParcelas);
			System.out.println(tipoDeParcelas);
			System.out.println(profundidaDeParcelas);
			
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

	public List<Criterio> getCriterios(){
		return new ArrayList<Criterio>();
	}
	
	public int getLimitDaysQuantity(){
		return limitDayQuantity;
	}
	
	
}
