package es.florida;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Biblioteca {
	static ArrayList<Llibre> llibres = new ArrayList<Llibre>();

	// M�tode: ultimId
	// Descripci� m�tode: Agarra el �ltim Id de la biblioteca
	// Par�metros de entrada: No
	// Par�metros de salida: Torna el id
	private static int ultimId() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
		MongoCollection<Document> coleccion = database.getCollection("Biblioteca");

		int id = 1;
		MongoCursor<Document> cursor = coleccion.find().iterator();
		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			id = obj.getInt("Id");
		}
		mongoClient.close();

		return id;
	}

	// M�tode: mostrarLLibres
	// Descripci� m�tode: Agarra el �ltim Id de la biblioteca
	// Par�metros de entrada: No
	// Par�metros de salida: Torna el id

	public static ArrayList<Llibre> mostrarLLibres() {

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
		MongoCollection<Document> coleccion = database.getCollection("Biblioteca");
		// CRUD operations

		MongoCursor<Document> cursor = coleccion.find().iterator();

		while (cursor.hasNext()) {
			JSONObject obj = new JSONObject(cursor.next().toJson());
			System.out.println(obj.getInt("Id") + " " + obj.getString("Titol"));

		}
		return llibres;

	}

	// M�tode: mostrarLlibre
	// Descripci� m�tode: Mostra el llibre con el id selecciona
	// Par�metros de entrada: No
	// Par�metros de salida: Torna el id con los datos

	public static void mostrarLlibre() {
		// Recuperar un objecte a partir del seu id
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
		MongoCollection<Document> coleccion = database.getCollection("Biblioteca");

		System.out.println("Que llibre vols vore, introduix el id:");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());

		Bson query = eq("Id", id);
		MongoCursor<Document> cursor = coleccion.find(query).iterator();

		if (query == null) {
			System.out.println("No hi ha pelicula amb la id:" + id);
		} else {
			while (cursor.hasNext()) {
				JSONObject obj = new JSONObject(cursor.next().toJson());
				System.out.println("Titol: " + obj.getString("Titol"));
				System.out.println("Autor: " + obj.getString("Autor"));
				System.out.println("Any_naixement: " + obj.getString("Any_naixement"));
				System.out.println("Any_publicacio: " + obj.getString("Any_publicacio"));
				System.out.println("Editorial: " + obj.getString("Editorial"));
				System.out.println("Nombre_pagines: " + obj.getString("Nombre_pagines"));

			}

		}
	}

	// M�tode: crearLlibre
	// Descripci� m�tode: Crea un llibre
	// Par�metros de entrada: No
	// Par�metros de salida: Torna el llibre creat amb un id mes
	public static void crearLlibre() {

		Scanner sc = new Scanner(System.in);

		System.out.print("�Vols crear un llibre de la biblioteca (s/n)? ");
		String respostaCrear = sc.nextLine();

		while (respostaCrear.equals("s")) {

			MongoClient mongoClient = new MongoClient("localhost", 27017);
			MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
			MongoCollection<Document> coleccion = database.getCollection("Biblioteca");

			// Crear nou objecte
			Document doc = new Document();

			doc.append("Id", ultimId() + 1);

			System.out.println("Anyadix el titol:");
			Scanner t = new Scanner(System.in);

			doc.append("Titol", t.nextLine());

			System.out.println("Anyadix el autor:");
			Scanner a = new Scanner(System.in);

			doc.append("Autor", a.nextLine());

			System.out.println("Anyadix el any de naixement del autor:");
			Scanner an = new Scanner(System.in);
			doc.append("Any_naixement", an.nextLine());

			System.out.println("Anyadix el any de publicacio del llibre:");
			Scanner ap = new Scanner(System.in);
			doc.append("Any_publicacio", ap.nextLine());

			System.out.println("Anyadix la editorial:");
			Scanner e = new Scanner(System.in);
			doc.append("Editorial", t.nextLine());

			System.out.println("Anyadix el nombre de pagines del llibre:");
			Scanner np = new Scanner(System.in);

			doc.append("Nombre_pagines", np.nextLine());
			coleccion.insertOne(doc);

			System.out.println("�Vols crear altre llibre en la biblioteca (s/n)? ");
			respostaCrear = sc.nextLine();

		}

	}

	// M�tode: modificarLlibre
	// Descripci� m�tode: Modifica el id que es indicant en la biblioteca
	// Par�metros de entrada: No
	// Par�metros de salida: Torna el objecte modificat

	public static void modificarLlibre() {
		Scanner sc = new Scanner(System.in);
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
		MongoCollection<Document> coleccion = database.getCollection("Biblioteca");
	

		System.out.println("Introdueix un id que vols actualizar: ");
		int idModificar = Integer.parseInt(sc.nextLine());

		

		System.out.print("Introdueix el titol: ");
		String modificarTitol = sc.nextLine();
		coleccion.updateOne(eq("Id", idModificar), new Document("$set", new Document("Titol", modificarTitol)));
		System.out.println("Ara el titol �s: " + modificarTitol);

		System.out.print("Introdueix el autor: ");
		String modificarAutor = sc.nextLine();
		coleccion.updateOne(eq("Id", idModificar), new Document("$set", new Document("Autor", modificarAutor)));
		System.out.println("Ara el autor �s: " + modificarAutor);

		System.out.print("Introdueix el any de naixement: ");
		String modificarAnyNaixement = sc.nextLine();
		modificarAnyNaixement = modificarAnyNaixement.equals("") ? "N.C" : modificarAnyNaixement;
		coleccion.updateOne(eq("Id", idModificar),
				new Document("$set", new Document("Any_naixement", modificarAnyNaixement)));
		System.out.println("Ara el any de naixement �s: " + modificarAnyNaixement);

		System.out.print("Introdueix el any de publicaci�: ");
		String modificarAnyPublicacio = sc.nextLine();
		coleccion.updateOne(eq("Id", idModificar),
				new Document("$set", new Document("Any_publicacio", modificarAnyPublicacio)));
		System.out
				.println("Ara el any de publicaci� �s: " + modificarAnyPublicacio);

		System.out.print("Introdueix la editorial: ");
		String modificarEditorial = sc.nextLine();
		coleccion.updateOne(eq("Id", idModificar), new Document("$set", new Document("Editorial", modificarEditorial)));
		System.out.println("Ara la editorial �s: " + modificarEditorial);

		System.out.print("Introdueix el nombre de p�gines: ");
		String modificarNombrePagines = sc.nextLine();
		coleccion.updateOne(eq("Id", idModificar),
				new Document("$set", new Document("Nombre_pagines", modificarNombrePagines)));
		System.out
				.println("Ara el nombre de p�gines �s: " + modificarNombrePagines);

		mongoClient.close();

	}

	// M�tode: borrarLlibre
	// Descripci� m�tode: Borra el  Id que li indiques la biblioteca
	// Par�metros de entrada: No
	// Par�metros de salida: Borra el id indicat

	public static void borrarLlibre() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Introdueix el id que vols eliminar: ");
		int idEsborrar = Integer.parseInt(sc.nextLine());

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
		MongoCollection<Document> coleccion = database.getCollection("Biblioteca");

		try {
			coleccion.deleteOne(eq("Id", idEsborrar));	
		} catch (Exception e) {

		}

		mongoClient.close();

	}

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("DAM_MongoDB");
		MongoCollection<Document> coleccion = database.getCollection("Biblioteca");
		// CRUD operations

		boolean repe = true;
		while (repe) {

			repe = false;
			System.out.println("");
			// Ac� les operacio/ns CRUD (crear, llegir, actualitzar, borrar)
			System.out.println("1 per mostrar la llista de tots els llibres");
			System.out.println("2 per mostrar un llibre");
			System.out.println("3 per crear un llibre");
			System.out.println("4 per modificar un llibre");
			System.out.println("5 per borrar un llibre");

			Scanner scOpcio = new Scanner(System.in);
			int Opcio = Integer.parseInt(scOpcio.nextLine());

			switch (Opcio) {
			case 1:

				mostrarLLibres();
				System.out.println("vols tornar al menu? s/n");

				Scanner sc1 = new Scanner(System.in);
				String scan1 = sc1.nextLine().toLowerCase();
				if (scan1.equals("s")) {
					repe = true;
				}
				break;
			case 2:

				mostrarLlibre();
				System.out.println("�vols tornar al menu? s/n");

				Scanner sc2 = new Scanner(System.in);
				String scan2 = sc2.nextLine().toLowerCase();
				if (scan2.equals("s")) {
					repe = true;
				}

				break;
			case 3:

				crearLlibre();
				System.out.println("vols tornar al menu? s/n");

				Scanner sc3 = new Scanner(System.in);
				String scan3 = sc3.nextLine().toLowerCase();
				if (scan3.equals("s")) {
					repe = true;
				}
				break;
			case 4:

				modificarLlibre();
				System.out.println("vols tornar al menu? s/n");

				Scanner sc4 = new Scanner(System.in);
				String scan4 = sc4.nextLine().toLowerCase();
				if (scan4.equals("s")) {
					repe = true;
				}
				break;
			case 5:

				borrarLlibre();
				System.out.println("vols tornar al menu? s/n");

				Scanner sc5 = new Scanner(System.in);
				String scan5 = sc5.nextLine().toLowerCase();
				if (scan5.equals("s")) {
					repe = true;
				}
				break;
			}

		}

		mongoClient.close();
	}
}
