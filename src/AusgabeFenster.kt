import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.Label
import javafx.scene.control.SplitPane
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage

open class AusgabeFenster() {

    val root = BorderPane()     // ohne SplitPane kann besser zentriert werden und man kan die grösse der Fenster ver$ndern

    val ausgabeFenster = TextArea()
    var vbox = VBox()

    fun ausgabeFensterAnzeigen() {
        ausgabeFenster.apply {
            isEditable = false
            promptText = "Programm Ausgabe"
        }

        vbox = VBox().apply {
            spacing = 10.0
            padding = Insets(20.0, 15.0, 15.0, 10.0)
            children.addAll(
                ausgabeFenster
            )
        }

    }

    fun ausgabeTextHinzufügen(text: String, zeile: Int): Int {
        ausgabeFenster.appendText("$text \n")
        val aktuellezeile = zeile + 1
        return aktuellezeile
    }
    open fun update(){
        root.center = vbox


    }

}