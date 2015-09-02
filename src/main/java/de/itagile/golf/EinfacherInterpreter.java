package de.itagile.golf;

import de.itagile.golf.befehl.BeendenBefehl;
import de.itagile.golf.operation.Hilfehinweis;
import de.itagile.golf.operation.Schlag;

import java.util.HashMap;
import java.util.Map;


public class EinfacherInterpreter implements Interpreter {

	private final Schlag defaultOperation;
	private Map<String, Operation> operationen = new HashMap<>();
	private String letzterBefehl = "";

	public EinfacherInterpreter(Schlag defaultOperation) {
		for (Befehl befehl : new BefehleSammler().sammle()) {
			operationen.put(befehl.kommando(), befehl.operation());
			operationen.put(befehl.alias(), befehl.operation());
		}
		this.defaultOperation = defaultOperation;
	}

	@Override
	public Operation interpretiere(String string) {
		letzterBefehl = string;
		if (string.isEmpty()) {
			return defaultOperation;
		}
		Operation operation = operationen.get(string);
		if (operation == null) {
			return new Hilfehinweis();
		}
		return operation;
	}

	@Override
	public boolean sollBeenden() {
		return letzterBefehl.equals(new BeendenBefehl().kommando()) || letzterBefehl.equals(new BeendenBefehl().alias());
	}
}
