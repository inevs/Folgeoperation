# language: de

  Funktionalität: Undo

    Szenario: Nach einem Schlag
      Angenommen ich habe den Ball auf dem aktuellen Loch 5 mal geschlagen
      Wenn ich den letzten Befehl rückgängig mache
      Dann habe ich 4 Schläge auf dem aktuellen Loch

    Szenario: Nach einem Lochwechsel
      Angenommen ich habe 4 Bälle auf dem 1. Loch gespielt
      Wenn ich zum nächsten Loch gehe
      Und ich den letzten Befehl rückgängig mache
      Dann habe ich 4 Schläge auf dem 1. Loch
