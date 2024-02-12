import Benutzer.GuiBenutzerErstellen
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.SplitPane
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage

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

        ausgabeFenster.apply {
            isEditable = false
            promptText = "Programm Ausgabe"
        }

        splitPane.apply {
            orientation = Orientation.HORIZONTAL
            items.addAll(vbox, ausgabeFenster)
            setDividerPositions(0.6) // Set initial divider position
        }

        val root = BorderPane()     // ohne SplitPane kann besser zentriert werden und man kan die grösse der Fenster ver$ndern
        root.right = splitPane


        buttonStart.setOnAction {}
        buttonArchiv.setOnAction {}
        buttonVisieren.setOnAction { }
        buttonErstellen.setOnAction {
            vbox.isVisible()
            GuiBenutzerErstellen.start(guiStage)}
        buttonLogOut.setOnAction {
            stage.close()
            logInFenster()
            angemeldet = false
            println("Sie wurden Abgemeldet")
        }

        with(stage) {
            scene = javafx.scene.Scene(root, 700.0, 500.0)
            title = "Zeiterfassung"
            show()
        }
    }

}