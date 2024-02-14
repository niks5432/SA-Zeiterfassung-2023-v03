import Benutzer.GuiBenutzerErstellen
import LogIn.LogIn
import Zeit.GuiZeit
import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.SplitPane
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage

class GuiMenueAdmin {

    val splitPane = SplitPane()
    val ausgabeFenster = TextArea()

    val buttonStart = Button("Zeitmessung")
    val buttonArchiv = Button("Stunden Archiv")
    val buttonVisieren = Button("Zeiten Visieren")
    val buttonErstellen = Button("Benutzer erstellen")
    val buttonLogOut = Button("Log Out")
    fun start(stage: Stage) {

            val vbox = VBox().apply {
                spacing = 30.0
                padding = Insets(0.0, 0.0, 0.0, 70.0)
                children.addAll(
                    Label("Herzlich Wilkommen $vorname").apply {
                        font = Font.font(20.0)
                        style = "-fx-font-weight: bold"
                        VBox.setMargin(this, Insets(20.0, 0.0, 0.0, -40.0))
                    },
                        Label("Menü").apply {
                        font = Font.font(18.0)
                        style = "-fx-font-weight: bold"
                        VBox.setMargin(this, Insets(-20.0, 0.0, 0.0, 35.0))
                    },
                    buttonStart.apply {
                        prefWidth = 120.0
                    },
                    buttonArchiv.apply {
                        prefWidth = 120.0
                    },
                    buttonVisieren.apply {
                        prefWidth = 120.0
                    },
                    buttonErstellen.apply {
                        prefWidth = 120.0
                    },
                    buttonLogOut.apply {
                    prefWidth = 120.0
                    }
                )
            }



            val ausgabeFenster = AusgabeFenster()

        splitPane.apply {
            orientation = Orientation.HORIZONTAL
            items.addAll(vbox, ausgabeFenster.vbox)
            setDividerPositions(0.4) // Set initial divider position
        }

            buttonStart.setOnAction {
                stage.close()
                val guiZeitStage = Stage()
                GuiZeit.start(guiZeitStage)
            }
            buttonArchiv.setOnAction {}
            buttonVisieren.setOnAction { }
            buttonErstellen.setOnAction {
                stage.close()
                GuiBenutzerErstellen.start(stage)
            }
            buttonLogOut.setOnAction {
                val loginStage = Stage()
                val loginGui = GuiLogIn()
                loginGui.start(loginStage)
                angemeldet = false
                println("Sie wurden Abgemeldet")
                stage.close()
            }



            with(stage) {
                scene = javafx.scene.Scene(splitPane, 700.0, 500.0)
                title = "Zeiterfassung"
                show()
            }
        }

}