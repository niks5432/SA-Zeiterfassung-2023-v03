package ZeitArchiv

import HOST
import PORT
import java.sql.DriverManager
import java.time.LocalDate

fun lesenArchivDB(userId: Int, startDatums: LocalDate, endDatums: LocalDate, abwesenheitsId: Int): List<String> {
    val PROTOCOL = "jdbc:mysql"
//    val HOST =     "localhost"
//    val PORT =     3306
    val DATABASE = "sa_semesterarbeit_2023"
    val OPTIONS =  "useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
    val URL =      "$PROTOCOL://$HOST:$PORT/$DATABASE?$OPTIONS"
    val USER =     "root"
    val PASSWORD = "SaZeiterfassung$"

    // Verbindung zur DB herstellen
    val connection = DriverManager.getConnection(URL, USER, PASSWORD)
    // Statement erzeugen
    val statement = connection.createStatement()
    val startDatumStr = startDatums.toString()
    val endDatumStr = endDatums.toString()
    // SQL erstellen um Zeilen aus DB zu laden
    val sql = "SELECT b.userid, z.datum, z.startzeit, z.endzeit, b.vorname, z.abwesenheitsid " +
            "FROM Zeiterfassung z, Benutzer b " +
            "WHERE z.datum BETWEEN '$startDatumStr' AND '$endDatumStr' " +
            "AND b.userid = '$userId' " +
            "AND z.abwesenheitsid = '$abwesenheitsId' " +
            "ORDER BY z.datum"

    // SQL ausführen
    val data = statement.executeQuery(sql)
    val resultList = mutableListOf<String>()
    // Zeilen ausgeben
    while (data.next()) {
        val datum = data.getDate("datum")
        val startzeit = data.getTime("startzeit").toLocalTime()
        val endzeit = data.getTime("endzeit").toLocalTime()
        val vorname = data.getString("vorname")
        val abwesenheitsidBack = data.getInt("abwesenheitsid")
        resultList.add("$datum $startzeit $endzeit $vorname $abwesenheitsidBack")
    }
    return resultList
}

