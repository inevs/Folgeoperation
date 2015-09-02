package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;
import util.SchlagFormatierer;

public class Schlagzahlausgabe implements Operation {

	private Operation folgeoperation;

	public Schlagzahlausgabe(Operation folgeoperation) {
		this.folgeoperation = folgeoperation;
	}

	@Override
	public String fuehreAus(Scorecard scorecard) {
		int anzahlSchlaege = scorecard.anzahlSchlaege();
		String vorlage = "Du hast %d " + SchlagFormatierer.formatiereNachAnzahl(anzahlSchlaege) + " %s";
		return String.format(vorlage, anzahlSchlaege, folgeoperation.fuehreAus(scorecard));
	}
}
