import GuiMenueAdmin.guiStage
import LogIn.logInAbfrage
import com.sun.javafx.application.PlatformImpl.exit
import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage

class GuiLogIn : Application() {


    private val buttonLogIn = Button("Log In")
    private val label = Label("")
    private val user = TextField()
    private val passwort = PasswordField()

    override fun start(stage: Stage) {
        val box = VBox().apply {
            spacing = 10.0
            padding = Insets(20.0)
            alignment = Pos.CENTER

            label.text = "Herzlich Wilkommen im Zeiterfassungs programm"

//            user.maxHeight = 50.0
//            user.prefHeight = 10.0
//            user.prefWidth  = 150.0
//            user.setPrefSize(10.0, 100.0)

            with(children) {
                add(label).apply {
                    label.font = Font.font(16.0,)
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
                    passwort.promptText = "Bitte den Passwort Eingeben"
                    passwort.alignment = Pos.CENTER}

                add(buttonLogIn)
            }
        }

        buttonLogIn.setOnAction {
            val currentUser = user.text
            val currentUserPasswort = passwort.text
            logInAbfrage(currentUser,currentUserPasswort)
            println(angemeldet)
            if (angemeldet) {
                println("Menue wird ausgeführt")
                GuiMenueAdmin.start(guiStage)
                stage.close()
            }
        }


        with(stage) {
            scene = Scene(box, 500.0, 200.0)
            title = "Zeiterfassung"
            setOnCloseRequest { exit() }
            show()
        }
    }



}



