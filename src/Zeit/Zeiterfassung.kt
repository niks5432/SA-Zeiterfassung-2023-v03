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
                    startZeit = startZeit.withSecond(0)
                    zustandZeitmessung ++
                    println("Startzeit $startZeit")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Startzeit:\t\t$startZeit")

                }

                4 -> {
                    endZeit = LocalTime.now()
                    endZeit = endZeit.withNano(0)
                    endZeit = endZeit.withSecond(0)

                    zustandZeitmessung ++
                    println("Endzeit $endZeit")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Endzeit:\t\t$endZeit" )

                }

                2 -> {
                    pausenZeit = LocalTime.now()
                    pausenZeit = pausenZeit.withNano(0)
                    pausenZeit = pausenZeit.withSecond(0)
                    zustandZeitmessung ++
                    println("pausenzeitBeginn $pausenZeit")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Pause beginn:\t$pausenZeit" )

                }

                3 -> {
                    pausenzeitEnde = LocalTime.now()
                    pausenzeitEnde = pausenzeitEnde.withNano(0)
                    pausenzeitEnde = pausenzeitEnde.withSecond(0)

                    zustandZeitmessung ++
                    println("pausenzeitEnde $pausenzeitEnde")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Pause ende:\t$pausenzeitEnde" )
                }
            }

        if (zustandZeitmessung >= 4) {
            // Deklaration und ausrechnen der Arbeits & Pausenzeit
            var arbeitsZeit = Duration.between(endZeit, startZeit)
            var pausenZeit = Duration.between(pausenZeit, pausenzeitEnde)
            val formatiertepausenZeit = formatiereZeitArchiv(pausenZeit)
            val formatiertearbeitsZeit =formatiereZeitArchiv(arbeitsZeit)


            // Mit ${} kan in println eine funktion aufgerufen werden
            println("Arbeitszeit: ${formatiereZeit(arbeitsZeit)} | Pausenzeit: ${formatiereZeit(pausenZeit)}")

            val zeiten = mutableListOf(startZeit, endZeit, formatiereZeit(pausenZeit))

            println(zeiten)
            GuiAusgabeFenster.ausgabeTextHinzufügen("Arbeitszeit: $formatiertearbeitsZeit | Pausenzeit: $formatiertepausenZeit" )
            eintragZeitDB(userId, startZeit, endZeit, formatiereZeit(pausenZeit), zustandid = 1, abwesenheitsid = 4)

//            berichteintragAbfrage()
            val stage = Stage()
            GuiBericht.start(stage)
            zustandZeitmessung = 0
        }
    }
}