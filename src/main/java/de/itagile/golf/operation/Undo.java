package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

public class Undo implements Operation {

	private Operation folgeOperation;

	public Undo(Operation folgeOperation) {
		this.folgeOperation = folgeOperation;
	}

	@Override
	public String fuehreAus(Scorecard scorecard) {
		scorecard.reduziereAnzahlSchlaege();
		return folgeOperation.fuehreAus(scorecard);
	}
}
