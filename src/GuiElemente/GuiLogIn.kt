package GuiElemente

import LogIn.logInAbfrage
import admin
import angemeldet
import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage

class GuiLogIn : Application() {
    private val buttonLogIn = Button("Log In")                              // Attribute welche benötigt werden um die Klasse zu bedienen und die Benutzer interaktion durchzuführen
    private val label = Label("")
    private val user = TextField()
    private val passwort = PasswordField()

    override fun start(stage: Stage) {
        val box = VBox().apply {                            // Vertikaler Layoutcontainer welche Elemente wie Label, Buttons und deren Formatierung enthält
            spacing = 10.0                                                  // formatierung des Layoutcontainers
            padding = Insets(20.0)
            alignment = Pos.CENTER

            label.text = "Herzlich Wilkommen im Zeiterfassungs Programm"    // Definition der Nachricht im Label

            with(children) {
                add(label).apply {                              // Hinzufügen von Formatierungs elementen
                    label.font = Font.font(20.0,)                          // Setzt die Schriftgrösse Fest
                    label.style  = "-fx-font-weight: bold"                 // Schrifft wird Fett Formatiert
                    label.padding = Insets(-40.0, 0.0, 0.0, 0.0)           // Position des Labels
                }
                add(user).apply {
                    user.maxWidth = 210.0                                  // Maximale Breite wird festgelegt
                    user.promptText = "Bitte den Benutzernamen Eingeben"   // Text im Eingabefeld wird angezeigt
                    user.alignment = Pos.CENTER                            // Zentriert den Text im Eingabefeld
                }
                add(passwort).apply {
                    passwort.maxWidth = 210.0
                    passwort.promptText = "Bitte das Passwort Eingeben"
                    passwort.alignment = Pos.CENTER}
                add(buttonLogIn)
            }
        }

        buttonLogIn.setOnAction {                              // bestimmt was passiert wen ein Button ausgelösst wird
            val currentUser = user.text                             // Zwischenspeicehrn was eingegeben wurde
            val currentUserPasswort = passwort.text
            logInAbfrage(currentUser,currentUserPasswort)                  // Datenbankabfrage wird gemacht mit den beiden Parametern
            angemeldet(stage)
        }


        with(stage) {                                            // Bestimmt wie das Fenster mit der entsprechenden stage formatiert ist und was angezeigt wird
            scene = Scene(box, 500.0, 200.0)                               // Bestimmt was Angezeigt wird und wie gross das Fenster wird
            title = "Zeiterfassung"                                        // Setzt den Titel des Fensters Fest
            show()                                                         // Führt die Stage aus und zeigt das fenster ann
        }
    }

    private fun falscheAngaben() {                                          // Hinweis Fenster fals falsche Angaben eingegeben werden
        with(Alert(Alert.AlertType.INFORMATION)) {
            contentText = "Falsche Benutzer Daten \n" +                     // Das wird Angezeigt
                          "Bitte nochmal eingeben"
            showAndWait()
        }

    }

    private fun angemeldet(stage : Stage) {                                // Funkjtion um zu überprüfen ob Anmeldung erfolgreich war
        if (angemeldet) {
            println("Menue wird ausgeführt")
            println("Angemeldet: $angemeldet")
            println("Admin: $admin")
            if (admin) {                                                   // Überprüft ob momentaner Benutzer ein Admin ist
                stage.close()                                              // schliesst das geöffnete Fenster
                val guiMenueAdmin = GuiMenueAdmin()                        // Erstellt aus der Klasse ein Objekt
                guiMenueAdmin.start(stage)                                 // Überschreibt die aktuelle start Funktion mit der vorhandene Stage und öfnet das neue Fenster
            } else {
                stage.close()
                val guiMenueUser = GuiMenueUser()
                guiMenueUser.start(stage)
            }
        } else {
                falscheAngaben()                                           // Ruft bei falschen Anmeldedaten die Funktion auf
        }

    }

}



