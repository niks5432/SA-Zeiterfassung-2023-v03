package LogIn

import GuiLogIn
import angemeldet
import javafx.stage.Stage
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

}

//fun logInFenster() {
//    val loginStage = Stage()
//    val loginGui = GuiLogIn()
//    loginGui.start(loginStage)
//}

