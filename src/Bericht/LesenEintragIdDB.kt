package Bericht

import HOST
import PORT
import java.sql.DriverManager

fun lesenEintragIdDB() : Int {
        val PROTOCOL = "jdbc:mysql"
//        val HOST =     "localhost"
//        val PORT =     3306
        val DATABASE = "sa_semesterarbeit_2023"
        val OPTIONS =  "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
        val URL =      "$PROTOCOL://$HOST:$PORT/$DATABASE?$OPTIONS"
        val USER =     "root"
        val PASSWORD = "SaZeiterfassung$"

        val connection = DriverManager.getConnection(URL, USER, PASSWORD)

        val statement = connection.createStatement()

        val sql = "SELECT eintragid FROM Zeiterfassung z ORDER BY eintragid DESC LIMIT 1;"              // Sortiert die Daten in der Zeiterfassungstabelle absteigend und speichert den ersten wert zwischen

        val data = statement.executeQuery(sql)
        var eintragid = 0

        while (data.next()) {
            eintragid = data.getInt("eintragid")
        }

        return eintragid
    }


