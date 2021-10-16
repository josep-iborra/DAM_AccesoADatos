package es.florida.AE2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Model {

	private String fichero_lectura;
	

	Model() {
		fichero_lectura = "AE02_T1_2_Streams_Groucho.txt";
		
	}
	
	/* Metode: contenidoFichero
	 	*Descripcio: Mostra el contigut del ficher en la aplicacio.
	 	*Parametres d'entrada:	fitxer(el fitxer que ens han proporcionat)
	 	*Parametres d'exida: almacena linea per linea el fitxer y el mostra.
 */

	public ArrayList<String> contenidoFichero(String fitxer) {
		ArrayList<String> contenidoFichero = new ArrayList<String>();
		File f = new File(fitxer);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				contenidoFichero.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return contenidoFichero;
	}
	/*Metode: ficheroLectura
	 	*Descripcio: Retorna el archiu el fitxer de lectura per a poder utilitzarlo.
	 	*Parametres d'entrada:
	 	*Parametres d'exida: fichero_lectura
	*/
	public String ficheroLectura() {
		return fichero_lectura;
	}
	
	/* Metode: buscarText
	 	*Descripcio: Aquets metod funciona per a buscar la cantitat de paraules que hi han el text.
	 	*Parametres d'entrada: textBuscar (paraula per la que vuic que me busque)
	 	*Parametres d'exida: fa el calcul de la cantitat de paraules que se introduixen en buscar.
	 */

	public void buscarText(String textBuscar) {
		// TODO Auto-generated method stub
		File fitxer = new File(ficheroLectura());
	
		try {
			if (fitxer.exists()) {
				BufferedReader leerArchivo = new BufferedReader(new FileReader(ficheroLectura()));
				int totalCoincidencias = 0;
				String lineaLeida = leerArchivo.readLine();
	
				String[] palabras = null;
				while (lineaLeida != null) {
					palabras = lineaLeida.split(" ");
					for (String palabra : palabras) {
						if (palabra.equals(textBuscar)) {
							totalCoincidencias++;
						}
					}
					lineaLeida = leerArchivo.readLine();
				}
	
				JOptionPane.showMessageDialog(new JFrame(), "Conte: " + totalCoincidencias, lineaLeida,
						JOptionPane.INFORMATION_MESSAGE);
				leerArchivo.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	
		}
	}
	/* Metode: reemplazar
	 	*Descripcio: Aquets metod remplaza en altre fitxer la paraula que has escrit en la variable buscar per la paraula que has ficat en la variable remplazar
	 	*Parametres d'entrada:fichero_lectura, paraula, paraularemplazar
	 	*Parametres d'exida: content (mostra el text amb la paraula cambiada)
	 */

	public String reemplazar(String fichero_lectura ,String paraula , String paraularemplazar) {
		// TODO Auto-generated method stub
		File fitxer = new File(fichero_lectura);
		File fitxerNou = new File("AE02_T1_2_Streams_GrouchoCopia.txt");
		String line = "", content = "";  
		
		try {
			if(fitxer.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader(ficheroLectura()));
				
		            while((line = reader.readLine())!= null) {
		                content += line + "\r\n";
		            }

		            reader.close();

		            content = content.replaceAll(paraula, paraularemplazar);
		            fitxerNou.createNewFile();
		            BufferedWriter bw= new BufferedWriter(new FileWriter(fitxerNou));
		            FileOutputStream fo = new FileOutputStream("AE02_T1_2_Streams_GrouchoCopia.txt");
		            fo.write(content.getBytes());
		            bw.close();
		            fo.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return content;
	}
	

}
