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

open class GuiMenueAdmin {

    val splitPane = SplitPane()

    val buttonZeitmessung = Button("Zeitmessung")
    val buttonArchiv = Button("Stunden Archiv")
    val buttonVisieren = Button("Zeiten Visieren")
    val buttonErstellen = Button("Benutzer erstellen")
    val buttonLogOut = Button("Log Out")
    val ausgabeFenster = AusgabeFenster()

    open fun start(stage: Stage) {

//        ausgabeFenster.ausgabeTextHinzufügen("Hallo", 0)

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
                    buttonZeitmessung.apply {
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

        ausgabeFenster.ausgabeFensterAnzeigen()

        splitPane.apply {
            orientation = Orientation.HORIZONTAL
            items.addAll(vbox, ausgabeFenster.vbox)
            setDividerPositions(0.3) // Set initial divider position
        }

        buttonZeitmessung.setOnAction {
            stage.close()
            GuiZeit.start(stage)
        }

            buttonArchiv.setOnAction {}
            buttonVisieren.setOnAction { }
            buttonErstellen.setOnAction {
                stage.close()
                GuiBenutzerErstellen.start(stage)

            }
            buttonLogOut.setOnAction {
                angemeldet = false
                zustandZeitmessung = 0
                println("Sie wurden Abgemeldet")
                stage.close()
                val loginGui = GuiLogIn()
                loginGui.start(stage)
            }

            with(stage) {
                scene = javafx.scene.Scene(splitPane, 700.0, 500.0)
                title = "Zeiterfassung"
                show()
            }
        }
}