package LogIn

fun logInAbfrage(user: String, userpasswort: String) {



    val currentUser = LogIn()
    println("Bitte Benutzer eingeben")
    currentUser.user = user
    println("Bitte Passwort eingeben")
    currentUser.userpasswort = userpasswort

    currentUser.logIn()
}

//fun logInFenster() {
//    val loginStage = Stage()
//    val loginGui = GuiLogIn()
//    loginGui.start(loginStage)
//}

