import GuiElemente.GuiBericht
import GuiElemente.GuiAusgabeFenster
import javafx.stage.Stage
import java.time.Duration
import java.time.LocalTime

class Zeiterfassung() {
    var userid              = 0                                                                // Attribute für das Verwenden der Klasse
    var startZeit           = LocalTime.now()
    var endZeit             = LocalTime.now()
    var pausenZeitBeginn    = LocalTime.now()
    var pausenzeitEnde      = LocalTime.now()

    fun zeitEruieren(buttonStart: Int) {
        userid = userIdString.toInt()

            when (buttonStart) {                                                               // when Anweisung um die momentan gewünschte zeit abzufragen
                1 -> {
                    startZeit = LocalTime.now()                                                // Überschreiben der variable mit der Aktuellen Zeit
                    startZeit = startZeit.withNano(0)                             // Entfernen der nanosekunden
//                    startZeit = startZeit.withSecond(0)
                    zustandZeitmessung ++                                                      // addieren mit 1
                    println("Startzeit $startZeit")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Startzeit:\t\t$startZeit")   // Ausgabe aufgezeichnete Zeit im Ausgabe Fenster
                }
                2 -> {
                    pausenZeitBeginn = LocalTime.now()
                    pausenZeitBeginn = pausenZeitBeginn.withNano(0)
                    pausenZeitBeginn = pausenZeitBeginn.withSecond(0)
                    zustandZeitmessung ++
                    println("pausenzeitBeginn $pausenZeitBeginn")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Pause beginn:\t$pausenZeitBeginn" )
                }
                3 -> {
                    pausenzeitEnde = LocalTime.now()
                    pausenzeitEnde = pausenzeitEnde.withNano(0)
                    pausenzeitEnde = pausenzeitEnde.withSecond(0)
                    zustandZeitmessung ++
                    println("pausenzeitEnde $pausenzeitEnde")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Pause ende:\t$pausenzeitEnde" )
                }
                4 -> {
                    endZeit = LocalTime.now()
                    endZeit = endZeit.withNano(0)
                    endZeit = endZeit.withSecond(0)

                    zustandZeitmessung ++
                    println("Endzeit $endZeit")
                    GuiAusgabeFenster.ausgabeTextHinzufügen("Endzeit:\t\t$endZeit" )
                }
            }

        if (zustandZeitmessung == 4) {
            // Deklaration und ausrechnen der Arbeits & Pausenzeit
            var arbeitsZeit = Duration.between(startZeit, endZeit)                                                             // Ausrechen der beiden Differenz mit den aufgezeichneten Zeiten (Arbeitszeit und Pausenzeit)
            val pausenZeit = Duration.between(pausenZeitBeginn, pausenzeitEnde)
            arbeitsZeit -= pausenZeit                                                                                                   // Korrigieren der aktuellen Arbeitszeit
            val formatiertepausenZeit = formatiereZeit(pausenZeit)                                                               // Formatieren der aktuellen Zeuiten
            val formatiertearbeitsZeit =formatiereZeit(arbeitsZeit)
            // Mit ${} kan in println eine funktion aufgerufen werden
            println("Arbeitszeit: ${formatiereZeit(arbeitsZeit)} | Pausenzeit: $formatiertepausenZeit")
            GuiAusgabeFenster.ausgabeTextHinzufügen("Arbeitszeit: $formatiertearbeitsZeit | Pausenzeit: $formatiertepausenZeit" )  // Augabe im Ausgabefenster
            eintragZeitDB(userid, startZeit, endZeit, formatiereZeit(pausenZeit), zustandid = 1, abwesenheitsid = 4)                    // eintrag der ermittelten Zeiten in die Datenbank
            val stage = Stage()                                                                                                         // Erstellen einer Neune Stage
            GuiBericht.start(stage)                                                                                                     // Ausführen eines neune Gui Fensters
            zustandZeitmessung = 0                                                                                                      // zurücksetzen der Variable
        }
    }
}