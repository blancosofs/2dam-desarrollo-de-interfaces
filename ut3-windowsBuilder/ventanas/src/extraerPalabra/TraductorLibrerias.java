package extraerPalabra;

import java.io.IOException;

//esto rompia por el module info
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class TraductorLibrerias {

	public static void main(String[] args) throws IOException {
		String web = "https://www.spanishdict.com/translate/gato";
		System.out.println("ESPAÑOL:"+"GATO");
		
		//se usa como la Math.random
		Document doc = Jsoup.connect(web).get();
		Element palabra = doc.select("div#quickdef1-es a.tCur1iYh").get(0);
		
		String resultado = palabra.html().toUpperCase();
		System.out.println("INGLES:"+resultado+"   :D");
	}
	

}
