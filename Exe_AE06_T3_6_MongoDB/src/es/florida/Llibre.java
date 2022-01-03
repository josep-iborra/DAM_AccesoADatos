package es.florida;

public class Llibre {

	private String id;
	private String titol;
	private String autor;
	private String any_naixement;
	private String any_publicacio;
	private String editorial;
	private String nombre_de_pagines;

	/*
	 * Metode: Llibre Descripcio: Crear el objecte llibre amb les seues atributs.
	 * Parametres d'entrada:id, titol, autor, any naixement, any publicacio, editorial, pagines del llibre. 
	 * Parametres d'exida: ;
	 */
	public Llibre() {
	}

	public Llibre(String id, String titol, String autor, String any_naixement, String any_publicacio, String editorial,
			String nombre_de_pagines) {
		this.id = id;
		this.titol = titol;
		this.autor = autor;
		this.any_naixement = any_naixement;
		this.any_publicacio = any_publicacio;
		this.editorial = editorial;
		this.nombre_de_pagines = nombre_de_pagines;
	}

	public Llibre(String titol, String autor, String any_naixement, String any_publicacio, String editorial,
			String nombre_de_pagines) {

		this.titol = titol;
		this.autor = autor;
		this.any_naixement = any_naixement;
		this.any_publicacio = any_publicacio;
		this.editorial = editorial;
		this.nombre_de_pagines = nombre_de_pagines;
	}

	/*
	 * Metode: Geters i Seters Descripcio: Crear geters i seters per a despues
	 * utilizarles Parametres d'entrada: 
	 * Parametres d'exida: retornen y actualicen els atributs del objecte.
	 */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getAny_naixement() {
		return any_naixement;
	}

	public void setAny_naixement(String any_naixement) {
		this.any_naixement = any_naixement;
	}

	public String getAny_publicacio() {
		return any_publicacio;
	}

	public void setAny_publicacio(String any_publicacio) {
		this.any_publicacio = any_publicacio;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getNombre_de_pagines() {
		return nombre_de_pagines;
	}

	public void setNombre_de_pagines(String nombre_de_pagines) {
		this.nombre_de_pagines = nombre_de_pagines;
	}
	@Override
	public String toString() {
		return "Llibre id=" + id + ", titol=" + titol + ", autor=" + autor + ", any_naixement=" + any_naixement
				+ ", any_publicacio=" + any_publicacio + ", editorial=" + editorial + ", nombre_de_pagines="
				+ nombre_de_pagines;
	}

}
