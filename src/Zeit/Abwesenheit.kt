package Zeit

import GuiElemente.GuiAbwesenheit
import eintragAbwesenheitZeitDB
import userIdString
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun abwesenheit() {

    val strDatumString = GuiAbwesenheit.strDatum.text
    val endDatumString = GuiAbwesenheit.endDatum.text

    val formatierung = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    val strDatum = LocalDate.parse(strDatumString, formatierung)
    val endDatum = LocalDate.parse(endDatumString, formatierung)

    val anzahlTage = ChronoUnit.DAYS.between(strDatum, endDatum).toInt()


    fun abwesenheitKrank() {
        println("1")

        val abwesenheitsid = 2
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
    when {
        GuiAbwesenheit.rbnFeiertag.isSelected -> abwesenheitFeiertag()
        GuiAbwesenheit.rbnKrank.isSelected -> abwesenheitKrank()
    }
}

