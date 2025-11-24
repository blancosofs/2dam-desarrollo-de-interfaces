package ejercicios; 
import java.io.*;
import java.util.Scanner;

public class CorreccionEjIntro { 

	public static void ej1Corregido() {
		// Realiza un programa que liste elementos de un directorio introducido por pantalla.
		//pedir ruta por teclado 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Introduce la ruta del directorio a mostrar:"); 
		String ruta = sc.nextLine(); 

		//Comprobar si la ruta es directorio
		File ficheroDir = new File(ruta); 
		if (ficheroDir.exists() && ficheroDir.isDirectory()) { 
			String[]lista = ficheroDir.list();
			//Puede ocurrir dos casos que no haya que recorreer
			//1- Lista = null : no tiene elementos
			//2- Podría ocurrir que tenga longitud 0 (nunca va a haber elementos de logitud 0)
			if (lista!=null) {
				for (String elemento : lista) { //mira apuntes pero te itera el contenido solo es como un for con indices
					System.out.println("Elementos de la lista: "+elemento+"tamaño: "+elemento.length());
				}
			}else {
				System.out.println("Directorio esta vacío");
			}

		}else { 
			System.out.println("No existe o no es un directorio"); 
		} 
		sc.close();
	}

	public static void ej2Corregido() {
		//Crea un programa que compruebe que existe un fichero y si existe que lo borre, pedir nombre por teclado 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Introduce el nombre del fichero:"); 
		// hay que poner la doble \\ en todos y el nombre del archivo con la extension
		//C:\\Users\\DAM\\Desktop\\proyectos-2DAM 1709\\introduccion\\src\\ejercicios\\eliminar.txt

		File fichero = new File(sc.nextLine()); 

		if (fichero.exists() && fichero.isFile()) { 
			if (fichero.delete()) { //si te da true es que lo ha borrado
				System.out.println("Fichero eliminado con exito");
			}else {
				System.out.println("No se ha podido eliminar el fichero");
			}
		}else { 
			System.out.println("No existe o no es un archivo"); 
		} 
		sc.close();
	}

	public static void ej3Corregido() {
		//Crea un programa que cree un fichero dentro de un directorio 
		//(ambos nombres son introducidos por el usuario por teclado) 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Introduce el nombre del directorio:"); 
		String ruta = sc.nextLine();
		System.out.println("Introduce el nombre del fichero:"); 
		String nombreFichero = sc.nextLine();

		//1. A=Concatenar ruta+nombreFichero: File fichero = new File(ruta,nombreFichero);
		//2. Saber new File(ruta, nombreFichero) *************????????????
		//3. Comprobar antes de crear que ruta es un directorio

		File directorio = new File(ruta); 
		if (directorio.exists() && directorio.isDirectory()) { 
			File fichero = new File(ruta,nombreFichero);
			//Ahora realizaria la creacion del fichero
			try {
				if (fichero.createNewFile()) {
					System.out.println("Fichero creado con exito");
				}else {
					System.out.println("El fichero no ha sido creado");
				}
			} catch (IOException e) { //esta es la de entrada salida
				e.getMessage();
			}
		}
		sc.close();
	}

	public static void listar (File directorio){
		//para ej 4. recursividad
		if (directorio.exists() && directorio.isDirectory()) {

			String[] listaArchivos = directorio.list();
			for(String archivo : listaArchivos) {
				//??
				File a = new File(archivo); //lo hacer en tipo file para poder hacer cosas
				//Caso base seria que archivo = null
				//Caso recursivo seria archivo != null
				if (a.isDirectory()) {
					listar(a);
				}
				System.out.println(a.getAbsolutePath());
			}
		}else {
			System.out.println("No es un directorio");
		}
	}

	public static void ej4Corregido() {
		//Crea un programa que dado un directorio (compruebe primero que es un directorio y si lo es) 
		//liste todos los ficheros y directorios que contiene. 

		Scanner sc = new Scanner(System.in); 
		System.out.println("Introduce el nombre del directorio:"); 
		String nombreDirectorio = sc.nextLine();

		File directorio = new File(nombreDirectorio);

		if (directorio.exists() && directorio.isDirectory()) {
			listar(directorio);
		}else {
			System.out.println("No es un directorio");
		}
		sc.close();
	}



	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("Seleccione una opcion del menu:");
			System.out.println("1. ");
			System.out.println("2. ");
			System.out.println("3. ");
			System.out.println("4. Listar ficheros y directorios");
			System.out.println("5. ");
			System.out.println("6. ");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				ej1Corregido();
				break;
			case 2:
				ej2Corregido();
				break;
			case 3:
				ej3Corregido();
				break;
			case 4:
				ej4Corregido();
				break;
			case 5:

				break;
			case 6:

				break;
			case 0:
				System.out.println("Saliendo del programa.....");
				break;

			default:
				System.out.println("Opción no valida");
				break;
			}
		} while (opcion!=0);
		sc.close();
	} 
}