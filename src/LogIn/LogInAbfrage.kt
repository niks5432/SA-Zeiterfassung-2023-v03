package LogIn

fun logInAbfrage(user: String, userpasswort: String) {

    val currentUser = LogIn()               // Erstellt ein Objekt aus der Klasse
    println("Bitte Benutzer eingeben")      //Konsolen Ausgabe
    currentUser.user = user                 // füllt Variable user vom Objekt mit dem parameter user aus
    println("Bitte Passwort eingeben")
    currentUser.userpasswort = userpasswort // füllt Variable userpasswort vom Objekt mit dem parameter userpasswort aus

    currentUser.logIn()                     // Führt die Methode LogIn() vom Objekt current User aus.
}

//fun logInFenster() {
//    val loginStage = Stage()
//    val loginGui = GuiLogIn()
//    loginGui.start(loginStage)
//}

