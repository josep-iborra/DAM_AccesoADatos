package es.florida.exeT1;
import java.io.File;
import es.florida.util.FilterExtencions;

public class Exercici5 {

	public static void main(String[] args) {
		String directorioStr=args[0];
		String extension=args[1];
		
		File directorio = new File(directorioStr);
		FilterExtencions filtro = new FilterExtencions(extension);
		
		String[] listaArchivos = directorio.list(filtro);
		for (int i=0; i < listaArchivos.length ;i++) {
			System.out.println(listaArchivos[i]);
		}
		
	}

}
