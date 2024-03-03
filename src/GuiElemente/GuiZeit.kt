package GuiElemente

import ZeitAbfrage
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage

object GuiZeit {
    val btnStart = Button("Zeiterfassung Start")
    val btnEnde = Button("Zeiterfassung Stopp")
    val btnAbwesend = Button("Abwesenheit Melden")
    val btnBack = Button("Ansicht Schliessen")
    var btnZeiterfassungFlaeche = HBox()
    var btnBackFlaeche = HBox()
    var btnFlaecheZusammen = VBox()


    fun btnZeitmessung() {
        btnZeiterfassungFlaeche = HBox().apply {
            spacing = 55.0
            padding = Insets(.0, 0.0, 0.0, 55.0)
            with(children) {
                addAll(
                    btnStart.apply {
                        prefWidth = 160.0
                    },
                    btnEnde.apply {
                        prefWidth = 160.0
                    },
                    btnAbwesend.apply {
                        prefWidth = 160.0
                    }
                )
            }
        }
        btnBackFlaeche = HBox().apply {
            padding = Insets(0.0, 0.0, 0.0, 270.0)
            with(children) {
                addAll(
                    btnBack.apply {
                        prefWidth = 160.0
//                        VBox.setMargin(this, Insets(30.0, 0.0, 0.0, 50.0))
                    }
                )
            }
        }
        btnFlaecheZusammen = VBox().apply {
            spacing = 20.0
            padding = Insets(0.0, 0.0, 25.0, 0.0)
            with(children) {
                addAll(
                    btnZeiterfassungFlaeche.apply{
                    },
                    btnBackFlaeche.apply{
                    },
                )
            }
        }

        btnAbwesend.setOnAction {
            val guiAbwesenheitStage = Stage()
            GuiAbwesenheit.start(guiAbwesenheitStage)
        }
        btnStart.setOnAction {
            ZeitAbfrage.zeiterfassungAbfrage(true)          // zustand wird benötigt damit Logik den gedrückten Button unterscheiden kann
        }
        btnEnde.setOnAction {
            ZeitAbfrage.zeiterfassungAbfrage(false)
        }
        btnBack.setOnAction {
            btnFlaecheZusammen.isVisible = false
            GuiAusgabeFenster.clear()
        }
    }

    fun wilkommen() {
        GuiAusgabeFenster.ausgabeTextHinzufügen("Menüpunk: Zeitmessung")
    }                                          // Funktion für ausgabe AusgabeFenster
}

