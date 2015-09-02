package de.itagile.golf;

import static org.hamcrest.Matchers.containsString;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Wenn;

public class HilfeStepdefs {
	
	private TrackerDriver tracker;

	public HilfeStepdefs(TrackerDriver tracker) {
		this.tracker = tracker;
	}
	
	@Wenn("ich die Hilfe aufrufe")
	public void rufeHilfeAuf() {
		tracker.gibEin("Hilfe");
	}
	
	@Dann("listet der NerdGolfTracker einen Eintrag zu (.*) auf")
	public void pruefeHilfeEintrag(String kommando) {
		tracker.assertThatAntwort(containsString(kommando));
	}

	@Wenn("^ich eine unbekannte Eingabe mache$")
	public void ich_eine_unbekannte_Eingabe_mache() throws Throwable {
		tracker.gibEin("unbekannter Befehl");
	}

	@Dann("^bekomme ich einen Hinweis auf die Hilfe$")
	public void bekomme_ich_einen_Hinweis_auf_die_Hilfe() throws Throwable {
		tracker.assertThatAntwort(containsString("Unbekannter Befehl. Gib 'Hilfe' ein um eine Liste möglicher Befehle zu erhalten."));
	}
}
