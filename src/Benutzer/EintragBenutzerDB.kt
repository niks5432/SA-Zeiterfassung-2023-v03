package Benutzer

import GuiElemente.GuiAusgabeFenster
import HOST
import PORT
import javafx.stage.Stage
import java.sql.DriverManager



fun eintragBenutzerDb(userIdNew: Int, passwortNew: String, vornameNew: String, nachnameNew: String, emailNew: String, funktionNew: String, admin: Boolean) {

    val PROTOCOL = "jdbc:mysql"
//    val HOST = "localhost"
//    val PORT = 3306
    val DATABASE = "sa_semesterarbeit_2023"
    val OPTIONS = "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
    val URL = "$PROTOCOL://$HOST:$PORT/$DATABASE?$OPTIONS"
    val USER =     "root"
    val PASSWORD = "SaZeiterfassung$"

    val connection = DriverManager.getConnection(URL, USER, PASSWORD)

    val statement = connection.createStatement()

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

    statement.executeUpdate(sql)
    println("Daten in DB gespeichert.")
    GuiAusgabeFenster.ausgabeTextHinzufügen("Neuer Benutzer in DB gespeichert." )

}