package de.itagile.golf;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import de.itagile.golf.befehl.SchlagBefehl;
import de.itagile.golf.operation.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EinfacherIntepreterTest {

	private Interpreter interpreter = new EinfacherInterpreter(new SchlagBefehl().operation());
	private final String befehl;
	private final Class<? super Operation> operation;

	public EinfacherIntepreterTest(String befehl, Class<? super Operation> operation) {
		this.befehl = befehl;
		this.operation = operation;
	}
	
	@Parameters
	public static List<Object[]> parameters() {
		Object[][] testData = new Object[][] {
				{"Schlage Ball", Schlag.class},
				{"", Schlag.class},
				{"Nächstes Loch", Lochwechsel.class},
				{"nl", Lochwechsel.class},
				{"Hilfe", Hilfe.class},
				{"Unbekannte Eingabe", Hilfehinweis.class},
				{"Beenden", Beenden.class},
				{"Zeige Zwischenergebnis", GesamtSchlagzahlAusgabe.class},
				{"Undo", Undo.class}
				};
		return Arrays.asList(testData);
	}
	
	@Test
	public void interpretiertBefehle() throws Exception {
		assertThat(interpreter.interpretiere(befehl), isA(operation));
	}


}
