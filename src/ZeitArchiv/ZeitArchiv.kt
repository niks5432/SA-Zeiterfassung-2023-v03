package ZeitArchiv

import berechneArbeitstage
import effektivearbeitsstundenamtag
import formatiereZeitArchiv
import minusuberstunden
import userIdString
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
class ZeitArchiv {
     private val startDatumStr = ""
     private val endDatumStr = ""
     private val abfrageUserId = ""
    fun archiveAbfrage() {

//        println("Geben Sie ein Startdatum im Format (yyyy-MM-dd) ein")
//        // Startdatum von der Konsole lesen
//        val startDatumStr = readlnOrNull()
        // Prüfen/Validierung des Datumsformats
        val startDatum = LocalDate.parse(startDatumStr)

//        println("Geben Sie ein Enddatum im Format (yyyy-MM-dd) ein")
//        // Enddatum von der Konsole lesen
//        val endDatumStr = readlnOrNull()
        // Prüfen/Validierung des Datumsformats
        val endDatum = LocalDate.parse(endDatumStr)

        // Datenbankabfrage durchführen
        val archiveDatenListe = lesenArchivDB(abfrageUserId.toInt(), startDatum, endDatum)

//    println("Anzahl der Elemente in der Liste: ${archiveDatenListe.size}")

        val matrix = mutableListOf<MutableList<String>>()

        for (archiveDate in archiveDatenListe) {
            val rowData = archiveDate.split(" ")
            matrix.add(rowData.toMutableList())
        }

        var datumelem: String
        var startzeitelem: String
        var endzeitelem: String
        var vornameelem: String
        var formatiertetotalArbeitszeit : Duration = Duration.ZERO
        var formatiertearbeitsstundenperiode : Duration = Duration.ZERO

        for (row in matrix) {
            datumelem = row[0]
            startzeitelem = row[1]
            endzeitelem = row[2]
            vornameelem = row[3]
            val ergebnis = minusuberstunden(startzeitelem, endzeitelem)
            val ergebnisformatiert = formatiereZeitArchiv(ergebnis)
            val arbeitsstundenperiode = effektivearbeitsstundenamtag(startzeitelem, endzeitelem)
            formatiertearbeitsstundenperiode += arbeitsstundenperiode
            formatiertetotalArbeitszeit += ergebnis
            println("UserID: ${abfrageUserId.toInt()} | Datum: $datumelem | Startzeit: $startzeitelem | Endzeit: $endzeitelem | Vorname: $vornameelem | Über-/Minus-stunden: $ergebnisformatiert")
        }

        val endDatumParce = LocalDate.parse(endDatumStr)
        val startDatumParce = LocalDate.parse(startDatumStr)

        var anzahlArbeitstage = 0
        anzahlArbeitstage = berechneArbeitstage(startDatumParce, endDatumParce)

        val totalArbeitszeit: Duration = Duration.ZERO
        val sollStundenAmTag: Duration = Duration.ofHours(8)
        val sollStundenAmTagAnzeige = 8


        val sollStundenAmTagInt = sollStundenAmTag.seconds.toInt()
        val totalSollStunden = sollStundenAmTagInt * anzahlArbeitstage / 3600

        val arbeitZeit = Duration.ofHours(sollStundenAmTagAnzeige.toLong() * anzahlArbeitstage)
        val minimumArbeitszeit: Duration = Duration.ofSeconds(1)

        if (arbeitZeit >= minimumArbeitszeit) {
            val formatiertetotalArbeitszeitanzeige = formatiereZeitArchiv(formatiertetotalArbeitszeit)
            val formatiertetotalArbeitszeitanzeige2 =formatiereZeitArchiv(formatiertearbeitsstundenperiode)
            println("Gesamt Teoretische Minus/Überstunden: $formatiertetotalArbeitszeitanzeige ")
            println("Anzahl Arbeitstagen $anzahlArbeitstage, Gesamtsollstunden: $totalSollStunden, Effektiv gearbeitete Stunden in dieser Periode: $formatiertetotalArbeitszeitanzeige2 ")
        }
    }
}