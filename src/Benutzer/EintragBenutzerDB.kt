package Benutzer

import HOST
import PORT
import javafx.stage.Stage
import java.sql.DriverManager



fun eintragBenutzerDb(userIdNew: Int, passwortNew: String, vornameNew: String, nachnameNew: String, emailNew: String, funktionNew: String, admin: Boolean) {

// Database connection parameters
    val PROTOCOL = "jdbc:mysql"
//    val HOST = "localhost"
//    val PORT = 3306
    val DATABASE = "SA-Semesterarbeit-2023"
    val OPTIONS = "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
    val URL = "$PROTOCOL://$HOST:$PORT/$DATABASE?$OPTIONS"
    val USER = "UserTest"
    val PASSWORD = "admin"

// Verbindung zur DB herstellen
    val connection = DriverManager.getConnection(URL, USER, PASSWORD)

// Statement erzeugen
    val statement = connection.createStatement()


// SQL erstellen um Daten in DB zu speichern
    val sql = """INSERT INTO Benutzer (
                     userid,
                     passwort,
                     vorname,
                     nachname,
                     email,
                     funktion,
                     admin)
                 VALUES (
                     '$userIdNew',
                     '$passwortNew',
                     '$vornameNew',
                     '$nachnameNew',
                     '$emailNew',
                     '$funktionNew',
                     '$admin'

                 )"""

// SQL ausführen
    statement.executeUpdate(sql)
    println("Daten in DB gespeichert.")

}