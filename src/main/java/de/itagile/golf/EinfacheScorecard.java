package de.itagile.golf;

import java.util.HashMap;
import java.util.Map;

public class EinfacheScorecard implements Scorecard {

	private int aktuellesLoch = 0;

	private Map<Integer, Integer> loecher;

	public EinfacheScorecard() {
		loecher = new HashMap<>();
		loecher.put(0, 0);
	}

	public void erhoeheAnzahlSchlaege() {
		int anzahl = loecher.get(aktuellesLoch);
		anzahl++;
		loecher.put(aktuellesLoch, anzahl);
	}

	public void schliesseLochAb() {
		aktuellesLoch++;
		loecher.put(aktuellesLoch, 0);
	}

	public int anzahlSchlaege() {
		return loecher.get(aktuellesLoch);
	}

	public int aktuellesLoch() {
		return aktuellesLoch + 1;
	}

	public int gesamtAnzahlSchlaege() {
		int anzahl = 0;
		for (int i = 0; i <= aktuellesLoch; i++) {
			anzahl += loecher.get(i);
		}
		return anzahl;
	}

	public void reduziereAnzahlSchlaege() {
		int anzahl = loecher.get(aktuellesLoch);
		if (anzahl > 0) {
			anzahl--;
			loecher.put(aktuellesLoch, anzahl);
		}
	}

	public int anzahlSchlaegeFuerLoch(int loch) {
		return loecher.get(loch - 1);
	}

	public void geheLochZurueck() {
		if (aktuellesLoch > 0) {
			aktuellesLoch--;
		}
	}
}
