package de.itagile.golf;

import de.itagile.golf.befehl.BeendenBefehl;
import de.itagile.golf.operation.Hilfehinweis;

import java.util.HashMap;
import java.util.Map;


public class EinfacherInterpreter implements Interpreter {

	private Map<String, Operation> operationen = new HashMap<>();
	private String letzterBefehl = "";

	public EinfacherInterpreter() {
		for (Befehl befehl : new BefehleSammler().sammle()) {
			operationen.put(befehl.kommando(), befehl.operation());
		}
	}

	@Override
	public Operation interpretiere(String string) {
		letzterBefehl = string;
		Operation operation = operationen.get(string);
		if (operation == null) {
			return new Hilfehinweis();
		}
		return operation;
	}

	@Override
	public boolean sollBeenden() {
		return letzterBefehl.equals(new BeendenBefehl().kommando());
	}
}
