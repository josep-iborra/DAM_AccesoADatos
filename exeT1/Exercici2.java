package es.florida.exeT1;
import java.io.File;

public class Exercici2 {

	public static void main(String[] args) {
		
		File Directorio = new File(args[0]);
		
		System.out.println("Nombre del archivo: "+ Directorio.getName());
		System.out.println("Ruta: "+ Directorio.getPath());
		System.out.println("Ruta absoluta: "+ Directorio.getAbsolutePath());
		System.out.println("Se puede leer: "+ Directorio.canRead());
		System.out.println("Se puede escribir: "+ Directorio.canWrite());
		System.out.println("Tamaño "+ Directorio.length());

	}

}
