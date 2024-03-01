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
    val guiLogInStage = Stage()
    private val buttonLogIn = Button("Log In")
    private val label = Label("")
    private val user = TextField()
    private val passwort = PasswordField()

    override fun start(stage: Stage) {
        val box = VBox().apply {
            spacing = 10.0
            padding = Insets(20.0)
            alignment = Pos.CENTER

            label.text = "Herzlich Wilkommen im Zeiterfassungs Programm"

            with(children) {
                add(label).apply {
                    label.font = Font.font(20.0,)
                    label.style  = "-fx-font-weight: bold"
                    label.padding = Insets(-40.0, 0.0, 0.0, 0.0)
                }
                add(user).apply {
                    user.maxWidth = 210.0
                    user.promptText = "Bitte den Benutzernamen Eingeben"
                    user.alignment = Pos.CENTER
                }
                add(passwort).apply {
                    passwort.maxWidth = 210.0
                    passwort.promptText = "Bitte das Passwort Eingeben"
                    passwort.alignment = Pos.CENTER}

                add(buttonLogIn)
            }
        }

        buttonLogIn.setOnAction {
            val currentUser = user.text
            val currentUserPasswort = passwort.text
            logInAbfrage(currentUser,currentUserPasswort)
            angemeldet(stage)
        }


        with(stage) {
            scene = Scene(box, 500.0, 200.0)
            title = "Zeiterfassung"
//            setOnCloseRequest { }
            show()
        }
    }

    private fun falscheAngaben() {
        with(Alert(Alert.AlertType.INFORMATION)) {
            contentText = "Falsche Benutzer Daten \n" +
                          "Bitte nochmal eingeben"
            showAndWait()
        }

    }

    private fun angemeldet(stage : Stage) {
        if (angemeldet) {
            println("Menue wird ausgeführt")
            println("Angemeldet: $angemeldet")
            println("Admin: $admin")
            if (admin) {
                stage.close()
                val guiMenueAdmin = GuiMenueAdmin()
                guiMenueAdmin.start(stage)
            } else {
                stage.close()
                val guiMenueUser = GuiMenueUser()
                guiMenueUser.start(stage)
            }
        } else {
                falscheAngaben()
        }

    }

}



