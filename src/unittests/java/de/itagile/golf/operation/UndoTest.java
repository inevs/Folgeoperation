package de.itagile.golf.operation;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UndoTest {

	private Undo undo;
	private Scorecard scoreCard;
	private Operation folgeOperation;

	@Before
	public void setUp() throws Exception {
		folgeOperation = mock(Operation.class);
		undo = new Undo(folgeOperation);
		scoreCard = mock(Scorecard.class);
	}

	@Test
	public void reduziertDieAnzahlDerSchlaege() throws Exception {
		when(scoreCard.anzahlSchlaege()).thenReturn(1);
		undo.fuehreAus(scoreCard);
		verify(scoreCard).reduziereAnzahlSchlaege();
	}

	@Test
	public void gibtAusgabeDerFolgeoperationMitAus() throws Exception {
		when(folgeOperation.fuehreAus(scoreCard)).thenReturn("FolgeOperationausgabe");
		assertThat(undo.fuehreAus(scoreCard), containsString("FolgeOperationausgabe"));
	}

	@Test
	public void reduziertAktuellesLochWennKeinBallGeschlagen() throws Exception {
		when(scoreCard.anzahlSchlaege()).thenReturn(0);
		undo.fuehreAus(scoreCard);
		verify(scoreCard).geheLochZurueck();
	}


}
