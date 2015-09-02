package de.itagile.golf;

public class EinfacheScorecard implements Scorecard {

	private int aktuellesLoch = 1;
	private int anzahlSchlaege;
	private int gesamtAnzahlSchlaege = 0;

	public void erhoeheAnzahlSchlaege() {
		anzahlSchlaege++;
		gesamtAnzahlSchlaege++;
	}

	public void schliesseLochAb() {
		anzahlSchlaege = 0;
		aktuellesLoch++;
	}

	public int anzahlSchlaege() {
		return anzahlSchlaege;
	}

	public int aktuellesLoch() {
		return aktuellesLoch;
	}

	public int gesamtAnzahlSchlaege() {
		return gesamtAnzahlSchlaege;
	}
}
