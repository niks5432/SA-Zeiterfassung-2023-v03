import Benutzer.GuiBenutzerErstellen
import LogIn.LogIn
import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.SplitPane
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import LogIn.logInAbfrage
import LogIn.logInFenster

object GuiMenueAdmin {

    val guiStage = Stage() // Erstelle eine neue Stage

    val splitPane = SplitPane()
    val ausgabeFenster = TextArea()

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

        val ausgabeFenster = AusgabeFenster(vbox)
        ausgabeFenster.ausgabeFensterAnzeigen()

        val rootBorder = ausgabeFenster.root

        buttonStart.setOnAction {}
        buttonArchiv.setOnAction {}
        buttonVisieren.setOnAction { }
        buttonErstellen.setOnAction {
            rootBorder.isVisible
            GuiBenutzerErstellen.start(guiStage)}
        buttonLogOut.setOnAction {
            stage.close()
            val loginStage = Stage()
            val loginGui = GuiLogIn()
            loginGui.start(loginStage)
            angemeldet = false
            println("Sie wurden Abgemeldet")
        }

        with(stage) {
            scene = javafx.scene.Scene(rootBorder, 700.0, 500.0)
            title = "Zeiterfassung"
            show()
        }
    }

}