package GuiElemente

import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.SplitPane
import javafx.scene.layout.VBox
import zeiterfassungAbfrage

object GuiZeit {
    private val splitPane = SplitPane()
    val btnStart = Button("Zeiterfassung Start")
    val btnEnde = Button("Zeiterfassung Stopp")
    val btnBack = Button("Ansicht Schliessen")
    var btnZeiterfassung = VBox()

    fun btnZeitmessung() {
        btnZeiterfassung = VBox().apply {
            spacing = 10.0
            padding = Insets(0.0, 0.0, 50.0, 0.0)
            with(children) {
                addAll(
                    btnStart.apply {
                        prefWidth = 160.0
                        VBox.setMargin(this, Insets(0.0, 0.0, 0.0, 50.0))
                    },
                    btnEnde.apply {
                        prefWidth = 160.0
                        VBox.setMargin(this, Insets(-35.0, 0.0, 0.0, 270.0))
                    },
                    btnBack.apply {
                        prefWidth = 160.0
                        VBox.setMargin(this, Insets(-35.0, 55.0, 0.0, 485.0))
                    }
                )
            }
        }

        btnStart.setOnAction {
            zeiterfassungAbfrage(true)
        }

        btnEnde.setOnAction {
            zeiterfassungAbfrage(false)
        }

        btnBack.setOnAction {
            btnZeiterfassung.isVisible = false
            GuiAusgabeFenster.clear()
        }

    }



    fun wilkommen() {
        GuiAusgabeFenster.ausgabeTextHinzufügen("Menüpunk: Zeitmessung")
    }


}