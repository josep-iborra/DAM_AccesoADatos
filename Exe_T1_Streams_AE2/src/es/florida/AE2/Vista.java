package es.florida.AE2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Vista {

	private JFrame frame;
	private JTextField textField_Buscar;
	private JTextField textField_Reemplazar;
	private JButton btnBuscar;
	private JButton btnReemplazar;
	private JTextArea textArea_Original;
	private JTextArea textArea_Modificado;

	
	public Vista() {
		initialize();
	}
	/*Metode: initialize
	 	*Descripcio: Mostra tot la interfaz grafica com ha de ser
	 	*Parametres d'entrada:
	 	*Parametres d'exida:
	*/

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_Original = new JScrollPane();
		scrollPane_Original.setBounds(22, 20, 743, 222);
		frame.getContentPane().add(scrollPane_Original);
		
		textArea_Original = new JTextArea();
		textArea_Original.setLineWrap(true);
		textArea_Original.setRows(12);
		scrollPane_Original.setColumnHeaderView(textArea_Original);
		scrollPane_Original.getViewport().setView(textArea_Original);
		
		textField_Buscar = new JTextField();
		textField_Buscar.setBounds(32, 252, 177, 27);
		frame.getContentPane().add(textField_Buscar);
		textField_Buscar.setColumns(10);
		
		textField_Reemplazar = new JTextField();
		textField_Reemplazar.setColumns(10);
		textField_Reemplazar.setBounds(421, 252, 177, 27);
		frame.getContentPane().add(textField_Reemplazar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.setBounds(219, 252, 120, 27);
		frame.getContentPane().add(btnBuscar);
		
		btnReemplazar = new JButton("Reemplazar");
		btnReemplazar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReemplazar.setBounds(608, 252, 120, 27);
		frame.getContentPane().add(btnReemplazar);
		
		JScrollPane scrollPane_Modificado = new JScrollPane();
		scrollPane_Modificado.setBounds(22, 300, 743, 222);
		frame.getContentPane().add(scrollPane_Modificado);
		
		textArea_Modificado = new JTextArea();
		textArea_Modificado.setLineWrap(true);
		textArea_Modificado.setRows(12);
		scrollPane_Modificado.setColumnHeaderView(textArea_Modificado);
		scrollPane_Modificado.getViewport().setView(textArea_Modificado);
		
		this.frame.setVisible(true);
	}
	/*Metode: getBtnBuscar
	 	*Descripcio: Agarra el boto buscar.
	 	*Parametres d'entrada:
	 	*Parametres d'exida: btnBuscar
 	*/
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	
	/*Metode: getBtnReemplazar
	 	*Descripcio: Agarra el boto reemplaçar.
	 	*Parametres d'entrada:
	 	*Parametres d'exida: btnReemplazar
	*/
	
	public JButton getBtnReemplazar() {
		return btnReemplazar;
	}
	
	/*Metode: getTextFieldBuscar
	 	*Descripcio: Agarra el archiu a on buscar.
	 	*Parametres d'entrada:
	 	*Parametres d'exida: textField_Buscar
	*/
	
	public JTextField getTextFieldBuscar() {
		return textField_Buscar;
	}
	
	/*Metode: getTextFieldReemplazar
	 	*Descripcio:Agarra el archiu a on reemplaçar.
	 	*Parametres d'entrada:
	 	*Parametres d'exida: textField_Reemplazar
	*/
	
	public JTextField getTextFieldReemplazar() {
		return textField_Reemplazar;
	}
	
	/*Metode: getTextAreaOriginal
	 	*Descripcio: Agarra el area a on reemplaçar per a que es mostre.
	 	*Parametres d'entrada:
	 	*Parametres d'exida: textArea_Original
	*/
	
	public JTextArea getTextAreaOriginal() {
		return textArea_Original;
	}
	
	/*Metode: getTextAreaModificado
	 	*Descripcio:Agarra el area a on reemplaçar per a que es mostre.
	 	*Parametres d'entrada:
	 	*Parametres d'exida: textArea_Modificado
	*/
	
	
	public JTextArea getTextAreaModificado() {
		return textArea_Modificado;
	}
	


	

}
