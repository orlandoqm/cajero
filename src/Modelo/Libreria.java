package Modelo;

public class Libreria {
	
static final String mensajeAvisoCuentaSinSaldo="　La cantidad excede a tu saldo!!";
static final String mensajeAvisoATMSinSaldo="　Saldo insuficiente del ATM!!";
static final String montoARetirar="Retirar 1)$100 2)$200 3)$500 4)$1000    5) Otro ";
static final String datosNoCoinciden="　Los datos no coinciden!!"; 
static final String intentaDeNuevo="　Intenta de nuevo!!";
static final String noHayDenominaciones="　No hay ";
static final int numero100=100;
static final int numero200=200;
static final int numero500=500;
static final int numero1000=1000;





public static int getNumero100() {
	return numero100;
}
public static String getIntentadenuevo() {
	return intentaDeNuevo;
}
public static int getNumero200() {
	return numero200;
}
public static int getNumero500() {
	return numero500;
}
public static int getNumero1000() {
	return numero1000;
}


public static String getDatosnocoinciden() {
	return datosNoCoinciden;
}
public static String getMontoaretirar() {
	return montoARetirar;
}
public static String getMensajeavisocuentasinsaldo() {
	return mensajeAvisoCuentaSinSaldo;
}
public static String getMensajeavisoATMsinsaldo() {
	return mensajeAvisoATMSinSaldo;
}



}
