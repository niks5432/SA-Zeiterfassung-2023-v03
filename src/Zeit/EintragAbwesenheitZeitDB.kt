/*
 * Titel: RDB-Test
 * Firma: ABB TS
 * Autor: M. Bontognali
 *
 * Beschreibung:
 * Daten via JDBC von MySQL DB speichern.
 * Verwendet die Bibliothek mysql-connector-j-8.2.0.jar.
 *
 * Einrichten der Datenbank:
 * create database people;
 * use people;
 * CREATE TABLE tabPerson (
 *   name VARCHAR(50) NOT NULL,
 *   age INTEGER
 * );
 *
 * Achtung:
 * MySQL Server muss in Betrieb sein.
 */

import GuiElemente.GuiAusgabeFenster
import java.sql.DriverManager
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

    fun eintragAbwesenheitZeitDB(userId: Int, startDatum: LocalDate, endDatum: LocalDate, anzahltage: Int,  startzeit: LocalTime, endzeit: LocalTime, pausenzeit: String, abwesenheitsid: Int, zustandid: Int) {
    val PROTOCOL = "jdbc:mysql"
//    val HOST =     "localhost"
//    val PORT =     3306
    val DATABASE = "sa_semesterarbeit_2023"
    val OPTIONS =  "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
    val URL =      "$PROTOCOL://$HOST:$PORT/$DATABASE?$OPTIONS"
    val USER =     "root"
    val PASSWORD = "SaZeiterfassung$"

    // Zu speichernde Daten
    val eintragid       =  0
    val datum           =  LocalDate.now()

    // Verbindung zur DB herstellen
    val connection= DriverManager.getConnection(URL, USER, PASSWORD)

    // Statement erzeugen
    val statement = connection.createStatement()

        var aktuelesDatum = startDatum


        while (!aktuelesDatum.isAfter(endDatum)) {

        // SQL erstellen um Daten in DB speichern
            val sql = """INSERT INTO Zeiterfassung (
                         userId,
                         datum,
                         startzeit,
                         endzeit,
                         pausenzeit,                 
                         abwesenheitsid,
                         zustandid)
                     VALUES (
                         '$userId',
                         '$aktuelesDatum',
                         '$startzeit',
                         '$endzeit',
                         '$pausenzeit',
                         '$abwesenheitsid',
                         '$zustandid'
                     )"""



            // SQL ausfuehren
            statement.executeUpdate(sql)

            aktuelesDatum = aktuelesDatum.plusDays(1)
    }

    println("Daten in DB gespeichert.")
    GuiAusgabeFenster.ausgabeTextHinzufügen("Abwesenheit in DB gespeichert." )



// Zeilen ausgeben

}




