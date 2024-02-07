import Bericht.berichteintragAbfrage
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

class Zeiterfassung {
     val userid         = 0
     var startZeit      = LocalTime.now()
     var endZeit        = LocalTime.now()
     var pausenZeit     = LocalTime.now()
     var pausenzeitEnde = LocalTime.now()
     var buttonStart    = 0

    fun zeitEruieren() {
        // Variablen Deklaration
        var userId           = userIdString.toInt()

        // Schleife um die Zeiten für den heutigen Ta zu eruieren
        while (buttonStart <= 3) {
            // Einlesen welches ereigniss gerade stattfindet
            if (buttonStart >= 2) {
                println("Badge Scanen")
                buttonStart = readln().toInt()
            }
            // Bedingungen die ausgeführt werden nach dem Einlesen des ereignisses
            when (buttonStart) {
                1 -> {
                    startZeit = LocalTime.now()
                    startZeit = startZeit.withNano(0)

                    println("Startzeit $startZeit")
                    buttonStart++
                }

                4 -> {
                    endZeit = LocalTime.now()
                    endZeit = endZeit.withNano(0)

                    println("Endzeit $endZeit")
                }

                2 -> {
                    pausenZeit = LocalTime.now()
                    pausenZeit = pausenZeit.withNano(0)

                    println("pausenzeitBeginn $pausenZeit")
                }

                3 -> {
                    pausenzeitEnde = LocalTime.now()
                    pausenzeitEnde = pausenzeitEnde.withNano(0)

                    println("pausenzeitEnde $pausenzeitEnde")
                }
            }
        }

        // Deklaration und ausrechnen der Arbeits & Pausenzeit
        var arbeitsZeit = Duration.between(startZeit,endZeit)
        var pausenZeit  = Duration.between(pausenZeit,pausenzeitEnde)

        // Mit ${} kan in println eine funktion aufgerufen werden
        println("Arbeitszeit: ${formatiereZeit(arbeitsZeit)} | Pausenzeit: ${formatiereZeit(pausenZeit)}")

        val zeiten = mutableListOf(startZeit, endZeit, formatiereZeit(pausenZeit))

        println(zeiten)

        eintragZeitDB(userId, startZeit, endZeit, formatiereZeit(pausenZeit), zustandid = 1, abwesenheitsid = 4)

        berichteintragAbfrage()
    }
}