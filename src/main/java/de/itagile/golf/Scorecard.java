package de.itagile.golf;

public interface Scorecard {

	void erhoeheAnzahlSchlaege();

	int anzahlSchlaege();

	void schliesseLochAb();

	int aktuellesLoch();

	int gesamtAnzahlSchlaege();

	void reduziereAnzahlSchlaege();

	int anzahlSchlaegeFuerLoch(int loch);

	void geheLochZurueck();
}