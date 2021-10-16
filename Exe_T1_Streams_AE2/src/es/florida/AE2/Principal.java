package es.florida.AE2;

import es.florida.AE2.Controlador;
import es.florida.AE2.Model;
import es.florida.AE2.Vista;

public class Principal {
	/*Metode: main
	 	*Descripcio:Junta tots els archius.
	 	*Parametres d'entrada: args
	 	*Parametres d'exida: 
 	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model modelo = new Model();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo,vista);
	}

}
