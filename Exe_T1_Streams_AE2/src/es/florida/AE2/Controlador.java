package es.florida.AE2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import es.florida.AE2.Model;
import es.florida.AE2.Vista;




public class Controlador {
	private Model modelo;
	private Vista vista;
	private ActionListener actionListenerBuscar, actionListenerReemplazar;
	
	/*Metode: Controlador
	 	*Descripcio: Junta el vista y el model per a poder utilitzar els botons en les necesitats que nos indiquen.
	 	*Parametres d'entrada:
	 	*Parametres d'exida:
 	*/
	
	Controlador(Model modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		control();
		
		String texto = ""; 
		for( String linea : modelo.contenidoFichero(modelo.ficheroLectura())) {
			texto += linea + "\n";
			}
		vista.getTextAreaOriginal().setText(texto);
	}
	
	/*Metode: Control
	 	*Descripcio: Crea els actionListener dels botons y mostra el contigut del fitxer en els textArea.
	 	*Parametres d'entrada:
	 	*Parametres d'exida:
	 */
	
	private void control() {
		String fitxerLectura = modelo.ficheroLectura();
		actionListenerBuscar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
					String palabras =vista.getTextFieldBuscar().getText();
					System.out.println();
					modelo.buscarText(palabras);
			}
			
		};
		vista.getBtnBuscar().addActionListener(actionListenerBuscar);
		
		actionListenerReemplazar = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
			String mostrarFitxer = modelo.reemplazar(fitxerLectura,vista.getTextFieldBuscar().getText(), vista.getTextFieldReemplazar().getText());
			vista.getTextAreaModificado().setText(mostrarFitxer);
			
			}
		};
		vista.getBtnReemplazar().addActionListener(actionListenerReemplazar);
	}
}
