/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Modelo.Atm;
import Modelo.Cliente;
import Modelo.Libreria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;



/**
 *
 * @author Orlando
 */
public class OperacionLista {
    
   private static Libreria lib;
    public LinkedList leerAgregar(String nombreArchivo, LinkedList listaC)  { 
        String cadenaLeida = ""; 
        
        FileReader fr; 
        try {
            fr = new FileReader(nombreArchivo);
            BufferedReader archivoLectura = new BufferedReader(fr); 
            Cliente cliente;
            
            cadenaLeida = archivoLectura.readLine(); 
            
            while (cadenaLeida != null) { 
            	 //System.out.println("encontro el archivo"); 
            	 
                cliente= new Cliente();
                StringTokenizer st = new StringTokenizer(cadenaLeida,",");
            
                cliente.setNumeroCuenta(Long.parseLong(st.nextToken()));
                cliente.setPropietario(st.nextToken());
                cliente.setApellidos(st.nextToken());
                cliente.setNip(Integer.parseInt(st.nextToken()));
                cliente.setSaldo(Double.parseDouble(st.nextToken()));
             
               
                cadenaLeida = archivoLectura.readLine(); 
                
                 listaC.add(cliente);
            }
            archivoLectura.close(); 
        }
        
        catch (IOException e) {
            System.out.println("No se pudo leer del archivo"); 
            e.printStackTrace(); 
        } 
        return listaC;
    }
    
  
    public Atm leerSaldoATM(String nombreArchivo)  { 
    	
    	String cadenaLeida;
    	FileReader fr;
    	Atm atm= new Atm();;
    	 try {
    		 
             fr = new FileReader(nombreArchivo);
             BufferedReader archivoLectura = new BufferedReader(fr); 
            
             
             cadenaLeida = archivoLectura.readLine(); 
             
             while (cadenaLeida != null) { 
             	 //System.out.println("encontro el archivo"); 
             	 
                
                 StringTokenizer st = new StringTokenizer(cadenaLeida,",");
                 atm.setCantidadBillete50(Double.parseDouble(st.nextToken()));
                 atm.setCantidadBillete100(Double.parseDouble(st.nextToken()));
                 atm.setCantidadBillete200(Double.parseDouble(st.nextToken()));
                 atm.setCantidadBillete500(Double.parseDouble(st.nextToken()));;

                // System.out.println(atm.toString()); 
                
                 cadenaLeida = archivoLectura.readLine(); 
                 
                 // listaC.add(cliente);
             }
             archivoLectura.close(); 
         }
         
         catch (IOException e) {
             System.out.println("No se pudo leer del archivo"); 
             e.printStackTrace(); 
         } 
    	
   return atm ;
    }
    
    
  
