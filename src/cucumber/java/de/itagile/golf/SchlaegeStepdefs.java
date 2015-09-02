package de.itagile.golf;

import static java.lang.String.valueOf;
import static org.hamcrest.Matchers.containsString;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.de.Angenommen;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Wenn;

import java.util.List;

public class SchlaegeStepdefs {

	private TrackerDriver tracker;
	private int schlaege;

    public class Lochergebnis {
        int loch;
        int schläge;
    }

	public SchlaegeStepdefs(TrackerDriver tracker) {
		this.tracker = tracker;
	}
	
	@Wenn("ich den Ball (\\d+)-mal schlage")
    public void schlageBall(int schlaege) {
        this.schlaege = schlaege;
        while (schlaege-- > 0) {
            tracker.gibEin("Schlage Ball");
        }
    }
	
	@Wenn("ich auf einem Loch gespielt habe")
    public void spieleAufEinemLochUndGeheWeiter() {
        tracker.gibEin("Schlage Ball");
        tracker.gibEin("Nächstes Loch");
    }
	
	@Dann("zählt der NerdGolfTracker auch so viele Schläge")
    public void pruefeSchlaege() {
        tracker.assertThatAntwort(containsString(valueOf(schlaege)));
    }
	
	@Dann("zählen die Schläge auf dem nächsten Loch wieder von 0 an")
	public void pruefeSchlaegeZaehlen() {
        tracker.gibEin("Schlage Ball");
		tracker.assertThatAntwort(containsString(valueOf(1)));
	}

    @Angenommen("^ich habe wie folgt gespielt$")
    public void ich_habe_wie_folgt_gespielt(List<Lochergebnis> spielstand) throws Throwable {
        for (Lochergebnis lochergebnis : spielstand) {
            schlageBall(lochergebnis.schläge);
        }
        tracker.gibEin("Nächstes Loch");
    }

    @Dann("^zeigt er mir die die Gesamtzahl aller Schläge an$")
    public void zeigt_er_mir_die_die_Gesamtzahl_aller_Schläge_an() throws Throwable {
        tracker.assertThatAntwort(containsString("9 Schläge benötigt"));
    }
}
