import `- Archiv`.guiMenue
import Bericht.berichteintragAbfrage
import Zeit.GuiZeit
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

open class Zeiterfassung() {
    val userid         = 0
    var startZeit      = LocalTime.now()
    var endZeit        = LocalTime.now()
    var pausenZeit     = LocalTime.now()
    var pausenzeitEnde = LocalTime.now()
//     var buttonStart    = 0

    fun zeitEruieren(buttonStart: Int) {
        // Variablen Deklaration
        var userId = userIdString.toInt()
        var aktuelleZeile = 0

            when (buttonStart) {
                1 -> {
                    startZeit = LocalTime.now()
                    startZeit = startZeit.withNano(0)
                    zustandZeitmessung ++
                    println("Startzeit $startZeit")
                    GuiZeit.textWeitergabe("Startzeit: $startZeit")

                }

                4 -> {
                    endZeit = LocalTime.now()
                    endZeit = endZeit.withNano(0)
                    zustandZeitmessung ++
                    println("Endzeit $endZeit")
                    GuiZeit.textWeitergabe("Endzeit: $endZeit" )

                }

                2 -> {
                    pausenZeit = LocalTime.now()
                    pausenZeit = pausenZeit.withNano(0)
                    zustandZeitmessung ++
                    println("pausenzeitBeginn $pausenZeit")
                    GuiZeit.textWeitergabe("Pause beginn: $pausenZeit" )

                }

                3 -> {
                    pausenzeitEnde = LocalTime.now()
                    pausenzeitEnde = pausenzeitEnde.withNano(0)
                    zustandZeitmessung ++
                    println("pausenzeitEnde $pausenzeitEnde")
                    GuiZeit.textWeitergabe("Pause ende: $pausenzeitEnde" )
                }
            }

        if (zustandZeitmessung >= 4) {
            // Deklaration und ausrechnen der Arbeits & Pausenzeit
            var arbeitsZeit = Duration.between(startZeit, endZeit)
            var pausenZeit = Duration.between(pausenZeit, pausenzeitEnde)

            // Mit ${} kan in println eine funktion aufgerufen werden
            println("Arbeitszeit: ${formatiereZeit(arbeitsZeit)} | Pausenzeit: ${formatiereZeit(pausenZeit)}")

            val zeiten = mutableListOf(startZeit, endZeit, formatiereZeit(pausenZeit))

            println(zeiten)

            eintragZeitDB(userId, startZeit, endZeit, formatiereZeit(pausenZeit), zustandid = 1, abwesenheitsid = 4)
            GuiZeit.textWeitergabe("Arbeitszeit: $arbeitsZeit | Pausenzeit: $pausenZeit" )

            berichteintragAbfrage()
            zustandZeitmessung = 0
        }
    }
}