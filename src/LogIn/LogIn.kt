package LogIn
/*
 * Titel: Zeiterfassung MAIN
 * Firma: ABB TS
 * Autor: Nikola Djukic
 */
import splitString
import userDaten
import angemeldet
class LogIn {
    var user = ""                                                                   // Attribute welche mit den Anmeldedaten des momentanen Benutzer ausgefühlt werden
    var userpasswort = ""
    fun logIn() {
            userDaten = LesenUserDB(user)                                            //Führt mit der Variable user eine Datenbankabfrage durch und speichert die Daten in einem String
            val userDatenSplit = splitString(userDaten)                  // Splitet den String userDaten nach Abstand und speichert es in Liste userDaten Split
            println(userDatenSplit)
            if (userDatenSplit.get(2) == user && userDatenSplit.get(2) != "") {     //überprüft ob der Benutername in Datenbank enthalten ist
                if (userDatenSplit.get(1) == userpasswort) {                        //überprüft ob Passwirt in der Datenbank mit dem Benutzerpasswort übereinstimmt
                    angemeldet = true                                               //setzt Variable nach erfolgreicher Anmeldung auf True
                    println("Herzlich Wilkommen Benutzer: $user")                   // Ausgabe in Kosole
                    if (user == "Nikola") {
                        println("Master Of Univers")
                    }
                    //menue(admin)
                } else {
                    println("Falsches Passwort")
                }
            } else {
                println("Falscher Benutzername")
            }
    }
}
