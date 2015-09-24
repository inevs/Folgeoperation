package de.itagile.golf.befehl;

import de.itagile.golf.Befehl;
import de.itagile.golf.Operation;
import de.itagile.golf.operation.Lochausgabe;
import de.itagile.golf.operation.Schlagzahlausgabe;
import de.itagile.golf.operation.Undo;

public class UndoBefehl implements Befehl {

	@Override
	public String kommando() {
		return "Undo";
	}

	@Override
	public String alias() {
		return "u";
	}

	@Override
	public Operation operation() {
		return new Undo(new Schlagzahlausgabe(new Lochausgabe()));
	}

	@Override
	public String beschreibung() {
		return "dann mache ich den letzten Befehl rückgängig.";
	}
}
