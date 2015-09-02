package de.itagile.golf.operation;

import de.itagile.golf.Scorecard;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class HilfehinweisTest {

	@Test
	public void gibtHilfehinweisAus() throws Exception {
		Scorecard scorecard = mock(Scorecard.class);
		Hilfehinweis hilfehinweis = new Hilfehinweis();
		String ausgabe = hilfehinweis.fuehreAus(scorecard);
		assertThat(ausgabe, containsString("Unbekannter Befehl."));
		assertThat(ausgabe, containsString("'Hilfe'"));
	}

}