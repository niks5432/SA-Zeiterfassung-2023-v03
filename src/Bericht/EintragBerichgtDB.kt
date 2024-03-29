package Bericht


import GuiElemente.GuiAusgabeFenster
import HOST
import PORT
import userIdString
import java.sql.DriverManager

fun EintragBerichgtDB(bericht: String, eientragid: Int ) {
        val PROTOCOL = "jdbc:mysql"
//        val HOST =     "localhost"
//        val PORT =     3306
        val DATABASE = "sa_semesterarbeit_2023"
        val OPTIONS =  "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
        val URL =      "$PROTOCOL://$HOST:$PORT/$DATABASE?$OPTIONS"
        val USER =     "root"
        val PASSWORD = "SaZeiterfassung$"

        val berichtId   =  0
        val userId      = userIdString.toInt()

        val connection= DriverManager.getConnection(URL, USER, PASSWORD)

        val statement = connection.createStatement()

        val sql = """INSERT INTO Bericht (
                     berichtid,
                     eintragid,
                     userId,
                     bericht)
                 VALUES (
                     '$berichtId',
                     '$eientragid',
                     '$userId',
                     '$bericht'
                 )"""

        statement.executeUpdate(sql)
        println("Bericht in DB gespeichert.")
        GuiAusgabeFenster.ausgabeTextHinzufügen("Bericht in DB gespeichert." )

}









