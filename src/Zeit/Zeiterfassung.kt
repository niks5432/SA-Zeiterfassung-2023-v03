import GuiElemente.GuiBericht
import GuiElemente.GuiAusgabeFenster
import javafx.stage.Stage
import java.time.Duration
import java.time.LocalTime

class Zeiterfassung() {
    val userid         = 0
    var startZeit      = LocalTime.now()
    var endZeit        = LocalTime.now()
    var pausenZeit     = LocalTime.now()
    var pausenzeitEnde = LocalTime.now()

    fun zeitEruieren(buttonStart: Int) {
        // Variablen Deklaration
        var userId = userIdString.toInt()

            when (buttonStart) {
                1 -> {
                    startZeit = LocalTime.now()
                    startZeit = startZeit.withNano(0)
                    zustandZeitmessung ++
                    println("Startzeit $startZeit")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Startzeit: $startZeit")

                }

                4 -> {
                    endZeit = LocalTime.now()
                    endZeit = endZeit.withNano(0)
                    zustandZeitmessung ++
                    println("Endzeit $endZeit")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Endzeit: $endZeit" )

                }

                2 -> {
                    pausenZeit = LocalTime.now()
                    pausenZeit = pausenZeit.withNano(0)
                    zustandZeitmessung ++
                    println("pausenzeitBeginn $pausenZeit")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Pause beginn: $pausenZeit" )

                }

                3 -> {
                    pausenzeitEnde = LocalTime.now()
                    pausenzeitEnde = pausenzeitEnde.withNano(0)
                    zustandZeitmessung ++
                    println("pausenzeitEnde $pausenzeitEnde")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Pause ende: $pausenzeitEnde" )
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
            GuiAusgabeFenster.ausgabeTextHinzufügen("Arbeitszeit: $arbeitsZeit | Pausenzeit: $pausenZeit" )

//            berichteintragAbfrage()
            val stage = Stage()
            GuiBericht.start(stage)
            zustandZeitmessung = 0
        }
    }
}