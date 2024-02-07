import Benutzer.guiBenutzerErstellen
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.stage.Stage

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

            buttonStart.setOnAction {
                vbox.isVisible()
                guiBenutzerErstellen.start(guiStage)}
            buttonArchiv.setOnAction { /* Implementiere die Aktion für Zeiterfassung Archiv */ }
            buttonVisieren.setOnAction { /* Implementiere die Aktion für Zeiterfassungen Visieren */ }
            buttonErstellen.setOnAction { /* Implementiere die Aktion für Benutzer erstellen */ }
            buttonLogOut.setOnAction {
                stage.close()
                //showAlert("Sie wurden ausgeloggt.")
                // Hier kannst du optional die main() Methode aufrufen oder andere Aktionen durchführen.
            }

            with(stage) {
                scene = javafx.scene.Scene(vbox, 700.0, 500.0)
                title = "Zeiterfassung"
                show()
            }
        }

    }

