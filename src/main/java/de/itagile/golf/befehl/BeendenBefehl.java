package de.itagile.golf.befehl;

import de.itagile.golf.Beenden;
import de.itagile.golf.Befehl;
import de.itagile.golf.Operation;

public class BeendenBefehl implements Befehl {

	@Override
	public String kommando() {
		return "Beenden";
	}

	@Override
	public Operation operation() {
		return new Beenden();
	}

	@Override
	public String beschreibung() {
		return "... dann beende ich mich.";
	}
}
