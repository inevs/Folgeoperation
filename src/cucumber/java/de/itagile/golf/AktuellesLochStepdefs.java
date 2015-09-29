package de.itagile.golf;

import static org.hamcrest.Matchers.containsString;

import cucumber.api.PendingException;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Wenn;

public class AktuellesLochStepdefs {

	private TrackerDriver tracker;

	public AktuellesLochStepdefs(TrackerDriver tracker) {
		this.tracker = tracker;
	}
	
	@Wenn("ich zum nächsten Loch gehe")
    public void geheZumNaechstenLoch() {
        tracker.gibEin("Nächstes Loch");
    }

	@Dann("bin ich auf dem (\\d+). Loch")
	public void pruefeAktuellesLoch(int erwartetesLoch) {
		pruefeLochAnzeige(erwartetesLoch);
		tracker.gibEin("Schlage Ball");
		pruefeLochAnzeige(erwartetesLoch);
	}

	@Dann("^habe ich (\\d+) Schläge auf dem (\\d+). Loch$")
	public void habe_ich_Schläge_auf_dem_Loch(int schlaege, int loch) throws Throwable {
		pruefeSchlagzahlAnzeige(schlaege);
		pruefeLochAnzeige(loch);
	}

	private void pruefeSchlagzahlAnzeige(int schlaege) {
		tracker.assertThatAntwort(containsString(String.format("%d Schläge", schlaege)));
	}

	private void pruefeLochAnzeige(int loch) {
		tracker.assertThatAntwort(containsString(String.format("%d. Loch", loch)));
	}
}
