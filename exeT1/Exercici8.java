package es.florida.exeT1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Exercici8 {

	public static void main(String[] args) throws IOException {
		String nombreFichero = args[0];
        System.out.println("Fichero original: " + nombreFichero);
        
        int posicionPunto =  nombreFichero.indexOf(".");
        String nombreFicheroSinExtension = nombreFichero.substring(0, posicionPunto);
        String extension = nombreFichero.substring(posicionPunto);
        String nombreFicheroCopia = nombreFicheroSinExtension + "_copia" + extension;
        
        System.out.println("Fichero copia: " + nombreFicheroCopia);
        
        File ficheroOriginal = new File (nombreFichero);
        File ficheroCopia = new File (nombreFicheroCopia);
        FileReader fr = new FileReader(ficheroOriginal);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(ficheroCopia);
        BufferedWriter bw = new BufferedWriter(fw);
        String linea = br.readLine();
        
        while(linea != null) {
            System.out.println("Copiando " + linea + " de " + nombreFichero + " a " + nombreFicheroCopia);
            bw.write(linea);
            linea = br.readLine();
        }
        br.close();
        bw.close();
        fr.close();
        fw.close(); 
        System.out.println("Borrando fichero: " + nombreFicheroCopia);
        ficheroCopia.delete();

}
}
