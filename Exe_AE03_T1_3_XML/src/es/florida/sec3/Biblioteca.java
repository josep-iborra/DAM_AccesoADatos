package es.florida.sec3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Biblioteca {
	/* Metode: recuperarTots
	*Descripcio: torna una llista amb tots els llibres de la biblioteca
	*Parametres d'entrada:
	*Parametres d'exida: llistaLlibres;
	*/
	public static ArrayList<Llibre> recuperarTots() {
		ArrayList<Llibre> llistaLlibres = new ArrayList<Llibre>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("Biblioteca.xml"));
			Element raiz = document.getDocumentElement();
			
			NodeList nodeList = document.getElementsByTagName("llibre");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
	
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					String id = eElement.getAttribute("id");
					String titol = eElement.getElementsByTagName("titol").item(0).getTextContent();
					String any =eElement.getElementsByTagName("any").item(0).getTextContent();
					String editorial=eElement.getElementsByTagName("editorial").item(0).getTextContent();
					String pagina=eElement.getElementsByTagName("pagina").item(0).getTextContent();
					String autor=eElement.getElementsByTagName("autor").item(0).getTextContent();
					Llibre lib = new Llibre(Integer.parseInt(id), titol,Integer.parseInt(any),editorial,Integer.parseInt(pagina),autor);
					llistaLlibres.add(lib);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return llistaLlibres;
	}
	/* Metode: mostrarLlibre
	*Descripcio: mostra els atributs del llibre per pantalla.
	*Parametres d'entrada:
	*Parametres d'exida: 
	*/
	public static void mostrarLlibre(Llibre llibre) {
		System.out.println("Identificador: " + llibre.getId());
		System.out.println("Titol: " + llibre.getTitol());
		System.out.println("Any: " + llibre.getAny());
		System.out.println("Editorial: " + llibre.getEditorial());
		System.out.println("Pagines: " + llibre.getPagina());
		System.out.println("Autor: " + llibre.getAutor());
	}
	/* Metode: recuperarLlibre
	*Descripcio:torna un objecte llibre a partir d’un identificador.
	*Parametres d'entrada:
	*Parametres d'exida: ;
	*/
	public static Llibre recuperarLlibre(int id) {
		ArrayList<Llibre> llibres = recuperarTots();
		for(Llibre llib : llibres) {
			if (id == llib.getId() ) {
				return llib;
			}
		}
		return null;
	}
	
	/* Metode: crearLlibre
	*Descripcio:  crear un nou llibre com a XML a partir de les dades proporcionades per l’usuari, torna l’identificador del llibre.
	*Parametres d'entrada:
	*Parametres d'exida: ;
	*/
	public static void crearLlibre() {
		ArrayList<Llibre> llibres = recuperarTots();
		
			Scanner sc = new Scanner(System.in);
			System.out.print("¿Desitja anyadir un llibre a la biblioteca (s/n)? ");
			String resposta = sc.nextLine();
			do{
			int id = llibres.size();
			int idNova = id + 1;
			
			
			System.out.print("Introduix titol:");
			String anyadirTitol = sc.nextLine();
			
			System.out.print("Introduix any:");
			int anyadirAny = Integer.parseInt(sc.nextLine());
			
			System.out.print("Introduix la editorial:");
			String anyadirEditorial = sc.nextLine();
			
			System.out.print("Introduix la pagina:");
			int anyadirPagina = Integer.parseInt(sc.nextLine());
			
			System.out.print("Introduix el autor:");
			String anyadirAutor = sc.nextLine();
			
			Llibre LlibreNou = new Llibre(idNova,anyadirTitol,anyadirAny,anyadirEditorial,anyadirPagina,anyadirAutor);
			
			llibres.add(LlibreNou);
			writeXmlFile(llibres);
			
			System.out.print("¿Desitja anyadir un llibre a la biblioteca (s/n)? ");
            resposta = sc.nextLine();
			}while (resposta.equals("s"));
			sc.close();
	}
	
	/* Metode: writeXmlFile
	*Descripcio: Escriu en el fitxer
	*Parametres d'entrada: llistaLlibres
	*Parametres d'exida: ;
	*/
	public static void writeXmlFile(ArrayList<Llibre> llistaLlibres) {
		
        try {
        	DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();
            Element raiz = doc.createElement("llibreria");
            doc.appendChild(raiz);
            for (Llibre llib : llistaLlibres) {
                Element llibre = doc.createElement("llibre");
                String id = String.valueOf(llib.getId());
                llibre.setAttribute("id", id);
                raiz.appendChild(llibre);
                
                Element crearTitol = doc.createElement("titol");
                crearTitol.appendChild(doc.createTextNode(String.valueOf(llib.getTitol())));
                llibre.appendChild(crearTitol);
                
                Element crearAny = doc.createElement("any");
                crearAny.appendChild(doc.createTextNode(String.valueOf(llib.getAny())));
                llibre.appendChild(crearAny);
                
                Element crearEditorial = doc.createElement("editorial");
                crearEditorial.appendChild(doc.createTextNode(String.valueOf(llib.getEditorial())));
                llibre.appendChild(crearEditorial);
                
                Element crearPagines = doc.createElement("pagina");
                crearPagines.appendChild(doc.createTextNode(String.valueOf(llib.getPagina())));
                llibre.appendChild(crearPagines);
                
                Element crearAutor = doc.createElement("autor");
                crearAutor.appendChild(doc.createTextNode(String.valueOf(llib.getAutor())));
                llibre.appendChild(crearAutor);
            }
            TransformerFactory tranFactory = TransformerFactory.newInstance(); // Crear serializador
            Transformer aTransformer = tranFactory.newTransformer();
            aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); // Darle formato al documento
            aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            try {
                FileWriter fw = new FileWriter("biblioteca.xml"); // Definir el nombre del fichero y guardar
                StreamResult result = new StreamResult(fw);
                aTransformer.transform(source, result);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (TransformerException ex) {
            System.out.println("Error escrivint el document");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error escrivint el document");
        }
    }
	/* Metode: actualizarLlibre
	*Descripcio: actualitza (modifica) la informació d’un objecte llibre a partir d’un identificador
	*Parametres d'entrada: id
	*Parametres d'exida: ;
	*/
	public static void actualizarLlibre(int id) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Llibre> llibres = recuperarTots();
		Llibre llibreActu = llibres.get(id-1);
		
		System.out.print("Introduix un nou titol:");
		String anyadirTitol = sc.nextLine();
		
		System.out.print("Introduix un nou any:");
		int anyadirAny = Integer.parseInt(sc.nextLine());
		
		System.out.print("Introduix una nova editorial:");
		String anyadirEditorial = sc.nextLine();
		
		System.out.print("Introduix una nova pagina:");
		int anyadirPagina = Integer.parseInt(sc.nextLine());
		
		System.out.print("Introduix un nou autor:");
		String anyadirAutor = sc.nextLine();
		
		llibreActu.setTitol(anyadirTitol);
		llibreActu.setAny(anyadirAny);
		llibreActu.setEditorial(anyadirEditorial);
		llibreActu.setPagina(anyadirPagina);
		llibreActu.setAutor(anyadirAutor);
		
		writeXmlFile(llibres);
		sc.close();
		
	}
	/* Metode: borrarllibre
	*Descripcio: borra un objecte llibre a partir d’un identificador.
	*Parametres d'entrada:id
	*Parametres d'exida: ;
	*/
	public static void borrarllibre(int id) {
		ArrayList<Llibre> llibres = recuperarTots();
		llibres.remove(id-1);
		writeXmlFile(llibres);
	}
	/* Metode: main
		*Descripcio: Creem un switch i anyadim el metods que nos demanen.
		*Parametres d'entrada:
		*Parametres d'exida: ;
		*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1 - Mostrar tots els titols de la biblioteca");
		System.out.println("2 - Mostrar inofrmació detallada d'un llibre");
		System.out.println("3 - Crear nou llibre");
		System.out.println("4 - Actualizar llibre");
		System.out.println("5 - Borrar llibre");
		System.out.println("6 - Tanca la biblioteca");

		System.out.println("Elige la opción que necesites:");
		String opcion = sc.nextLine();

		switch (opcion) {
		case "1":
			System.out.println("Mostrar tots els titols de la biblioteca");
			ArrayList<Llibre> llibres = recuperarTots();
			for (Llibre llib : llibres) {
				mostrarLlibre(llib);
				System.out.println("");
			}
			break;
		case "2":
			System.out.println("Indica la id del llibre que vols consultar:");
			mostrarLlibre(recuperarLlibre(sc.nextInt()));
			
			break;
		case "3":
		
			crearLlibre();
			break;
			
		case "4":
			System.out.println("Indica la id del llibre que vols actualizar:");
			actualizarLlibre(recuperarLlibre(Integer.parseInt(sc.nextLine())).getId());
			break;
			
		case "5":
			System.out.println("Indica la id del llibre que vols eliminar:");
			borrarllibre(recuperarLlibre(Integer.parseInt(sc.nextLine())).getId());
			break;
			
		case "6":
			System.exit(1);
			break;
		}
		sc.close();

	}
}
