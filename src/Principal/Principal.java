package Principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

import Modelo.Atm;
import Modelo.Cliente;
import Modelo.Libreria;

import Operaciones.OperacionLista;

public class Principal {
	private static LinkedList listaClientes;
	private static double saldoFinalATM;
	private static Atm atm;
	private static Libreria libreria;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			
		
		atm= new Atm();
        OperacionLista op1= new OperacionLista();
        String archivoSaldo="saldoATM.txt";
		 atm =op1.leerSaldoATM(archivoSaldo);// Es para asignar las denominacions y saldo del cajero
		 atm.setSaldoTotalATM();
		 saldoFinalATM=atm.getSaldoTotalATM();
	     atm.setSaldoTotalATM();
	     
	     
		listaClientes= new LinkedList();
		String nombreArchivo="registro.txt";
		agregarClientes(nombreArchivo);
		
		int s=0;
	      
	      while(s!=3){
	    	  
	    	  System.out.println("\n1) RETIRAR       2) CONSULTAR SALDO   3)VER ACTIVIDAD 4) SALIR \n");
	    	  Scanner tec = new Scanner(System.in);
	    	  int i=tec.nextInt();
	    	 
	    	  switch(i){
	          case 1: 
	             retirar(i);// Es el mismo metodo ...
	              break;
	           case 2: 
	        	   retirar(i);//solo que cada valor de i hace
	        	   break;
	           case 3:
	        	  retirar(i);//diferentes operaciones
	        	   break;
	           case 4: 
	        	   s=3;
	    	     break;
	    	     
	    	     default:
	    	    	System.out.println("\n"+libreria.getIntentadenuevo());
	    	    	 
	    	  }
	    	  
	      }	  
	}
	
	
   public static void agregarClientes(String archivo) {
	   
	   OperacionLista ol = new OperacionLista();
	   
	   listaClientes= ol.leerAgregar(archivo, listaClientes);//Lee el archivo plano y agrega
	  }
  
   public static void retirar(int i) {
      OperacionLista op= new OperacionLista();
	  
	  
	   long entradaCuenta;
	   int entradaNip;
	   //-----preuba contraseña
	  // entradaNip=new String();
	   //--------
	   
	   Scanner sc = new Scanner(System.in);
	      System.out.print("Numero de cuenta: ");
	   entradaCuenta=sc.nextLong();
	
	   System.out.print("NIP: ");
	   entradaNip= sc.nextInt();
	   
	   int posicionBuscado=op.buscaCuenta(listaClientes, entradaCuenta, entradaNip);
	   if(posicionBuscado!=-1) {
		 if(i== 1) {
		   System.out.print("\n\t***REtirar en ecfectivo***\n");  
		  retirarEfectivo(posicionBuscado);
	   }else { 
		   if(i==2) {
		  System.out.print("\n\t***CONSULTA***\n");  
		  consultarSaldo(posicionBuscado); 
		   
	   }else if (i==3){
		  System.out.print("\n\t***ACTIVIDADES***\n"); 
		   verActividades(posicionBuscado);
		    
	   }
	     }
	   
	  }else {
	  System.out.println("\n"+libreria.getDatosnocoinciden());
		  
	  }
	    }
   
   public static void retirarEfectivo(int posicionCliente) {
	   OperacionLista ol;
	   Date fecha= new Date();
	   Cliente cliente= (Cliente)listaClientes.get(posicionCliente);
	   System.out.println("\t\t:::Bienvenido:::");
	   System.out.println("¿Su nombre es "+cliente.getPropietario()+" "+cliente.getApellidos());
	   System.out.println("\n1) Aceptar    2) Rechazar\n");
	
	   Scanner sc = new Scanner(System.in);
	   int opcion =sc.nextInt();
	  if(opcion==1) {
	  
		 
		   ol= new OperacionLista();
		  System.out.println(libreria.getMontoaretirar());
		  int opc =sc.nextInt();
		 double saldoFinal;
		   switch(opc) {
		   
		   case 1:
			  if(saldoFinalATM>=libreria.getNumero100() ) {
				 
				  if(cliente.getSaldo()>=libreria.getNumero100()) {
					 
					  saldoFinal= cliente.getSaldo()-libreria.getNumero100();
		cliente.setSaldo(saldoFinal); 
		ol.cuentaBilletes(atm, libreria.getNumero100());//se le pasa ek Atm(saldo) y la candidad que el cliente va a retirar
		       
		ol.registrarActividades(cliente.getNumeroCuenta(), cliente.getPropietario(),"Retiro", libreria.getNumero100(), fecha.toLocaleString());
				  }else {
		    	   
		    	 System.out.println(libreria.getMensajeavisocuentasinsaldo());
				   
				  }
				 }else {
				  
				  System.out.println(libreria.getMensajeavisoATMsinsaldo());
			  }
				break;
			   
		   case 2: 
			    if(saldoFinalATM>libreria.getNumero200() ) {
					  if(cliente.getSaldo()>=libreria.getNumero200()) {
						  saldoFinal= cliente.getSaldo()-libreria.getNumero200();
			cliente.setSaldo(saldoFinal); 
			ol.cuentaBilletes(atm, libreria.getNumero200());//se le pasa ek Atm(saldo) y la candidad que el cliente va a ret...
			ol.registrarActividades(cliente.getNumeroCuenta(), cliente.getPropietario(),"Retiro", libreria.getNumero200(), fecha.toLocaleString());
			
					  }else {

						  System.out.println(libreria.getMensajeavisocuentasinsaldo());
					 }
				  }else {
					  
					  System.out.println(libreria.getMensajeavisoATMsinsaldo());
				  }
			   break;
		   case 3:
			   if(saldoFinalATM>libreria.getNumero500() ) {
					  if(cliente.getSaldo()>=libreria.getNumero500()) {
						  saldoFinal= cliente.getSaldo()-libreria.getNumero500();
			cliente.setSaldo(saldoFinal); 
			ol.cuentaBilletes(atm, libreria.getNumero500());//se le pasa ek Atm(saldo) y la candidad que el cliente va a ret...
			ol.registrarActividades(cliente.getNumeroCuenta(), cliente.getPropietario(),"Retiro", libreria.getNumero500(), fecha.toLocaleString());
			
				  }else {

						  System.out.println(libreria.getMensajeavisocuentasinsaldo());
				  }
					    
				  }else {
					  
					  System.out.println(libreria.getMensajeavisoATMsinsaldo());
				  }
					   break;
		  case 4: 
			  
			  if(saldoFinalATM>libreria.getNumero1000() ) {
				  if(cliente.getSaldo()>=libreria.getNumero1000()) {
					  saldoFinal= cliente.getSaldo()-libreria.getNumero1000();
		cliente.setSaldo(saldoFinal); 
		ol.cuentaBilletes(atm, libreria.getNumero1000());//se le pasa ek Atm(saldo) y la candidad que el cliente va a ret...
		ol.registrarActividades(cliente.getNumeroCuenta(), cliente.getPropietario(),"Retiro", libreria.getNumero1000(), fecha.toLocaleString());
		
				  }else {

					  System.out.println(libreria.getMensajeavisocuentasinsaldo());
			  }
				    
			  }else {
				  
				  System.out.println(libreria.getMensajeavisoATMsinsaldo());
			  }
				   break;
			  
	    case 5:
			  
			  System.out.println("Introduzca la cantidad: ");
			   double cantidadARetirar =sc.nextDouble();
			   
			   if(saldoFinalATM>=cantidadARetirar) {
					  if(cliente.getSaldo()>=cantidadARetirar) {
						  
						  cantidadARetirar=(cantidadARetirar/50);
						  cantidadARetirar=(Math.floor(cantidadARetirar)*50);
						  
						  //---------
						 
						  saldoFinal= cliente.getSaldo()-cantidadARetirar;
			cliente.setSaldo(saldoFinal); 
			
			ol.cuentaBilletes(atm, cantidadARetirar);// la cantidad de cada denominacion se retiro
			//este  llamado es para escribir en el archivo plano el movimiendo del cliente
			ol.registrarActividades(cliente.getNumeroCuenta(), cliente.getPropietario(),"Retiro", cantidadARetirar, fecha.toLocaleString());
			
					  }else {
					
						  System.out.println(libreria.getMensajeavisocuentasinsaldo());
					  }
					    
				  }else {
					  
					  System.out.println(libreria.getMensajeavisoATMsinsaldo());
				  } 
			  
			   break;
		   }
		   nuevoRegistro();
		   }else {
			   if(opcion==2) {
				   
			   }else {
				   
				   System.out.println(libreria.getIntentadenuevo());
		   }}
	 
	  }
   
   public static void nuevoRegistro() {
	   
	    String archivo= "registro";
		
		try {
			File file = new File(archivo + ".txt");
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new  OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			//Cliente cl ;				
			for(int i=0;i<listaClientes.size();i++) {
				
				Cliente cl=(Cliente)listaClientes.get(i);
				
				bw.write(cl.getNumeroCuenta()+","+cl.getPropietario()+","+cl.getApellidos()+","+cl.getNip()+
						","+cl.getSaldo());
				bw.newLine();
			}
			
			bw.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
	  }
   
 public static void consultarSaldo(int posicionCliente) {
	 OperacionLista ol= new OperacionLista();
	 Date fecha= new Date();
	   Cliente cliente= (Cliente)listaClientes.get(posicionCliente);
	   System.out.println("\t::::::::Bienvenido:::::::");
	   System.out.println("\t¿Su nombre es "+cliente.getPropietario()+" "+cliente.getApellidos()+" ?");
	   System.out.println("\n1) Aceptar    2) Rechazar\n");
	   
	   Scanner sc = new Scanner(System.in);
	   int opcion =sc.nextInt();
	   if(opcion==1) {
		  // ol= new OperacionLista();
		  System.out.println("Saldo: $"+cliente.getSaldo()
		  +"\nNumero de Cuenta:  "+cliente.getNumeroCuenta()
		  +"\nNombre: "+cliente.getPropietario()+" "+ cliente.getApellidos());
		 ol.registrarActividades(cliente.getNumeroCuenta(), cliente.getPropietario(), "Cosulta", 0.0, fecha.toLocaleString());
			 
	   }
 }
//  
 public static void   verActividades(int posicionCliente) {
	 OperacionLista ol= new OperacionLista();
	 
	   Cliente cliente= (Cliente)listaClientes.get(posicionCliente);
	   System.out.println("\t::::::::Bienvenido:::::::");
	   System.out.println("\t¿Su nombre es "+cliente.getPropietario()+" "+cliente.getApellidos()+" ?");
	   System.out.println("\n1) Aceptar    2) Rechazar\n");
	   
	   Scanner sc = new Scanner(System.in);
	   int opcion =sc.nextInt();
	   if(opcion==1) {
		  ol.imprimirActividades(cliente.getNumeroCuenta(), cliente.getPropietario()); 
	   }
	  
 }
 
   
}
