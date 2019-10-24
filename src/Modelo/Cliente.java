package Modelo;

public class Cliente {

	private long numeroCuenta;
	private String propietario;
	private String apellidos;
	private int nip;
	private double saldo;
	



	public long getNumeroCuenta() {
		return numeroCuenta;
	}


	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}


	public String getPropietario() {
		return propietario;
	}


	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getNip() {
		return nip;
	}


	public void setNip(int nip) {
		this.nip = nip;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	@Override
	public String toString() {
		return "\nCliente: "
				+ "\nNumero de cuenta=" + numeroCuenta 
				+ " \nPropietario:" + propietario 
				+ "\nApellidos:" + apellidos
				+ " \nNip=" + nip 
				+ "\nSaldo= $ " + saldo ;
	}
	
	
	
	
	
}
