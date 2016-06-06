package de.itagile.golf.operation;

import de.itagile.golf.Scorecard;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GesamtSchlagzahlAusgabeTest {

	private Scorecard scorecard;
	private GesamtSchlagzahlAusgabe ausgabe;

	@Before
	public void setUp() throws Exception {
		scorecard = mock(Scorecard.class);
		ausgabe = new GesamtSchlagzahlAusgabe();
	}

	@Test
	public void gibtDieGesamtzahlDerSchlägeAus() throws Exception {
		when(scorecard.gesamtAnzahlSchlaege()).thenReturn(42);
		assertThat(ausgabe.fuehreAus(scorecard), containsString("42 Schläge"));
	}

	@Test
	public void formatiertEinzahlKorrekt() throws Exception {
		when(scorecard.gesamtAnzahlSchlaege()).thenReturn(1);
		assertThat(ausgabe.fuehreAus(scorecard), containsString("1 Schlag"));
	}


}