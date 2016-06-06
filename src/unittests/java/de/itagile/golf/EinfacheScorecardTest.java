package de.itagile.golf;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class EinfacheScorecardTest {

	private Scorecard scorecard = new EinfacheScorecard();
	
	@Test
	public void inkrementiertSchlagzahlEinmal() throws Exception {
		scorecard.erhoeheAnzahlSchlaege();
		assertThat(scorecard.anzahlSchlaege(), is(1));
	}
	
	@Test
	public void inkrementiertSchlagzahlMehrmals() throws Exception {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.erhoeheAnzahlSchlaege();
		assertThat(scorecard.anzahlSchlaege(), is(2));
	}
	
	@Test
	public void setztSchlagzahlZurueck() throws Exception {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.schliesseLochAb();
		assertThat(scorecard.anzahlSchlaege(), is(0));
	}
	
	@Test
	public void hatInitialErstesLoch() throws Exception {
		assertThat(scorecard.aktuellesLoch(), is(1));
	}
	
	@Test
	public void zaehltAktuellesLoch() throws Exception {
		scorecard.schliesseLochAb();
		assertThat(scorecard.aktuellesLoch(), is(2));
	}

	@Test
	public void zaehltUeberAlleLoecher() throws Exception {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.schliesseLochAb();
		scorecard.erhoeheAnzahlSchlaege();
		assertThat(scorecard.gesamtAnzahlSchlaege(), is(2));
	}

	@Test
	public void reduziertAnzahlSchlaege() throws Exception {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.reduziereAnzahlSchlaege();
		assertThat(scorecard.anzahlSchlaege(), is(0));
	}

	@Test
	public void reduziertGesamtanzahlSchlaege() throws Exception {
		scorecard.erhoeheAnzahlSchlaege();
		scorecard.reduziereAnzahlSchlaege();
		assertThat(scorecard.gesamtAnzahlSchlaege(), is(0));
	}

	@Test
	public void reduziertSchlaegeNichtUnterNull() throws Exception {
		scorecard.reduziereAnzahlSchlaege();
		assertThat(scorecard.anzahlSchlaege(), is(0));
		assertThat(scorecard.gesamtAnzahlSchlaege(), is(0));
	}

	@Test
	public void merktSichSchlaegeAufJedemLoch() throws Exception {
		schlageBall(3);
		scorecard.schliesseLochAb();
		schlageBall(2);
		assertThat(scorecard.anzahlSchlaegeFuerLoch(1), is(3));
	}

	@Test
	public void stelltSchlaegeVonLetztemLochWiederHer() throws Exception {
		schlageBall(3);
		scorecard.schliesseLochAb();
		scorecard.geheLochZurueck();
		assertThat(scorecard.anzahlSchlaege(), is(3));
	}

	@Test
	public void gehtNurBisLoch0Zurueck() throws Exception {
		scorecard.geheLochZurueck();
		assertThat(scorecard.anzahlSchlaege(), is(0));
	}



	private void schlageBall(int anzahl) {
		for (int i=0; i<anzahl; i++) {
			scorecard.erhoeheAnzahlSchlaege();
		}
	}


}
