import javafx.stage.Stage
import java.time.Duration


// Allgemeine Funktionen

fun splitString(string: String): kotlin.collections.List<String> {
    val string = userDaten.split(" ")
    return string
}

fun formatiereZeit (dauer: Duration): String {
    val stunden = dauer.toHours()
    val minuten = dauer.toMinutesPart()
    val sekunden = dauer.toSecondsPart()

    return "$stunden:$minuten:$sekunden"
}

