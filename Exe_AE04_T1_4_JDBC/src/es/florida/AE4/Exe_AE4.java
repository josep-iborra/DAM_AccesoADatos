package es.florida.AE4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.sql.Connection;

public class Exe_AE4 {
	/*
	 * Metode: main Descripcio: llig y modifica el contingut del fitxer csv a la bdd.
	 * Parametres d'entrada: 
	 * Parametres d'exida: llistaLlibres;
	 */

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
		File fichero = new File("AE04_T1_4_JDBC_Dades.csv");

		try {

			FileReader fr = new FileReader(fichero, StandardCharsets.ISO_8859_1);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			linea = br.readLine();
			String titol = "";
			String autor = "";
			String any_naixement = "";
			String any_publicacio = "";
			String editorial = "";
			String nombre_de_pagines = "";

			String sqlFiles = "SELECT COUNT(ID) FROM llibreria";
			Statement stmtFiles = con.createStatement();
			ResultSet rsFiles = stmtFiles.executeQuery(sqlFiles);

			int num;
			while (rsFiles.next()) {
				num = rsFiles.getInt(1);
				if (num < 1) {
					// llig linea a linea
					while (linea != null) {
						// Separa per cada ";" i ho clava en la array
						String[] lineas = linea.split(";");

						// llig linea a linea per a comprobar si esta vuida alguna posicio i la replena
						// en N.C
						for (int i = 0; i < lineas.length; i++) {
							if (lineas[i].equals("")) {
								lineas[i] = "N.C";
							} else {
								titol = lineas[0];
								autor = lineas[1];
								any_naixement = lineas[2];
								any_publicacio = lineas[3];
								editorial = lineas[4];
								nombre_de_pagines = lineas[5];
							}
						}
						// inserta els datos en la llibreria
						String sql = "INSERT INTO llibreria (Titol, Autor, Any_naixement, Any_publicacio, Editorial, Nombre_de_pagines) VALUES (?,?,?,?,?,?)";
						PreparedStatement psInsertar = con.prepareStatement(sql);

						psInsertar.setString(1, titol);
						psInsertar.setString(2, autor);
						psInsertar.setString(3, any_naixement);
						psInsertar.setString(4, any_publicacio);
						psInsertar.setString(5, editorial);
						psInsertar.setString(6, nombre_de_pagines);
						int resultadoInsertar = psInsertar.executeUpdate();

						linea = br.readLine();
					}
				}
			}

			System.out.println("La crida s'ha agregat amb exit a la base de dades \n");
			br.close();
			fr.close();

			String sqlAnyNaixement = ("SELECT Titol, Autor, Any_publicacio FROM llibreria WHERE Any_naixement < 1950");
			String sqlEditorial = ("SELECT Editorial, Any_publicacio FROM llibreria WHERE Any_publicacio > 2000");
			// mosta el resultat del slq
			Statement stmt = con.createStatement();
			ResultSet rsAnyNaixement = stmt.executeQuery(sqlAnyNaixement);

			while (rsAnyNaixement.next()) {
				System.out.println(rsAnyNaixement.getString(1) + " ; " + rsAnyNaixement.getString(2) + " ; "
						+ rsAnyNaixement.getString(3));
			}

			ResultSet rsEditorial = stmt.executeQuery(sqlEditorial);
			while (rsEditorial.next()) {
				System.out.println(rsEditorial.getString(1));
			}

			Scanner sc = new Scanner(System.in);

			System.out.println("\n");
			System.out.print("Introdueix un tipus de consulta (SELECT, INSERT, UPDATE, DELETE): ");
			String sqlTeclat = sc.nextLine();
			StringTokenizer tokens = new StringTokenizer(sqlTeclat); // Obté el primer token que introdueix el usuari per teclat
			String tipusConsulta = tokens.nextToken().toUpperCase();

			switch (tipusConsulta) {
			case "SELECT":
				Statement stmtSelectTeclat = con.createStatement();
				ResultSet rsSelectTeclat = stmtSelectTeclat.executeQuery(sqlTeclat);
				int nombreFiles = rsSelectTeclat.getMetaData().getColumnCount();
				while (rsSelectTeclat.next()) {
					for (int i = 1; i <= nombreFiles; i++) {
						System.out.print(rsSelectTeclat.getString(i));
						if (i < nombreFiles) {
							System.out.print(" - ");
						}
					}
					System.out.print(" \n ");
				}
				break;
			case "INSERT":
				PreparedStatement psInsertar = con.prepareStatement(sqlTeclat);
				System.out.print("¿Vols insertar el llibre en la base de dades (s/n)? ");
				String confirmacioInsertar = sc.nextLine();
				int resultatInsertar = 0;
				if (confirmacioInsertar.equals("s")) {
					resultatInsertar = psInsertar.executeUpdate();
				}
				if (resultatInsertar > 0) {
					System.out.println("El llibre s'ha anyadit correctament en la base de dades");
				} else {
					System.err.print("Error, no s'ha pogut anyadir el llibre en la base de dades");
				}
				break;
			case "UPDATE":
				PreparedStatement psActualitzar = con.prepareStatement(sqlTeclat);
				System.out.print("¿Vols actualitzar el llibre en la base de dades (s/n)? ");
				String confirmacioActualitzar = sc.nextLine();
				int resultatActualitzar = 0;
				if (confirmacioActualitzar.equals("s")) {
					resultatActualitzar = psActualitzar.executeUpdate();
				}
				if (resultatActualitzar > 0) {
					System.out.println("El llibre s'ha actualitzat correctament en la base de dades");
				} else {
					System.err.print("Error, no s'ha pogut actualitzar el llibre en la base de dades");
				}
				break;
			case "DELETE":
				PreparedStatement psEliminar = con.prepareStatement(sqlTeclat);
				System.out.print("¿Vols eliminar el llibre de la base de dades (s/n)? ");
				String confirmacioEliminar = sc.nextLine();
				int resultatEliminar = 0;
				if (confirmacioEliminar.equals("s")) {
					resultatEliminar = psEliminar.executeUpdate();
				}
				if (resultatEliminar > 0) {
					System.out.println("El llibre s'ha eliminat correctament en la base de dades");
				} else {
					System.err.print("Error, no s'ha pogut eliminar el llibre en la base de dades");
				}
				break;
			}

			rsAnyNaixement.close();
			rsEditorial.close();
			stmt.close();
			con.close();
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}