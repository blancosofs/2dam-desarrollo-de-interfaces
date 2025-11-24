package extraerPalabra;

import java.io.IOException;
import java.util.Scanner;

//esto rompia por el module info
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class TraductorLibrerias2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su palabra a traducir:");
		String esp= sc.next();
		
		String web = "https://www.spanishdict.com/translate/";
		
		String newWeb=web.concat(esp);
	
		//se usa como la Math.random
		Document doc = Jsoup.connect(newWeb).get();
		Element palabra = doc.select("div#quickdef1-es a.tCur1iYh").get(0);
		
		String resultado = palabra.html().toUpperCase();
		System.out.println("Traduccion: "+resultado+"   :D");
		sc.close();
	}
	

}
