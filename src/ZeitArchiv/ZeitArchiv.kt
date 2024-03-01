package ZeitArchiv

import GuiElemente.GuiAusgabeFenster
import berechneArbeitstage
import effektivearbeitsstundenamtag
import formatiereZeitArchiv
import minusuberstunden
import java.time.Duration
import java.time.LocalDate

class ZeitArchiv {
    var startDatumStr = ""
    var endDatumStr = ""
    var abfrageUserId = ""
    var abwesenheitsId = 0

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
        val archiveDatenListe = lesenArchivDB(abfrageUserId.toInt(), startDatum, endDatum, abwesenheitsId)

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
            val abwesenheitsidBack = row[4]
            val ergebnis = minusuberstunden(startzeitelem, endzeitelem)
            val ergebnisformatiert = formatiereZeitArchiv(ergebnis)
            val arbeitsstundenperiode = effektivearbeitsstundenamtag(startzeitelem, endzeitelem)
            formatiertearbeitsstundenperiode += arbeitsstundenperiode
            formatiertetotalArbeitszeit += ergebnis

            val userIdFormatted = abfrageUserId.toInt().toString().padEnd(10)
            val datumFormatted = datumelem.padEnd(12)
            val startzeitFormatted = startzeitelem.padEnd(10)
            val endzeitFormatted = endzeitelem.padEnd(10)
            val vornameFormatted = vornameelem.padEnd(15)
            val ergebnisformatiertt = ergebnisformatiert.padEnd(20)

            println("UserID: $userIdFormatted \t| Datum: $datumFormatted \t| Startzeit: $startzeitFormatted\t | Endzeit: $endzeitFormatted\t | Vorname: $vornameFormatted\t | Über-/Minus-stunden: $ergebnisformatiertt | AbwesenheitID: $abwesenheitsidBack")
            GuiAusgabeFenster.ausgabeTextHinzufügen("UserID: $userIdFormatted\tDatum: $datumFormatted\tStartzeit: $startzeitFormatted\t Endzeit: $endzeitFormatted\tVorname: $vornameFormatted\t Über-/Minus-stunden:\t$ergebnisformatiertt\t AbwesenheitID: $abwesenheitsidBack")
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

            GuiAusgabeFenster.ausgabeTextHinzufügen("Gesamt Teoretische Minus/Überstunden: $formatiertetotalArbeitszeitanzeige ")
            GuiAusgabeFenster.ausgabeTextHinzufügen("Anzahl Arbeitstagen $anzahlArbeitstage, Gesamtsollstunden: $totalSollStunden, Effektiv gearbeitete Stunden in dieser Periode: $formatiertetotalArbeitszeitanzeige2 ")

            println("Gesamt Teoretische Minus/Überstunden: $formatiertetotalArbeitszeitanzeige ")
            println("Anzahl Arbeitstagen $anzahlArbeitstage, Gesamtsollstunden: $totalSollStunden, Effektiv gearbeitete Stunden in dieser Periode: $formatiertetotalArbeitszeitanzeige2 ")
        }
    }
}