package LogIn/*
 * Titel: RDB-Test
 * Firma: ABB TS
 * Autor: M. Bontognali
 *
 * Beschreibung:
 * Daten via JDBC von MySQL DB laden.
 * Verwendet die Bibliothek mysql-connector-j-8.2.0.jar.
 *
 * Achtung:
 * MySQL Server muss in Betrieb sein.
 */

import HOST
import PORT
import admin
import email
import funktion
import nachname
import passwort
import userIdString
import vorname
import java.sql.*

fun LesenUserDB(user: String) : String {
    val PROTOCOL = "jdbc:mysql"                                                         // Verwendetes Protocol
//    val HOST =     "localhost"                                                        // Wurde Global definert
//    val PORT =     3306
    val DATABASE = "sa_semesterarbeit_2023"                                             // Name der Datenbank
    val OPTIONS =  "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"       // optionen für die Verbindung
    val URL =      "$PROTOCOL://$HOST:$PORT/$DATABASE?$OPTIONS"                         // Url damit die Datenbank im Netzwerk gefunden werden kann
    val USER =     "root"                                                               // User
    val PASSWORD = "SaZeiterfassung$"                                                   // Passwort

    // Aufbau der Datenbankverbindung
    val connection = DriverManager.getConnection(URL, USER, PASSWORD)

    // Statement erzeugen
    val statement = connection.createStatement()

    // SQL Befehl erstellen und in Variable zwischenspeichern
    val sql = "select  b2.userid, b2.passwort, b2.vorname, b2.nachname, b2.email, b2.funktion, b2.Admin from Benutzer b2 , Zeiterfassung z \n" +
            "where   b2.vorname  = '$user'"

    // SQL Statement ausfuehren
    val data = statement.executeQuery(sql)
    var userId = 1
    // Abgefragte Userdaten in Variablen speichern
    while (data.next()) {
        userId      = data.getInt("userid")
        passwort = data.getString("passwort")
        vorname = data.getString("vorname")
        nachname = data.getString("nachname")
        email = data.getString("email")
        funktion = data.getString("funktion")
        admin = data.getString("admin").toBoolean()
    }
    userIdString = userId.toString()
    // rückgabe der Benutzerdaten
    return "$userIdString $passwort $vorname $nachname $email $funktion $admin"
}
