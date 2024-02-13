import javafx.geometry.Orientation
import javafx.scene.control.SplitPane
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage

class AusgabeFenster(val vbox: VBox) {

    val root = BorderPane()     // ohne SplitPane kann besser zentriert werden und man kan die grösse der Fenster ver$ndern

    val splitPane = SplitPane()
    val ausgabeFenster = TextArea()

    fun ausgabeFensterAnzeigen() {
        ausgabeFenster.apply {
            isEditable = false
            promptText = "Programm Ausgabe"
        }


        splitPane.apply {
            orientation = Orientation.HORIZONTAL
            items.addAll(vbox, ausgabeFenster)
            setDividerPositions(0.4) // Set initial divider position
        }

        root.right = splitPane
    }
}