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
		if (scorecard.anzahlSchlaege() == 0) {
			scorecard.geheLochZurueck();
		} else {
			scorecard.reduziereAnzahlSchlaege();
		}
		return folgeOperation.fuehreAus(scorecard);
	}
}
