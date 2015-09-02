package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.Operation;
import de.itagile.golf.operation.GesamtSchlagzahlAusgabe;

public class ZwischenErgebnisBefehl implements Befehl {

	@Override
	public String kommando() {
		return "Zeige Zwischenergebnis";
	}

	@Override
	public String alias() {
		return "zz";
	}

	@Override
	public Operation operation() {
		return new GesamtSchlagzahlAusgabe();
	}

	@Override
	public String beschreibung() {
		return "dann zeige ich dir einen Zwischenstand";
	}
}
