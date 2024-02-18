import javafx.geometry.Insets
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox

object GuiAusgabeFenster{


    private val ausgabeFenster = TextArea()
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

    fun ausgabeTextHinzufügen(text: String) {
        ausgabeFenster.appendText("$text \n")
    }
    fun clear(){
        ausgabeFenster.clear()
    }

}