package de.itagile.golf;

public interface Befehl {

	String kommando();

	String alias();

	Operation operation();

	String beschreibung();

}
