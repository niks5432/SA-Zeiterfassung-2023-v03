

import GuiElemente.GuiLogIn
import javafx.application.Application

var userDaten = ""
var userIdString = ""
var passwort = ""
var vorname = ""
var nachname = ""
var email = ""
var funktion = ""
var admin = false
var angemeldet = false
var zustandZeitmessung = 0

val HOST =     "192.168.55.107"
val PORT =     3308



fun main() {
    println("Hello World!")
    Application.launch(GuiLogIn::class.java)

}

