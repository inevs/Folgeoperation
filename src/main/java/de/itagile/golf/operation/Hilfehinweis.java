package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class Hilfehinweis implements Operation {

	@Override
	public String fuehreAus(Scorecard scorecard) {
		return "Unbekannter Befehl. Gib 'Hilfe' ein um eine Liste möglicher Befehle zu erhalten.";
	}
}