    public void imprimirLista (LinkedList lista){
 
        for(int i=0;i<lista.size();i++){ 
            Cliente al = (Cliente) lista.get(i);
          
            System.out.println(al.toString()); 
          
        }
}

    
  

public int buscaCuenta(LinkedList lista, long numeroCuenta,  int nip){ 
   int posicion = -1; 
   
   
   for(int i=0;i<lista.size();i++){ 
	   
     Cliente al = (Cliente) lista.get(i); 
    
    
       if(al.getNumeroCuenta()==numeroCuenta && al.getNip()==nip){// en caso de que los datos coincidad
    	   //regresara su posicion en la lista
    	   
           posicion = i;
          
           break; 
       }else {
    	   
    	   
    	   posicion=-1;
       }
   } return posicion;
}


public void nuevoRegistroATM(Atm atm) {
	   
	   
	   String archivo= "saldoATM";
		
		try {
			File file = new File(archivo + ".txt");
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new  OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			//Cliente cl ;				
			for(int i=0;i<1;i++) {
				Atm atm2=atm;
				
				//Cliente cl=(Cliente)listaClientes.get(i);
				
				bw.write(atm2.getCantidadBillete50()+","+atm2.getCantidadBillete100()+","+atm2.getCantidadBillete200()
				+","+atm2.getCantidadBillete500());
				bw.newLine();
			}
			
			
			bw.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
	
}


//------------------
public void cuentaBilletes(Atm atm,double cantidad) {
	
	int b500=0,b200=0,b100=0,b50=0;
	
	int c1=((int)(atm.getCantidadBillete500()/lib.getNumero500()));//cantidad de billetes en el atm menos la cantidad
	//de bill.. equivalente a la retirada
    int	c2=((int)(atm.getCantidadBillete200()/lib.getNumero200()));
    int c3=((int)(atm.getCantidadBillete100()/lib.getNumero100()));
    int c4=((int)(atm.getCantidadBillete50()/50));
    
	String denominacionesExistentes;
	double modulo=0;
	System.out.println("Denominaciones del retiro:\n");
	//-----------primerra version del algoritmo para:-------------
	if (atm.getCantidadBillete500()>=500) {//Checar la logica adecuada si
		if(cantidad>=500) {
			
			int nec=(int)(cantidad/500);
		
		if(nec>c1) {
		
		b500=c1*lib.getNumero500();//los biletes que hay por la denominacion(500)
		
		System.out.println(c1+" ...........> $"+lib.getNumero500()+" pesos");
		c1=0;
		cantidad= cantidad%b500;
		}else{
			
			b500=nec*lib.getNumero500();//los biletes que hay por la denominacion(500)
			System.out.println(nec+" ...........> $"+lib.getNumero500()+" pesos");
			c1=c1-nec;
			
			cantidad= cantidad%b500;	
			
		}   }
		
		}
		   
	if (atm.getCantidadBillete200()>=200) {
		
		if(cantidad>=200) {
			
			int nec=(int)(cantidad/200);
			
			if(nec>=c2) {
			b200=c2*lib.getNumero200();//los biletes que hay por la denominacion(500)
			//c1=c1-b500;//cantidad de billetes en el atm menos la cantidad
			//de bill.. equivalente a la retirada
			
			System.out.println(c2+" ...........> $"+lib.getNumero200()+" pesos");
			c2=0;
			cantidad= cantidad%b200;
			
			}else {
				
				b200=nec*lib.getNumero200();
				System.out.println(nec+" ...........> $"+lib.getNumero200()+" pesos");
				c2=c2-nec;
				
				cantidad= cantidad%b200;
			
			}
		}
		
		   }
	
	
	
	
	if (atm.getCantidadBillete100()>=100) {
		
		
		if(cantidad>=100) {
		int nec=(int)(cantidad/100);
		if(nec>=c3) {
			
			b100=c3*lib.getNumero100();//los biletes que hay por la denominacion(500)
		System.out.println(c3+" ...........> $"+lib.getNumero100()+" pesos");
		c3=0;
		cantidad= cantidad%b100;
		}else {
			
			b100=nec*lib.getNumero100();//los biletes que hay por la denominacion(100)
			System.out.println("despues del b100:"+b100);
			System.out.println(nec+" ...........> $"+lib.getNumero100()+" pesos");
			c3=c3-nec;
			
			cantidad= cantidad%b100;
			
		}	
			
		}
		
		   }
	
	
	
	if (atm.getCantidadBillete50()>=50) {
		
		if(cantidad>=50) {
			int nec=(int) (cantidad/50);
		if(nec>c4) {
			
			b50=c4*50;//los biletes que hay por la denominacion(500)
		
		
		System.out.println(c4+" ...........> $"+50+" pesos");
		
		cantidad= cantidad%b50;	
			
		}else {
			
			b50=nec*50;
			System.out.println(nec+" ...........> $"+50+" pesos");
			c4=c4-nec;
			cantidad= cantidad%b50;	
		}
			
		}
		
		  }else {
			   
			   System.out.println("No hay billetes de 50");  	   
			   
		   }
	
	denominacionesExistentes=c4+","+c3+","+c2+","+c1; 
	escribirDenominacionEx(denominacionesExistentes);
}

//------------------


public void escribirDenominacionEx(String denominacionesEx) {
	 String archivo= "saldoATM";
		
		try {
			File file = new File(archivo + ".txt");
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new  OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			//Cliente cl ;				
			
				
				bw.write(denominacionesEx);
				bw.newLine();
		
			
			bw.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}	
      }   

//------evidencia_actividades-----------
public void registrarActividades(long cuenta,String nombre,String actividad,double retiro, String fecha) {
	 String archivo= cuenta+"_"+nombre;
		String datosActividad=actividad+","+retiro+","+fecha;
		try {
			File file = new File(archivo + ".txt");
			FileOutputStream fos = new FileOutputStream(file.getAbsoluteFile(),true);
			OutputStreamWriter osw = new  OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			//Cliente cl ;				
			
				
				bw.write(datosActividad);
				bw.newLine();
		
			
			bw.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}	
     }  
//--------------------------------

public void imprimirActividades(long cuenta, String nombre) {
	
	String nombreArchivo=cuenta+"_"+nombre+".txt";
	String cadenaLeida="";
	FileReader fr;
	
	try {
		fr= new FileReader(nombreArchivo);
		BufferedReader bf= new BufferedReader(fr);
		cadenaLeida=bf.readLine();
		 while (cadenaLeida != null) { 
			
			  StringTokenizer st = new StringTokenizer(cadenaLeida,",");
			  
			  String actividad=st.nextToken();
			  String cantidadRetiro=st.nextToken();
			  String fecha =st.nextToken();
			  
			  System.out.println("Actividad: "+actividad+
					             "\nCantidad: "+cantidadRetiro+
					             "\nFecha: "+fecha+"\n\n");
			  
			  cadenaLeida = bf.readLine();  
			 
		 }
		
		
	}catch(IOException e) {
		
		System.out.println("No hay movimientos pasados del cliente");
	}
	
	
	
}

}








