package Zeit

import GuiElemente.GuiAbwesenheit
import eintragAbwesenheitZeitDB
import userIdString
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
object Abwesenheit {
    val strDatumString = GuiAbwesenheit.strDatum.text                           // Attribute welche für die Logik des Objects
    val endDatumString = GuiAbwesenheit.endDatum.text
    val formatierung = DateTimeFormatter.ofPattern("yyyy-MM-dd")        // Forgabe der Datumsformatierung
    val strDatum = LocalDate.parse(strDatumString, formatierung)                // Umwandlung in Datumsformat
    val endDatum = LocalDate.parse(endDatumString, formatierung)
    val anzahlTage = ChronoUnit.DAYS.between(strDatum, endDatum).toInt()        // Ausrechnen von Arbeitstagen
fun abwesenheit() {
    fun abwesenheitKrank() {
        // Setzt die Variablen mit den richtigen Werten
        val abwesenheitsid = 2
        val zustandId = 1
        // Überprüft welcher Button momentan ausgewählt ist und führt dementsprechend den richtigen If Block aus
        if (GuiAbwesenheit.rbnGanzerTag.isSelected) {
            val userid = userIdString.toInt()
            val startZeit = LocalTime.of(7, 0, 0)
            val endZeit = LocalTime.of(16, 0, 0)
            val pausenZeit = LocalTime.of(0, 0, 0)

            // Eintrag der Zeiten in die Datenbank
            // Eintrag der Zeiten und ID's in die Datenbank
            eintragAbwesenheitZeitDB(userid, strDatum, endDatum, anzahlTage, startZeit, endZeit, pausenZeit.toString(), abwesenheitsid, zustandId)

        } else if (GuiAbwesenheit.rbnHalbertag.isSelected) {
            val userid = userIdString.toInt()
            val startZeit = LocalTime.of(7, 0, 0)
            val endZeit = LocalTime.of(11, 0, 0)
            val pausenZeit = LocalTime.of(0, 0, 0)

            eintragAbwesenheitZeitDB(userid, strDatum, endDatum, anzahlTage, startZeit, endZeit, pausenZeit.toString(), abwesenheitsid, zustandId)
        }

    }

    fun abwesenheitFeiertag() {

        val abwesenheitsid = 3
        val zustandId = 1

        if (GuiAbwesenheit.rbnGanzerTag.isSelected) {
            val userid = userIdString.toInt()
            val startZeit = LocalTime.of(7, 0, 0)
            val endZeit = LocalTime.of(16, 0, 0)
            val pausenZeit = LocalTime.of(0, 0, 0)

            eintragAbwesenheitZeitDB(userid, strDatum, endDatum, anzahlTage, startZeit, endZeit, pausenZeit.toString(), abwesenheitsid, zustandId)

        } else if (GuiAbwesenheit.rbnHalbertag.isSelected) {
            val userid = userIdString.toInt()
            val startZeit = LocalTime.of(7, 0, 0)
            val endZeit = LocalTime.of(11, 0, 0)
            val pausenZeit = LocalTime.of(0, 0, 0)

            eintragAbwesenheitZeitDB(userid, strDatum, endDatum, anzahlTage, startZeit, endZeit, pausenZeit.toString(), abwesenheitsid, zustandId)
    }


    }

    // Nochmal eine Abfrage welcher Button ausgewählt ist um die richtige Logik einzuleiten
    when {
        GuiAbwesenheit.rbnFeiertag.isSelected -> abwesenheitFeiertag()
        GuiAbwesenheit.rbnKrank.isSelected -> abwesenheitKrank()
    }
}

}