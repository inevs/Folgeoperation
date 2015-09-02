package de.itagile.golf.operation;

import de.itagile.golf.Beenden;
import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BeendenOperationTest {

	@Test
	public void fuehrtFolgeOperationAus() throws Exception {
		Operation folgeOperation = mock(Operation.class);
		Beenden beenden = new Beenden(folgeOperation);
		Scorecard scoreCard = mock(Scorecard.class);
		beenden.fuehreAus(scoreCard);
		verify(folgeOperation).fuehreAus(scoreCard);
	}

}
