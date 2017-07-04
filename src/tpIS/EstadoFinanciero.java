package tpIS;

public class EstadoFinanciero {

	private double _accountStatus;
	
	public EstadoFinanciero(double initialAccountStatus){
		this._accountStatus = 100000;//initialAccountStatus;
	}
	
	public void acredit(double credit){
		
		this._accountStatus += credit;
	}
	
	public void debit(double debit){
		this._accountStatus -= debit;
	}
	
	public double getStatus(){
		return this._accountStatus;
	}
	
}
