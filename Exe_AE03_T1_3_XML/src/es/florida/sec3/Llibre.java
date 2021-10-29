package es.florida.sec3;

import java.util.ArrayList;

public class Llibre {

	private int id;
	private String titol;
	private int any;
	private String editorial;
	private int pagina;
	private String autor;

	/* Metode: Llibre
	*Descripcio: Crear el objecte llibre amb les seues atributs.
	*Parametres d'entrada:id, titol,any, editorial, pagina, autor.
	*Parametres d'exida: ;
	*/

	public Llibre(int id, String titol, int any, String editorial, int pagina, String autor) {
		this.id = id;
		this.titol = titol;
		this.any = any;
		this.editorial = editorial;
		this.pagina = pagina;
		this.autor = autor;
	}

	/* Metode: Geters i Seters
	*Descripcio: Crear geters i seters per a despues utilizarles
	*Parametres d'entrada:
	*Parametres d'exida: retornen y actualicen els atributs del objecte.
	*/

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitol() {
		return titol;
	}



	public void setTitol(String titol) {
		this.titol = titol;
	}



	public int getAny() {
		return any;
	}



	public void setAny(int any) {
		this.any = any;
	}



	public String getEditorial() {
		return editorial;
	}



	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}



	public int getPagina() {
		return pagina;
	}



	public void setPagina(int pagina) {
		this.pagina = pagina;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}
	
		
}