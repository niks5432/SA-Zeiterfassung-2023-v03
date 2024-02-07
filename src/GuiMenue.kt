import Benutzer.guiBenutzerErstellen
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.stage.Stage

var menueStage = Stage()

object guiMenue {

    val buttonStart = Button("Zeiterfassung Starten")
    val buttonArchiv = Button("Zeiterfassung Archiv")
    val buttonVisieren = Button("Zeiterfassungen Visieren")
    val buttonErstellen = Button("Benutzer erstellen")
    val buttonLogOut = Button("Log Out")
      fun start(stage: Stage) {


            val vbox = VBox().apply {
                spacing = 10.0
                padding = Insets(20.0, 15.0, 15.0, 10.0)
                children.addAll(
                    Label("-----Menue----"),
                    buttonStart,
                    buttonArchiv,
                    buttonVisieren,
                    buttonErstellen,
                    buttonLogOut
                )
            }

            buttonStart.setOnAction {}
            buttonArchiv.setOnAction {}
            buttonVisieren.setOnAction { }
            buttonErstellen.setOnAction {
                vbox.isVisible()
                guiBenutzerErstellen.start(guiStage)}
            buttonLogOut.setOnAction {
                stage.close()
                showLoginWindow()
                angemeldet = false
                println("Sie wurden Abgemeldet")
            }

            with(stage) {
                scene = javafx.scene.Scene(vbox, 700.0, 500.0)
                title = "Zeiterfassung"
                show()
            }
        }
    }


