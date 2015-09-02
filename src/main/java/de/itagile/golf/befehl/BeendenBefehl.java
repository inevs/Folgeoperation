package de.itagile.golf.befehl;

import de.itagile.golf.Beenden;
import de.itagile.golf.Befehl;
import de.itagile.golf.operation.GesamtSchlagzahlAusgabe;

public class BeendenBefehl implements Befehl {

	@Override
	public String kommando() {
		return "Beenden";
	}

	@Override
	public de.itagile.golf.Operation operation() {
		return new Beenden(new GesamtSchlagzahlAusgabe());
	}

	@Override
	public String beschreibung() {
		return "dann beende ich mich.";
	}
}
