# language: de

  Funktionalität: Gesamtschläge zählen

    Szenario: Bei Beenden
      Angenommen ich habe wie folgt gespielt
      | Loch | Schläge |
      | 1    | 4       |
      | 2    | 5       |
      Wenn ich den NerdGolfTracker beende
      Dann zeigt er mir die die Gesamtzahl aller Schläge an

    Szenario: Zwischenergebnis anzeigen
      Angenommen ich habe wie folgt gespielt
        | Loch | Schläge |
        | 1    | 4       |
        | 2    | 5       |
      Wenn ich den Zwischenstand anzeige
      Dann zeigt er mir die die Gesamtzahl aller Schläge an
