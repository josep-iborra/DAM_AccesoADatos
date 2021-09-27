package es.florida.evaT1;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ae1 {

	public static void main(String[] args) {
		info(args);
		crearCarpeta();
		creaFichero();
		EliminarFichero();
		EliminarCarpeta();
		renombrarFichero();
		renombrarCarpeta();
	}
	
	public static void info(String[] args) {
		File Directorio = new File(args[0]);
		System.out.println("Nombre"+ Directorio.getName());
		if(Directorio.isDirectory()) {
			System.out.println("Tipo de directorio");
			File[] lista = Directorio.listFiles();
			int contador = 0;
			for(int i=0; i<lista.length;i++) {
				contador++;
			}
			System.out.println("Numero de elementos"+ contador);
			System.out.println("Espacio total: "+ Directorio.getTotalSpace());
			System.out.println("Espacio libre: "+ Directorio.getFreeSpace());
			System.out.println("Espacio Total: "+  (Directorio.getTotalSpace() - Directorio.getFreeSpace()));
		}else {
			System.out.println("Tipo fichero:");
			System.out.println("Tamaño en bytes: " + Directorio.length());
		}
		System.out.println("Ruta absoluta: "+ Directorio.getAbsolutePath());
		long modificacion = Directorio.lastModified();
		
		String formato = "dd-MM-aaaa hh:mm";
		SimpleDateFormat formatoFecha= new SimpleDateFormat(formato);
		
		Date fecha = new Date (modificacion);
		System.out.println("Fecha de ultima modificaciones: "+ formatoFecha.format(fecha));
		System.out.println("Oculto: "+ Directorio.isHidden());
		
		
		
	}
	public static void crearCarpeta() {
		Scanner sc= new Scanner(System.in);
		String strCarpeta;
		System.out.println("Dime el nombre de la carpeta: ");
		strCarpeta= sc.nextLine();
		
	 boolean carpeta = new File("carpeta/"+strCarpeta).mkdirs();
	 	System.out.println("Se ha creado la carpeta "+ strCarpeta);
		
	}
	public static void creaFichero() {
		
		
		Scanner sc= new Scanner(System.in);
		String strFichero;
		System.out.println("Dime el nombre del fichero: ");
		strFichero= sc.nextLine();
		
		File fichero = new File("carpeta/"+strFichero+".txt");
		System.out.println("Se ha creado la carpeta "+ strFichero);
		
		
		try { 
			fichero.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void EliminarCarpeta() {
		Scanner sc= new Scanner(System.in);
		String strEleminarC;
		System.out.println("Dime el nombre de la carpeta que quieres eliminar: ");
		strEleminarC= sc.nextLine();
		File eliminado = new File("carpeta/"+strEleminarC);
		System.out.println("Se ha eliminado la carpeta "+ strEleminarC);
		
		try { 
			eliminado.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void EliminarFichero() {
		Scanner sc= new Scanner(System.in);
		String strEleminarF;
		System.out.println("Dime el nombre del fichero que quieres eliminar: ");
		strEleminarF= sc.nextLine();
		File eliminado = new File("carpeta/"+strEleminarF+".txt");
		System.out.println("Se ha eliminado el fichero "+ strEleminarF);
		try { 
			eliminado.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void renombrarFichero() {
		Scanner sc= new Scanner(System.in);
		String strRF;
		System.out.println("Dime el nombre del Fichero que quieres renombrar:");
		strRF= sc.nextLine();
		
		File rfichero = new File("carpeta/"+strRF +".txt");
		
		Scanner sc1= new Scanner(System.in);
		String strNuevo;
		System.out.println("Dime nuevo el nombre del Fichero:" );
		strNuevo= sc.nextLine();
		
		File nuevo = new File("carpeta/"+strNuevo+".txt");
		if(rfichero.renameTo(nuevo)) {
			System.out.println("El fichero se ha renombrado");
		}else {
			System.out.println("El fichero no se ha renombrado");
		}
	}
	public static void renombrarCarpeta() {
		Scanner sc= new Scanner(System.in);
		String strRC;
		System.out.println("Dime el nombre de la carpeta que quieres renombrar:");
		strRC= sc.nextLine();
		
		File rcarpeta = new File("carpeta/"+strRC);
		
		Scanner sc1= new Scanner(System.in);
		String strNuevoC;
		System.out.println("Dime el nuevo nombre de la carpeta:" );
		strNuevoC= sc.nextLine();
		
		File nuevo = new File("carpeta/"+strNuevoC);
		if(rcarpeta.renameTo(nuevo)) {
			System.out.println("La carpeta se ha renombrado");
		}else {
			System.out.println("La carpeta  no se ha renombrado");
		}
	}
}
