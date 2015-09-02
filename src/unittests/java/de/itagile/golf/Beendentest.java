package de.itagile.golf;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BeendenTest {

	private EinfacherInterpreter interpreter;

	@Before
	public void setUp() throws Exception {
		interpreter = new EinfacherInterpreter();
	}

	@Test
	public void beendetSichBeiNormalenBefehlenNicht() throws Exception {
		interpreter.interpretiere("Hilfe");
		assertThat(interpreter.sollBeenden(), is(false));
	}

	@Test
	public void beendetSichBeiBeendenBefehl() throws Exception {
		interpreter.interpretiere("Beenden");
		assertThat(interpreter.sollBeenden(), is(true));
	}

	@Test
	public void beendetSichBeiBeendenAlias() throws Exception {
		interpreter.interpretiere("b");
		assertThat(interpreter.sollBeenden(), is(true));
	}



}
