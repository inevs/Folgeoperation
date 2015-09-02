package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;
import util.SchlagFormatierer;

public class GesamtSchlagzahlAusgabe implements Operation {

	@Override
	public String fuehreAus(Scorecard scorecard) {
		int anzahlSchlaege = scorecard.gesamtAnzahlSchlaege();
		return "Du hast insgesamt " + anzahlSchlaege + " " + SchlagFormatierer.formatiereNachAnzahl(anzahlSchlaege) + " benötigt.";
	}

}
