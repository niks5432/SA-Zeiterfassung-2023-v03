import javafx.stage.Stage
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import kotlin.math.absoluteValue


// Allgemeine Funktionen


fun splitString(string: String): List<String> {                 // Trennt einen String  alles mit einen Leerzeichen und gibt es in der List stirng zurück
    val string = userDaten.split(" ")
    return string
}

fun formatiereZeit (dauer: Duration): String {                  // Formatiert Durration werte
    val stunden = dauer.toHours()
    val minuten = dauer.toMinutes()
    val sekunden = dauer.toSeconds()

    return "$stunden:$minuten:$sekunden"                        // rückgabe der formatierten Werte
}

fun effektivearbeitsstundenamtag(startzeitelem: String, endzeitelem: String): Duration {        // Von Entwickler Herr Luca
    val startzeitElemParced = LocalTime.parse(startzeitelem)
    val endzeitElemParced = LocalTime.parse(endzeitelem)
    val arbeitZeit = Duration.between(startzeitElemParced, endzeitElemParced)
    return arbeitZeit
}

fun minusuberstunden(startzeitelem: String, endzeitelem: String): Duration {                   // Von Entwickler Herr Luca
    val startzeitElemParced = LocalTime.parse(startzeitelem)
    val endzeitElemParced = LocalTime.parse(endzeitelem)
    val arbeitZeit = Duration.between(startzeitElemParced, endzeitElemParced)
    val sollStundenAmTag = Duration.ofHours(8)

    return if (arbeitZeit < sollStundenAmTag) {
        // Berechnung der Minusstunden
        sollStundenAmTag.minus(arbeitZeit).negated()
    } else {
        // Berechnung der Überstunden, falls vorhanden
        val ueberstundenDauer = arbeitZeit.minus(sollStundenAmTag)
        if (ueberstundenDauer > Duration.ZERO) {
            ueberstundenDauer
        } else {
            Duration.ZERO
        }
    }
}

fun berechneArbeitstage(startDatum: LocalDate, endDatum: LocalDate): Int {                  // Von Entwickler Herr Luca
    // Arbeitstage zählen, ohne Wochenenden
    val anzahlTage = ChronoUnit.DAYS.between(startDatum, endDatum) + 1
    val anzahlTageInt = anzahlTage.toInt()
    val wochenenden = (0..anzahlTage).map { startDatum.plusDays(it) }
        .count { it.dayOfWeek == DayOfWeek.SATURDAY || it.dayOfWeek == DayOfWeek.SUNDAY }
    return anzahlTageInt  - wochenenden
}


fun formatiereZeitArchiv(dauer: Duration): String {                                         // Von Entwickler Herr Luca
    val stunden = dauer.toHours().absoluteValue // Absolute Stunden, um negatives Vorzeichen zu entfernen
    val minuten = dauer.toMinutesPart().absoluteValue
    val sekunden = dauer.toSecondsPart().absoluteValue
    val sign = if (dauer.isNegative) "-" else "" // Vorzeichen für negative Dauer

    // Führende Nullen für Minuten und Sekunden hinzufügen
    val formatierteMinuten = minuten.toString().padStart(2, '0')
    val formatierteSekunden = sekunden.toString().padStart(2, '0')
    return "$sign$stunden:$formatierteMinuten:$formatierteSekunden"
}