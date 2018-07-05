package Vinateria;

import java.io.IOException;
import java.util.Properties;

public class Idioma extends Properties{
	private static final long serialVersionUID = 1L;
	private String idiomaActual;
	public Idioma(String idioma) {
		switch (idioma) {
		case "Espa�ol":
			getProperties("espa�ol.properties");
			break;
		case "Ingles":
			getProperties("ingles.properties");
			break;
		default:
			getProperties("espa�ol.properties");
			break;
		}
	}
	
	private void getProperties(String idioma) {
		try {
			System.out.println(getClass().getResourceAsStream("res\\"+idioma));
			this.load(getClass().getResourceAsStream("res\\"+idioma));
		} catch (IOException e) {
			System.out.println("no existe");
		}
	}

}
