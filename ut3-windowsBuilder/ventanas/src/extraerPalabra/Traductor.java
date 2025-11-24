package extraerPalabra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Traductor {

	public static void main(String[] args) throws IOException {
		URL direccUrl = new URL("https://www.spanishdict.com/translate/alfombra");

		String html = obtenerHTML(direccUrl);

		String palabraTraducida = cortarHTML(html);

		System.out.println(palabraTraducida);
	}

	private static String obtenerHTML(URL direccUrl) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(direccUrl.openStream())); // abres comunicacion
		String inputLine, codigo = "";

		while ((inputLine = in.readLine()) != null) { // lees hasta el final
			codigo += inputLine; // te lo cuardas
		}
		in.close();
		return codigo; // va al html
	}

	private static String cortarHTML(String html) {
		//?langFrom=en" class="tCur1iYh"
		int inicio,puntoFinal2,puntoFinal1;
		
		//el index of es la primera vez que aparezca algo
		inicio=html.indexOf("?langFrom=en\" class=\"tCur1iYh\">"); //34caracteres
		
		//opción1
			//	crear una subcarpeta y buscar desde ahi
		String trozo = html.substring(inicio);
		puntoFinal1=trozo.indexOf("</a>");
		
		String resultado1=html.substring(inicio+31,inicio+puntoFinal1);
		
		//opción2
			//	crear una subcarpeta y buscar desde ahi
		puntoFinal2=html.indexOf("</a>",inicio);
		String resultado2=html.substring(inicio+31,puntoFinal2);
		
		return resultado1;
		//return resultado2;
	}

}
