# Requirements

* Java 7
* Gradle 2.0

Known to work

* Java 8
* Gradle 2.12


# Folgeoperation

Übung für ein größeres Refactoring. Fast jede Operation hat eine Folgeoperation. Wenn die Operation ausgeführt wird, so wird dann auch die Folgeoperation ausgeführt. Diese Struktur erzeugt unnötig aufwändigen Code in den Operationen. So muss z.B. jede Operation wissen, wenn sie eine Folgeoperation hat, dass diese auch entsprechend aufgerufen werden soll.

# Refactoring

Idee: Neue Struktur ist nicht mehr die Verkettung von Operationen über Folgeoperation. Statt dessen soll das Composite-Pattern eingesetzt werden. Erstelle eine neue Klasse (zB KombinierteOperation), welche das Interface Operation implementiert. Diese enthält alle Operationen eines bestimmten Befehls und sorgt dafür, dass diese in der richtigen Reihenfolge ausgeführt werden. 

Auch große Refactorings lassen sich in kleinere Schritte aufteilen. Stelle den Code schrittweise um. Lasse nach jedem Schritt alle Tests laufen und prüfe, dass noch alles funktioniert.