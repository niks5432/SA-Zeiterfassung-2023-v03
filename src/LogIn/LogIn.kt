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

    var user = ""
    var userpasswort = ""

    fun logIn() {
//        do {
            var schleifenEndeLogIn   = false
            userDaten = LesenUserDB(user)
            val userDatenSplit = splitString(userDaten)                                                    // Splitet den String userDaten nach Abstand und speichert es in Liste userDaten Split
            if (userDatenSplit.get(2) == user && userDatenSplit.get(2) != "") {                           //überprüft ob der Benutername in Datenbank enthalten ist
                if (userDatenSplit.get(1) == userpasswort) {                                             //überprüft ob Passwirt in der Datenbank mit dem Benutzerpasswort übereinstimmt
                    schleifenEndeLogIn = true
                    angemeldet = true
                    println("Herzlich Wilkommen Benutzer: $user")
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
//        } while (!schleifenEndeLogIn)                             //Bedingung damit Schleife weiter geführt wird
    }
}
