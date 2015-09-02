package de.itagile.golf;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.de.Dann;
import cucumber.api.java.de.Wenn;

import static org.hamcrest.CoreMatchers.containsString;

public class NerdGolfTrackerStepdefs {
	
	private TrackerDriver tracker;

	public NerdGolfTrackerStepdefs(TrackerDriver tracker) {
		this.tracker = tracker;
	}

	@Before
    public void starteNeuesSpiel() {
        tracker.starte();
    }

	@After
    public void beendeTracker() {
        tracker.beende();
    }

	@Wenn("ich den NerdGolfTracker starte")
    public void starteNerdGolfTracker() {
        // nur da, um lesbarere Szenarien zu schreiben
    }

    @Wenn("^ich den NerdGolfTracker beende$")
    public void ich_den_NerdGolfTracker_beende() throws Throwable {
        tracker.gibEin("Beenden");
    }

    @Dann("^verabschiedet er sich$")
    public void verabschiedet_er_sich() throws Throwable {
        tracker.assertThatAntwort(containsString("Auf Wiedersehen!"));
    }
}
