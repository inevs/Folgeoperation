package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.Operation;
import de.itagile.golf.BefehleSammler;
import de.itagile.golf.operation.Hilfe;

public class HilfeBefehl implements Befehl {

	public String kommando() {
		return "Hilfe";
	}

	@Override
	public String alias() {
		return "h";
	}

	public Operation operation() {
		return new Hilfe(new BefehleSammler());
	}

	public String beschreibung() {
		return "dann zeige ich Dir das hier";
	}

}
