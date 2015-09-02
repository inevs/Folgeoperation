package util;

public class SchlagFormatierer {

	public static String formatiereNachAnzahl(int anzahlSchlaege) {
		return anzahlSchlaege == 1 ? "Schlag" : "Schläge";
	}
}
