package ejercicios; 
import java.io.*;
import java.util.Scanner; 
public class Ejercicio1 { 
	public static void main(String[] args) { 
		// Realiza un programa que liste elementos de un directorio introducido por pantalla. 

		//pedir ruta por teclado 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Introduce la ruta del directorio a mostrar:"); 
		String ruta = sc.nextLine(); 
		//objeto files con esa ruta 
		File ficheroDir = new File(ruta); 
		//existe? 
		if (ficheroDir.exists()) { 
			//obtener contenido 
			File[] arrayMostrar = ficheroDir.listFiles(); // ficheroDir.listFiles() esto te tira un array de objetos. no puedes hacer print y ya 
			for (int i = 0; i < arrayMostrar.length; i++) { 
				System.out.println(arrayMostrar[i].getName()); 
			} 
		}else { 
			System.out.println("No existe el directorio que buscas"); 
		} 
		sc.close();
	} 
}