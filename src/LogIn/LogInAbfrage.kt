package LogIn

import userDaten
import vorname
import nachname
import userIdString

fun logInAbfrage(user: String, userpasswort: String) {

    val currentUser = LogIn()
    println("Bitte Benutzer eingeben")
    currentUser.user = user
    println("Bitte Passwort eingeben")
    currentUser.userpasswort = userpasswort

    currentUser.logIn()

}