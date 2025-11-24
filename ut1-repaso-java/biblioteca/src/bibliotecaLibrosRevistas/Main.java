package bibliotecaLibrosRevistas;

import java.util.Scanner;

public class Main {

	public static void gestionMenu() {
		Scanner sc = new Scanner(System.in);
		int opcion=0;
		do {
			System.out.println("****Menu****");
			System.out.println("Selecione una de las siguientes opciones:");
			System.out.println("1. Añadir Libro");
			System.out.println("2. Añadir Revista");
			System.out.println("3. ");
			System.out.println("4. ");
			System.out.println("0. Salir el programa");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				/*
				System.out.println("Vas a añadir un nuevo libro");
				System.out.println("Introduce: int isbn, String titulo, int añoPublicacion,boolean prestado");
				int isbn = sc.nextInt();
				String titulo = sc.nextLine();
				int añoPublicacion = sc.nextInt();
				Biblioteca.añadirLibro( isbn,  titulo,  añoPublicacion):
					System.out.println("libro añadido con exito :D");
					*/
					break;
			case 2:

				break;
			case 3:

				break;
			case 4:
				break;
			case 0:
				System.out.println("Saliendo del programa");

				break;

			default:
				System.out.println("Opcion no valida");
				break;
			}
		}while(opcion!=0);
		sc.close();
	}

	public static void main(String[] args) {
		gestionMenu();
	}

}
