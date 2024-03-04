
object ZeitAbfrage {
    val heutigeZeit = Zeiterfassung()                           // Objekt erstellen
    fun zeiterfassungAbfrage(state: Boolean) {

        if (state) {                                            // Abfrage welcher Zustand anliegt
            when (zustandZeitmessung) {
                0 -> heutigeZeit.zeitEruieren(1)      // Ausführen je nach Zustand der Globalen variable
                2 -> heutigeZeit.zeitEruieren(3)
            }
        } else {
            when (zustandZeitmessung) {
                1 -> heutigeZeit.zeitEruieren(2)
                3 -> heutigeZeit.zeitEruieren(4)
            }
        }
    }

}