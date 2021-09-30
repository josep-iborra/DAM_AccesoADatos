package es.florida.exeT1;
import java.io.File;
import es.florida.util.FilterExtencions;

public class Exercici7 {

	public static void main(String[] args) {
		String directorioStr=args[0];
		File directorio = new File(directorioStr);
		
		
		
		
		if(args.length < 2 ) {
			String[] listaDeArchivos = directorio.list();

			
			for (int i=0; i < listaDeArchivos.length ;i++) {
				System.out.println(listaDeArchivos[i]);
				}
			}else {
				for (int j=1; j < args.length ;j++) {
				
					String extension=args[j];
					FilterExtencions filtro = new FilterExtencions(extension);	
					String[] listaArchivos = directorio.list(filtro);
					
					for (int i=0; i < listaArchivos.length ;i++) {
					System.out.println(listaArchivos[i]);
				}
				}
			}
		
	}

}
