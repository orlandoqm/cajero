package Modelo;

public class Atm {
	
private double cantidadBillete50;
private double cantidadBillete100;
private double cantidadBillete200;
private double cantidadBillete500;

private double saldoTotalATM;

public double getCantidadBillete50() {
	return cantidadBillete50;
}
public void setCantidadBillete50(double cantidadBillete50) {
	
	this.cantidadBillete50 = (cantidadBillete50*50);
}

public double getCantidadBillete100() {
	return cantidadBillete100;
}
public void setCantidadBillete100(double cantidadBillete100) {
	this.cantidadBillete100 = (cantidadBillete100*100);
}

public double getCantidadBillete200() {
	return cantidadBillete200;
}
public void setCantidadBillete200(double cantidadBillete200) {
	this.cantidadBillete200 = (cantidadBillete200*200);
}
public double getCantidadBillete500() {
	return cantidadBillete500;
}
public void setCantidadBillete500(double cantidadBillete500) {
	this.cantidadBillete500 = (cantidadBillete500*500);
}
public double getSaldoTotalATM() {
	return saldoTotalATM;
}
public void setSaldoTotalATM() {
	
saldoTotalATM=cantidadBillete50+cantidadBillete100+cantidadBillete200+cantidadBillete500;
	
	this.saldoTotalATM = saldoTotalATM;
}

@Override
public String toString() {
	
	return "El Atm  cuenta con :"
              
            +"[\ncantidadBillete50=" + cantidadBillete50 + ", \ncantidadBillete100=" + cantidadBillete100
			+ ",\n cantidadBillete200=" + cantidadBillete200 + ",\n cantidadBillete500=" + cantidadBillete500
			+ " \n y su saldo Total ATM: "+saldoTotalATM+ "]";
}





}


