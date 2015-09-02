package de.itagile.golf;

public class Beenden implements Operation {

	private Operation folgeOperation;

	public Beenden(Operation folgeOperation) {
		this.folgeOperation = folgeOperation;
	}

	@Override
	public String fuehreAus(Scorecard scorecard) {
		return "Auf Wiedersehen! " + folgeOperation.fuehreAus(scorecard);
	}


}
