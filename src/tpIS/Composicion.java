package tpIS;

public class Composicion {
	private int agua;
	private int petroleo;
	private int gas;
	public Composicion(int agua,int petroleo, int gas){
		this.agua = agua;
		this.petroleo = petroleo;
		this.gas = gas;
	}
	
	public int getAgua() {
		return agua;
	}
	public int getPetroleo() {
		return petroleo;
	}

	public int getGas() {
		return gas;
	}

}
