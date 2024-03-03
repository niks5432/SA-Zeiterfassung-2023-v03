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

fun eintragZeitDB(userId: Int, startzeit: LocalTime, endzeit: LocalTime, pausenzeit: String, abwesenheitsid: Int, zustandid: Int) {
    val PROTOCOL = "jdbc:mysql"
//    val HOST =     "localhost"
//    val PORT =     3306
    val DATABASE = "sa_semesterarbeit_2023"
    val OPTIONS =  "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
    val URL =      "$PROTOCOL://$HOST:$PORT/$DATABASE?$OPTIONS"
    val USER =     "root"
    val PASSWORD = "SaZeiterfassung$"

    val eintragid       =  0
    val datum           =  LocalDate.now()

    val connection= DriverManager.getConnection(URL, USER, PASSWORD)

    val statement = connection.createStatement()

    val sql = """INSERT INTO Zeiterfassung (
                     eintragid,
                     userId,
                     datum,
                     startzeit,
                     endzeit,
                     pausenzeit,                 
                     abwesenheitsid,
                     zustandid)
                 VALUES (
                     '$eintragid',
                     '$userId',
                     '$datum',
                     '$startzeit',
                     '$endzeit',
                     '$pausenzeit',
                     '$abwesenheitsid',
                     '$zustandid'
                 )"""

    statement.executeUpdate(sql)
    println("Daten in DB gespeichert.")
    GuiAusgabeFenster.ausgabeTextHinzufügen("Heutige Zeit in DB gespeichert." )

}




